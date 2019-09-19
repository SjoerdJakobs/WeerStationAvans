import org.junit.Assert;
import org.junit.Test;

public class ValueConverterTest {

    @Test
    public void testTemperature()
    {
        short testValue = 680;
        double expectedValue = 20;
        Assert.assertEquals("raw temperature to readable values", ValueConverter.temperature(testValue), expectedValue, 0.0001);
    }

    @Test
    public void testFahrenheitToCelcius()
    {
        short testValue = 68;
        double expectedValue = 20;
        Assert.assertEquals("F to C", ValueConverter.FahrenheitToCelcius(testValue), expectedValue, 0.0001);
    }

    @Test
    public void testAirPressure()
    {
        short testValue = 30279;
        double expectedValue = 1025.4488;
        Assert.assertEquals("raw airpressure to readable values", ValueConverter.airPressure(testValue), expectedValue, 0.0001);
    }

    @Test
    public void testHumidity()
    {
        short testValue = 55;
        double expectedValue = 55;
        Assert.assertEquals("raw humidity to readable values", ValueConverter.humidity(testValue), expectedValue, 0.0001);
    }

    @Test
    public void testWindDirection()
    {
        short testValue = 56;
        double expectedValue = 56;
        Assert.assertEquals("raw humidity to readable values", ValueConverter.windDirection(testValue), expectedValue, 0.0001);
    }

    @Test
    public void testBatteryLevel()
    {
        short testValue = 193;
        double expectedValue = 1.130859375;
        Assert.assertEquals("raw batteryLevel to readable values", ValueConverter.batteryLevel(testValue), expectedValue, 0.0001);
    }

    @Test
    public void testRainMeter()
    {
        short testValue = 50;
        double expectedValue = 10;
        Assert.assertEquals("raw rainMeter to readable values", ValueConverter.rainMeter(testValue), expectedValue, 0.0001);
    }

    @Test
    public void testWindSpeed()
    {
        short testValue = 14;
        double expectedValue = 22.526;
        Assert.assertEquals("raw windSpeed to readable values", ValueConverter.windSpeed(testValue), expectedValue, 0.0001);
    }

    @Test
    public void testUvIndex()
    {
        short testValue = 244;
        double expectedValue = 24.4;
        Assert.assertEquals("raw uvIndex to readable values", ValueConverter.uvIndex(testValue), expectedValue, 0.0001);
    }

    @Test
    public void testIntTimeIntToString()
    {
        short testValue = 7908;
        String expectedValue = "79:08";
        Assert.assertEquals("24h clock in 4 numbers to a string", ValueConverter.IntTimeIntToString(testValue), expectedValue);
    }

    @Test
    public void testDewPoint()
    {
        short testValue1 = 20;
        short testValue2 = 60;
        double expectedValue = 12;
        Assert.assertEquals("temp and humidity to dewPoint", ValueConverter.dewPoint(testValue1,testValue2), expectedValue, 0.0001);
    }

    @Test
    public void testwindChill()
    {
        short testValue1 = 15;
        short testValue2 = 10;
        double expectedValue = 7.914117477770259;
        Assert.assertEquals("temp and windspeed to windChill", ValueConverter.windChill(testValue1,testValue2), expectedValue, 0.0001);
    }

    @Test
    public void testHeatIndex()
    {
        short testValue1 = 75;
        short testValue2 = 44;
        double expectedValue = ValueConverter.FahrenheitToCelcius(74.268);
        Assert.assertEquals("temp and HeatIndex to windChill", ValueConverter.heatIndex(testValue1,testValue2), expectedValue, 0.0001);
    }
}
