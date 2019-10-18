public class AirPressureTab extends Tab
{
    private int counter = 0;
    private Period period;
    protected AirPressureTab(Menu menu) {
        super(menu);
    }

    @Override
    protected void OnOpen() {
        m_menu.DrawMenu();
        setPeriod();
        setValues();

        Measurement measurement = SavedData.INSTANCE.GetLastMeasurement();
        current = measurement.getBarometer();
        if (Double.isNaN(current)){
            HelperFunctions.WriteOnMatrixScreen(String.format("\nAir pressure\ncurrent: no value"));
        }
        else {
            HelperFunctions.WriteOnMatrixScreen(String.format("\nAir pressure\ncurrent: %.2f",current)+" hP");
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

            HelperFunctions.WriteOnMatrixScreen(String.format("\nAir pressure\nmin: %.2f",min)+" hP");
        }

        else if (counter == 2){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nAir pressure\nmax: %.2f",max)+" hP");
        }

        else if (counter == 3){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nAir pressure\naverage: %.2f",average)+" hP");
        }

        else if (counter == 4){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nAir pressure\nmodus: %.2f",Mode)+" hP");
        }

        else if (counter == 5){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nAir pressure\nmedian: %.2f",Median)+" hP");
        }

        else if (counter == 6){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nAir pressure\nstd deviation: %.2f",stdDev));
        }
        else if (counter > 6){
            if (Double.isNaN(current)){
                HelperFunctions.WriteOnMatrixScreen(String.format("\nAir pressure\ncurrent: no value"));
            }
            else {
                HelperFunctions.WriteOnMatrixScreen(String.format("\nAir pressure\ncurrent: %.2f",current)+" hP");
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

