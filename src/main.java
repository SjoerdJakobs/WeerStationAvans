import javax.swing.text.ParagraphView;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class main
{

    public static void main(String[] args)
    {
        IO.init();
        HelperFunctions.ClearAll();


        /**
         * this will later be moved to other places.
         * we know this should not be put in the main.
         */

        /**
         * get last temperature, put it on the display and print
         */
//        RawMeasurement rawData = DatabaseConnection.getMostRecentMeasurement();
//        Measurement thisAfternoon =  new Measurement(rawData);

//        System.out.println(thisAfternoon.getOutsideTemp());


        /**
         * get the mean of temperatures from the last hour
//         */
//        ArrayList<RawMeasurement> rawDatas = DatabaseConnection.getMeasurementsLastDays(1);
//        ArrayList<Measurement> measurements = new ArrayList<Measurement>();
//        ArrayList<Double> temperature = new ArrayList<>();
//        ArrayList<Double> maxTemp = new ArrayList<>();
//        ArrayList<Double> minTemp = new ArrayList<>();

//        for (int i = 0; i < rawDatas.size(); i++)
//        {
//            measurements.add(new Measurement(rawDatas.get(i)));
//            temperature.add(measurements.get(i).getOutsideTemp());
//            measurements.get(1).getDateStamp().getDayOfYear();
//            maxTemp.add(measurements.get(i).getOutsideTemp());
//            minTemp.add(measurements.get(i).getOutsideTemp());
//        }
//        System.out.println(temperature.size());
//        int dagen = 4;


        Scanner reader = new Scanner(System.in);
        System.out.println("Tussen welke datum?");
        System.out.println("Begin Jaar: ");
        int beginjaar = Integer.parseInt(reader.nextLine());
        System.out.println("Begin Maand: ");
        int beginmaand = Integer.parseInt(reader.nextLine());
        System.out.println("Begin dag: ");
        int begindag = Integer.parseInt(reader.nextLine());
        System.out.println("Uur: ");
        int beginuur = Integer.parseInt(reader.nextLine());
        System.out.println("Minuut: ");
        int beginminuut = Integer.parseInt(reader.nextLine());
        LocalDateTime begin = LocalDateTime.of(beginjaar,beginmaand,begindag,beginuur,beginminuut);
        System.out.println("");
        System.out.println("En");
        System.out.println("");
        System.out.println("Eind Jaar: ");
        int eindjaar = Integer.parseInt(reader.nextLine());
        System.out.println("Eind Maand: ");
        int eindmaand = Integer.parseInt(reader.nextLine());
        System.out.println("Eind dag: ");
        int einddag = Integer.parseInt(reader.nextLine());
        System.out.println("Uur: ");
        int einduur = Integer.parseInt(reader.nextLine());
        System.out.println("Minuut: ");
        int eindminuut = Integer.parseInt(reader.nextLine());
        LocalDateTime eind = LocalDateTime.of(eindjaar,eindmaand,einddag,einduur,eindminuut);

        Graaddagen graaddagen = new Graaddagen(begin,eind);
//        Graaddagen graaddagen1 = new Graaddagen(LocalDateTime.of(2010,9,29,0,0),LocalDateTime.of(2010,10,3,0,0));
       System.out.println("aantal graaddagen: " +graaddagen.calculateGraaddagen());


//        HelperFunctions.WriteOnMatrixScreen("Graaddagen over de afgelope "+ dagen+ " dagen: " +graaddagen.calculateGraaddagen());
//        System.out.println("Max outside last hour: " + MSD.maximum(maxTemp));
//        System.out.println("Min outside last hour: " + MSD.minimum(minTemp));
//        String strDouble = String.format("%.2f", MSD.mean(temperature));
//        System.out.println(MSD.mean(temperature));
//        HelperFunctions.WriteOnMatrixScreen("Mean temperature past hour: " + strDouble);
    }
}