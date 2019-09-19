public class main
{
    public RawMeasurement rawData = DatabaseConnection.getMostRecentMeasurement();

    public void main(String[] args)
    {
        Measurement thisAfternoon =  new Measurement(rawData);
        thisAfternoon.getInsideHum();

    }
}
