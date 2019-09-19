public class Measurement {

    public Measurement()
    {

    }

    public Measurement(RawMeasurement rawData)
    {

    }

    private double barometer;
    public void setBarometer (short val) { this.barometer = ValueConverter.airPressure(val);};
    public double getBarometer () { return barometer; };

    //public double Barometer = ValueConverter.airPressure(rawData.getBarometer());
    //public double insideTemperature = ValueConverter.temperature(rawData.getInsideTemp());
    //public double insideHum = ValueConverter.humidity(rawData.getInsideHum());
    //public double outsideTemperature = ValueConverter.temperature(rawData.getOutsideTemp());
    //public double windspeed = ValueConverter.windSpeed(rawData.getWindSpeed());
    //public double avgWindSpeed = ValueConverter.windSpeed(rawData.getWindSpeed());
    //public double windDir = ValueConverter.windDirection(rawData.getWindDir());
    //public double outsideHum = ValueConverter.humidity(rawData.getOutsideHum());
    //public double rainRate = ValueConverter.rainMeter(rawData.getRainRate());
    //public double uvLevel = ValueConverter.uvIndex(rawData.getUVLevel());
    // public double solarRad = ValueConverter.;
    //public double xmitBatt = rawData.getXmitBatt();
    //public double battLevel = ValueConverter.batteryLevel(rawData.getBattLevel());
    // public double foreIcon = ;
    //public String sunRise = ValueConverter.sunRise(rawData.getSunrise());
    //public String sunSet = ValueConverter.sunSet(rawData.getSunset());

    /*
    public String toString()
    {
        String s = "RawMeasurement:"
                + "\nstationId = \t" + stationId
                + "\ndateStamp = \t" + dateStamp
                + "\nbarometer = \t" + barometer
                + "\ninsideTemp = \t" + insideTemp
                + "\ninsideHum = \t" + insideHum
                + "\noutsideTemp = \t" + outsideTemp
                + "\nwindSpeed = \t" + windSpeed
                + "\navgWindSpeed = \t" + avgWindSpeed
                + "\nwindDir = \t" + windDir
                + "\noutsideHum = \t" + outsideHum
                + "\nrainRate = \t" + rainRate
                + "\nUVLevel = \t" + UVLevel
                + "\nsolarRad = \t" + solarRad
                + "\nxmitBatt = \t" + xmitBatt
                + "\nbattLevel = \t" + battLevel
                + "\nforeIcon = \t" + foreIcon
                + "\nsunrise = \t" + sunrise
                + "\nsunset = \t" + sunset;
        return s;
    }*/


}