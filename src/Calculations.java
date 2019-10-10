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

    public static double windChill(short outsideTemp, short windSpeed) {
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
    public static ArrayList<LocalDateTime> mist(ArrayList<Measurement> array) {
        int counter = 0;
        int lastDate = 0;
        ArrayList<LocalDateTime> result = new ArrayList<LocalDateTime>();
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getDateStamp().getDayOfYear() != lastDate) {
                if (!Double.isNaN(array.get(i).getOutsideTemp()) && !Double.isNaN(array.get(i).getOutsideHum())) {
                    if (Math.abs(array.get(i).getOutsideTemp() - dewPoint(array.get(i).getOutsideTemp(), array.get(i).getOutsideHum())) < 2.5) {
                        result.add(array.get(i).getDateStamp());
                        counter++;
                        lastDate = array.get(i).getDateStamp().getDayOfYear();
                    }
                }
            }
        }
        System.out.println(counter);
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
     * TODO Samir
     */
    public int Graaddagen(LocalDateTime begin, LocalDateTime end){

        int graaddagen = 0;
        ArrayList<RawMeasurement> rawDatas = DatabaseConnection.getMeasurementsBetween(begin,end);
        ArrayList<Measurement> measurements = new ArrayList<Measurement>();
        ArrayList<Double> temperature = new ArrayList<>();
        int degreeDifference;

        for (int i = 0; i < rawDatas.size(); i++)
        {
            measurements.add(new Measurement(rawDatas.get(i)));
            temperature.add(measurements.get(i).getOutsideTemp());
        }

        int prevDate = measurements.get(0).getDateStamp().getDayOfYear();

        int OriginalDate = prevDate;
        ArrayList<Double> dayTemps = new ArrayList<>();
        for (int counter = 0; counter<measurements.size(); counter++){
            if (measurements.get(counter).getDateStamp().getDayOfYear() == prevDate) {
                dayTemps.add(temperature.get(counter));
            }
            else if (measurements.get(counter).getDateStamp().getDayOfYear() != prevDate) {

                int RoundedAveragePlusOne = (int)Calculations.mean(dayTemps)+1;
                double CorrectAverage = Calculations.mean(dayTemps);
                double offrounderDecider = (double)RoundedAveragePlusOne - CorrectAverage;
                if (offrounderDecider < 0.5){
                    degreeDifference = 18 - RoundedAveragePlusOne;
                }
                else {
                    degreeDifference = 18 - (int)Calculations.mean(dayTemps);
                }

                if (degreeDifference > 0){
                    graaddagen = graaddagen + degreeDifference;
                }
                dayTemps.clear();
                prevDate = measurements.get(counter).getDateStamp().getDayOfYear();

            }


        }
        if (prevDate == OriginalDate && graaddagen == 0){
            degreeDifference = 18 - (int) Calculations.mean(dayTemps);
            graaddagen = graaddagen + degreeDifference;
        }
        return graaddagen;
    }
}
