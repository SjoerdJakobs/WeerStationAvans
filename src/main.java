import java.util.ArrayList;
import java.util.RandomAccess;
import java.util.concurrent.atomic.DoubleAccumulator;

public class main
{

    public static void main(String[] args)
    {
        IO.init();
        HelperFunctions.ClearAll();
        ArrayList<RawMeasurement> rawMeasurements = DatabaseConnection.getMeasurementsLastYear();

        ArrayList<Measurement> measurements = new ArrayList<Measurement>();

        for (int i = 0; i < rawMeasurements.size(); i++) {
        measurements.add(new Measurement(rawMeasurements.get(i)));
        }

        System.out.println(Calculations.mist(measurements));
    }
}
