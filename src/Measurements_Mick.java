public class Measurements_Mick {

    private double insideTemp;
    public void setInsideTemp (short val) { this.insideTemp = ValueConverter.temperature(val);};
    public double getInsideTemp () { return insideTemp; };

    private double insideHum;
    public void setInsideHum (short val) { this.insideHum = ValueConverter.humidity(val);};
    public double getInsideHum () { return insideHum; };

    private double outsideTemp;
    public void setOutsideTemp (short val) { this.outsideTemp = ValueConverter.temperature(val);};
    public double getOutsideTemp () { return outsideTemp; };

    private double windSpeed;
    public void setWindSpeed (short val) { this.windSpeed = ValueConverter.windSpeed(val);};
    public double getWindSpeed () { return windSpeed; };

    private double avgWindSpeed;
    public void setAvgWindSpeed (short val) { this.avgWindSpeed = ValueConverter.windSpeed(val);};
    public double getAvgWindSpeed () { return avgWindSpeed; };

    private double windDir;
    public void setWindDir (short val) { this.windDir = ValueConverter.windDirection(val);};
    public double getWindDir () { return windDir; };

    private double outsideHum;
    public void setOutsideHum (short val) { this.outsideHum = ValueConverter.humidity(val);};
    public double getOutsideHum () { return outsideHum; };

    private double rainRate;
    public void setRainRate (short val) { this.rainRate = ValueConverter.rainMeter(val);};
    public double getRainRate () { return rainRate; };

    private double uvLevel;
    public void setUvLevel (short val) { this.uvLevel = ValueConverter.uvIndex(val);};
    public double getUvLevel () { return uvLevel; };

    //solar rad

    //xmittbat

    private double battLevel;
    public void setBattLevel (short val) { this.battLevel = ValueConverter.batteryLevel(val);};
    public double getBattLevel () { return battLevel; };

    //ForeIcon
    private String sunSet;
    public void SetSunSet (short val) { this.sunSet = ValueConverter.sunSet(val);};
    public String GetSunSet () { return sunSet; };

    private String sunRise;
    public void SetSunRise (short val) { this.sunRise = ValueConverter.sunRise(val);};
    public String GetSunRise () { return sunRise; };
}
