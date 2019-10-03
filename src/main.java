import java.util.ArrayList;

public class main
{

    public static void main(String[] args)
    {
        /**
         * this will later be moved to other places.
         * we know this should not be put in the main.
         */
        IO.init();
        HelperFunctions.ClearAll();
        RawMeasurement rawData = DatabaseConnection.getMostRecentMeasurement();
        Measurement thisAfternoon =  new Measurement(rawData);

        System.out.println(thisAfternoon);
        System.out.println(rawData.getOutsideTemp());
        System.out.println(thisAfternoon.getOutsideTemp());

        String strDouble = String.format("%.2f", thisAfternoon.getOutsideTemp());
        HelperFunctions.WriteOnMatrixScreen("OutsideTemp " + strDouble + "    bovenste value is ooktemperatuur");
        HelperFunctions.WriteValueOnSegments(1,thisAfternoon.getOutsideTemp(), 3);
    }
}
