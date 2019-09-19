import java.util.logging.Filter;

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

    public Measurement()
    {

    }

    public Measurement(RawMeasurement rawData)
    {
       setBarometer(rawData.getBarometer());
       setInsideTemp(rawData.getInsideTemp());
    }



    public void setBarometer (short val) {
        short max = 32767;
        if (DataFilter(val,max)) {
            this.barometer = ValueConverter.airPressure(val);
        } else {
            this.barometer = ;
        }

    };
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
                /*+ "\nUVLevel = \t" + UVLevel
                + "\nsolarRad = \t" + solarRad
                + "\nxmitBatt = \t" + xmitBatt*/
                + "\nbattLevel = \t" + battLevel;
                /*+ "\nforeIcon = \t" + foreIcon
                + "\nsunrise = \t" + sunrise
                + "\nsunset = \t" + sunset;*/
        return s;
    }
    public boolean DataFilter (short rawData, short maxValue) {
        boolean valid;
        if (rawData < maxValue) {
            return valid = true;
        } else {
            return valid = false;
        }
    }
}