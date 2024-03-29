import java.time.LocalDateTime;

public class Measurement {

    private String stationId;
    private LocalDateTime dateStamp;
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
    private double sunSet;
    private double sunRise;

    public Measurement() {

    }

    public Measurement(RawMeasurement rawData) {
        setStationId(rawData.getStationId());
        setDateStamp(rawData.getDateStamp());
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
    }


    public void setBarometer(short val) {
        short max = 32767;
        if (DataFilter(val, max)) {
            this.barometer = ValueConverter.airPressure(val);
        } else {
            this.barometer = Double.NaN;
        }
    }


    public double getBarometer() {
        return barometer;
    }


    public void setInsideTemp(short val) {
        short max = 32767;
        if (DataFilter(val, max)) {
            this.insideTemp = ValueConverter.temperature(val);
            ;
        } else {
            this.insideTemp = Double.NaN;
        }
    }

    public double getInsideTemp() {
        return insideTemp;
    }


    public void setInsideHum(short val) {
        short max = 100;
        if (DataFilter(val, max)) {
            this.insideHum = ValueConverter.humidity(val);
        } else {
            this.insideHum = Double.NaN;
        }
    }

    public double getInsideHum() {
        return insideHum;
    }


    public void setOutsideTemp(short val) {
        short max = 32767;
        if (DataFilter(val, max)) {
            this.outsideTemp = ValueConverter.temperature(val);
        } else {
            this.outsideTemp = Double.NaN;
        }
    }

    public double getOutsideTemp() {
        return outsideTemp;
    }

    public void setWindSpeed(short val) {
        short max = 255;
        if (DataFilter(val, max)) {
            this.windSpeed = ValueConverter.windSpeed(val);
        } else {
            this.windSpeed = Double.NaN;
        }
    }

    public double getWindSpeed() {
        return windSpeed;
    }


    public void setAvgWindSpeed(short val) {
        short max = 255;
        if (DataFilter(val, max)) {
            this.avgWindSpeed = ValueConverter.windSpeed(val);
        } else {
            this.avgWindSpeed = Double.NaN;
        }
    }

    public double getAvgWindSpeed() {
        return avgWindSpeed;
    }


    public void setWindDir(short val) {
        short max = 32767;
        if (DataFilter(val, max)) {
            this.windDir = ValueConverter.windDirection(val);
        } else {
            this.windDir = Double.NaN;
        }
    }

    public double getWindDir() {
        return windDir;
    }


    public void setOutsideHum(short val) {
        short max = 255;
        if (DataFilter(val, max)) {
            this.outsideHum = ValueConverter.humidity(val);
        } else {
            this.outsideHum = Double.NaN;
        }
    }

    public double getOutsideHum() {
        return outsideHum;
    }


    public void setRainRate(short val) {
        short max = 32767;
        if (DataFilter(val, max)) {
            this.rainRate = ValueConverter.rainMeter(val);
        } else {
            this.rainRate = Double.NaN;
        }
    }

    public double getRainRate() {
        return rainRate;
    }


    public void setUvLevel(short val) {
        short max = 255;
        if (DataFilter(val, max)) {
            this.uvLevel = ValueConverter.uvIndex(val);
        } else {
            this.uvLevel = Double.NaN;
        }
    }

    public double getUvLevel() {
        return uvLevel;
    }


    public void setBattLevel(short val) {
        short max = 1000;
        if (DataFilter(val, max)) {
            this.battLevel = ValueConverter.batteryLevel(val);
        } else {
            this.battLevel = Double.NaN;
        }
    }

    public double getBattLevel() {
        return battLevel;
    }

    public void SetSunSet(short val) {
        short max = 2400;
        if (DataFilter(val, max)) {
            this.sunSet = val;
        } else {
            this.sunSet = Double.NaN;
        }
    }

    public double GetSunSet() {
        return sunSet;
    }


    public void SetSunRise(short val) {
        short max = 2400;
        if (DataFilter(val, max)) {
            this.sunRise = val;
        } else {
            this.sunRise = Double.NaN;
        }
    }

    public double GetSunRise () {
        return sunRise;
    }

    public void setStationId(String val1) { this.stationId = val1; }
    public String getStationId() { return stationId; }

    public void setDateStamp(LocalDateTime val1) { this.dateStamp = val1;};
    public LocalDateTime getDateStamp() { return dateStamp; }

    public String toString()
    {
        String s = "Measurement:"
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
                + "\nUVLevel = \t" + uvLevel
                + "\nbattLevel = \t" + battLevel
                + "\nsunrise = \t" + sunRise
                + "\nsunset = \t" + sunSet;

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