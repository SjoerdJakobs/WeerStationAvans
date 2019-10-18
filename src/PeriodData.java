import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.Set;

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
     * Creates individual ArrayLists for each measurement type and adds to the list.
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
            windChill.add(Calculations.windChill(data.getOutsideTemp(),data.getWindSpeed()));
            heatIndex.add(Calculations.heatIndex(data.getInsideTemp(),data.getInsideHum()));
            dewPoint.add(Calculations.dewPoint(data.getOutsideTemp(), data.getOutsideHum()));
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
        this.maxAirPressure = Calculations.maximum(airPressure);
        this.minAirPressure = Calculations.minimum(airPressure);
        this.meanAirPressure = Calculations.mean(airPressure);
        this.modeAirPressure = Calculations.mode(airPressure);
        this.medianAirPressure = Calculations.median(airPressure);
        this.standardDeviationAirPressure = Calculations.standardDeviation(airPressure);
    }

    /**
     * Individual gets for each calculated AirPressure value to allow access from other classes.
     * @return Calculated variable.
     */
    public double getMaxAirPressure() {
        return this.maxAirPressure;
    }
    public double getMinAirPressure(){
        return this.minAirPressure;
    }
    public double getMeanAirPressure() {
        return this.meanAirPressure;
    }
    public double getModeAirPressure() {
        return this.modeAirPressure;
    }
    public double getMedianAirPressure() {
        return this.medianAirPressure;
    }
    public double getStandardDeviationAirPressure() {
        return this.standardDeviationAirPressure;
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param insideTemp The filtered list of all measurements of this type within the given period.
     */
    private void SetInsideTemp(ArrayList<Double> insideTemp) {
        this.maxInsideTemp = Calculations.maximum(insideTemp);
        this.minInsideTemp = Calculations.minimum(insideTemp);
        this.meanInsideTemp = Calculations.mean(insideTemp);
        this.modeInsideTemp = Calculations.mode(insideTemp);
        this.medianInsideTemp = Calculations.median(insideTemp);
        this.standardDeviationInsideTemp = Calculations.standardDeviation(insideTemp);
    }
    /**
     * Individual gets for each calculated InsideTemp value to allow access from other classes.
     * @return Calculated variable.
     */
    public double getMaxInsideTemp() {
        return this.maxInsideTemp;
    }
    public double getMinInsideTemp(){
        return this.minInsideTemp;
    }
    public double getMeanInsideTemp() {
        return this.meanInsideTemp;
    }
    public double getModeInsideTemp() {
        return this.modeInsideTemp;
    }
    public double getMedianInsideTemp() {
        return this.medianInsideTemp;
    }
    public double getStandardDeviationInsideTemp() {
        return this.standardDeviationInsideTemp;
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param insideHum The filtered list of all measurements of this type within the given period.
     */
    private void SetInsideHum(ArrayList<Double> insideHum) {
        this.maxInsideHum = Calculations.maximum(insideHum);
        this.minInsideHum = Calculations.minimum(insideHum);
        this.meanInsideHum = Calculations.mean(insideHum);
        this.modeInsideHum = Calculations.mode(insideHum);
        this.medianInsideHum = Calculations.median(insideHum);
        this.standardDeviationInsideHum = Calculations.standardDeviation(insideHum);
    }
    /**
     * Individual gets for each calculated MaxInsideHum value to allow access from other classes.
     * @return Calculated variable.
     */
    public double getMaxInsideHum() {
        return this.maxInsideHum;
    }
    public double getMinInsideHum(){
        return this.minInsideHum;
    }
    public double getMeanInsideHum() {
        return this.meanInsideHum;
    }
    public double getModeInsideHum() {
        return this.modeInsideHum;
    }
    public double getMedianInsideHum() {
        return this.medianInsideHum;
    }
    public double getStandardDeviationInsideHum() {
        return this.standardDeviationInsideHum;
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param outsideTemp The filtered list of all measurements of this type within the given period.
     */
    private void SetOutsideTemp(ArrayList<Double> outsideTemp) {
        this.maxOutsideTemp = Calculations.maximum(outsideTemp);
        this.minOutsideTemp = Calculations.minimum(outsideTemp);
        this.meanOutsideTemp = Calculations.mean(outsideTemp);
        this.modeOutsideTemp = Calculations.mode(outsideTemp);
        this.medianOutsideTemp = Calculations.median(outsideTemp);
        this.standardDeviationOutsideTemp = Calculations.standardDeviation(outsideTemp);
    }
    /**
     * Individual gets for each calculated OutsideTemp value to allow access from other classes.
     * @return Calculated variable.
     */
    public double getMaxOutsideTemp() {
        return this.maxOutsideTemp;
    }
    public double getMinOutsideTemp(){
        return this.minOutsideTemp;
    }
    public double getMeanOutsideTemp() {
        return this.meanOutsideTemp;
    }
    public double getModeOutsideTemp() {
        return this.modeOutsideTemp;
    }
    public double getMedianOutsideTemp() {
        return this.medianOutsideTemp;
    }
    public double getStandardDeviationOutsideTemp() {
        return this.standardDeviationOutsideTemp;
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param windSpeed The filtered list of all measurements of this type within the given period.
     */
    private void SetWindSpeed(ArrayList<Double> windSpeed){
        this.maxWindSpeed = Calculations.maximum(windSpeed);
        this.minWindSpeed = Calculations.minimum(windSpeed);
        this.meanWindSpeed = Calculations.mean(windSpeed);
        this.modeWindSpeed = Calculations.mode(windSpeed);
        this.medianWindSpeed = Calculations.median(windSpeed);
        this.standardDeviationWindSpeed = Calculations.standardDeviation(windSpeed);
    }
    /**
     * Individual gets for each calculated WindSpeed value to allow access from other classes.
     * @return Calculated variable.
     */
    public double getMaxWindSpeed() {
        return this.maxWindSpeed;
    }
    public double getMinWindSpeed(){
        return this.minWindSpeed;
    }
    public double getMeanWindSpeed() {
        return this.meanWindSpeed;
    }
    public double getModeWindSpeed() {
        return this.modeWindSpeed;
    }
    public double getMedianWindSpeed() {
        return this.medianWindSpeed;
    }
    public double getStandardDeviationWindSpeed() {
        return this.standardDeviationWindSpeed;
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param avgWindSpeed The filtered list of all measurements of this type within the given period.
     */
    private void SetAvgWindSpeed(ArrayList<Double> avgWindSpeed){
        this.maxAvgWindSpeed = Calculations.maximum(avgWindSpeed);
        this.minAvgWindSpeed = Calculations.minimum(avgWindSpeed);
        this.meanAvgWindSpeed = Calculations.mean(avgWindSpeed);
        this.modeAvgWindSpeed = Calculations.mode(avgWindSpeed);
        this.medianAvgWindSpeed = Calculations.median(avgWindSpeed);
        this.standardDeviationAvgWindSpeed = Calculations.standardDeviation(avgWindSpeed);
    }
    /**
     * Individual gets for each calculated AvgWindSpeed value to allow access from other classes.
     * @return Calculated variable.
     */
    public double getMaxAvgWindSpeed() {
        return this.maxAvgWindSpeed;
    }
    public double getMinAvgWindSpeed(){
        return this.minAvgWindSpeed;
    }
    public double getMeanAvgWindSpeed() {
        return this.meanAvgWindSpeed;
    }
    public double getModeAvgWindSpeed() {
        return this.modeAvgWindSpeed;
    }
    public double getMedianAvgWindSpeed() {
        return this.medianAvgWindSpeed;
    }
    public double getStandardDeviationAvgWindSpeed() {
        return this.standardDeviationAvgWindSpeed;
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param windDir The filtered list of all measurements of this type within the given period.
     */
    private void SetWindDir(ArrayList<Double> windDir) {
        this.maxWindDir = Calculations.maximum(windDir);
        this.minWindDir = Calculations.minimum(windDir);
        this.meanWindDir = Calculations.mean(windDir);
        this.modeWindDir = Calculations.mode(windDir);
        this.medianWindDir = Calculations.median(windDir);
        this.standardDeviationWindDir = Calculations.standardDeviation(windDir);
    }
    /**
     * Individual gets for each calculated WindDir value to allow access from other classes.
     * @return Calculated variable.
     */
    public double getMaxWindDir() {
        return this.maxWindDir;
    }
    public double getMinWindDir(){
        return this.minWindDir;
    }
    public double getMeanWindDir() {
        return this.meanWindDir;
    }
    public double getModeWindDir() {
        return this.modeWindDir;
    }
    public double getMedianWindDir() {
        return this.medianWindDir;
    }
    public double getStandardDeviationWindDir() {
        return this.standardDeviationWindDir;
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param outsideHum The filtered list of all measurements of this type within the given period.
     */
    private void SetOutsideHum(ArrayList<Double> outsideHum) {
        this.maxOutsideHum = Calculations.maximum(outsideHum);
        this.minOutsideHum = Calculations.minimum(outsideHum);
        this.meanOutsideHum = Calculations.mean(outsideHum);
        this.modeOutsideHum = Calculations.mode(outsideHum);
        this.medianOutsideHum = Calculations.median(outsideHum);
        this.standardDeviationOutsideHum = Calculations.standardDeviation(outsideHum);
    }
    /**
     * Individual gets for each calculated OutsideHum value to allow access from other classes.
     * @return Calculated variable.
     */
    public double getMaxOutsideHum() {
        return this.maxOutsideHum;
    }
    public double getMinOutsideHum(){
        return this.minOutsideHum;
    }
    public double getMeanOutsideHum() {
        return this.meanOutsideHum;
    }
    public double getModeOutsideHum() {
        return this.modeOutsideHum;
    }
    public double getMedianOutsideHum() {
        return this.medianOutsideHum;
    }
    public double getStandardDeviationOutsideHum() {
        return this.standardDeviationOutsideHum;
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param rainRate The filtered list of all measurements of this type within the given period.
     */
    private void SetRainRate(ArrayList<Double> rainRate) {
        this.maxRainRate = Calculations.maximum(rainRate);
        this.minRainRate = Calculations.minimum(rainRate);
        this.meanRainRate = Calculations.mean(rainRate);
        this.modeRainRate = Calculations.mode(rainRate);
        this.medianRainRate = Calculations.median(rainRate);
        this.standardDeviationRainRate = Calculations.standardDeviation(rainRate);
    }
    /**
     * Individual gets for each calculated RainRate value to allow access from other classes.
     * @return Calculated variable.
     */
    public double getMaxRainRate() {
        return this.maxRainRate;
    }
    public double getMinRainRate(){
        return this.minRainRate;
    }
    public double getMeanRainRate() {
        return this.meanRainRate;
    }
    public double getModeRainRate() {
        return this.modeRainRate;
    }
    public double getMedianRainRate() {
        return this.medianRainRate;
    }
    public double getStandardDeviationRainRate() {
        return this.standardDeviationRainRate;
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param uvLevel The filtered list of all measurements of this type within the given period.
     */
    private void SetUvLevel(ArrayList<Double> uvLevel) {
        this.maxUvLevel = Calculations.maximum(uvLevel);
        this.minUvLevel = Calculations.minimum(uvLevel);
        this.meanUvLevel = Calculations.mean(uvLevel);
        this.modeUvLevel = Calculations.mode(uvLevel);
        this.medianUvLevel = Calculations.median(uvLevel);
        this.standardDeviationUvLevel = Calculations.standardDeviation(uvLevel);
    }
    /**
     * Individual gets for each calculated UvLevel value to allow access from other classes.
     * @return Calculated variable.
     */
    public double getMaxUvLevel() {
        return this.maxUvLevel;
    }
    public double getMinUvLevel(){
        return this.minUvLevel;
    }
    public double getMeanUvLevel() {
        return this.meanUvLevel;
    }
    public double getModeUvLevel() {
        return this.modeUvLevel;
    }
    public double getMedianUvLevel() {
        return this.medianUvLevel;
    }
    public double getStandardDeviationUvLevel() {
        return this.standardDeviationUvLevel;
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param battLevel The filtered list of all measurements of this type within the given period.
     */
    private void SetBattLevel(ArrayList<Double> battLevel) {
        this.maxBattLevel = Calculations.maximum(battLevel);
        this.minBattLevel = Calculations.minimum(battLevel);
        this.meanBattLevel = Calculations.mean(battLevel);
        this.modeBattLevel = Calculations.mode(battLevel);
        this.medianBattLevel = Calculations.median(battLevel);
        this.standardDeviationBattLevel = Calculations.standardDeviation(battLevel);
    }
    /**
     * Individual gets for each calculated BattLevel value to allow access from other classes.
     * @return Calculated variable.
     */
    public double getMaxBattLevel() {
        return this.maxBattLevel;
    }
    public double getMinBattLevel(){
        return this.minBattLevel;
    }
    public double getMeanBattLevel() {
        return this.meanBattLevel;
    }
    public double getModeBattLevel() {
        return this.modeBattLevel;
    }
    public double getMedianBattLevel() {
        return this.medianBattLevel;
    }
    public double getStandardDeviationBattLevel() {
        return this.standardDeviationBattLevel;
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param sunSet The filtered list of all measurements of this type within the given period.
     */
    private void SetSunSet(ArrayList<Double> sunSet) {
        this.maxSunSet = Calculations.maximum(sunSet);
        this.minSunSet = Calculations.minimum(sunSet);
        this.meanSunSet = Calculations.mean(sunSet);
        this.modeSunSet = Calculations.mode(sunSet);
        this.medianSunSet = Calculations.median(sunSet);
        this.standardDeviationSunSet = Calculations.standardDeviation(sunSet);
    }
    /**
     * Individual gets for each calculated SunSet value to allow access from other classes.
     * @return Calculated variable.
     */
    public double getMaxSunSet() {
        return this.maxSunSet;
    }
    public double getMinSunSet(){
        return this.minSunSet;
    }
    public double getMeanSunSet() {
        return this.meanSunSet;
    }
    public double getModeSunSet() {
        return this.modeSunSet;
    }
    public double getMedianSunSet() {
        return this.medianSunSet;
    }
    public double getStandardDeviationSunSet() {
        return this.standardDeviationSunSet;
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param sunRise The filtered list of all measurements of this type within the given period.
     */
    private void SetSunRise(ArrayList<Double> sunRise) {
        this.maxSunRise = Calculations.maximum(sunRise);
        this.minSunRise = Calculations.minimum(sunRise);
        this. meanSunRise = Calculations.mean(sunRise);
        this.modeSunRise = Calculations.mode(sunRise);
        this.medianSunRise = Calculations.median(sunRise);
        this.standardDeviationSunRise = Calculations.standardDeviation(sunRise);
    }
    /**
     * Individual gets for each calculated SunRise value to allow access from other classes.
     * @return Calculated variable.
     */
    public double getMaxSunRise() {
        return this.maxSunRise;
    }
    public double getMinSunRise(){
        return this.minSunRise;
    }
    public double getMeanSunRise() {
        return this.meanSunRise;
    }
    public double getModeSunRise() {
        return this.modeSunRise;
    }
    public double getMedianSunRise() {
        return this.medianSunRise;
    }
    public double getStandardDeviationSunRise() {
        return this.standardDeviationSunRise;
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param windChill The filtered list of all measurements of this type within the given period.
     */
    private void SetWindChill(ArrayList<Double> windChill) {
        this.maxWindChill = Calculations.maximum(windChill);
        this.minWindChill = Calculations.minimum(windChill);
        this.meanWindChill = Calculations.mean(windChill);
        this.modeWindChill = Calculations.mode(windChill);
        this.medianWindChill = Calculations.median(windChill);
        this.standardDeviationWindChill = Calculations.standardDeviation(windChill);
    }
    /**
     * Individual gets for each calculated WindChill value to allow access from other classes.
     * @return Calculated variable.
     */
    public double getMaxWindChill() {
        return this.maxWindChill;
    }
    public double getMinWindChill(){
        return this.minWindChill;
    }
    public double getMeanWindChill() {
        return this.meanWindChill;
    }
    public double getModeWindChill() {
        return this.modeWindChill;
    }
    public double getMedianWindChill() {
        return this.medianWindChill;
    }
    public double getStandardDeviationWindChill() {
        return this.standardDeviationWindChill;
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param heatIndex The filtered list of all measurements of this type within the given period.
     */
    private void SetHeatIndex(ArrayList<Double> heatIndex) {
        this.maxHeatIndex = Calculations.maximum(heatIndex);
        this.minHeatIndex = Calculations.minimum(heatIndex);
        this.meanHeatIndex = Calculations.mean(heatIndex);
        this.modeHeatIndex = Calculations.mode(heatIndex);
        this.medianHeatIndex = Calculations.median(heatIndex);
        this.standardDeviationHeatIndex = Calculations.standardDeviation(heatIndex);
    }
    /**
     * Individual gets for each calculated HeatIndex value to allow access from other classes.
     * @return Calculated variable.
     */
    public double getMaxHeatIndex() {
        return this.maxHeatIndex;
    }
    public double getMinHeatIndex(){
        return this.minHeatIndex;
    }
    public double getMeanHeatIndex() {
        return this.meanHeatIndex;
    }
    public double getModeHeatIndex() {
        return this.modeHeatIndex;
    }
    public double getMedianHeatIndex() {
        return this.medianHeatIndex;
    }
    public double getStandardDeviationHeatIndex() {
        return this.standardDeviationHeatIndex;
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param dewPoint The filtered list of all measurements of this type within the given period.
     */
    private void SetDewPoint(ArrayList<Double> dewPoint) {
        this.maxDewPoint = Calculations.maximum(dewPoint);
        this.minDewPoint = Calculations.minimum(dewPoint);
        this.meanDewPoint = Calculations.mean(dewPoint);
        this.modeDewPoint = Calculations.mode(dewPoint);
        this.medianDewPoint = Calculations.median(dewPoint);
        this.standardDeviationDewPoint = Calculations.standardDeviation(dewPoint);
    }
    /**
     * Individual gets for each calculated DewPoint value to allow access from other classes.
     * @return Calculated variable.
     */
    public double getMaxDewPoint() {
        return this.maxDewPoint;
    }
    public double getMinDewPoint(){
        return this.minDewPoint;
    }
    public double getMeanDewPoint() {
        return this.meanDewPoint;
    }
    public double getModeDewPoint() {
        return this.modeDewPoint;
    }
    public double getMedianDewPoint() {
        return this.medianDewPoint;
    }
    public double getStandardDeviationDewPoint() {
        return this.standardDeviationDewPoint;
    }

    /**
     * Sets the calculated data by calling the calculation functions and adding the results to the data storage.
     * @param periodMeasurements The complete list of all measurements within the given period.
     */
    private void SetPreDefined(ArrayList<Measurement> periodMeasurements) {
        this.mist = Calculations.mist(periodMeasurements);
        //this.maxRain = Calculations.maxRain(periodMeasurements);
        //this.tempChange = Calculations.tempChange(periodMeasurements);
        this.degreeDays = Calculations.calculateDegreeDays(periodMeasurements);
        this.risingTemperature = Calculations.risingTemperatureDuration(periodMeasurements);
    }
    /**
     * Individual gets for each individual assignment value to allow access from other classes.
     * @return individual assignment variable.
     */
    public int getMist() {
        return this.mist;
    }
    public double getMaxRain() {
        return this.maxRain;
    }
    public int getTempChange() {
        return this.tempChange;
    }
    public int getDegreeDays() {
        return this.degreeDays;
    }
    public int getRisingTemperature() {
        return this.risingTemperature;
    }

}