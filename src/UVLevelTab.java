public class UVLevelTab extends Tab
{
    private int counter = 0;
    private Period period;
    protected UVLevelTab(Menu menu) {
        super(menu);
    }

    @Override
    protected void OnOpen() {
        m_menu.DrawMenu();
        setPeriod();
        setValues();
        Measurement measurement = SavedData.INSTANCE.GetLastMeasurement();
        current = measurement.getUvLevel();
        if (Double.isNaN(current)){
            HelperFunctions.WriteOnMatrixScreen(String.format("\nUV level\ncurrent: no value"));
        }
        else {
            HelperFunctions.WriteOnMatrixScreen(String.format("\nUV level\ncurrent UV index: %.0f",current));
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

            HelperFunctions.WriteOnMatrixScreen(String.format("\nUV level\nmin UV index: %.0f",min));
        }

        else if (counter == 2){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nUV level\nmax UV index: %.0f",max));
        }

        else if (counter == 3){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nUV level\naverage UV index: %.0f",average));
        }

        else if (counter == 4){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nUV level\nmodus UV index: %.0f",Mode));
        }

        else if (counter == 5){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nUV level\nmedian UV index: %.0f",Median));
        }

        else if (counter == 6){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nUV level\nstd deviation: %.0f",stdDev));
        }
        else if (counter > 6){
            if (Double.isNaN(current)){
                HelperFunctions.WriteOnMatrixScreen(String.format("\nUV level\ncurrent: no value"));
            }
            else {
                HelperFunctions.WriteOnMatrixScreen(String.format("\nUV level\ncurrent UV index: %.0f",current));
            }
            counter = 0;

        }
    }

    public void setPeriod(){period = SavedData.INSTANCE.GetPeriod(); }

    private double current;
    private double min;
    private double max;
    private double average;
    private double Mode;
    private double Median;
    private double stdDev;

    public void setValues(){
        min = period.getDataStorage().getMinUvLevel();
        max = period.getDataStorage().getMaxUvLevel();
        average = period.getDataStorage().getMeanUvLevel();
        Mode = period.getDataStorage().getModeUvLevel();
        Median = period.getDataStorage().getMedianUvLevel();
        stdDev = period.getDataStorage().getStandardDeviationUvLevel();

    }

    @Override
    protected void OnButtonRed() {
        //runs when red button is pressed(runs once, its an actual bu)
    }
}

