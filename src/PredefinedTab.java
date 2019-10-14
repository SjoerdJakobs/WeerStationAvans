import java.util.ArrayList;

public class PredefinedTab extends Tab {

    protected PredefinedTab(Menu menu) {
        super(menu);
    }
    String text1 = "MaxRain";
    String text2 = "DegreeDays";
    String text3 = "Mist";
    String text4 = "RisingTemperature";
    String text5 = "CrossingTemperature";
    @Override
    protected void OnOpen() {
        //runs when tab is opened
        //Show:
        //MaxRain
        //DegreeDays
        //Mist
        //RisingTemperature
        //CrossingTemperature
        HelperFunctions.WriteOnMatrixScreen(text1);
    }

    @Override
    protected void OnClose() {
        //runs when tab is closed

    }

    @Override
    protected void Run(double deltaTime) {
        //runs every frame when tab is opened

    }

    @Override
    protected void OnButtonBlueTwo() {
        //runs when red button is pressed(runs once, its an actual bu)
        //Next horizontal tab
        //Denk zoiets?
        if (text1.equals("MaxRain")){
            HelperFunctions.WriteOnMatrixScreen(text2);
        }
        if (text2.equals("DegreeDays")){
            HelperFunctions.WriteOnMatrixScreen(text3);
        }
        if (text3.equals("Mist")) {
            HelperFunctions.WriteOnMatrixScreen(text4);
        }
        if (text4.equals("RisingTemperature")){
            HelperFunctions.WriteOnMatrixScreen(text5);
        }
        if (text5.equals("CrossingTemperature")){
            HelperFunctions.WriteOnMatrixScreen(text1);
        }
    }

    @Override
    protected void OnButtonRed() {
        //runs when red button is pressed(runs once, its an actual bu)
        //When on MaxRain --> run Calculations.MaxRain(period)
        //When on DegreeDays --> run Calculations.calculateDegreeDays(period)
        //When on Mist --> run Calculations.Mist(period)
        //When on RisingTemperature --> run Calculations.risingTemperatureDuration(period)
        //When on CrossingTemperatures --> run Calculations.tempChange(period)

        // ik heb echt geen idee of dit wel klopt...
        if (text1.equals("MaxRain")){
            HelperFunctions.WriteOnMatrixScreen(Calculations.MaxRain());
        }
        if (text2.equals("DegreeDays")){
            HelperFunctions.WriteOnMatrixScreen(Calculations.calculateDegreeDays(/*(periodData?)*/));
        }
        if (text3.equals("Mist")){
            HelperFunctions.WriteOnMatrixScreen(Calculations.mist(/*periodData?)*/));
        }
        if (text4.equals("RisingTemperature")){
            HelperFunctions.WriteOnMatrixScreen(Calculations.risingTemperatureDuration(/*(periodData?)*/));
        }
        if (text5.equals("CrossingTemperatures")){
            HelperFunctions.WriteOnMatrixScreen(Calculations.tempChange(/*(periodData), (periodData?)*/));
        }

    }

}
