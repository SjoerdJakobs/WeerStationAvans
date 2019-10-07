import java.util.ArrayList;
import java.time.LocalDateTime;

public class main
{

    public static void main(String[] args)
    {
        IO.init();
        HelperFunctions.ClearAll();


        /**
         * this will later be moved to other places.
         * we know this should not be put in the main.
         */

        /**
         * get last temperature, put it on the display and print
         */
        RawMeasurement rawData = DatabaseConnection.getMostRecentMeasurement();
        Measurement thisAfternoon =  new Measurement(rawData);
        thisAfternoon.getInsideHum();

        System.out.println(thisAfternoon.getOutsideTemp());

        String strDouble = String.format("%.2f", thisAfternoon.getOutsideTemp());
        HelperFunctions.WriteOnMatrixScreen("OutsideTemp " + strDouble + "    bovenste value is ooktemperatuur");
        HelperFunctions.WriteValueOnSegments(1,thisAfternoon.getOutsideTemp(), 3);


        /**
        * get the mean of temperatures from the last hour
        */
        ArrayList<RawMeasurement> rawDatas = DatabaseConnection.getMeasurementsLastHour();
        ArrayList<Measurement>  measurements = new ArrayList<Measurement>();

        Double mean = 0.0;
        for (int i = 0; i < rawDatas.size(); i++)
        {
            measurements.add(new Measurement(rawDatas.get(i)));
            mean += measurements.get(i).getOutsideTemp();
        }
        mean /= measurements.size();

        System.out.println(mean);

        MaxRain.run();

    }
}
