import java.util.ArrayList;
import java.lang.Math;

public class GraphMaker {

    public static PixelGrid createAxels(PixelGrid pixelGrid) {
        // Draw the x and y axels on the left- and bottom boundary
        for (int i = 0; i <= 127; i++) pixelGrid.PixelGrid[31][i] = true;
        for (int i = 8; i <= 31; i++) pixelGrid.PixelGrid[i][0] = true;
        return pixelGrid;
    }

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
            frame.PixelGrid[bottomBoundary - result - 1][x]= true; // Minus one to prevent from drawing on the x-axel

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
