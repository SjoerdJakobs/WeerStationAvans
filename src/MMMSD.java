import java.util.ArrayList;
import java.util.Arrays;
import static java.lang.Math.sqrt;

public class MMMSD {
    /**
     * calculate the mode (most frequent number in the array)
     *
     */
    public static double mode(ArrayList<Double> array){
        double most = 0;
        int mostCount = 0;

        for(int i = 0; i < array.size(); i++){
            int count = 0;

            for(int j = 0; j < array.size(); j++){
                if (array.get(j) == array.get(i)){
                    count++;
                }

                if ( count > mostCount){
                    mostCount = count;
                    most = array.get(i);
                }
            }
        }
        return most;
    }

    /**
     *
     * calculate the median (the middle value of a sorted array)
     */

    public static double median(ArrayList<Double> array){
        double[] sorted = new double[array.size()];

        System.arraycopy(array, 0, sorted,0,array.size());
        Arrays.sort(sorted);

        if (array.size() % 2 ==0){
            return (sorted[(sorted.length / 2) - 1] + sorted[sorted.length / 2]) / 2;
        } else {
            return sorted[sorted.length / 2];
        }
    }

    /**
     *
     * calculate the mean
     */
    public static double mean(ArrayList<Double> array){
        double sum = 0;
        double average = 0;

        for (int i = 0; i < array.size(); i++){
            sum = sum + array.get(i);
            average = sum / array.size();
        }
        return average;
    }

    /**
     *
     * calculate the standard deviation
     */
    public static double standardDeviation(ArrayList<Double> array){
        double sd = 0;
        for (int i = 0; i < array.size(); i++){
            sd = sd + ((sqrt((array.get(i) - mean(array))* (array.get(i) - mean(array))))/ (array.size() - 1));
        }
        return sd;
    }

    /**
     *
     * calculate the minimum
     */
    public static double minimum(ArrayList<Double> array){
        double minimum = array.get(0);
        for (int i = 0; i < array.size(); i++){
            if (array.get(i) < minimum){
                minimum = array.get(i);
            }
        }
        return minimum;
    }

    /**
     *
     * calculate the maximum
     */
    public static double maximum(ArrayList<Double> array){
        double maximum = 0;
        for (int i = 0; i < array.size(); i++){
            if (array.get(i) > maximum){
                maximum = array.get(i);
            }
        }
        return maximum;
    }
}
