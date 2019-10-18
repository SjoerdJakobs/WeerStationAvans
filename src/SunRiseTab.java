public class SunRiseTab extends Tab
{
    private int counter = 0;
    private Period period;
    protected SunRiseTab(Menu menu) {
        super(menu);
    }

    @Override
    protected void OnOpen() {
        m_menu.DrawMenu();
        setPeriod();
        setValues();
        RawMeasurement rawData = DatabaseConnection.getMostRecentMeasurement();
        Measurement measurement = new Measurement(rawData);
        current = ValueConverter.IntTimeIntToString((short)measurement.GetSunRise());
        HelperFunctions.WriteOnMatrixScreen(String.format("\nSun rise\ncurrent: "+ current));


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

            HelperFunctions.WriteOnMatrixScreen(String.format("\nSun rise\nmin: "+min));
        }

        else if (counter == 2){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nSun rise\nmax: "+max));
        }

        else if (counter == 3){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nSun rise\naverage: "+average));
        }

        else if (counter == 4){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nSun rise\nmodus: "+Mode));
        }

        else if (counter == 5){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nSun rise\nmedian: "+Median));
        }

        else if (counter == 6){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nSun rise\nstd deviation: "+stdDev));
        }
        else if (counter > 6){
            HelperFunctions.WriteOnMatrixScreen(String.format("\nSun rise\ncurrent: "+current));
            counter = 0;

        }
    }

    public void setPeriod(){period = SavedData.INSTANCE.GetPeriod(); }

    private String current;
    private String min;
    private String max;
    private String average;
    private String Mode;
    private String Median;
    private double stdDev;

    public void setValues(){
        min = ValueConverter.IntTimeIntToString((short)period.getDataStorage().getMinSunRise());
        max = ValueConverter.IntTimeIntToString((short)period.getDataStorage().getMaxSunRise());
        average = ValueConverter.IntTimeIntToString((short)period.getDataStorage().getMeanSunRise());
        Mode = ValueConverter.IntTimeIntToString((short)period.getDataStorage().getModeSunRise());
        Median = ValueConverter.IntTimeIntToString((short)period.getDataStorage().getMedianSunRise());
        stdDev = period.getDataStorage().getStandardDeviationSunRise();
    }

    @Override
    protected void OnButtonRed() {
        //runs when red button is pressed(runs once, its an actual bu)
    }
}

