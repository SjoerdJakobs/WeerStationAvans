import java.time.LocalDateTime;
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
        /*RawMeasurement rawData = DatabaseConnection.getMostRecentMeasurement();
        Measurement thisAfternoon =  new Measurement(rawData);

        System.out.println(thisAfternoon.getOutsideTemp());


        /**
        * get the mean of temperatures from the last hour
        */
        /*ArrayList<RawMeasurement> rawDatas = DatabaseConnection.getMeasurementsLastHour();
        ArrayList<Measurement> measurements = new ArrayList<Measurement>();
        ArrayList<Double> temperature = new ArrayList<>();
        ArrayList<Double> maxTemp = new ArrayList<>();
        ArrayList<Double> minTemp = new ArrayList<>();
        */

        //ArrayList<RawMeasurement> rawDatas2 = DatabaseConnection.getMeasurementsLastDay();
        ArrayList<RawMeasurement> rawDatas2 = DatabaseConnection.getMeasurementsBetween(LocalDateTime.of(2010,7,1,0,0,0,0), LocalDateTime.of(2010, 7,5,0,0,0,0));
        ArrayList<Measurement> measurments2 = new ArrayList<Measurement>();
        ArrayList<Double> insideTemp = new ArrayList<>();
        ArrayList<Double> outsideTemp = new ArrayList<>();

        for (int j = 0; j < rawDatas2.size(); j++){
            measurments2.add(new Measurement(rawDatas2.get(j)));
            insideTemp.add(measurments2.get(j).getInsideTemp());
            outsideTemp.add(measurments2.get(j).getOutsideTemp());
        }
        System.out.println("Outside and inside temperatures cross " + Opdracht2.tempChange(measurments2, outsideTemp) + " amount of times.");

        /*for (int i = 0; i < rawDatas.size(); i++)
        {
            measurements.add(new Measurement(rawDatas.get(i)));
            temperature.add(measurements.get(i).getOutsideTemp());
            maxTemp.add(measurements.get(i).getOutsideTemp());
            minTemp.add(measurements.get(i).getOutsideTemp());

        }

        System.out.println("Max outside last hour: " + MMMSD.maximum(maxTemp));
        System.out.println("Min outside last hour: " + MMMSD.minimum(minTemp));
        String strDouble = String.format("%.2f", MMMSD.mean(temperature));
        HelperFunctions.WriteOnMatrixScreen("Mean temperature past hour: " + strDouble);
        */
    }
}