import java.io.CharArrayReader;
//import java.time.Period;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.RandomAccess;
import java.util.concurrent.atomic.DoubleAccumulator;

public class main
{

    public static void main(String[] args)
    {
        IO.init();
        HelperFunctions.ClearAll();

        Period lastYear = new Period();
        System.out.println(lastYear.dataStorage.maxAirPressure);

        Program program = new Program();
        program.Run();
    }


}
