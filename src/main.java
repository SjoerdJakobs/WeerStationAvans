import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class main
{

    public static void main(String[] args)
    {
        /**
         * Comment out this section if you want to use the below example.
         */
        Program program = new Program();
        program.Run();



        /**
         * Example code for testing setting a period and testing receiving the data from it.
         */
        /*Period now = new Period();
        System.out.println(now.getDataStorage().getMaxAirPressure());
        Period lastDay = new Period(1);
        System.out.println(lastDay.getDataStorage().getMinAirPressure());
        Period lastWeek = new Period(7);
        System.out.println(lastWeek.getDataStorage().getMeanAirPressure());
        Period lastYear = new Period(LocalDate.of(2018,1,1),LocalDate.of(2018,12,31));
        System.out.println(lastYear.getDataStorage().getModeAirPressure());
        System.out.println(lastYear.getDataStorage().getMedianAirPressure());
        System.out.println(lastYear.getDataStorage().getStandardDeviationAirPressure());*/
    }


}
