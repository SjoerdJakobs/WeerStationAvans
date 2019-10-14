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
        current = measurement.getBarometer();
        HelperFunctions.WriteOnMatrixScreen(String.format("\nAir pressure\ncurrent:%.2f",current));

    }

    @Override
    protected void OnClose() {
        HelperFunctions.ClearTextDisplay();
    }

    @Override
    protected void Run(double deltaTime) {
        //runs every frame when tab is opened

    }

    @Override
    protected void OnButtonBlueTwo() {
        counter++;
        HelperFunctions.ClearTextDisplay();

        if (counter == 1){

            HelperFunctions.WriteOnMatrixScreen(String.format(String.format("\nAir pressure\nmin:%.2f",min)));
        }

        else if (counter == 2){

            HelperFunctions.WriteOnMatrixScreen(String.format(String.format("\nAir pressure\nmax:%.2f",max)));
        }

        else if (counter == 3){

            HelperFunctions.WriteOnMatrixScreen(String.format(String.format("\nAir pressure\naverage:%.2f",average)));
        }

        else if (counter == 4){

            HelperFunctions.WriteOnMatrixScreen(String.format(String.format("\nAir pressure\nmodus:%.2f",Mode)));
        }

        else if (counter == 5){

            HelperFunctions.WriteOnMatrixScreen(String.format(String.format("\nAir pressure\nmedian:%.2f",Median)));
        }

        else if (counter == 6){

            HelperFunctions.WriteOnMatrixScreen(String.format(String.format("\nAir pressure\nstandard deviation:%.2f",stdDev)));
        }
        else if (counter > 6){
            HelperFunctions.WriteOnMatrixScreen(String.format("\nAir pressure\ncurrent:%.2f",current));
            counter = 0;

        }
    }

    Period period = new Period();

    private double current;
    private double min;
    private double max;
    private double average;
    private double Mode;
    private double Median;
    private double stdDev;

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
