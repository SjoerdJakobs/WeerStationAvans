import java.util.ArrayList;

public class MaxRain {
    public static void GetMaxRain(ArrayList<Double> rainRates) {

        double max = 0.0;
        double finalMax = 0.0;

        for (int i = 0; i < rainRates.size(); i++) {
            if (rainRates.get(i) > 0) {
                max += rainRates.get(i);
            } else {
                if (max > finalMax) {
                    finalMax = max;
                }
                max = 0;
            }
        }
        System.out.println("max rain is " + finalMax);
    }
}
