public class main
{

    public static void main(String[] args)
    {
        RawMeasurement rawData = DatabaseConnection.getMostRecentMeasurement();
        Measurement thisAfternoon =  new Measurement(rawData);
        System.out.println(thisAfternoon);

    }
}
