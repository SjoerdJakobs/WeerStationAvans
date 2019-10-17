import java.util.ArrayList;
import java.time.LocalDate;
import java.lang.Math;

public class ExampleTab3 extends Tab
{

    private byte topBoundary = 8;
    private byte rightBoundary = 127;
    private byte bottomBoundary = 29;
    private byte leftBoundary = 0;
    private byte yAxel = 20; // position x of yAxel

    // Get raw measurements of period
    Period period = new Period(LocalDate.of(2010, 11, 20), LocalDate.of(2010, 12, 31));

    // Get measurements from period
    private ArrayList<Measurement> measurements = period.getDataStorage().getPeriodMeasurements();

    // Get temperatures of measurements
    ArrayList<Double> temperatures = getUnit(measurements);

    PixelGrid graph = new PixelGrid();

    // Menu variables
    private int counter = 0;
    private boolean showGraph = false;

    // Graph variables
    private double maxValue = Calculations.maximum(temperatures);
    private double minValue = Calculations.minimum(temperatures);
    private double amplitudeValue = maxValue - minValue;
    private int amplitudeGraph = bottomBoundary - topBoundary - 1; // Minus one to prevent the graph from drawing on the x-axes

    private double deltaTimer;
    private int xIndex, oldResult = 0, step = 50, graphRestart = 0, currentColomn = 127;
    private double posBar = temperatures.size() / step / (double)(rightBoundary - leftBoundary);


    // Menu
    protected ExampleTab3(Menu menu) {
        super(menu);
    }

    @Override
    protected void OnOpen() {
        HelperFunctions.ClearTextDisplay();
        m_menu.DrawMenu();
        setValues();
        RawMeasurement rawData = DatabaseConnection.getMostRecentMeasurement();
        Measurement measurement = new Measurement(rawData);
        current = measurement.getOutsideTemp();
        HelperFunctions.WriteOnMatrixScreen(String.format("\nOutside Temperature\ncurrent:%.2f",current)+ " C");
    }

    @Override
    protected void OnClose() {
        HelperFunctions.ClearTextDisplay();
    }

    @Override
    protected void Run(double deltaTime) {
        deltaTimer += deltaTime;

        if (showGraph == true && deltaTimer >= 0.014) {
            PixelGrid addToGraph = new PixelGrid();

            // Shift graph to the left only if there are more than two colomns
            if (xIndex > 1) graph = ShiftToLeft(graph);

            // TODO Redraw axels due to shifting the graph
            //GraphMaker.createAxels(graph);

            // Current xIndex must be able to get values from ArrayList temperatures
            if (temperatures.size() > Math.round(step * (xIndex - leftBoundary + 1))) {

                int result;
                double mean = CalculateMean();
                // Show a new dot (part of graph) only if mean is not NaN
                if(!Double.isNaN(mean)) {
                    // Push previous result in old result for later to compare

                    result = (int)Math.round((mean - minValue) / amplitudeValue * (double) amplitudeGraph);
                    if (xIndex == 0) oldResult = result;

                    // Add result to the current colomn (= at the end of the graph)
                    addToGraph.PixelGrid[bottomBoundary - result - 1][currentColomn] = true;
                }
                else
                    result = oldResult;

                // Create a vertical line for value jumps > 1
                if (result - oldResult > 1) {
                    for (int i = oldResult + 1; i < result; i++) {
                        addToGraph.PixelGrid[bottomBoundary - i - 1][currentColomn] = true; // Minus one to prevent from drawing on the x-axel
                    }
                }
                else if (result - oldResult < -1) {
                    for (int i = oldResult - 1; i > result; i--) {
                        addToGraph.PixelGrid[bottomBoundary - i - 1][currentColomn] = true; // Minus one to prevent from drawing on the x-axel
                    }
                }

                // Update oldResult with current result for next cycle of Run() function
                oldResult = result;

                // Position bar shows how much of the graph is left to show
                posBar = temperatures.size() / step / (double)(rightBoundary - leftBoundary);
                for (int y = bottomBoundary + 1; y <= 31; y++) {
                    HelperFunctions.SetDisplayPixel(true, (int)Math.ceil(xIndex / posBar), y);
                    HelperFunctions.SetDisplayPixel(false, (int)Math.ceil(xIndex / posBar ) - 2, y);
                }

                // TODO EXPERIMENTAL1: Give latest mean
                // HelperFunctions.WriteValueOnSegments(1, mean, 1);
            } // End if-statement

            // Else: start graphRestart counter to create a gap after which everything restarts
            else {
                // TODO EXPERIMENTAL1: Remove latest mean
                // if (graphRestart == 0) HelperFunctions.ClearAllSegmentDisplays();


                // position bar goes back to the beginning
                for (int y = bottomBoundary + 1; y <= 31; y++) {
                    HelperFunctions.SetDisplayPixel(true, 127 - graphRestart - 2, y);
                    HelperFunctions.SetDisplayPixel(false, 127 - graphRestart, y);
                }

                graphRestart++;
                if (graphRestart == 128) {
                    xIndex = -1; // -1 + incremental = 0
                    graphRestart = 0;
                }
            }

            PixelGridDrawer.INSTANCE_DRAWER.AddDraw(addToGraph.PixelGrid);
            xIndex++;

            // Update graph: add last colomn
            graph.OrGrid(addToGraph);

            deltaTimer = 0;
        }
    }

    @Override
    protected void OnButtonBlueTwo() {
        counter++;
        HelperFunctions.ClearTextDisplay();
        m_menu.DrawMenu();

        switch (counter % 8) {
            case 0:
                showGraph = false;
                HelperFunctions.WriteOnMatrixScreen(String.format("\nOutside Temperature\ncurrent:%.2f",current)+ " C");
                break;
            case 1:
                HelperFunctions.WriteOnMatrixScreen(String.format("\nOutside Temperature\nmin:%.2f",min)+ " C");
                break;
            case 2:
                HelperFunctions.WriteOnMatrixScreen(String.format("\nOutside Temperature\nmax:%.2f",max)+ " C");
                break;
            case 3:
                HelperFunctions.WriteOnMatrixScreen(String.format("\nOutside Temperature\naverage:%.2f",average)+ " C");
                break;
            case 4:
                HelperFunctions.WriteOnMatrixScreen(String.format("\nOutside Temperature\nmodus:%.2f",Mode));
                break;
            case 5:
                HelperFunctions.WriteOnMatrixScreen(String.format("\nOutside Temperature\nmedian:%.2f",Median));
                break;
            case 6:
                HelperFunctions.WriteOnMatrixScreen(String.format("\nOutside Temperature\nstd deviation:%.2f",stdDev));
                break;
            case 7:
                // Draw axels
                PixelGrid graph = new PixelGrid();
                for (int i = leftBoundary; i <= rightBoundary; i++) graph.PixelGrid[bottomBoundary][i] = true;
                //for (int i = topBoundary; i <= bottomBoundary; i++) graph.PixelGrid[i][yAxel] = true;
                PixelGridDrawer.INSTANCE_DRAWER.AddDraw(graph.PixelGrid);

                showGraph = true;
                System.out.println("Graph tab reached!");
                break;


        } // End switch case
    }

    //Period period = new Period();

    private double current;
    private double min;
    private double max;
    private double average;
    private double Mode;
    private double Median;
    private double stdDev;

    public void setValues(){
        min = period.getDataStorage().getMinOutsideTemp();
        max = period.getDataStorage().getMaxOutsideTemp();
        average = period.getDataStorage().getMeanOutsideTemp();
        Mode = period.getDataStorage().getModeOutsideTemp();
        Median = period.getDataStorage().getMedianOutsideTemp();
        stdDev = period.getDataStorage().getStandardDeviationOutsideTemp();
    }

    @Override
    protected void OnButtonRed() {
        //runs when red button is pressed(runs once, its an actual bu)
    }

    private ArrayList<Double> getUnit(ArrayList<Measurement> measurements) {
        ArrayList<Double> data = new ArrayList<>();
        for (int i = 0; i < measurements.size(); i++) data.add(measurements.get(i).getOutsideTemp());
        return data;
    }

    private PixelGrid ShiftToLeft(PixelGrid pixelGrid) {
        for (int x = leftBoundary + 1; x <= rightBoundary; x++) {
            for (int y = topBoundary; y <= bottomBoundary - 1; y++) {
//                if (pixelGrid.PixelGrid[y][1] == true) {
//                    HelperFunctions.SetDisplayPixel(false, 1, y);
//                    pixelGrid.PixelGrid[y][1] = false;
//                }
                if (pixelGrid.PixelGrid[y][x] == true) {
                    HelperFunctions.SetDisplayPixel(false, x, y);
                    HelperFunctions.SetDisplayPixel(true, x-1, y);
                    pixelGrid.PixelGrid[y][x] = false;
                    pixelGrid.PixelGrid[y][x-1] = true;
                }
            }
        }
        return pixelGrid;
    }

    private double CalculateMean() {
        double sum = 0;
        int nValues = 0;
        for (int i = Math.round(step * (xIndex - leftBoundary)); i < Math.round(step * (xIndex - leftBoundary + 1)); i++) {
            sum += temperatures.get(i);
            if (!Double.isNaN(temperatures.get(i))) nValues++;
        }
        return sum / nValues;
    }
}