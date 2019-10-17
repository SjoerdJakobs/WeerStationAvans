import java.util.ArrayList;
import java.time.LocalDate;

public class ExampleTab2 extends Tab
{
    protected ExampleTab2(Menu menu) {
        super(menu);
    }

    // Get raw measurements of period
    private Period period = new Period(LocalDate.of(2010, 10, 20), LocalDate.of(2010, 11, 30));

    // Get measurements from period
    private ArrayList<Measurement> measurements = period.getDataStorage().getPeriodMeasurements();

    // In this TAB, we want all the outside temperatures
    ArrayList<Double> unitValues = GetUnit(measurements);

    // Create a PixelGrid to keep track of the shown dots
    PixelGrid graph = new PixelGrid();

    // MENU VARIABLES
    private int menuCounter = 0;
    private boolean showGraph = false;

    // DATA VARIABLES
    private double currentUnitValue;
    private double minUnitValue = period.getDataStorage().getMinOutsideTemp();
    private double maxUnitValue = period.getDataStorage().getMaxOutsideTemp();;
    private double averageUnitValue = period.getDataStorage().getMeanOutsideTemp();;
    private double ModeUnitValue = period.getDataStorage().getModeOutsideTemp();;
    private double MedianUnitValue = period.getDataStorage().getMedianOutsideTemp();;
    private double stdDevUnitValue = period.getDataStorage().getStandardDeviationOutsideTemp();;

    // GRAPH VARIABLES
    private int topBoundary = 8;
    private int rightBoundary = 127;
    private int bottomBoundary = 29;
    private int leftBoundary = 0;
    private int yAxel = 20; // The position on the x-axel for the vertical (y-)axel
    private double minValue = Calculations.minimum(unitValues);
    private double maxValue = Calculations.maximum(unitValues);
    private double amplitudeOfUnitValues = maxValue - minValue;
    private int    amplitudeOfGraph = bottomBoundary - topBoundary - 1; // Minus one to not draw on the x-axes

    private int xIndex, oldResult = 0, step = 50, graphRestart = 0, drawColomn = 127;
    private double positionBar = unitValues.size() / step / (double)(rightBoundary - leftBoundary);

    private double deltaTimer = 0;
    private double graphSpeed = 0.03;

    // Runs when tab is opened
    @Override
    protected void OnOpen() {
        HelperFunctions.ClearAll();
        m_menu.DrawMenu();

        // Get current temperature
        RawMeasurement rawData = DatabaseConnection.getMostRecentMeasurement();
        Measurement measurement = new Measurement(rawData);
        currentUnitValue = measurement.getOutsideTemp();
        HelperFunctions.WriteOnMatrixScreen(String.format("\nOutside Temperature\ncurrent: %.2f", currentUnitValue) + " C");
    }

    @Override
    protected void OnClose() {
        //runs when tab is closed
        System.out.println("exampletab 2 closed");

    }

    @Override
    protected void Run(double deltaTime) {
        deltaTimer += deltaTime;

        if (showGraph == true && deltaTimer >= graphSpeed) {
            deltaTimer = 0;

            // Create new PixelGrid to update the main PixelGrid each run
            PixelGrid addToGraph = new PixelGrid();

            // Shift graph to the left only if there are more than two colomns
            if (xIndex > 0) {
                graph = GraphMaker.ShiftGraphToLeft(graph, topBoundary, rightBoundary, bottomBoundary, leftBoundary);
                GraphMaker.RedrawYAxel(topBoundary, bottomBoundary, yAxel);
            }

            // Current xIndex must be able to get values from ArrayList temperatures
            if (unitValues.size() > Math.round(step * (xIndex - leftBoundary + 1))) {
                // VARIABLES
                int result;
                double unitValuesAverage = GraphMaker.CalculateUnitValueAverage(unitValues, xIndex, step, leftBoundary);

                if (!Double.isNaN(unitValuesAverage)) {
                    result = (int)Math.round((unitValuesAverage - minValue) / amplitudeOfUnitValues * (double)amplitudeOfGraph);

                    // If first colomn, create fake oldResult
                    if (xIndex == 0) oldResult = result;

                    // Update the pixelGrid with latest result
                    addToGraph.PixelGrid[bottomBoundary - result - 1][drawColomn] = true;
                } // End if-statement check if value is not NaN
                else
                    // If value is NaN, use oldResult
                    result = oldResult;

                // Fill vertical gaps between two consecutive values if needed
                addToGraph = GraphMaker.GraphVerticalGapFiller(addToGraph, result, oldResult, drawColomn, bottomBoundary);

                // Update for next run cycle
                oldResult = result;

                // Show position bar below graph
                positionBar = unitValues.size() / step / (double)(rightBoundary - leftBoundary);
                for (int y = bottomBoundary + 1; y <= 31; y++) {
                    HelperFunctions.SetDisplayPixel(true, (int)Math.ceil(xIndex / positionBar), y);
                    HelperFunctions.SetDisplayPixel(false, (int)Math.ceil(xIndex / positionBar ) - 2, y);
                }
            } // End if-statement current step is within unitValue's size

            // Else (if all values are shown as graph), restart the graph
            else {
                // Remove latest unitValueAverage on segments
                if (xIndex - (drawColomn - yAxel) == unitValues.size() / step )
                    HelperFunctions.ClearAllSegmentDisplays();

                // Position bar goes back to the beginning
                for (int y = bottomBoundary + 1; y <= 31; y++) {
                    HelperFunctions.SetDisplayPixel(true, 127 - graphRestart - 2, y);
                    HelperFunctions.SetDisplayPixel(false, 127 - graphRestart, y);
                }

                // Create empty width before showing the graph again
                graphRestart++;
                if (graphRestart == 128) {
                    xIndex = -1; // -1 + incremental = index 0
                    graphRestart = 0;
                }
            } // End else

            // Give unitValueAverage of position yAxel
            double unitValueAverageOnYAxel;
            if (unitValues.size() > Math.round(step * (xIndex - (drawColomn - yAxel) - leftBoundary + 1))) {
                unitValueAverageOnYAxel = GraphMaker.CalculateUnitValueAverage(unitValues, xIndex - (drawColomn - yAxel), step, leftBoundary);
                if (!Double.isNaN(unitValueAverageOnYAxel)) {
                    HelperFunctions.ClearAllSegmentDisplays();
                    HelperFunctions.WriteValueOnSegments(1, unitValueAverageOnYAxel, 1);
                }
                else HelperFunctions.ClearAllSegmentDisplays();
            }

            PixelGridDrawer.INSTANCE_DRAWER.AddDraw(addToGraph.PixelGrid);
            xIndex++;

            // Update graph: add the last colomn
            graph.OrGrid(addToGraph);
        } // End if-statement showGraph

    }

    @Override
    protected void OnButtonBlueTwo() {
        menuCounter++;
        HelperFunctions.ClearAll();
        m_menu.DrawMenu();

        switch (menuCounter % 8) {
            case 0:
                showGraph = false;

                // Get current temperature
                RawMeasurement rawData = DatabaseConnection.getMostRecentMeasurement();
                Measurement measurement = new Measurement(rawData);
                currentUnitValue = measurement.getOutsideTemp();
                HelperFunctions.WriteOnMatrixScreen(String.format("\nOutside Temperature\ncurrent: %.2f", currentUnitValue) + " C");
                break;
            case 1:
                // Test function
                double testValue = 10.0;
                HelperFunctions.WriteValueOnSegments(1, testValue, 1);

                HelperFunctions.WriteOnMatrixScreen(String.format("\nOutside Temperature\nmin: %.2f", minUnitValue) + " C");
                break;
            case 2:
                HelperFunctions.WriteOnMatrixScreen(String.format("\nOutside Temperature\nmax: %.2f", maxUnitValue) + " C");
                break;
            case 3:
                HelperFunctions.WriteOnMatrixScreen(String.format("\nOutside Temperature\naverage: %.2f", averageUnitValue) + " C");
                break;
            case 4:
                HelperFunctions.WriteOnMatrixScreen(String.format("\nOutside Temperature\nmodus: %.2f", ModeUnitValue) + " C");
                break;
            case 5:
                HelperFunctions.WriteOnMatrixScreen(String.format("\nOutside Temperature\nmedian: %.2f", MedianUnitValue) + " C");
                break;
            case 6:
                HelperFunctions.WriteOnMatrixScreen(String.format("\nOutside Temperature\nstd deviation: %.2f", stdDevUnitValue));
                break;
            case 7:
                showGraph = true;

                // Draw x-axel
                PixelGrid graph = new PixelGrid();
                for (int i = leftBoundary; i <= rightBoundary; i++) graph.PixelGrid[bottomBoundary][i] = true;
                PixelGridDrawer.INSTANCE_DRAWER.AddDraw(graph.PixelGrid);
                break;
        } // End switch-case
    } // End function OnButtonBlueTwo

    @Override
    protected void OnButtonRed() {
        //runs when red button is pressed(runs once, its an actual bu)

        System.out.println("exampletab 2 redbutton pressed");
    }

    private ArrayList<Double> GetUnit(ArrayList<Measurement> measurements) {
        ArrayList<Double> data = new ArrayList<>();
        for (int i = 0; i < measurements.size(); i++) data.add(measurements.get(i).getOutsideTemp());
        return data;
    }

}
