public class OutsideTempTab extends Tab
{
    private int counter = 0;
    private Period period;
    protected OutsideTempTab(Menu menu) {
        super(menu);
    }

    @Override
    protected void OnOpen() {
        m_menu.DrawMenu();
        setPeriod();
        setValues();
        RawMeasurement rawData = DatabaseConnection.getMostRecentMeasurement();
        Measurement measurement = new Measurement(rawData);
        current = measurement.getOutsideTemp();
        if (Double.isNaN(current)){
            HelperFunctions.WriteOnMatrixScreen(String.format("\nOutside temperature\ncurrent: no value"));
        }
        else {
            HelperFunctions.WriteOnMatrixScreen(String.format("\nOutside temperature\ncurrent: %.1f",current)+ " C");
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

            HelperFunctions.WriteOnMatrixScreen(String.format("\nOutside temperature\nmin: %.1f",min)+ " C");
        }

        else if (counter == 2){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nOutside temperature\nmax: %.1f",max)+ " C");
        }

        else if (counter == 3){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nOutside temperature\naverage: %.1f",average)+ " C");
        }

        else if (counter == 4){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nOutside temperature\nmodus: %.1f",Mode)+ " C");
        }

        else if (counter == 5){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nOutside temperature\nmedian: %.1f",Median)+ " C");
        }

        else if (counter == 6){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nOutside temperature\nstd deviation: %.1f",stdDev));
        }
        else if (counter > 6){
            if (Double.isNaN(current)){
                HelperFunctions.WriteOnMatrixScreen(String.format("\nOutside temperature\ncurrent: no value"));
            }
            else {
                HelperFunctions.WriteOnMatrixScreen(String.format("\nOutside temperature\ncurrent: %.1f",current)+ " C");
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
        min = period.getDataStorage().getMinOutsideTemp();
        max = period.getDataStorage().getMaxOutsideTemp();
        average = period.getDataStorage().getMeanOutsideTemp();
        Mode = period.getDataStorage().getModeOutsideTemp();
        Median = period.getDataStorage().getMedianOutsideTemp();
        stdDev = period.getDataStorage().getStandardDeviationOutsideTemp();
    }

    @Override
    protected void OnButtonRed() {
        //runs when red button is pressed(runs once, its an actual bu)
    }
}

