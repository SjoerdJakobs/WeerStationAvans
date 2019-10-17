import java.util.ArrayList;
import java.lang.Math;

public class GraphMaker {

    /**
     * Draw the axels of the graph
     * @param topBoundary Boundary of the top for the container in which the graph is displayed
     * @param rightBoundary Boundary of the right side for the container in which the graph is displayed
     * @param bottomBoundary Boundary of the bottom for the container in which the graph is displayed
     * @param leftBoundary Boundary of the left side for the container in which the graph is displayed
     * @param yAxel The position on the x-axel for the vertical (y-)axel
     */
    public static void CreateAxels(int topBoundary, int rightBoundary, int bottomBoundary, int leftBoundary, int yAxel) {
        for (int i = leftBoundary; i <= rightBoundary; i++) HelperFunctions.SetDisplayPixel(true, i, bottomBoundary);
        for (int i = topBoundary; i <= bottomBoundary; i++) HelperFunctions.SetDisplayPixel(true, yAxel, i);
    }

    /**
     * Redraw the yAxel
     * @param topBoundary Boundary of the top for the container in which the graph is displayed
     * @param bottomBoundary Boundary of the bottom for the container in which the graph is displayed
     * @param yAxel The position on the x-axel for the vertical (y-)axel
     */
    public static void RedrawYAxel(int topBoundary, int bottomBoundary, int yAxel) {
        for (int i = topBoundary; i <= bottomBoundary; i++) HelperFunctions.SetDisplayPixel(true, yAxel, i);
    }

    /**
     * Shift the graph one dot to the left
     * @param pixelGrid 2DArray with current image on DotMatrixDisplay
     * @return updated pixelGrid
     */
    public static PixelGrid ShiftGraphToLeft(PixelGrid pixelGrid, int topBoundary, int rightBoundary, int bottomBoundary, int leftBoundary) {
        for (int x = leftBoundary; x <= rightBoundary; x++) {
            for (int y = topBoundary; y <= bottomBoundary - 1; y++) {
                if (pixelGrid.PixelGrid[y][x] == true) {
                    // Shift the dots one to the left
                    HelperFunctions.SetDisplayPixel(false, x, y);
                    HelperFunctions.SetDisplayPixel(true, x-1, y);

                    // Update the pixelGrid with updated shown graph
                    pixelGrid.PixelGrid[y][x] = false;
                    if (x != 0) pixelGrid.PixelGrid[y][x-1] = true;
                }
            }
        }
        return pixelGrid;
    }

    public static double CalculateUnitValueAverage(ArrayList<Double> unitValues, int xIndex, int step, int leftBoundary) {
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

    public static PixelGrid GraphVerticalGapFiller(PixelGrid pixelGrid, int result, int oldResult, int drawColomn, int bottomBoundary) {
        if (result - oldResult > 1) {
            for (int i = oldResult + 1; i < result; i++) {
                pixelGrid.PixelGrid[bottomBoundary - i - 1][drawColomn] = true; // Minus one to prevent from drawing on the x-axel
            }
        }
        else if (result - oldResult < -1) {
            for (int i = oldResult - 1; i > result; i--) {
                pixelGrid.PixelGrid[bottomBoundary - i - 1][drawColomn] = true; // Minus one to prevent from drawing on the x-axel
            }
        }
        return pixelGrid;
    }

    // OLD FUNCTIONS

    public static PixelGrid createGraph(ArrayList<Double> measurements) {

        // Create frame
        PixelGrid frame = new PixelGrid();
        for (int i = 0; i < frame.PixelGrid.length; i++) {
            for (int j = 0; j < frame.PixelGrid[0].length; j++) {
                frame.PixelGrid[i][j] = false;
            }
        }

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

        return frame;
    } // End function


} // End class
