import java.net.CookieHandler;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class weerstation {

    private static boolean quit = false;
    private static String[] horizontal = {"barometer", "inside temp.", "inside hum.", "outside temp.", "wind speed",
                                          "avg. wind sp.", "wind dir.", "outside temp.", "rain rate", "UV level",
                                          "sun set", "sun rise", "dew point", "windchill", "heat index", };
    private static String[] vertical = {"Current", "Min.", "Max.", "Avg.", "Mode", "Median",  "Graph", "Std. Dev."};

    public static void initialise() {
        IO.init();
        HelperFunctions.ClearAll();
        // Calculate the function results for each unit
    }

    public static void menu() {
        while (!quit) {
            // Switch menu's



        }
    }
}
