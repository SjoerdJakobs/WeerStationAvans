public class Measurement
{
    private double barometer;
    private double insideTemp;
    private double insideHum;
    private double outsideTemp;
    private double windSpeed;
    private double avgWindSpeed;
    private double windDir;
    private double outsideHum;
    private double rainRate;
    private double uvLevel;
    private double battLevel;
    private String sunSet;
    private String sunRise;
    private double dewPoint;
    private double windChill;
    private double heatIndex;

    public Measurement()
    {

    }

    public Measurement(RawMeasurement rawData)
    {
        setBarometer(rawData.getBarometer());
        setInsideTemp(rawData.getInsideTemp());
        setInsideHum(rawData.getInsideHum());
        setOutsideTemp(rawData.getOutsideTemp());
        setWindSpeed(rawData.getWindSpeed());
        setAvgWindSpeed(rawData.getAvgWindSpeed());
        setWindDir(rawData.getWindDir());
        setOutsideHum(rawData.getOutsideHum());
        setRainRate(rawData.getRainRate());
        setUvLevel(rawData.getRainRate());
        setBattLevel(rawData.getBattLevel());
        SetSunSet(rawData.getSunset());
        SetSunRise(rawData.getSunrise());
        SetDewPoint(getOutsideTemp(),getOutsideHum());
        SetWindChill(rawData.getWindSpeed(),rawData.getOutsideTemp());
        SetHeatIndex(getOutsideTemp(),getOutsideHum());
    }

    public void setBarometer (short val) { this.barometer = ValueConverter.airPressure(val);};
    public double getBarometer () { return barometer; };

    public void setInsideTemp (short val) { this.insideTemp = ValueConverter.temperature(val);};
    public double getInsideTemp () { return insideTemp; };

    public void setInsideHum (short val) { this.insideHum = ValueConverter.humidity(val);};
    public double getInsideHum () { return insideHum; };

    public void setOutsideTemp (short val) { this.outsideTemp = ValueConverter.temperature(val);};
    public double getOutsideTemp () { return outsideTemp; };

    public void setWindSpeed (short val) { this.windSpeed = ValueConverter.windSpeed(val);};
    public double getWindSpeed () { return windSpeed; };

    public void setAvgWindSpeed (short val) { this.avgWindSpeed = ValueConverter.windSpeed(val);};
    public double getAvgWindSpeed () { return avgWindSpeed; };

    public void setWindDir (short val) { this.windDir = ValueConverter.windDirection(val);};
    public double getWindDir () { return windDir; };

    public void setOutsideHum (short val) { this.outsideHum = ValueConverter.humidity(val);};
    public double getOutsideHum () { return outsideHum; };

    public void setRainRate (short val) { this.rainRate = ValueConverter.rainMeter(val);};
    public double getRainRate () { return rainRate; };

    public void setUvLevel (short val) { this.uvLevel = ValueConverter.uvIndex(val);};
    public double getUvLevel () { return uvLevel; };

    //solar rad

    //xmittbat

    public void setBattLevel (short val) { this.battLevel = ValueConverter.batteryLevel(val);};
    public double getBattLevel () { return battLevel; };

    //ForeIcon
    public void SetSunSet (short val) { this.sunSet = ValueConverter.sunSet(val);};
    public String GetSunSet () { return sunSet; };

    public void SetSunRise (short val) { this.sunRise = ValueConverter.sunRise(val);};
    public String GetSunRise () { return sunRise; };

    public void SetDewPoint(double val1, double val2) { this.dewPoint = ValueConverter.dewPoint(val1,val2);};
    public double GetDewPoint() { return dewPoint; };

    public void SetWindChill(short val1, short val2) { this.windChill = ValueConverter.windChill(val1, val2);};
    public double GetWindChill() { return windChill; };

    public void SetHeatIndex(double val1, double val2) { this.heatIndex = ValueConverter.dewPoint(val1,val2);};
    public double GetHeatIndex() { return heatIndex; };


    public String toString()
    {
        String s = "RawMeasurement:"
                /*+ "\nstationId = \t" + stationId
                + "\ndateStamp = \t" + dateStamp*/
                + "\nbarometer = \t" + barometer
                + "\ninsideTemp = \t" + insideTemp
                + "\ninsideHum = \t" + insideHum
                + "\noutsideTemp = \t" + outsideTemp
                + "\nwindSpeed = \t" + windSpeed
                + "\navgWindSpeed = \t" + avgWindSpeed
                + "\nwindDir = \t" + windDir
                + "\noutsideHum = \t" + outsideHum
                + "\nrainRate = \t" + rainRate
                + "\nUVLevel = \t" + uvLevel
                /*+ "\nsolarRad = \t" + solarRad
                + "\nxmitBatt = \t" + xmitBatt*/
                + "\nbattLevel = \t" + battLevel
                /*+ "\nforeIcon = \t" + foreIcon*/
                + "\nsunrise = \t" + sunRise
                + "\nsunset = \t" + sunSet;
        return s;
    }
}