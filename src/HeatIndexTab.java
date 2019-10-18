public class HeatIndexTab extends Tab
{
    private int counter = 0;
    private Period period;
    protected HeatIndexTab(Menu menu) {
        super(menu);
    }

    @Override
    protected void OnOpen() {
        m_menu.DrawMenu();
        setPeriod();
        setValues();
        RawMeasurement rawData = DatabaseConnection.getMostRecentMeasurement();
        Measurement measurement = new Measurement(rawData);
        current = Calculations.dewPoint(measurement.getInsideTemp(),measurement.getInsideHum());
        if (Double.isNaN(current)){
            HelperFunctions.WriteOnMatrixScreen(String.format("\nHeat index\ncurrent: no value"));
        }
        else {
            HelperFunctions.WriteOnMatrixScreen(String.format("\nHeat index\ncurrent: %.2f",current) + " C");
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

            HelperFunctions.WriteOnMatrixScreen(String.format("\nHeat index\nmin: %.2f",min) + " C");
        }

        else if (counter == 2){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nHeat index\nmax: %.2f",max) + " C");
        }

        else if (counter == 3){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nHeat index\naverage: %.2f",average) + " C");
        }

        else if (counter == 4){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nHeat index\nmodus: %.2f",Mode) + " C");
        }

        else if (counter == 5){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nHeat index\nmedian: %.2f",Median) + " C");
        }

        else if (counter == 6){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nHeat index\nstd deviation: %.2f",stdDev));
        }
        else if (counter > 6){
            if (Double.isNaN(current)){
                HelperFunctions.WriteOnMatrixScreen(String.format("\nHeat index\ncurrent: no value"));
            }
            else {
                HelperFunctions.WriteOnMatrixScreen(String.format("\nHeat index\ncurrent: %.2f",current) + " C");
            }
            counter = 0;

        }
    }

    public void setPeriod(){period = SavedData.getInstance().GetPeriod(); }

    private double current;
    private double min;
    private double max;
    private double average;
    private double Mode;
    private double Median;
    private double stdDev;

    public void setValues(){
        min = period.getDataStorage().getMinHeatIndex();
        max = period.getDataStorage().getMaxHeatIndex();
        average = period.getDataStorage().getMeanHeatIndex();
        Mode = period.getDataStorage().getModeHeatIndex();
        Median = period.getDataStorage().getMedianHeatIndex();
        stdDev = period.getDataStorage().getStandardDeviationHeatIndex();

    }

    @Override
    protected void OnButtonRed() {
        //runs when red button is pressed(runs once, its an actual bu)
    }
}

