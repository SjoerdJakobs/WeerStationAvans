public class Measurement {

    public RawMeasurement rawData = DatabaseConnection.getMostRecentMeasurement();
    public double Barometer = ValueConverter.airPressure(rawData.getBarometer());
    public double insideTemperature = ValueConverter.temperature(rawData.getInsideTemp());
    public double insideHum = ValueConverter.humidity(rawData.getInsideHum());
    public double outsideTemperature = ValueConverter.temperature(rawData.getOutsideTemp());
    public double windspeed = ValueConverter.windSpeed(rawData.getWindSpeed());
    public double avgWindSpeed = ValueConverter.windSpeed(rawData.getWindSpeed());
    public double windDir = ValueConverter.windDirection(rawData.getWindDir());
    public double outsideHum = ValueConverter.humidity(rawData.getOutsideHum());
    public double rainRate = ValueConverter.rainMeter(rawData.getRainRate());
    public double uvLevel = ValueConverter.uvIndex(rawData.getUVLevel());
    // public double solarRad = ValueConverter.;
    public double xmitBatt = rawData.getXmitBatt();
    public double battLevel = ValueConverter.batteryLevel(rawData.getBattLevel());
    // public double foreIcon = ;
    public String sunRise = ValueConverter.sunRise(rawData.getSunrise());
    public String sunSet = ValueConverter.sunSet(rawData.getSunset());



}