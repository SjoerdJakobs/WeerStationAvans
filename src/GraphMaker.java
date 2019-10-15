import java.util.ArrayList;
import java.lang.Math;

public class GraphMaker {

    public static void createGraph(ArrayList<Double> measurements) {

        byte topBoundary = 9;
        byte rightBoundary = 127;
        byte bottomBoundary = 31;
        byte leftBoundary = 0;

        // Draw the x and y axels on the left- and bottom boundary
        //for (int i = leftBoundary; i <= rightBoundary; i++) HelperFunctions.SetDisplayPixel(true, i, bottomBoundary);
        //for (int i = topBoundary; i <= bottomBoundary; i++) HelperFunctions.SetDisplayPixel(true, leftBoundary, i);

        // Draw the graph
        double step = measurements.size() / (rightBoundary - leftBoundary); // One dot on the DotMatrixDisplay
        double maxValue = Calculations.maximum(measurements);
        double minValue = Calculations.minimum(measurements);
        double amplitudeValue = maxValue - minValue;
        int amplitudeGraph = bottomBoundary - topBoundary - 1; // Minus one to prevent the graph from drawing on the x-axes

        double sum, average;
        int nValues, oldResult, result = 0;

        /*********** UNUSED
        // Create frame
        boolean[][] frame = new boolean[32][128];
        for (int i = 0; i < 128; i++)
            for (int j = 0; j < 32; j++)
                frame[i][j] = false;
         ************/

        for (int x = leftBoundary + 1; x <= rightBoundary; x++) { // Plus one to prevent the graph from drawing on the y-axes
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
            HelperFunctions.SetDisplayPixel(true, x, bottomBoundary - result - 1);

            if (result - oldResult > 1) {
                for (int i = oldResult + 1; i < result; i++) {
                    HelperFunctions.SetDisplayPixel(true, x, bottomBoundary - i - 1);
                }
            }
            else if (result - oldResult < -1) {
                for (int i = oldResult - 1; i > result; i--) {
                    HelperFunctions.SetDisplayPixel(true, x, bottomBoundary - i - 1);
                }
            }
        } // End for-loop
    } // End function
} // End class
