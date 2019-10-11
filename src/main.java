import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class main
{

    public static void main(String[] args)
    {
        IO.init();
        HelperFunctions.ClearAll();

        Program program = new Program();
        program.Run();

        //Period now = new Period();
        //System.out.println(now.dataStorage.maxAirPressure);
        //Period lastDay = new Period(1);
        //System.out.println(lastDay.dataStorage.maxAirPressure);
        //Period lastWeek = new Period(7);
        //System.out.println(lastWeek.dataStorage.maxAirPressure);
        System.out.println(LocalDateTime.now());
        Period lastYear = new Period(LocalDate.of(2018,1,1),LocalDate.of(2018,12,31));
        System.out.println(lastYear.dataStorage.maxAirPressure);
        System.out.println(LocalDateTime.now());
    }


}
