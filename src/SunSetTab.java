public class SunSetTab extends Tab
{
    private int counter = 0;
    private Period period;
    protected SunSetTab(Menu menu) {
        super(menu);
    }

    @Override
    protected void OnOpen() {
        m_menu.DrawMenu();
        setPeriod();
        setValues();
        RawMeasurement rawData = DatabaseConnection.getMostRecentMeasurement();
        Measurement measurement = new Measurement(rawData);
        current = ValueConverter.IntTimeIntToString((short)measurement.GetSunSet());
        HelperFunctions.WriteOnMatrixScreen(String.format("\nSun set\ncurrent: "+ current));


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

            HelperFunctions.WriteOnMatrixScreen(String.format("\nSun set\nmin: "+min));
        }

        else if (counter == 2){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nSun set\nmax: "+max));
        }

        else if (counter == 3){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nSun set\naverage: "+average));
        }

        else if (counter == 4){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nSun set\nmodus: "+Mode));
        }

        else if (counter == 5){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nSun set\nmedian: "+Median));
        }

        else if (counter == 6){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nSun set\nstd deviation: "+stdDev));
        }
        else if (counter > 6){
            HelperFunctions.WriteOnMatrixScreen(String.format("\nSun set\ncurrent: "+current));
            counter = 0;

        }
    }

    public void setPeriod(){period = SavedData.getInstance().GetPeriod(); }

    private String current;
    private String min;
    private String max;
    private String average;
    private String Mode;
    private String Median;
    private double stdDev;

    public void setValues(){
        min = ValueConverter.IntTimeIntToString((short)period.getDataStorage().getMinSunSet());
        max = ValueConverter.IntTimeIntToString((short)period.getDataStorage().getMaxSunSet());
        average = ValueConverter.IntTimeIntToString((short)period.getDataStorage().getMeanSunSet());
        Mode = ValueConverter.IntTimeIntToString((short)period.getDataStorage().getModeSunSet());
        Median = ValueConverter.IntTimeIntToString((short)period.getDataStorage().getMedianSunSet());
        stdDev = period.getDataStorage().getStandardDeviationSunSet();
    }

    @Override
    protected void OnButtonRed() {
        //runs when red button is pressed(runs once, its an actual bu)
    }
}

