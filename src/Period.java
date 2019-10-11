import java.time.*;
import java.time.temporal.*;
import java.util.ArrayList;

/**
 * A class to contain a period of time
 *
 * @author Johan Talboom
 * Revised by team A3
 * @version 2.1
 */
public class Period {
    private LocalDate beginPeriod;
    private LocalDate endPeriod;
    private ArrayList<Measurement> periodMeasurements = new ArrayList<Measurement>();
    public PeriodData dataStorage = new PeriodData();



    /**
     * default constructor, sets the period to today
     */
    public Period() {
        beginPeriod = LocalDate.now();
        endPeriod = LocalDate.now();
        Init();
    }

    public Period(LocalDate beginPeriod, LocalDate endPeriod) {
        this.beginPeriod = beginPeriod;
        this.endPeriod = endPeriod;
        Init();
    }

    public Period(LocalDate beginPeriod) {
        this.beginPeriod = beginPeriod;
        this.endPeriod = LocalDate.now();
        Init();
    }

    public Period(int days) {
        this.beginPeriod = LocalDate.now().minus(java.time.Period.ofDays(days));
        this.endPeriod = LocalDate.now();
        Init();
    }

    private void Init() {
        periodMeasurements = getMeasurements();
        setData();
    }

    /**
     * Simple setter for start of period
     */
    public void setStart(int year, int month, int day) {
        beginPeriod = LocalDate.of(year, month, day);
    }

    /**
     * simple setter for end of period
     */
    public void setEnd(int year, int month, int day) {
        endPeriod = LocalDate.of(year, month, day);
    }

    /**
     * alternative setter for start of period
     *
     * @param beginPeriod
     */
    public void setStart(LocalDate beginPeriod) {
        this.beginPeriod = beginPeriod;
    }

    /**
     * alternative setter for end of period
     *
     * @param endPeriod
     */
    public void setEnd(LocalDate endPeriod) {
        this.endPeriod = endPeriod;
    }

    /**
     * calculates the number of days in the period
     */
    public long numberOfDays() {
        return ChronoUnit.DAYS.between(beginPeriod, endPeriod);
    }


    /**
     * gets all raw measurements of this period from the database
     * @return a list of raw measurements
     */
    public ArrayList<RawMeasurement> getRawMeasurements() {
        return DatabaseConnection.getMeasurementsBetween(LocalDateTime.of(beginPeriod, LocalTime.of(0, 1)), LocalDateTime.of(endPeriod, LocalTime.of(23, 59)));
    }

    /**
     * Builds an ArrayList of measurements. This method also filters out any 'bad' measurements
     * @return a filtered list of measurements
     */
    public ArrayList<Measurement> getMeasurements() {
        ArrayList<Measurement> measurements = new ArrayList<>();
        ArrayList<RawMeasurement> rawMeasurements = getRawMeasurements();
        for (RawMeasurement rawMeasurement : rawMeasurements) {
            Measurement measurement = new Measurement(rawMeasurement);
            measurements.add(measurement);
        }
        return measurements;
    }

    private void setData() {
        ArrayList<Double> airPressure = new ArrayList<Double>();
        ArrayList<Double> insideTemp = new ArrayList<Double>();
        ArrayList<Double> insideHum = new ArrayList<Double>();
        ArrayList<Double> outsideTemp = new ArrayList<Double>();
        ArrayList<Double> windSpeed = new ArrayList<Double>();
        ArrayList<Double> avgWindSpeed = new ArrayList<Double>();
        ArrayList<Double> windDir = new ArrayList<Double>();
        ArrayList<Double> outsideHum = new ArrayList<Double>();
        ArrayList<Double> rainRate = new ArrayList<Double>();
        ArrayList<Double> uvLevel = new ArrayList<Double>();
        ArrayList<Double> battLevel = new ArrayList<Double>();
        ArrayList<Double> sunSet = new ArrayList<Double>();
        ArrayList<Double> sunRise = new ArrayList<Double>();
        ArrayList<Double> windChill = new ArrayList<Double>();
        ArrayList<Double> heatIndex = new ArrayList<Double>();
        ArrayList<Double> dewPoint = new ArrayList<Double>();

        for (Measurement data : periodMeasurements){
            airPressure.add(data.getBarometer());
            insideTemp.add(data.getInsideTemp());
            insideHum.add(data.getInsideHum());
            outsideTemp.add(data.getOutsideTemp());
            windSpeed.add(data.getWindSpeed());
            avgWindSpeed.add(data.getAvgWindSpeed());
            windDir.add(data.getWindDir());
            outsideHum.add(data.getOutsideHum());
            rainRate.add(data.getRainRate());
            uvLevel.add(data.getUvLevel());
            battLevel.add(data.getBattLevel());
            sunSet.add(data.GetSunSet());
            sunRise.add(data.GetSunRise());
        }
        for (int i = 0; i < periodMeasurements.size(); i++) {
            if (!Double.isNaN(outsideTemp.get(i)) & !Double.isNaN(windSpeed.get(i))) {
                windChill.add(Calculations.windChill(outsideTemp.get(i),windSpeed.get(i)));
            }
            if (!Double.isNaN(insideTemp.get(i)) & !Double.isNaN(insideHum.get(i))) {
                heatIndex.add(Calculations.heatIndex(insideTemp.get(i),insideHum.get(i)));
            }
            if (!Double.isNaN(outsideTemp.get(i)) & !Double.isNaN(outsideHum.get(i))) {
                dewPoint.add(Calculations.dewPoint(outsideTemp.get(i), outsideHum.get(i)));
            }
        }

        dataStorage.maxAirPressure = Calculations.maximum(airPressure);
        dataStorage.minAirPressure = Calculations.minimum(airPressure);
        dataStorage.meanAirPressure = Calculations.mean(airPressure);
        dataStorage.modeAirPressure = Calculations.mode(airPressure);
        dataStorage.medianAirPressure = Calculations.median(airPressure);
        dataStorage.standardDeviationAirPressure = Calculations.standardDeviation(airPressure);

        dataStorage.maxInsideTemp = Calculations.maximum(insideTemp);
        dataStorage.minInsideTemp = Calculations.minimum(insideTemp);
        dataStorage.meanInsideTemp = Calculations.mean(insideTemp);
        dataStorage.modeInsideTemp = Calculations.mode(insideTemp);
        dataStorage.medianInsideTemp = Calculations.median(insideTemp);
        dataStorage.standardDeviationInsideTemp = Calculations.standardDeviation(insideTemp);

        dataStorage.maxInsideHum = Calculations.maximum(insideHum);
        dataStorage.minInsideHum = Calculations.minimum(insideHum);
        dataStorage.meanInsideHum = Calculations.mean(insideHum);
        dataStorage.modeInsideHum = Calculations.mode(insideHum);
        dataStorage.medianInsideHum = Calculations.median(insideHum);
        dataStorage.standardDeviationInsideHum = Calculations.standardDeviation(insideHum);

        dataStorage.maxOutsideTemp = Calculations.maximum(outsideTemp);
        dataStorage.minOutsideTemp = Calculations.minimum(outsideTemp);
        dataStorage.meanOutsideTemp = Calculations.mean(outsideTemp);
        dataStorage.modeOutsideTemp = Calculations.mode(outsideTemp);
        dataStorage.medianOutsideTemp = Calculations.median(outsideTemp);
        dataStorage.standardDeviationOutsideTemp = Calculations.standardDeviation(outsideTemp);

        dataStorage.maxWindSpeed = Calculations.maximum(windSpeed);
        dataStorage.minWindSpeed = Calculations.minimum(windSpeed);
        dataStorage.meanWindSpeed = Calculations.mean(windSpeed);
        dataStorage.modeWindSpeed = Calculations.mode(windSpeed);
        dataStorage.medianWindSpeed = Calculations.median(windSpeed);
        dataStorage.standardDeviationWindSpeed = Calculations.standardDeviation(windSpeed);

        dataStorage.maxAvgWindSpeed = Calculations.maximum(avgWindSpeed);
        dataStorage.minAvgWindSpeed = Calculations.minimum(avgWindSpeed);
        dataStorage.meanAvgWindSpeed = Calculations.mean(avgWindSpeed);
        dataStorage.modeAvgWindSpeed = Calculations.mode(avgWindSpeed);
        dataStorage.medianAvgWindSpeed = Calculations.median(avgWindSpeed);
        dataStorage.standardDeviationAvgWindSpeed = Calculations.standardDeviation(avgWindSpeed);

        dataStorage.maxWindDir = Calculations.maximum(windDir);
        dataStorage.minWindDir = Calculations.minimum(windDir);
        dataStorage.meanWindDir = Calculations.mean(windDir);
        dataStorage.modeWindDir = Calculations.mode(windDir);
        dataStorage.medianWindDir = Calculations.median(windDir);
        dataStorage.standardDeviationWindDir = Calculations.standardDeviation(windDir);

        dataStorage.maxOutsideHum = Calculations.maximum(outsideHum);
        dataStorage.minOutsideHum = Calculations.minimum(outsideHum);
        dataStorage.meanOutsideHum = Calculations.mean(outsideHum);
        dataStorage.modeOutsideHum = Calculations.mode(outsideHum);
        dataStorage.medianOutsideHum = Calculations.median(outsideHum);
        dataStorage.standardDeviationOutsideHum = Calculations.standardDeviation(outsideHum);

        dataStorage.maxRainRate = Calculations.maximum(rainRate);
        dataStorage.minRainRate = Calculations.minimum(rainRate);
        dataStorage.meanRainRate = Calculations.mean(rainRate);
        dataStorage.modeRainRate = Calculations.mode(rainRate);
        dataStorage.medianRainRate = Calculations.median(rainRate);
        dataStorage.standardDeviationRainRate = Calculations.standardDeviation(rainRate);

        dataStorage.maxUvLevel = Calculations.maximum(uvLevel);
        dataStorage.minUvLevel = Calculations.minimum(uvLevel);
        dataStorage.meanUvLevel = Calculations.mean(uvLevel);
        dataStorage.modeUvLevel = Calculations.mode(uvLevel);
        dataStorage.medianUvLevel = Calculations.median(uvLevel);
        dataStorage.standardDeviationUvLevel = Calculations.standardDeviation(uvLevel);

        dataStorage.maxBattLevel = Calculations.maximum(battLevel);
        dataStorage.minBattLevel = Calculations.minimum(battLevel);
        dataStorage.meanBattLevel = Calculations.mean(battLevel);
        dataStorage.modeBattLevel = Calculations.mode(battLevel);
        dataStorage.medianBattLevel = Calculations.median(battLevel);
        dataStorage.standardDeviationBattLevel = Calculations.standardDeviation(battLevel);

        dataStorage.maxSunSet = Calculations.maximum(sunSet);
        dataStorage.minSunSet = Calculations.minimum(sunSet);
        dataStorage.meanSunSet = Calculations.mean(sunSet);
        dataStorage.modeSunSet = Calculations.mode(sunSet);
        dataStorage.medianSunSet = Calculations.median(sunSet);
        dataStorage.standardDeviationSunSet = Calculations.standardDeviation(sunSet);

        dataStorage.maxSunRise = Calculations.maximum(sunRise);
        dataStorage.minSunRise = Calculations.minimum(sunRise);
        dataStorage.meanSunRise = Calculations.mean(sunRise);
        dataStorage.modeSunRise = Calculations.mode(sunRise);
        dataStorage.medianSunRise = Calculations.median(sunRise);
        dataStorage.standardDeviationSunRise = Calculations.standardDeviation(sunRise);

        dataStorage.maxWindChill = Calculations.maximum(windChill);
        dataStorage.minWindChill = Calculations.minimum(windChill);
        dataStorage.meanWindChill = Calculations.mean(windChill);
        dataStorage.modeWindChill = Calculations.mode(windChill);
        dataStorage.medianWindChill = Calculations.median(windChill);
        dataStorage.standardDeviationWindChill = Calculations.standardDeviation(windChill);

        dataStorage.maxHeatIndex = Calculations.maximum(heatIndex);
        dataStorage.minHeatIndex = Calculations.minimum(heatIndex);
        dataStorage.meanHeatIndex = Calculations.mean(heatIndex);
        dataStorage.modeHeatIndex = Calculations.mode(heatIndex);
        dataStorage.medianHeatIndex = Calculations.median(heatIndex);
        dataStorage.standardDeviationHeatIndex = Calculations.standardDeviation(heatIndex);


        dataStorage.maxDewPoint = Calculations.maximum(dewPoint);
        dataStorage.minDewPoint = Calculations.minimum(dewPoint);
        dataStorage.meanDewPoint = Calculations.mean(dewPoint);
        dataStorage.modeDewPoint = Calculations.mode(dewPoint);
        dataStorage.medianDewPoint = Calculations.median(dewPoint);
        dataStorage.standardDeviationDewPoint = Calculations.standardDeviation(dewPoint);

        dataStorage.mist = Calculations.mist(periodMeasurements);
        //dataStorage.maxRain = Calculations.maxRain(periodMeasurements);
        //dataStorage.tempChange = Calculations.tempChange(periodMeasurements);
        //dataStorage.degreeDays = Calculations.degreeDays(periodMeasurements);
        dataStorage.risingTemperature = Calculations.risingTemperatureDuration(periodMeasurements);
    }
}
