import java.util.ArrayList;

public class MaxRain {
    public  static void run() {
        ArrayList<RawMeasurement> rawDatas = DatabaseConnection.getMeasurementsLastYear();
        ArrayList<Measurement> measurements = new ArrayList<Measurement>();

        double max = 0.0;
        double finalMax = 0.0;
        for (int i = 0; i < rawDatas.size(); i++) {
            measurements.add(new Measurement(rawDatas.get(i)));
            if (measurements.get(i).getRainRate() != null) {
                if (measurements.get(i).getRainRate() > 0) {
                    max += measurements.get(i).getRainRate();
                } else {
                    if (max > finalMax) {
                        finalMax = max;
                    }
                    max = 0;
                }
            }
        }
        System.out.println("max rain is " +finalMax);
    }
}
