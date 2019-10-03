import java.time.LocalDateTime;

public class Measurement {

    private String stationId;
    private LocalDateTime dateStamp;
    private Double barometer;
    private Double insideTemp;
    private Double insideHum;
    private Double outsideTemp;
    private Double windSpeed;
    private Double avgWindSpeed;
    private Double windDir;
    private Double outsideHum;
    private Double rainRate;
    private Double uvLevel;
    private Double battLevel;
    private String sunSet;
    private String sunRise;
    private Double windChill;
    private Double heatIndex;

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
            this.barometer = null;
        }
    }


    public Double getBarometer() {
        return barometer;
    }


    public void setInsideTemp(short val) {
        short max = 32767;
        if (DataFilter(val, max)) {
            this.insideTemp = ValueConverter.temperature(val);
            ;
        } else {
            this.insideTemp = null;
        }
    }

    public Double getInsideTemp() {
        return insideTemp;
    }


    public void setInsideHum(short val) {
        short max = 100;
        if (DataFilter(val, max)) {
            this.insideHum = ValueConverter.humidity(val);
        } else {
            this.insideHum = null;
        }
    }

    public Double getInsideHum() {
        return insideHum;
    }


    public void setOutsideTemp(short val) {
        short max = 32767;
        if (DataFilter(val, max)) {
            this.outsideTemp = ValueConverter.temperature(val);
        } else {
            this.outsideTemp = null;
        }
    }

    public Double getOutsideTemp() {
        return outsideTemp;
    }

    public void setWindSpeed(short val) {
        short max = 255;
        if (DataFilter(val, max)) {
            this.windSpeed = ValueConverter.windSpeed(val);
        } else {
            this.windSpeed = null;
        }
    }

    public Double getWindSpeed() {
        return windSpeed;
    }


    public void setAvgWindSpeed(short val) {
        short max = 255;
        if (DataFilter(val, max)) {
            this.avgWindSpeed = ValueConverter.windSpeed(val);
        } else {
            this.avgWindSpeed = null;
        }
    }

    public Double getAvgWindSpeed() {
        return avgWindSpeed;
    }


    public void setWindDir(short val) {
        short max = 32767;
        if (DataFilter(val, max)) {
            this.windDir = ValueConverter.windDirection(val);
        } else {
            this.windDir = null;
        }
    }

    public Double getWindDir() {
        return windDir;
    }


    public void setOutsideHum(short val) {
        short max = 255;
        if (DataFilter(val, max)) {
            this.outsideHum = ValueConverter.humidity(val);
        } else {
            this.outsideHum = null;
        }
    }

    public Double getOutsideHum() {
        return outsideHum;
    }


    public void setRainRate(short val) {
        short max = 32767;
        if (DataFilter(val, max)) {
            this.rainRate = ValueConverter.rainMeter(val);
        } else {
            this.rainRate = null;
        }
    }

    public Double getRainRate() {
        return rainRate;
    }


    public void setUvLevel(short val) {
        short max = 255;
        if (DataFilter(val, max)) {
            this.uvLevel = ValueConverter.uvIndex(val);
        } else {
            this.uvLevel = null;
        }
    }

    public Double getUvLevel() {
        return uvLevel;
    }


    public void setBattLevel(short val) {
        short max = 1000;
        if (DataFilter(val, max)) {
            this.battLevel = ValueConverter.batteryLevel(val);
        } else {
            this.battLevel = null;
        }
    }

    public Double getBattLevel() {
        return battLevel;
    }


    public void SetSunSet(short val) {
        short max = 2400;
        if (DataFilter(val, max)) {
            this.sunSet = ValueConverter.sunSet(val);
        } else {
            this.sunSet = null;
        }
    }

    public String GetSunSet() {
        return sunSet;
    }


    public void SetSunRise(short val) {
        short max = 2400;
        if (DataFilter(val, max)) {
            this.sunRise = ValueConverter.sunRise(val);
        } else {
            this.sunRise = null;
        }
    }

    public String GetSunRise () {
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