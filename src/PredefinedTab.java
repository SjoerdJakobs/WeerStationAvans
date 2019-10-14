import java.util.ArrayList;

public class PredefinedTab extends Tab {

    protected PredefinedTab(Menu menu) {
        super(menu);
    }
    int count = 0;
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
        HelperFunctions.ClearMatrixDisplay();
    }

    @Override
    protected void Run(double deltaTime) {
        //runs every frame when tab is opened
    }

    @Override
    protected void OnButtonBlueTwo() {
        //runs when red button is pressed(runs once, its an actual bu)
        //Next horizontal tab
        count++;
        if (count == 1){
            HelperFunctions.WriteOnMatrixScreen(text2);
        } else if (count == 2){
            HelperFunctions.WriteOnMatrixScreen(text3);
        } else if (count == 3) {
            HelperFunctions.WriteOnMatrixScreen(text4);
        } else if (count == 4){
            HelperFunctions.WriteOnMatrixScreen(text5);
        } else if (count == 0){
            HelperFunctions.WriteOnMatrixScreen(text1);
        } else if (count > 4){
            count = 0;
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
        if (count == 0){
            HelperFunctions.WriteOnMatrixScreen(Calculations.MaxRain());
        } else if (count == 1){
            HelperFunctions.WriteOnMatrixScreen(Calculations.calculateDegreeDays(/*(periodData?)*/));
        } else if (count == 2){
            Mick;
        } else if (count == 3){
            HelperFunctions.WriteOnMatrixScreen(Calculations.risingTemperatureDuration(/*(periodData?)*/));
        } else if (count == 4){
            RawMeasurement rawData = DatabaseConnection.getMeasurementsBetween(SetPeriodTab, SetPeriodTab);//???
            Measurement measurement = new Measurement(rawData);
            ArrayList<Measurement> inside = new ArrayList<>();
            ArrayList<Double> outside = new ArrayList<>();
            HelperFunctions.WriteOnMatrixScreen("Times crossed: " + Calculations.tempChange(inside,outside));
        }

    }

}
