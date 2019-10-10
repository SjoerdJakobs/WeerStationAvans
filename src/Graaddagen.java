import java.io.CharArrayReader;
import java.time.LocalDateTime;
import java.util.ArrayList;



public class Graaddagen
{

    /**
     * Author: Samir Rademakers.
     *
     * This function calculates the amount of degreedays over a given period of time.
     * The degreedays of one day are equal to 18 - (the average temperature of that day).
     * If the average temperature of that day was higher than 18, the amount of degreedays of that day is equal to 0.
     *
     * @param begin is the begin date from when you want to calculate the degreedays.
     * @param end is the end date till when you want to calculate the degreedays.
     */

    public int calculateGraaddagen(LocalDateTime begin, LocalDateTime end)
    {

        int degreedays = 0;

        /**
         * The line below creates an arraylist which contains all the raw values from the period.
         */
        ArrayList<RawMeasurement> rawValues = DatabaseConnection.getMeasurementsBetween(begin,end);
//        ArrayList<RawMeasurement> rawValues = DatabaseConnection.getMeasurementsLastYear();

        ArrayList<Measurement> measurements = new ArrayList<Measurement>();
        ArrayList<Double> temperature = new ArrayList<>();

        /**
         * This for-loop first creates a new arraylist which contains the converted values from the raw values,
         * after that it creates and arraylist which only contains the outside temperature measurements from the
         * period.
         */

        for (int i = 0; i < rawValues.size(); i++)
        {
            measurements.add(new Measurement(rawValues.get(i)));
            temperature.add(measurements.get(i).getOutsideTemp());
        }

        /**
         * This for-loop calculates the average outside temperature separately per day from the arraylist temperatures
         * and adds the amount of degreedays of each day to the total amount of degreedays.
         * This for-loop also contains an if-statement which takes care of incorrect values.
         */

        int prevDate = measurements.get(0).getDateStamp().getDayOfYear();
        int OriginalDate = prevDate;
        int teller =0;
        ArrayList<Double> dayTemps = new ArrayList<>();
        for (int counter = 0; counter<measurements.size(); counter++)
        {
            if (measurements.get(counter).getDateStamp().getDayOfYear() == prevDate)
            {
                if (!Double.isNaN(temperature.get(counter)))
                {
                    dayTemps.add(temperature.get(counter));
                }
            }
            else if (measurements.get(counter).getDateStamp().getDayOfYear() != prevDate)
            {
               int degreeDifference = 18 - ((int)Math.round(Calculations.mean(dayTemps)));
                if (degreeDifference > 0)
                {
                    degreedays = degreedays + degreeDifference;
                }

                System.out.println(measurements.get(counter).getDateStamp());
                System.out.println("Dag: "+measurements.get(counter).getDateStamp().getDayOfYear());
                System.out.println("Graaddagen: "+degreeDifference);
                System.out.println("");
                teller++;

                 dayTemps.clear();
                 prevDate = measurements.get(counter).getDateStamp().getDayOfYear();
            }
        }
        /**
         * This if-statement calculates the amount of degreedays in case the given period was only one day.
         */

        if (prevDate == OriginalDate && degreedays == 0)
        {
            int degreeDifference = 18 - (int) Calculations.mean(dayTemps);
            degreedays = degreedays + degreeDifference;
        }
        System.out.println(teller);
        return degreedays;
    }
}

