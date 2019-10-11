import java.net.CookieHandler;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class Calculations {
    /**
     * calculate the mode (most frequent number in the array)
     */
    public static double mode(ArrayList<Double> array) {
        double most = 0;
        int mostCount = 0;

        for (int i = 0; i < array.size(); i++) {
            int count = 0;

            for (int j = 0; j < array.size(); j++) {
                if (array.get(j) == array.get(i)) {
                    count++;
                }

                if (count > mostCount) {
                    mostCount = count;
                    most = array.get(i);
                }
            }
        }
        return most;
    }

    /**
     * calculate the median (the middle value of a sorted array)
     */
    public static double median(ArrayList<Double> array) {
        Collections.sort(array);

        if (array.size() % 2 == 0) {
            return (array.get((array.size() / 2) - 1) + array.get(array.size() / 2)) / 2;
        } else {
            return array.get(array.size() / 2);
        }
    }

    /**
     * calculate the mean
     */
    public static double mean(ArrayList<Double> array) {
        double sum = 0;
        double average = 0;

        for (int i = 0; i < array.size(); i++) {
            sum = sum + array.get(i);
            average = sum / array.size();
        }
        return average;
    }

    /**
     * calculate the standard deviation
     */
    public static double standardDeviation(ArrayList<Double> array) {
        double sd = 0;
        for (int i = 0; i < array.size(); i++) {
            sd = sd + ((sqrt((array.get(i) - mean(array)) * (array.get(i) - mean(array)))) / (array.size() - 1));
        }
        return sd;
    }

    /**
     * calculate the minimum
     */
    public static double minimum(ArrayList<Double> array) {
        double minimum = array.get(0);
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) < minimum) {
                minimum = array.get(i);
            }
        }
        return minimum;
    }

    /**
     * calculate the maximum
     */
    public static double maximum(ArrayList<Double> array) {
        double maximum = 0;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > maximum) {
                maximum = array.get(i);
            }
        }
        return maximum;
    }

    public static double dewPoint(double outsideTemp, double outsideHumid) {
        double result = outsideTemp - ((100 - outsideHumid) / 5);
        return result;
    }

    public static double windChill(double outsideTemp, double windSpeed) {
        double windchill = 13.12 + (0.6215 * windSpeed) - (11.37 * Math.pow(outsideTemp, 0.16)) + ((0.3965 * windSpeed) * Math.pow(outsideTemp, 0.16));
        return windchill;
    }

    public static double heatIndex(double insideTemp, double insideHumid) {
        insideTemp = ValueConverter.CelsiusToFahrenheit(insideTemp);
        double result = -42.379 + 2.04901523 * insideTemp + 10.14333127 * insideHumid - 0.22475541 * insideTemp * insideHumid - 0.00683783 * insideTemp * insideTemp - 0.05481717 * insideHumid * insideHumid + 0.00122874 * insideTemp * insideTemp * insideHumid + 0.00085282 * insideTemp * insideHumid * insideHumid - 0.00000199 * insideTemp * insideTemp * insideHumid * insideHumid;
        if (insideHumid < 13 && insideTemp > 80 && insideTemp < 112) {
            result = ((13 - insideHumid) / 4) * Math.sqrt((17 - Math.abs(insideTemp - 95.)) / 17);
        } else {
            if (insideHumid > 85 && insideTemp > 80 && insideTemp < 87) {
                result = ((insideHumid - 85) / 10) * ((87 - insideTemp) / 5);
            } else {
                if (result < 80) {
                    result = (insideTemp + 61.0 + ((insideTemp - 68.0) * 1.2) + (insideHumid * 0.094)) * 0.5;
                }
            }
        }
        return ValueConverter.FahrenheitToCelsius(result);
    }

    /**
     * Author: Mick van der Werf.
     * <p>
     * This function checks the difference between outside temperature and dewpoint to determine if there was a chance of mist.
     *
     * @param array consists of the values during the period of which to check the values.
     * Counter: keeps track of how many days it has found.
     * LastDate: keeps track of the last day that was found.
     */
    public static int mist(ArrayList<Measurement> array) {
        int counter = 0;
        int lastDate = 0;
        int result = 0;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getDateStamp().getDayOfYear() != lastDate) {
                if (!Double.isNaN(array.get(i).getOutsideTemp()) && !Double.isNaN(array.get(i).getOutsideHum())) {
                    if (Math.abs(array.get(i).getOutsideTemp() - dewPoint(array.get(i).getOutsideTemp(), array.get(i).getOutsideHum())) < 2.5) {
                        result++;
                        lastDate = array.get(i).getDateStamp().getDayOfYear();
                    }
                }
            }
        }
        return result;
    }

    /**
     * TODO Sjoerd
     */
    public static void MaxRain() {
        ArrayList<RawMeasurement> rawDatas = DatabaseConnection.getMeasurementsLastYear();
        ArrayList<Measurement> measurements = new ArrayList<Measurement>();

        double max = 0.0;
        double finalMax = 0.0;
        for (int i = 0; i < rawDatas.size(); i++) {
            measurements.add(new Measurement(rawDatas.get(i)));
            if (!Double.isNaN(measurements.get(i).getRainRate())) {
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
        System.out.println("max rain is " + finalMax);
    }

    /**
     * Author: Kim
     * Bepaal hoe vaak binnen een periode de binnen- en buitentemperatuur elkaar inhalen. Hiermee
     * bedoelen we dat op een moment de buitentemperatuur boven de binnentemperatuur komt of
     * omgekeerd binnentemperatuur boven de buitentemperatuur komt.
     */
    public static double tempChange(ArrayList<Measurement> inside, ArrayList<Double> outside) {
        int count = 0;
        double insideTemp = inside.get(0).getInsideTemp();
        double outsideTemp = inside.get(0).getOutsideTemp();

        boolean colderOutside = true;

        if (outsideTemp < insideTemp) {
            colderOutside = true;
        } else {
            colderOutside = false;
        }

        for (int i = 0; i < inside.size(); i++) {
            insideTemp = inside.get(i).getInsideTemp();
            outsideTemp = inside.get(i).getOutsideTemp();

            if (colderOutside == true && insideTemp > outsideTemp) {
                count++;
                colderOutside = false;
                System.out.println(inside.get(i).getDateStamp());
            } else if (colderOutside == false && outsideTemp > insideTemp) {
                count++;
                colderOutside = true;
                System.out.println(inside.get(i).getDateStamp());

            }
        }
        return count;
    }

    /**
     * Author: Samir Rademakers.
     *
     * This function calculates the amount of degree days over a given period of time.
     * The degree days of one day are equal to 18 - (the average temperature of that day).
     * If the average temperature of that day was higher than 18, the amount of degree days of that day is equal to 0.
     *
     * @param measurements is an array list that contains all converted measurements from the period of time.
     */

    public int calculateDegreeDays(ArrayList<Measurement> measurements)
    {
        int degreedays = 0;
        ArrayList<Double> temperature = new ArrayList<>();
        /**
         * The for-loop below first creates a new array list which only contains the outside temperature measurements
         * from the period.
         */
        for (int i = 0; i < measurements.size(); i++)
        {
            temperature.add(measurements.get(i).getOutsideTemp());
        }
        /**
         * The for-loop below calculates the average outside temperature separately per day from the array list
         * temperatures and adds the amount of degree days of each day to the total amount of degree days.
         * This for-loop also contains an if-statement which takes care of incorrect values.
         */
        int previousDate = measurements.get(0).getDateStamp().getDayOfYear();
        int OriginalDate = previousDate;
        ArrayList<Double> dayTemps = new ArrayList<>();

        for (int counter = 0; counter<measurements.size(); counter++)
        {
            if (measurements.get(counter).getDateStamp().getDayOfYear() == previousDate)
            {
                if (!Double.isNaN(temperature.get(counter)))
                {
                    dayTemps.add(temperature.get(counter));
                }
            }
            else if (measurements.get(counter).getDateStamp().getDayOfYear() != previousDate)
            {
                int degreeDifference = 18 - ((int)Math.round(Calculations.mean(dayTemps)));
                if (degreeDifference > 0)
                {
                    degreedays = degreedays + degreeDifference;
                }
                dayTemps.clear();
                previousDate = measurements.get(counter).getDateStamp().getDayOfYear();
            }
        }
        /**
         * The if-statement below calculates the amount of degree days in case the given period of time was
         * only one day.
         */
        if (previousDate == OriginalDate && degreedays == 0)
        {
            int degreeDifference = 18 - ((int)Math.round(Calculations.mean(dayTemps)));
            degreedays = degreedays + degreeDifference;
        }

        return degreedays;
    }      

    /**
     * Author: Dennis Kruijt.
     * Purpose: calculate the number of rising temperature series where the temperature may not decrease
     *          or stay level over a period of 10 minutes.     *
     *
     * @param measurements is an array consisting of measurements with values such as temperatures.
     * series: keeps track of the number of rising temperature series which must rise for at least 10 measurements.
     * notRising: keeps series of the rising temperature seperate.
     */
    public static int risingTemperatureDuration(ArrayList<Measurement> measurements) {
        int series = 0;
        int notRising = 0;
        boolean addCounter = true;

        for (int i = 10; i < measurements.size(); i++) {
            if (!Double.isNaN(measurements.get(i).getOutsideTemp())) {
                // Compare temperature indexed i with temperature of 10 places back
                if (measurements.get(i).getOutsideTemp() > measurements.get(i - 10).getOutsideTemp()) {
                    if (addCounter) {
                        addCounter = false; // Don't count the same serie more than once
                        series++;
                        notRising = 0;
                    }
                } else {
                    notRising++;
                    if (notRising == 10) addCounter = true; // If temperatur is not rising, end the serie
                }
            }
        }
        return series;
    }
}
