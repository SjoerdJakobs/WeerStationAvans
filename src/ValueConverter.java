public class ValueConverter {
    /**
     * temperature
     *
     * @paramrawValueRuwe meetwaarde van het vp2pro weerstation
     * @return De temperatuur in graden Celcius
     * <p>
     * C° = (°F − 32) × 5/9
     **/
    public static double temperature(short rawValue) {
        double returnValue = (((double) rawValue / 10.0) - 32) * (5 / 9.0);
        return returnValue;
    }

    public static double temperatureInFahrenheit(short rawValue) {
        double returnValue = (double)rawValue/10.0;
        return returnValue;
    }

    /**
     * airPressure
     *
     * @paramrawValueRuwe meetwaarde van het vp2pro weerstation
     * @return De luchtdruk in hPa
     */
    public static double airPressure(short rawValue) {

        double result = (double) rawValue / 1000.0 * 2.54 / 3.0 * 40.0;
        return result;
    }

    /**
     * windSpeed
     *
     * @paramrawValueRuwe meetwaarde van het vp2pro weerstation
     * @return De windsnelheid in km/h
     */
    public static double windSpeed(short rawValue) {

        double result = (double) rawValue * 1.609;
        return result;
    }

    /**
     * rainMeter
     *
     * @paramrawValueRuwe meetwaarde van het vp2pro weerstation
     * @return De hoeveelheid regen in mm
     */
    public static double rainMeter(short rawValue) {

        double result = (double) rawValue / 5;
        return result;
    }

    /**
     * uvIndex
     *
     * @paramrawValueRuwe meetwaarde van het vp2pro weerstation
     * @return De uv index (dimensieloos)
     */
    public static double uvIndex(short rawValue) {
        double result = (double) rawValue / 10;
        return result;
    }

    /**
     * batteryLevel
     *
     * @paramrawValueRuwe meetwaarde van het vp2pro weerstation
     * @return De batterijspanning in Volt
     */
    public static double batteryLevel(short rawValue) {

        double batlevel = ((((double) rawValue * 300) / 512) / 100);
        return batlevel;
    }

    /**
     * humidity
     *
     * @paramrawValueRuwe meetwaarde van het vp2pro weerstation
     * @returnDe relatieve luchtvochtigheid in procenten
     */
    public static double humidity(short rawValue) {
        return (double)rawValue;
    }

    /**
     * windSpeed
     * @paramrawValueRuwe meetwaarde van het vp2pro weerstation
     * @returnDe windsnelheid in km/h
     */
    public static double windDirection(short rawValue)  {
        return (double)rawValue;
    }

    public static String IntTimeIntToString(short rawValue) {
        int integerOne = rawValue/100;
        int integerTwo = (rawValue-(integerOne*100));
        String leftString;
        if(integerOne/10 == 0)
        {
            leftString = "0"+integerOne;
        }
        else {
            leftString = Integer.toString(integerOne);
        }
        String rightString;
        if(integerTwo/10 == 0)
        {
            rightString = "0"+integerTwo;
        }
        else {
            rightString = Integer.toString(integerTwo);
        }
        String returnValue =  leftString+":"+rightString;
        return returnValue;
    }


    /**
     * sunRise
     *
     * @paramrawValueRuwe meetwaarde van het vp2pro weerstation
     * @returnZonsopkomst in hh:mm notatie
     */
    public static String sunRise(short rawValue)
    {
        return IntTimeIntToString(rawValue);
    }

    /**
     * sunSet
     *
     * @paramrawValueRuwe meetwaarde van het vp2pro weerstation
     * @returnZonsopkomst in hh:mm notatie
     */
    public static String sunSet(short rawValue)
    {
        return IntTimeIntToString(rawValue);
    }

    public static double dewPoint(double Temp,double Humid) {
        double result = Temp - ((100 - Humid)/5);
        return result;
    }

    public static double windChill(short rawValue, short rawValue2) {
        double windchill = 13.12 + (0.6215 * rawValue2) - (11.37 * Math.pow(rawValue, 0.16)) + ((0.3965 * rawValue2) * Math.pow(rawValue, 0.16));
        return windchill;
    }

    public static double heatIndex(double Temp,double Humid) {
        double result = -42.379+2.04901523*Temp+10.14333127*Humid-0.22475541*Temp*Humid-0.00683783*Temp*Temp-0.05481717*Humid*Humid+0.00122874*Temp*Temp*Humid+0.00085282*Temp*Humid*Humid-0.00000199*Temp*Temp*Humid*Humid;
        if (Humid <13 && Temp > 80 && Temp < 112) {
            result = ((13-Humid)/4)*Math.sqrt((17-Math.abs(Temp-95.))/17);
        } else {
            if (Humid > 85 && Temp > 80 && Temp < 87) {
                result = ((Humid-85)/10)*((87-Temp)/5);
            } else {
                if (result < 80) {
                    result = (Temp + 61.0 + ((Temp-68.0)*1.2) + (Humid*0.094))*0.5;
                }
            }
        }
        return FahrenheitToCelcius(result);
    }

    public static double FahrenheitToCelcius(double Fahrenheit) {
        double returnValue = (Fahrenheit - 32) * (5 / 9.0);
        return returnValue;
    }
}
