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
        if (rawValue > 2400) return "no value";

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



    public static double FahrenheitToCelsius(double Fahrenheit) {
        double returnValue = (Fahrenheit - 32) * (5 / 9.0);
        return returnValue;
    }
    public static double CelsiusToFahrenheit(double Celsius) {
        double returnValue = Celsius * (5 / 9.0) + 32;
        return returnValue;
    }
}
