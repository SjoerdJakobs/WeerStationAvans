import java.util.ArrayList;

/**
 * A class used as a data storage for all calculated values within the current active period.
 */
public class PeriodData {
    private ArrayList<Measurement> periodMeasurements = new ArrayList<Measurement>();

    private double maxAirPressure;
    private double minAirPressure;
    private double meanAirPressure;
    private double modeAirPressure;
    private double medianAirPressure;
    private double standardDeviationAirPressure;

    private double maxInsideTemp;
    private double minInsideTemp;
    private double meanInsideTemp;
    private double modeInsideTemp;
    private double medianInsideTemp;
    private double standardDeviationInsideTemp;

    private double maxInsideHum;
    private double minInsideHum;
    private double meanInsideHum;
    private double modeInsideHum;
    private double medianInsideHum;
    private double standardDeviationInsideHum;

    private double maxOutsideTemp;
    private double minOutsideTemp;
    private double meanOutsideTemp;
    private double modeOutsideTemp;
    private double medianOutsideTemp;
    private double standardDeviationOutsideTemp;

    private double maxWindSpeed;
    private double minWindSpeed;
    private double meanWindSpeed;
    private double modeWindSpeed;
    private double medianWindSpeed;
    private double standardDeviationWindSpeed;

    private double maxAvgWindSpeed;
    private double minAvgWindSpeed;
    private double meanAvgWindSpeed;
    private double modeAvgWindSpeed;
    private double medianAvgWindSpeed;
    private double standardDeviationAvgWindSpeed;

    private double maxWindDir;
    private double minWindDir;
    private double meanWindDir;
    private double modeWindDir;
    private double medianWindDir;
    private double standardDeviationWindDir;

    private double maxOutsideHum;
    private double minOutsideHum;
    private double meanOutsideHum;
    private double modeOutsideHum;
    private double medianOutsideHum;
    private double standardDeviationOutsideHum;

    private double maxRainRate;
    private double minRainRate;
    private double meanRainRate;
    private double modeRainRate;
    private double medianRainRate;
    private double standardDeviationRainRate;

    private double maxUvLevel;
    private double minUvLevel;
    private double meanUvLevel;
    private double modeUvLevel;
    private double medianUvLevel;
    private double standardDeviationUvLevel;

    private double maxBattLevel;
    private double minBattLevel;
    private double meanBattLevel;
    private double modeBattLevel;
    private double medianBattLevel;
    private double standardDeviationBattLevel;

    private double maxSunSet;
    private double minSunSet;
    private double meanSunSet;
    private double modeSunSet;
    private double medianSunSet;
    private double standardDeviationSunSet;

    private double maxSunRise;
    private double minSunRise;
    private double meanSunRise;
    private double modeSunRise;
    private double medianSunRise;
    private double standardDeviationSunRise;

    private double maxWindChill;
    private double minWindChill;
    private double meanWindChill;
    private double modeWindChill;
    private double medianWindChill;
    private double standardDeviationWindChill;

    private double maxHeatIndex;
    private double minHeatIndex;
    private double meanHeatIndex;
    private double modeHeatIndex;
    private double medianHeatIndex;
    private double standardDeviationHeatIndex;

    private double maxDewPoint;
    private double minDewPoint;
    private double meanDewPoint;
    private double modeDewPoint;
    private double medianDewPoint;
    private double standardDeviationDewPoint;

    private int mist;
    private double maxRain;
    private int tempChange;
    private int degreeDays;
    private int risingTemperature;

    /**
     * Sets the ArrayList to contain all measurements in the period.
     * @param periodMeasurements All measurements in the period.
     */
    public void setPeriodMeasurements(ArrayList<Measurement> periodMeasurements) {
        this.periodMeasurements = periodMeasurements;
    }
    /**
     * Returns the ArrayList which contains all measurements in the period.
     * @return All measurements in the period.
     */
    public ArrayList<Measurement> getPeriodMeasurements() {
        return periodMeasurements;
    }

    /**
     * Creates individual ArrayLists for each measurement type and filters the invalid data before adding it to the list.
     * It then calls the  "set" function for each measurement type.
     */
    public void setData() {
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
        maxAirPressure = Calculations.maximum(airPressure);
        minAirPressure = Calculations.minimum(airPressure);
        meanAirPressure = Calculations.mean(airPressure);
        modeAirPressure = Calculations.mode(airPressure);
        medianAirPressure = Calculations.median(airPressure);
        standardDeviationAirPressure = Calculations.standardDeviation(airPressure);
    }

    /**
     * Individual gets for each calculated AirPressure value to allow access from other classes.
     * @return Calculated variable.
     */
    public double getMaxAirPressure() {
        return maxAirPressure;
    }
    public double getMinAirPressure(){
        return minAirPressure;
    }
    public double getMeanAirPressure() {
        return meanAirPressure;
    }
    public double getModeAirPressure() {
        return modeAirPressure;
    }
    public double getMedianAirPressure() {
        return medianAirPressure;
    }
    public double getStandardDeviationAirPressure() {
        return standardDeviationAirPressure;
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param insideTemp The filtered list of all measurements of this type within the given period.
     */
    private void SetInsideTemp(ArrayList<Double> insideTemp) {
        maxInsideTemp = Calculations.maximum(insideTemp);
        minInsideTemp = Calculations.minimum(insideTemp);
        meanInsideTemp = Calculations.mean(insideTemp);
        modeInsideTemp = Calculations.mode(insideTemp);
        medianInsideTemp = Calculations.median(insideTemp);
        standardDeviationInsideTemp = Calculations.standardDeviation(insideTemp);
    }
    /**
     * Individual gets for each calculated InsideTemp value to allow access from other classes.
     * @return Calculated variable.
     */
    public double getMaxInsideTemp() {
        return maxInsideTemp;
    }
    public double getMinInsideTemp(){
        return minInsideTemp;
    }
    public double getMeanInsideTemp() {
        return meanInsideTemp;
    }
    public double getModeInsideTemp() {
        return modeInsideTemp;
    }
    public double getMedianInsideTemp() {
        return medianInsideTemp;
    }
    public double getStandardDeviationInsideTemp() {
        return standardDeviationInsideTemp;
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param insideHum The filtered list of all measurements of this type within the given period.
     */
    private void SetInsideHum(ArrayList<Double> insideHum) {
        maxInsideHum = Calculations.maximum(insideHum);
        minInsideHum = Calculations.minimum(insideHum);
        meanInsideHum = Calculations.mean(insideHum);
        modeInsideHum = Calculations.mode(insideHum);
        medianInsideHum = Calculations.median(insideHum);
        standardDeviationInsideHum = Calculations.standardDeviation(insideHum);
    }
    /**
     * Individual gets for each calculated MaxInsideHum value to allow access from other classes.
     * @return Calculated variable.
     */
    public double getMaxInsideHum() {
        return maxInsideHum;
    }
    public double getMinInsideHum(){
        return minInsideHum;
    }
    public double getMeanInsideHum() {
        return meanInsideHum;
    }
    public double getModeInsideHum() {
        return modeInsideHum;
    }
    public double getMedianInsideHum() {
        return medianInsideHum;
    }
    public double getStandardDeviationInsideHum() {
        return standardDeviationInsideHum;
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param outsideTemp The filtered list of all measurements of this type within the given period.
     */
    private void SetOutsideTemp(ArrayList<Double> outsideTemp) {
        maxOutsideTemp = Calculations.maximum(outsideTemp);
        minOutsideTemp = Calculations.minimum(outsideTemp);
        meanOutsideTemp = Calculations.mean(outsideTemp);
        modeOutsideTemp = Calculations.mode(outsideTemp);
        medianOutsideTemp = Calculations.median(outsideTemp);
        standardDeviationOutsideTemp = Calculations.standardDeviation(outsideTemp);
    }
    /**
     * Individual gets for each calculated OutsideTemp value to allow access from other classes.
     * @return Calculated variable.
     */
    public double getMaxOutsideTemp() {
        return maxOutsideTemp;
    }
    public double getMinOutsideTemp(){
        return minOutsideTemp;
    }
    public double getMeanOutsideTemp() {
        return meanOutsideTemp;
    }
    public double getModeOutsideTemp() {
        return modeOutsideTemp;
    }
    public double getMedianOutsideTemp() {
        return medianOutsideTemp;
    }
    public double getStandardDeviationOutsideTemp() {
        return standardDeviationOutsideTemp;
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param windSpeed The filtered list of all measurements of this type within the given period.
     */
    private void SetWindSpeed(ArrayList<Double> windSpeed){
        maxWindSpeed = Calculations.maximum(windSpeed);
        minWindSpeed = Calculations.minimum(windSpeed);
        meanWindSpeed = Calculations.mean(windSpeed);
        modeWindSpeed = Calculations.mode(windSpeed);
        medianWindSpeed = Calculations.median(windSpeed);
        standardDeviationWindSpeed = Calculations.standardDeviation(windSpeed);
    }
    /**
     * Individual gets for each calculated WindSpeed value to allow access from other classes.
     * @return Calculated variable.
     */
    public double getMaxWindSpeed() {
        return maxWindSpeed;
    }
    public double getMinWindSpeed(){
        return minWindSpeed;
    }
    public double getMeanWindSpeed() {
        return meanWindSpeed;
    }
    public double getModeWindSpeed() {
        return modeWindSpeed;
    }
    public double getMedianWindSpeed() {
        return medianWindSpeed;
    }
    public double getStandardDeviationWindSpeed() {
        return standardDeviationWindSpeed;
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param avgWindSpeed The filtered list of all measurements of this type within the given period.
     */
    private void SetAvgWindSpeed(ArrayList<Double> avgWindSpeed){
        maxAvgWindSpeed = Calculations.maximum(avgWindSpeed);
        minAvgWindSpeed = Calculations.minimum(avgWindSpeed);
        meanAvgWindSpeed = Calculations.mean(avgWindSpeed);
        modeAvgWindSpeed = Calculations.mode(avgWindSpeed);
        medianAvgWindSpeed = Calculations.median(avgWindSpeed);
        standardDeviationAvgWindSpeed = Calculations.standardDeviation(avgWindSpeed);
    }
    /**
     * Individual gets for each calculated AvgWindSpeed value to allow access from other classes.
     * @return Calculated variable.
     */
    public double getMaxAvgWindSpeed() {
        return maxAvgWindSpeed;
    }
    public double getMinAvgWindSpeed(){
        return minAvgWindSpeed;
    }
    public double getMeanAvgWindSpeed() {
        return meanAvgWindSpeed;
    }
    public double getModeAvgWindSpeed() {
        return modeAvgWindSpeed;
    }
    public double getMedianAvgWindSpeed() {
        return medianAvgWindSpeed;
    }
    public double getStandardDeviationAvgWindSpeed() {
        return standardDeviationAvgWindSpeed;
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param windDir The filtered list of all measurements of this type within the given period.
     */
    private void SetWindDir(ArrayList<Double> windDir) {
        maxWindDir = Calculations.maximum(windDir);
        minWindDir = Calculations.minimum(windDir);
        meanWindDir = Calculations.mean(windDir);
        modeWindDir = Calculations.mode(windDir);
        medianWindDir = Calculations.median(windDir);
        standardDeviationWindDir = Calculations.standardDeviation(windDir);
    }
    /**
     * Individual gets for each calculated WindDir value to allow access from other classes.
     * @return Calculated variable.
     */
    public double getMaxWindDir() {
        return maxWindDir;
    }
    public double getMinWindDir(){
        return minWindDir;
    }
    public double getMeanWindDir() {
        return meanWindDir;
    }
    public double getModeWindDir() {
        return modeWindDir;
    }
    public double getMedianWindDir() {
        return medianWindDir;
    }
    public double getStandardDeviationWindDir() {
        return standardDeviationWindDir;
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param outsideHum The filtered list of all measurements of this type within the given period.
     */
    private void SetOutsideHum(ArrayList<Double> outsideHum) {
        maxOutsideHum = Calculations.maximum(outsideHum);
        minOutsideHum = Calculations.minimum(outsideHum);
        meanOutsideHum = Calculations.mean(outsideHum);
        modeOutsideHum = Calculations.mode(outsideHum);
        medianOutsideHum = Calculations.median(outsideHum);
        standardDeviationOutsideHum = Calculations.standardDeviation(outsideHum);
    }
    /**
     * Individual gets for each calculated OutsideHum value to allow access from other classes.
     * @return Calculated variable.
     */
    public double getMaxOutsideHum() {
        return maxOutsideHum;
    }
    public double getMinOutsideHum(){
        return minOutsideHum;
    }
    public double getMeanOutsideHum() {
        return meanOutsideHum;
    }
    public double getModeOutsideHum() {
        return modeOutsideHum;
    }
    public double getMedianOutsideHum() {
        return medianOutsideHum;
    }
    public double getStandardDeviationOutsideHum() {
        return standardDeviationOutsideHum;
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param rainRate The filtered list of all measurements of this type within the given period.
     */
    private void SetRainRate(ArrayList<Double> rainRate) {
        maxRainRate = Calculations.maximum(rainRate);
        minRainRate = Calculations.minimum(rainRate);
        meanRainRate = Calculations.mean(rainRate);
        modeRainRate = Calculations.mode(rainRate);
        medianRainRate = Calculations.median(rainRate);
        standardDeviationRainRate = Calculations.standardDeviation(rainRate);
    }
    /**
     * Individual gets for each calculated RainRate value to allow access from other classes.
     * @return Calculated variable.
     */
    public double getMaxRainRate() {
        return maxRainRate;
    }
    public double getMinRainRate(){
        return minRainRate;
    }
    public double getMeanRainRate() {
        return meanRainRate;
    }
    public double getModeRainRate() {
        return modeRainRate;
    }
    public double getMedianRainRate() {
        return medianRainRate;
    }
    public double getStandardDeviationRainRate() {
        return standardDeviationRainRate;
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param uvLevel The filtered list of all measurements of this type within the given period.
     */
    private void SetUvLevel(ArrayList<Double> uvLevel) {
        maxUvLevel = Calculations.maximum(uvLevel);
        minUvLevel = Calculations.minimum(uvLevel);
        meanUvLevel = Calculations.mean(uvLevel);
        modeUvLevel = Calculations.mode(uvLevel);
        medianUvLevel = Calculations.median(uvLevel);
        standardDeviationUvLevel = Calculations.standardDeviation(uvLevel);
    }
    /**
     * Individual gets for each calculated UvLevel value to allow access from other classes.
     * @return Calculated variable.
     */
    public double getMaxUvLevel() {
        return maxUvLevel;
    }
    public double getMinUvLevel(){
        return minUvLevel;
    }
    public double getMeanUvLevel() {
        return meanUvLevel;
    }
    public double getModeUvLevel() {
        return modeUvLevel;
    }
    public double getMedianUvLevel() {
        return medianUvLevel;
    }
    public double getStandardDeviationUvLevel() {
        return standardDeviationUvLevel;
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param battLevel The filtered list of all measurements of this type within the given period.
     */
    private void SetBattLevel(ArrayList<Double> battLevel) {
        maxBattLevel = Calculations.maximum(battLevel);
        minBattLevel = Calculations.minimum(battLevel);
        meanBattLevel = Calculations.mean(battLevel);
        modeBattLevel = Calculations.mode(battLevel);
        medianBattLevel = Calculations.median(battLevel);
        standardDeviationBattLevel = Calculations.standardDeviation(battLevel);
    }
    /**
     * Individual gets for each calculated BattLevel value to allow access from other classes.
     * @return Calculated variable.
     */
    public double getMaxBattLevel() {
        return maxBattLevel;
    }
    public double getMinBattLevel(){
        return minBattLevel;
    }
    public double getMeanBattLevel() {
        return meanBattLevel;
    }
    public double getModeBattLevel() {
        return modeBattLevel;
    }
    public double getMedianBattLevel() {
        return medianBattLevel;
    }
    public double getStandardDeviationBattLevel() {
        return standardDeviationBattLevel;
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param sunSet The filtered list of all measurements of this type within the given period.
     */
    private void SetSunSet(ArrayList<Double> sunSet) {
        maxSunSet = Calculations.maximum(sunSet);
        minSunSet = Calculations.minimum(sunSet);
        meanSunSet = Calculations.mean(sunSet);
        modeSunSet = Calculations.mode(sunSet);
        medianSunSet = Calculations.median(sunSet);
        standardDeviationSunSet = Calculations.standardDeviation(sunSet);
    }
    /**
     * Individual gets for each calculated SunSet value to allow access from other classes.
     * @return Calculated variable.
     */
    public double getMaxSunSet() {
        return maxSunSet;
    }
    public double getMinSunSet(){
        return minSunSet;
    }
    public double getMeanSunSet() {
        return meanSunSet;
    }
    public double getModeSunSet() {
        return modeSunSet;
    }
    public double getMedianSunSet() {
        return medianSunSet;
    }
    public double getStandardDeviationSunSet() {
        return standardDeviationSunSet;
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param sunRise The filtered list of all measurements of this type within the given period.
     */
    private void SetSunRise(ArrayList<Double> sunRise) {
        maxSunRise = Calculations.maximum(sunRise);
        minSunRise = Calculations.minimum(sunRise);
        meanSunRise = Calculations.mean(sunRise);
        modeSunRise = Calculations.mode(sunRise);
        medianSunRise = Calculations.median(sunRise);
        standardDeviationSunRise = Calculations.standardDeviation(sunRise);
    }
    /**
     * Individual gets for each calculated SunRise value to allow access from other classes.
     * @return Calculated variable.
     */
    public double getMaxSunRise() {
        return maxSunRise;
    }
    public double getMinSunRise(){
        return minSunRise;
    }
    public double getMeanSunRise() {
        return meanSunRise;
    }
    public double getModeSunRise() {
        return modeSunRise;
    }
    public double getMedianSunRise() {
        return medianSunRise;
    }
    public double getStandardDeviationSunRise() {
        return standardDeviationSunRise;
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param windChill The filtered list of all measurements of this type within the given period.
     */
    private void SetWindChill(ArrayList<Double> windChill) {
        maxWindChill = Calculations.maximum(windChill);
        minWindChill = Calculations.minimum(windChill);
        meanWindChill = Calculations.mean(windChill);
        modeWindChill = Calculations.mode(windChill);
        medianWindChill = Calculations.median(windChill);
        standardDeviationWindChill = Calculations.standardDeviation(windChill);
    }
    /**
     * Individual gets for each calculated WindChill value to allow access from other classes.
     * @return Calculated variable.
     */
    public double getMaxWindChill() {
        return maxWindChill;
    }
    public double getMinWindChill(){
        return minWindChill;
    }
    public double getMeanWindChill() {
        return meanWindChill;
    }
    public double getModeWindChill() {
        return modeWindChill;
    }
    public double getMedianWindChill() {
        return medianWindChill;
    }
    public double getStandardDeviationWindChill() {
        return standardDeviationWindChill;
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param heatIndex The filtered list of all measurements of this type within the given period.
     */
    private void SetHeatIndex(ArrayList<Double> heatIndex) {
        maxHeatIndex = Calculations.maximum(heatIndex);
        minHeatIndex = Calculations.minimum(heatIndex);
        meanHeatIndex = Calculations.mean(heatIndex);
        modeHeatIndex = Calculations.mode(heatIndex);
        medianHeatIndex = Calculations.median(heatIndex);
        standardDeviationHeatIndex = Calculations.standardDeviation(heatIndex);
    }
    /**
     * Individual gets for each calculated HeatIndex value to allow access from other classes.
     * @return Calculated variable.
     */
    public double getMaxHeatIndex() {
        return maxHeatIndex;
    }
    public double getMinHeatIndex(){
        return minHeatIndex;
    }
    public double getMeanHeatIndex() {
        return meanHeatIndex;
    }
    public double getModeHeatIndex() {
        return modeHeatIndex;
    }
    public double getMedianHeatIndex() {
        return medianHeatIndex;
    }
    public double getStandardDeviationHeatIndex() {
        return standardDeviationHeatIndex;
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param dewPoint The filtered list of all measurements of this type within the given period.
     */
    private void SetDewPoint(ArrayList<Double> dewPoint) {
        maxDewPoint = Calculations.maximum(dewPoint);
        minDewPoint = Calculations.minimum(dewPoint);
        meanDewPoint = Calculations.mean(dewPoint);
        modeDewPoint = Calculations.mode(dewPoint);
        medianDewPoint = Calculations.median(dewPoint);
        standardDeviationDewPoint = Calculations.standardDeviation(dewPoint);
    }
    /**
     * Individual gets for each calculated DewPoint value to allow access from other classes.
     * @return Calculated variable.
     */
    public double getMaxDewPoint() {
        return maxDewPoint;
    }
    public double getMinDewPoint(){
        return minDewPoint;
    }
    public double getMeanDewPoint() {
        return meanDewPoint;
    }
    public double getModeDewPoint() {
        return modeDewPoint;
    }
    public double getMedianDewPoint() {
        return medianDewPoint;
    }
    public double getStandardDeviationDewPoint() {
        return standardDeviationDewPoint;
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param periodMeasurements The complete list of all measurements within the given period.
     */
    private void SetPreDefined(ArrayList<Measurement> periodMeasurements) {
        mist = Calculations.mist(periodMeasurements);
        //maxRain = Calculations.maxRain(periodMeasurements);
        //tempChange = Calculations.tempChange(periodMeasurements);
        //degreeDays = Calculations.calculateDegreeDays(periodMeasurements);
        risingTemperature = Calculations.risingTemperatureDuration(periodMeasurements);
    }
    /**
     * Individual gets for each individual assignment value to allow access from other classes.
     * @return individual assignment variable.
     */
    public int getMist() {
        return mist;
    }
    public double getMaxRain() {
        return maxRain;
    }
    public int getTempChange() {
        return tempChange;
    }
    public int getDegreeDays() {
        return degreeDays;
    }
    public int getRisingTemperature() {
        return risingTemperature;
    }
}
