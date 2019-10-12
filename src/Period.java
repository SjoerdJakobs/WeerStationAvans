import java.time.*;
import java.time.temporal.*;
import java.util.ArrayList;

/**
 * A class to contain a period of time
 *
 * @author Johan Talboom
 * Revised by team A3
 * @version 2.2
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

    /**
     * Constructor which sets the period to two set start and end dates.
     * @param beginPeriod Given start of the period.
     * @param endPeriod Given end of the period.
     */
    public Period(LocalDate beginPeriod, LocalDate endPeriod) {
        this.beginPeriod = beginPeriod;
        this.endPeriod = endPeriod;
        Init();
    }

    /**
     * Constructor which sets the period from a start period to today.
     * @param beginPeriod Given start of the period.
     */
    public Period(LocalDate beginPeriod) {
        this.beginPeriod = beginPeriod;
        this.endPeriod = LocalDate.now();
        Init();
    }

    /**
     * Constructor which sets the period to a given amount of days ago .
     * @param days Given amount of days in the period.
     */
    public Period(int days) {
        this.beginPeriod = LocalDate.now().minus(java.time.Period.ofDays(days));
        this.endPeriod = LocalDate.now();
        Init();
    }

    /**
     * Initializes the process of automatically grabbing, converting, calculating and setting all data in the period.
     */
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
     * @param beginPeriod Start of the period.
     */
    public void setStart(LocalDate beginPeriod) {
        this.beginPeriod = beginPeriod;
    }

    /**
     * alternative setter for end of period
     *      *
     * @param endPeriod End of the period.
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
    private ArrayList<RawMeasurement> getRawMeasurements() {
        return DatabaseConnection.getMeasurementsBetween(LocalDateTime.of(beginPeriod, LocalTime.of(0, 1)), LocalDateTime.of(endPeriod, LocalTime.of(23, 59)));
    }

    /**
     * Builds an ArrayList of measurements. This method also filters out any 'bad' measurements
     * @return a filtered list of measurements
     */
    private ArrayList<Measurement> getMeasurements() {
        ArrayList<Measurement> measurements = new ArrayList<>();
        ArrayList<RawMeasurement> rawMeasurements = getRawMeasurements();
        for (RawMeasurement rawMeasurement : rawMeasurements) {
            Measurement measurement = new Measurement(rawMeasurement);
            measurements.add(measurement);
        }
        return measurements;
    }

    /**
     * Creates individual ArrayLists for each measurement type and filters the invalid data before adding it to the list.
     * It then calls the  "set" function for each measurement type.
     */
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
            if (!Double.isNaN(data.getBarometer())) {
                airPressure.add(data.getBarometer());
            }
            if (!Double.isNaN(data.getInsideTemp())) {
                insideTemp.add(data.getInsideTemp());
            }
            if (!Double.isNaN(data.getInsideHum())) {
                insideHum.add(data.getInsideHum());
            }
            if (!Double.isNaN(data.getOutsideTemp())) {
                outsideTemp.add(data.getOutsideTemp());
            }
            if (!Double.isNaN(data.getWindSpeed())) {
                windSpeed.add(data.getWindSpeed());
            }
            if (!Double.isNaN(data.getAvgWindSpeed())) {
                avgWindSpeed.add(data.getAvgWindSpeed());
            }
            if (!Double.isNaN(data.getWindDir())) {
                windDir.add(data.getWindDir());
            }
            if (!Double.isNaN(data.getOutsideHum())) {
                outsideHum.add(data.getOutsideHum());
            }
            if (!Double.isNaN(data.getRainRate())) {
                rainRate.add(data.getRainRate());
            }
            if (!Double.isNaN(data.getUvLevel())) {
                uvLevel.add(data.getUvLevel());
            }
            if (!Double.isNaN(data.getBattLevel())) {
                battLevel.add(data.getBattLevel());
            }
            if (!Double.isNaN(data.GetSunSet())) {
                sunSet.add(data.GetSunSet());
            }
            if (!Double.isNaN(data.GetSunRise())) {
                sunRise.add(data.GetSunRise());
            }
            if (!Double.isNaN(data.getOutsideTemp()) & !Double.isNaN(data.getWindSpeed())) {
                windChill.add(Calculations.windChill(data.getOutsideTemp(),data.getWindSpeed()));
            }
            if (!Double.isNaN(data.getInsideTemp()) & !Double.isNaN(data.getInsideHum())) {
                heatIndex.add(Calculations.heatIndex(data.getInsideTemp(),data.getInsideHum()));
            }
            if (!Double.isNaN(data.getOutsideTemp()) & !Double.isNaN(data.getOutsideHum())) {
                dewPoint.add(Calculations.dewPoint(data.getOutsideTemp(), data.getOutsideHum()));
            }
        }
        SetAirPressure(airPressure);
        SetInsideTemp(insideTemp);
        SetInsideHum(insideHum);
        SetOutsideTemp(outsideTemp);
        SetWindSpeed(windSpeed);
        SetAvgWindSpeed(avgWindSpeed);
        SetWindDir(windDir);
        SetOutsideHum(outsideHum);
        SetRainRate(rainRate);
        SetUvLevel(uvLevel);
        SetBattLevel(battLevel);
        SetSunSet(sunSet);
        SetSunRise(sunRise);
        SetWindChill(windChill);
        SetHeatIndex(heatIndex);
        SetDewPoint(dewPoint);
        SetPreDefined(periodMeasurements);
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param airPressure The filtered list of all measurements of this type within the given period.
     */
    private void SetAirPressure(ArrayList<Double> airPressure) {
        dataStorage.maxAirPressure = Calculations.maximum(airPressure);
        dataStorage.minAirPressure = Calculations.minimum(airPressure);
        dataStorage.meanAirPressure = Calculations.mean(airPressure);
        dataStorage.modeAirPressure = Calculations.mode(airPressure);
        dataStorage.medianAirPressure = Calculations.median(airPressure);
        dataStorage.standardDeviationAirPressure = Calculations.standardDeviation(airPressure);
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param insideTemp The filtered list of all measurements of this type within the given period.
     */
    private void SetInsideTemp(ArrayList<Double> insideTemp) {
        dataStorage.maxInsideTemp = Calculations.maximum(insideTemp);
        dataStorage.minInsideTemp = Calculations.minimum(insideTemp);
        dataStorage.meanInsideTemp = Calculations.mean(insideTemp);
        dataStorage.modeInsideTemp = Calculations.mode(insideTemp);
        dataStorage.medianInsideTemp = Calculations.median(insideTemp);
        dataStorage.standardDeviationInsideTemp = Calculations.standardDeviation(insideTemp);
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param insideHum The filtered list of all measurements of this type within the given period.
     */
    private void SetInsideHum(ArrayList<Double> insideHum) {
        dataStorage.maxInsideHum = Calculations.maximum(insideHum);
        dataStorage.minInsideHum = Calculations.minimum(insideHum);
        dataStorage.meanInsideHum = Calculations.mean(insideHum);
        dataStorage.modeInsideHum = Calculations.mode(insideHum);
        dataStorage.medianInsideHum = Calculations.median(insideHum);
        dataStorage.standardDeviationInsideHum = Calculations.standardDeviation(insideHum);
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param outsideTemp The filtered list of all measurements of this type within the given period.
     */
    private void SetOutsideTemp(ArrayList<Double> outsideTemp) {
        dataStorage.maxOutsideTemp = Calculations.maximum(outsideTemp);
        dataStorage.minOutsideTemp = Calculations.minimum(outsideTemp);
        dataStorage.meanOutsideTemp = Calculations.mean(outsideTemp);
        dataStorage.modeOutsideTemp = Calculations.mode(outsideTemp);
        dataStorage.medianOutsideTemp = Calculations.median(outsideTemp);
        dataStorage.standardDeviationOutsideTemp = Calculations.standardDeviation(outsideTemp);
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param windSpeed The filtered list of all measurements of this type within the given period.
     */
    private void SetWindSpeed(ArrayList<Double> windSpeed){
        dataStorage.maxWindSpeed = Calculations.maximum(windSpeed);
        dataStorage.minWindSpeed = Calculations.minimum(windSpeed);
        dataStorage.meanWindSpeed = Calculations.mean(windSpeed);
        dataStorage.modeWindSpeed = Calculations.mode(windSpeed);
        dataStorage.medianWindSpeed = Calculations.median(windSpeed);
        dataStorage.standardDeviationWindSpeed = Calculations.standardDeviation(windSpeed);
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param avgWindSpeed The filtered list of all measurements of this type within the given period.
     */
    private void SetAvgWindSpeed(ArrayList<Double> avgWindSpeed){
        dataStorage.maxAvgWindSpeed = Calculations.maximum(avgWindSpeed);
        dataStorage.minAvgWindSpeed = Calculations.minimum(avgWindSpeed);
        dataStorage.meanAvgWindSpeed = Calculations.mean(avgWindSpeed);
        dataStorage.modeAvgWindSpeed = Calculations.mode(avgWindSpeed);
        dataStorage.medianAvgWindSpeed = Calculations.median(avgWindSpeed);
        dataStorage.standardDeviationAvgWindSpeed = Calculations.standardDeviation(avgWindSpeed);
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param windDir The filtered list of all measurements of this type within the given period.
     */
    private void SetWindDir(ArrayList<Double> windDir) {
        dataStorage.maxWindDir = Calculations.maximum(windDir);
        dataStorage.minWindDir = Calculations.minimum(windDir);
        dataStorage.meanWindDir = Calculations.mean(windDir);
        dataStorage.modeWindDir = Calculations.mode(windDir);
        dataStorage.medianWindDir = Calculations.median(windDir);
        dataStorage.standardDeviationWindDir = Calculations.standardDeviation(windDir);
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param outsideHum The filtered list of all measurements of this type within the given period.
     */
    private void SetOutsideHum(ArrayList<Double> outsideHum) {
        dataStorage.maxOutsideHum = Calculations.maximum(outsideHum);
        dataStorage.minOutsideHum = Calculations.minimum(outsideHum);
        dataStorage.meanOutsideHum = Calculations.mean(outsideHum);
        dataStorage.modeOutsideHum = Calculations.mode(outsideHum);
        dataStorage.medianOutsideHum = Calculations.median(outsideHum);
        dataStorage.standardDeviationOutsideHum = Calculations.standardDeviation(outsideHum);
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param rainRate The filtered list of all measurements of this type within the given period.
     */
    private void SetRainRate(ArrayList<Double> rainRate) {
        dataStorage.maxRainRate = Calculations.maximum(rainRate);
        dataStorage.minRainRate = Calculations.minimum(rainRate);
        dataStorage.meanRainRate = Calculations.mean(rainRate);
        dataStorage.modeRainRate = Calculations.mode(rainRate);
        dataStorage.medianRainRate = Calculations.median(rainRate);
        dataStorage.standardDeviationRainRate = Calculations.standardDeviation(rainRate);
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param uvLevel The filtered list of all measurements of this type within the given period.
     */
    private void SetUvLevel(ArrayList<Double> uvLevel) {
        dataStorage.maxUvLevel = Calculations.maximum(uvLevel);
        dataStorage.minUvLevel = Calculations.minimum(uvLevel);
        dataStorage.meanUvLevel = Calculations.mean(uvLevel);
        dataStorage.modeUvLevel = Calculations.mode(uvLevel);
        dataStorage.medianUvLevel = Calculations.median(uvLevel);
        dataStorage.standardDeviationUvLevel = Calculations.standardDeviation(uvLevel);
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param battLevel The filtered list of all measurements of this type within the given period.
     */
    private void SetBattLevel(ArrayList<Double> battLevel) {
        dataStorage.maxBattLevel = Calculations.maximum(battLevel);
        dataStorage.minBattLevel = Calculations.minimum(battLevel);
        dataStorage.meanBattLevel = Calculations.mean(battLevel);
        dataStorage.modeBattLevel = Calculations.mode(battLevel);
        dataStorage.medianBattLevel = Calculations.median(battLevel);
        dataStorage.standardDeviationBattLevel = Calculations.standardDeviation(battLevel);
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param sunSet The filtered list of all measurements of this type within the given period.
     */
    private void SetSunSet(ArrayList<Double> sunSet) {
        dataStorage.maxSunSet = Calculations.maximum(sunSet);
        dataStorage.minSunSet = Calculations.minimum(sunSet);
        dataStorage.meanSunSet = Calculations.mean(sunSet);
        dataStorage.modeSunSet = Calculations.mode(sunSet);
        dataStorage.medianSunSet = Calculations.median(sunSet);
        dataStorage.standardDeviationSunSet = Calculations.standardDeviation(sunSet);
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param sunRise The filtered list of all measurements of this type within the given period.
     */
    private void SetSunRise(ArrayList<Double> sunRise) {
        dataStorage.maxSunRise = Calculations.maximum(sunRise);
        dataStorage.minSunRise = Calculations.minimum(sunRise);
        dataStorage.meanSunRise = Calculations.mean(sunRise);
        dataStorage.modeSunRise = Calculations.mode(sunRise);
        dataStorage.medianSunRise = Calculations.median(sunRise);
        dataStorage.standardDeviationSunRise = Calculations.standardDeviation(sunRise);
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param windChill The filtered list of all measurements of this type within the given period.
     */
    private void SetWindChill(ArrayList<Double> windChill) {
        dataStorage.maxWindChill = Calculations.maximum(windChill);
        dataStorage.minWindChill = Calculations.minimum(windChill);
        dataStorage.meanWindChill = Calculations.mean(windChill);
        dataStorage.modeWindChill = Calculations.mode(windChill);
        dataStorage.medianWindChill = Calculations.median(windChill);
        dataStorage.standardDeviationWindChill = Calculations.standardDeviation(windChill);
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param heatIndex The filtered list of all measurements of this type within the given period.
     */
    private void SetHeatIndex(ArrayList<Double> heatIndex) {
        dataStorage.maxHeatIndex = Calculations.maximum(heatIndex);
        dataStorage.minHeatIndex = Calculations.minimum(heatIndex);
        dataStorage.meanHeatIndex = Calculations.mean(heatIndex);
        dataStorage.modeHeatIndex = Calculations.mode(heatIndex);
        dataStorage.medianHeatIndex = Calculations.median(heatIndex);
        dataStorage.standardDeviationHeatIndex = Calculations.standardDeviation(heatIndex);
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param dewPoint The filtered list of all measurements of this type within the given period.
     */
    private void SetDewPoint(ArrayList<Double> dewPoint) {
        dataStorage.maxDewPoint = Calculations.maximum(dewPoint);
        dataStorage.minDewPoint = Calculations.minimum(dewPoint);
        dataStorage.meanDewPoint = Calculations.mean(dewPoint);
        dataStorage.modeDewPoint = Calculations.mode(dewPoint);
        dataStorage.medianDewPoint = Calculations.median(dewPoint);
        dataStorage.standardDeviationDewPoint = Calculations.standardDeviation(dewPoint);
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param periodMeasurements The complete list of all measurements within the given period.
     */
    private void SetPreDefined(ArrayList<Measurement> periodMeasurements) {
        dataStorage.mist = Calculations.mist(periodMeasurements);
        //dataStorage.maxRain = Calculations.maxRain(periodMeasurements);
        //dataStorage.tempChange = Calculations.tempChange(periodMeasurements);
        //dataStorage.degreeDays = Calculations.degreeDays(periodMeasurements);
        dataStorage.risingTemperature = Calculations.risingTemperatureDuration(periodMeasurements);
    }
}
