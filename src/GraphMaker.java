import java.util.ArrayList;

public class GraphMaker {

    ArrayList<Double> unitValues;
    private PixelGrid graph = new PixelGrid();

    // Variables for graph boundaries an axels
    private int topBoundary = 8;
    private int rightBoundary = 127;
    private int bottomBoundary = 29;
    private int leftBoundary = 0;
    private int yAxel = 20; // The position on the x-axel for the vertical (y-)axel

    // Variables to calculate graph itself.
    private int xIndex;
    private int oldResult = 0;
    private int result;
    private int step;
    private int graphRestart = 0;
    private int drawColomn = 127;
    private int amplitudeOfGraph;

    private double minValue;
    private double maxValue;
    private double amplitudeOfUnitValues;
    private double positionBar;
    private double oldAverage = Double.NaN;

    /**
     * Initialise most static variables
     * @param unitValues The ArrayList<Double> with all the values of a unit
     */
    public void initialise(ArrayList<Double> unitValues) {
        this.unitValues = unitValues;

        step = SavedData.INSTANCE.GetGraphStep();;
        minValue = Calculations.minimum(unitValues);
        maxValue = Calculations.maximum(unitValues);
        amplitudeOfUnitValues = maxValue - minValue;
        amplitudeOfGraph = bottomBoundary - topBoundary - 1; // Minus one to not draw on the x-axes
        positionBar = unitValues.size() / step / (double)(rightBoundary - leftBoundary);

    }

    /**
     * Draw the horizontal (x-)axel
     */
    public void DrawAxels() {
        for (int i = leftBoundary; i <= rightBoundary; i++) graph.PixelGrid[bottomBoundary][i] = true;
        PixelGridDrawer.INSTANCE_DRAWER.AddDraw(graph.PixelGrid);
    }

    /**
     * Create a new dot each time you run through the cycle.
     */
    public void RunCycle() {
        // Create new PixelGrid to update the main PixelGrid each run
        PixelGrid addToGraph = new PixelGrid();

        // Shift graph to the left only if there are more than two colomns
        if (xIndex > 0) {
            ShiftGraphToLeft();
            RedrawYAxel();
        }

        // Current xIndex must be able to get values from ArrayList temperatures
        if (unitValues.size() > Math.round(step * (xIndex - leftBoundary + 1))) {
            // VARIABLES
            double average = CalculateAverage(xIndex);

            if (!Double.isNaN(average)) {
                result = (int)Math.round((average - minValue) / amplitudeOfUnitValues * (double)amplitudeOfGraph);

                // If first colomn, create fake oldResult
                if (xIndex == 0) oldResult = result;

                // Update the pixelGrid with latest result
                addToGraph.PixelGrid[bottomBoundary - result - 1][drawColomn] = true;
            } // End if-statement check if value is not NaN
            else
                // If value is NaN, use oldResult
                result = oldResult;

            // Fill vertical gaps between two consecutive values if needed
            if (!Double.isNaN(oldAverage)) GraphVerticalGapFiller();
            oldAverage = average;

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

        // Calculate value on yAxel and show in top 7 segments display
        double unitValueAverageOnYAxel = 0;
        if (unitValues.size() > Math.round(step * (xIndex - (drawColomn - yAxel) - leftBoundary + 1))) {
            unitValueAverageOnYAxel = CalculateAverage(xIndex - (drawColomn - yAxel));
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
    }


    /**
     * Draw the axels of the graph
     */
    private void CreateAxels() {
        for (int i = leftBoundary; i <= rightBoundary; i++) HelperFunctions.SetDisplayPixel(true, i, bottomBoundary);
        for (int i = topBoundary; i <= bottomBoundary; i++) HelperFunctions.SetDisplayPixel(true, yAxel, i);
    }

    /**
     * Redraw the yAxel
     */
    private void RedrawYAxel() {
        for (int i = topBoundary; i <= bottomBoundary; i++) HelperFunctions.SetDisplayPixel(true, yAxel, i);
    }

    /**
     * Shift the graph one dot to the left
     */
    private void ShiftGraphToLeft() {
        for (int x = leftBoundary; x <= rightBoundary; x++) {
            for (int y = topBoundary; y <= bottomBoundary - 1; y++) {
                if (graph.PixelGrid[y][x] == true) {
                    // Shift the dots one to the left
                    HelperFunctions.SetDisplayPixel(false, x, y);
                    HelperFunctions.SetDisplayPixel(true, x-1, y);

                    // Update the pixelGrid with updated shown graph
                    graph.PixelGrid[y][x] = false;
                    if (x != 0) graph.PixelGrid[y][x-1] = true;
                }
            }
        }
    }

    /**
     * Calculate the average of a dot
     * @param xIndex The index of the dot of which the average must be calculated
     * @return the average if the xIndex if valid, else return NaN
     */
    private double CalculateAverage(int xIndex) {
        double sum = 0;
        int nValues = 0;

        if (xIndex >= 0) {
            for (int i = Math.round(step * (xIndex - leftBoundary)); i < Math.round(step * (xIndex - leftBoundary + 1)); i++) {
                sum += unitValues.get(i);
                if (!Double.isNaN(unitValues.get(i))) nValues++;
            }
            return sum / nValues;
        }
        else
            return Double.NaN;
    }

    /**
     * Create a vertical line between two consecutive dots if there's a vertical gap between the two dots
     */
    private void GraphVerticalGapFiller() {
        // TODO EXPERIMENTAL IMPROVEMENT
        /*
        for (int i = -1; i <= 1; i += 2) {
            if (result - oldResult > i) {
                for (int j = oldResult + i; j < result; j += i) {
                    graph.PixelGrid[bottomBoundary - j - 1][drawColomn] = true; // Minus one to prevent from drawing on the x-axel
                }
            }
        }
        */

        if (result - oldResult > 1) {
            for (int i = oldResult + 1; i < result; i++) {
                graph.PixelGrid[bottomBoundary - i - 1][drawColomn] = true; // Minus one to prevent from drawing on the x-axel            }
            }
        }
        else if (result - oldResult < -1) {
            for (int i = oldResult - 1; i > result; i--) {
                graph.PixelGrid[bottomBoundary - i - 1][drawColomn] = true; // Minus one to prevent from drawing on the x-axel            }
            }
        }
    }

    /**
     * Print a static graph
     * @param measurements
     */
    public static void createStaticGraph(ArrayList<Double> measurements) {

        PixelGrid frame = new PixelGrid();

        byte topBoundary = 8;
        byte rightBoundary = 127;
        byte bottomBoundary = 31;
        byte leftBoundary = 0;

        // Draw the x and y axels on the left- and bottom boundary
        for (int i = leftBoundary; i <= rightBoundary; i++) frame.PixelGrid[bottomBoundary][i] = true;
        for (int i = topBoundary; i <= bottomBoundary; i++) frame.PixelGrid[i][leftBoundary] = true;

        // Draw the graph
        double step = measurements.size() / (rightBoundary - leftBoundary); // One dot on the DotMatrixDisplay
        double maxValue = Calculations.maximum(measurements);
        double minValue = Calculations.minimum(measurements);
        double amplitudeValue = maxValue - minValue;
        int amplitudeGraph = bottomBoundary - topBoundary - 1; // Minus one to prevent the graph from drawing on the x-axes

        double sum, average;
        int nValues, oldResult, result = 0;

        for (int x = leftBoundary + 1; x < rightBoundary; x++) { // Plus one to prevent the graph from drawing on the y-axes
            nValues = 0;
            sum = 0;

            // Calculate the average of one step
            for (int i = (int)Math.round(step * (x - leftBoundary)); i <= (int)Math.round(step * (x - leftBoundary)); i++) {
                sum += measurements.get(i);
                nValues++;
            }
            average = sum / nValues;

            oldResult = result;
            result = (int)Math.round((average - minValue) / amplitudeValue * (double)amplitudeGraph);

            // Draw the result as dot in the graph
            frame.PixelGrid[bottomBoundary - result - 1][x] = true; // Minus one to prevent from drawing on the x-axel

            if (result - oldResult > 1) {
                for (int i = oldResult + 1; i < result; i++) {
                    frame.PixelGrid[bottomBoundary - i - 1][x] = true; // Minus one to prevent from drawing on the x-axel
                }
            }
            else if (result - oldResult < -1) {
                for (int i = oldResult - 1; i > result; i--) {
                    frame.PixelGrid[bottomBoundary - i - 1][x] = true; // Minus one to prevent from drawing on the x-axel
                }
            }
        } // End for-loop with var x

        PixelGridDrawer.INSTANCE_DRAWER.AddDraw(frame.PixelGrid);
    } // End function


} // End class
