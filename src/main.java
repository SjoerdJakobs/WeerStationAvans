import java.io.CharArrayReader;
//import java.time.Period;
import java.util.ArrayList;
import java.util.RandomAccess;
import java.util.concurrent.atomic.DoubleAccumulator;

public class main
{

    public static void main(String[] args)
    {
        IO.init();
        HelperFunctions.ClearAll();
        Period lasthour = new Period(1);
        System.out.println(lasthour.dataStorage.maxAirPressure);
    }
}
