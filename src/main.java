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


        Calculations a = new Calculations();
        a.calculateGraaddagen(LocalDateTime.of(2010,1,1,0,0), LocalDateTime.of(2010,12,31,0,0));
        /*Period lastYear = new Period(365);
        ArrayList<Measurement> measurements = lastYear.getMeasurements();
        ArrayList<Double> temps = new ArrayList<Double>();
        System.out.println(Calculations.mist(measurements));
        for (Measurement reading : measurements){
            if (!Double.isNaN(reading.getOutsideTemp())){
                temps.add(reading.getOutsideTemp());
            }
        }
        System.out.println(Calculations.mean(temps));
        System.out.println(Calculations.maximum(temps));
        System.out.println(Calculations.minimum(temps));
        System.out.println(Calculations.median(temps));*/
    }
}
