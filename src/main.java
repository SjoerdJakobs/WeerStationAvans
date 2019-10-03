import java.util.ArrayList;

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
//        RawMeasurement rawData = DatabaseConnection.getMostRecentMeasurement();
//        Measurement thisAfternoon =  new Measurement(rawData);

//        System.out.println(thisAfternoon.getOutsideTemp());


        /**
         * get the mean of temperatures from the last hour
//         */
        ArrayList<RawMeasurement> rawDatas = DatabaseConnection.getMeasurementsLastDays(1);
        ArrayList<Measurement> measurements = new ArrayList<Measurement>();
        ArrayList<Double> temperature = new ArrayList<>();
//        ArrayList<Double> maxTemp = new ArrayList<>();
//        ArrayList<Double> minTemp = new ArrayList<>();

        for (int i = 0; i < rawDatas.size(); i++)
        {
            measurements.add(new Measurement(rawDatas.get(i)));
            temperature.add(measurements.get(i).getOutsideTemp());
//            measurements.get(1).getDateStamp().getDayOfYear();
//            maxTemp.add(measurements.get(i).getOutsideTemp());
//            minTemp.add(measurements.get(i).getOutsideTemp());
        }
//        System.out.println(temperature.size());
        int dagen = 4;
        Graaddagen graaddagen = new Graaddagen(dagen);
        System.out.println("Graaddagen over de afgelope "+ dagen+ " dagen: " +graaddagen.calculateGraaddagen());
//        System.out.println("Max outside last hour: " + MSD.maximum(maxTemp));
//        System.out.println("Min outside last hour: " + MSD.minimum(minTemp));
//        String strDouble = String.format("%.2f", MSD.mean(temperature));
//        System.out.println(MSD.mean(temperature));
//        HelperFunctions.WriteOnMatrixScreen("Mean temperature past hour: " + strDouble);
    }
}