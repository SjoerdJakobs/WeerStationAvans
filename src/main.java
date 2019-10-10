import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.RandomAccess;
import java.util.concurrent.atomic.DoubleAccumulator;

public class main {

    public static void main(String[] args) {
        IO.init();
        HelperFunctions.ClearAll();

        Graaddagen ah = new Graaddagen();
        System.out.println(  "Aantal graaddagen: "  +    ah.calculateGraaddagen(LocalDateTime.of(2010, 1,1,1,0), LocalDateTime.of(2010,12,31,22,0)));
    }
    }
