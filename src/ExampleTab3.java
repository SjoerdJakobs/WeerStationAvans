import java.util.ArrayList;
import java.time.LocalDate;
import java.lang.Math;

public class ExampleTab3 extends Tab
{
    private byte topBoundary = 8;
    private byte rightBoundary = 127;
    private byte bottomBoundary = 31;
    private byte leftBoundary = 0;

    // Get raw measurements of period
    Period period = new Period(LocalDate.of(2010, 11, 1), LocalDate.of(2010, 11, 30));

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

    double mean, deltaTimer;
    int xIndex, oldResult, result = 0, step = 50, graphRestart = 0, currentColomn = 0;

    // Menu
    protected ExampleTab3(Menu menu) {
        super(menu);
    }

    @Override
    protected void OnOpen() {
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

        if (showGraph == true && deltaTimer >= 0.03) {
            PixelGrid addToGraph = new PixelGrid();

            System.out.println("xIndex: " + xIndex);

            if (xIndex > 127) {
                graph = ShiftToLeft(graph);

            }

            // Variables
            double sum = 0;
            int nValues = 0;
            for (int i = Math.round(step * (xIndex - leftBoundary)); i < Math.round(step * (xIndex - leftBoundary + 1)); i++) {
                sum += temperatures.get(i);
                nValues++;
            }
            mean = sum / nValues;

            // Push previous result in old result for later to compare
            oldResult = result;
            result = (int)Math.round((mean - minValue) / amplitudeValue * (double)amplitudeGraph);

            // If xIndex out of bound, keep xIndex = 127 while rest of graph ShiftToLeft()
            if (xIndex <= 127) addToGraph.PixelGrid[bottomBoundary - result - 1][xIndex] = true;
            else addToGraph.PixelGrid[bottomBoundary - result - 1][127] = true;

            // Create a vertical line for value jumps > 1
            if (result - oldResult > 1) {
                for (int i = oldResult + 1; i < result; i++) {
                    addToGraph.PixelGrid[bottomBoundary - i - 1][xIndex] = true; // Minus one to prevent from drawing on the x-axel
                }
            }
            else if (result - oldResult < -1) {
                for (int i = oldResult - 1; i > result; i--) {
                    addToGraph.PixelGrid[bottomBoundary - i - 1][xIndex] = true; // Minus one to prevent from drawing on the x-axel
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
                graph = GraphMaker.createAxels(graph);
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
                if (pixelGrid.PixelGrid[y][1] == true) {
                    HelperFunctions.SetDisplayPixel(false, 1, y);
                    pixelGrid.PixelGrid[y][1] = false;
                }
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
}