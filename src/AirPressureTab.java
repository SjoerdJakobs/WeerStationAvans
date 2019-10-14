import java.util.ArrayList;

public class AirPressureTab extends Tab
{
    private int counter = 0;
    protected AirPressureTab(Menu menu) {
        super(menu);
    }

    @Override
    protected void OnOpen() {
        setValues();
        RawMeasurement rawData = DatabaseConnection.getMostRecentMeasurement();
        Measurement measurement = new Measurement(rawData);
        HelperFunctions.WriteOnMatrixScreen("Current: " +measurement.getBarometer() );

        //runs when tab is opened
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
        counter++;
        HelperFunctions.ClearTextDisplay();


        if (counter == 0){
            RawMeasurement rawData = DatabaseConnection.getMostRecentMeasurement();
            Measurement measurement = new Measurement(rawData);
            HelperFunctions.WriteOnMatrixScreen("Current: " +measurement.getBarometer() );
        }

        else if (counter == 1){

            HelperFunctions.WriteOnMatrixScreen("Average air pressure: " +min );
        }

        else if (counter == 2){

            HelperFunctions.WriteOnMatrixScreen("Max air pressure: " +max );
        }

        else if (counter == 3){

            HelperFunctions.WriteOnMatrixScreen("Average air pressure: " +average );
        }

        else if (counter == 4){

            HelperFunctions.WriteOnMatrixScreen("Modus of air pressure: " +Mode );
        }

        else if (counter == 5){

            HelperFunctions.WriteOnMatrixScreen("Median of air pressure: " +Median );
        }

        else if (counter == 6){

            HelperFunctions.WriteOnMatrixScreen("Standard deviation of air pressure: " +stdDev );
        }
        else if (counter > 6){
            counter = 0;

        }
        //runs when red button is pressed(runs once, its an actual bu)
    }

    Period period = new Period();

    double min;
    double max;
    double average;
    double Mode;
    double Median;
    double stdDev;

    public void setValues(){
        min = period.getDataStorage().getMinAirPressure();
        max = period.getDataStorage().getMaxAirPressure();
        average = period.getDataStorage().getMeanAirPressure();
        Mode = period.getDataStorage().getModeAirPressure();
        Median = period.getDataStorage().getMedianAirPressure();
        stdDev = period.getDataStorage().getStandardDeviationAirPressure();
    }



    @Override
    protected void OnButtonRed() {
        //runs when red button is pressed(runs once, its an actual bu)
    }
}

