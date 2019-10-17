public class InsideHumTab extends Tab
{
    private int counter = 0;
    protected InsideHumTab(Menu menu) {
        super(menu);
    }

    @Override
    protected void OnOpen() {
        m_menu.DrawMenu();
        setValues();
        RawMeasurement rawData = DatabaseConnection.getMostRecentMeasurement();
        Measurement measurement = new Measurement(rawData);
        current = measurement.getInsideHum();
        if (Double.isNaN(current)){
            HelperFunctions.WriteOnMatrixScreen(String.format("\nInside humidity\ncurrent: no value"));
        }
        else {
            HelperFunctions.WriteOnMatrixScreen(String.format("\nInside humidity\ncurrent: %.2f",current)+ "%");
        }

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
        m_menu.DrawMenu();


        if (counter == 1){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nInside humidity\nmin: %.2f",min)+ "%");
        }

        else if (counter == 2){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nInside humidity\nmax: %.2f",max)+ "%");
        }

        else if (counter == 3){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nInside humidity\naverage: %.2f",average)+ "%");
        }

        else if (counter == 4){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nInside humidity\nmodus: %.2f",Mode)+ "%");
        }

        else if (counter == 5){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nInside humidity\nmedian: %.2f",Median)+ "%");
        }

        else if (counter == 6){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nInside humidity\nstd deviation: %.2f",stdDev));
        }
        else if (counter > 6){
            if (Double.isNaN(current)){
                HelperFunctions.WriteOnMatrixScreen(String.format("\nInside humidity\ncurrent: no value"));
            }
            else {
                HelperFunctions.WriteOnMatrixScreen(String.format("\nInside humidity\ncurrent: %.2f",current)+ "%");
            }
            counter = 0;

        }
    }

    Period period = SavedData.INSTANCE.SavedPeriod;

    private double current;
    private double min;
    private double max;
    private double average;
    private double Mode;
    private double Median;
    private double stdDev;

    public void setValues(){
        min = period.getDataStorage().getMinInsideHum();
        max = period.getDataStorage().getMaxInsideHum();
        average = period.getDataStorage().getMeanInsideHum();
        Mode = period.getDataStorage().getModeInsideHum();
        Median = period.getDataStorage().getMedianInsideHum();
        stdDev = period.getDataStorage().getStandardDeviationInsideHum();
    }

    @Override
    protected void OnButtonRed() {
        //runs when red button is pressed(runs once, its an actual bu)
    }
}

