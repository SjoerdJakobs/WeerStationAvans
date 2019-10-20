//import sun.awt.SunHints;

import java.util.ArrayList;

public class SunRiseTab extends Tab
{
    protected SunRiseTab(Menu menu) {
        super(menu);
    }

    private Period period;
    public void setPeriod(){period = SavedData.INSTANCE.GetPeriod(); }

    // MENU VARIABLES
    private int menuCounter = 0;

    // DATA VARIABLES
    private String currentUnitValue;
    private String minUnitValue;
    private String maxUnitValue;
    private String averageUnitValue;
    private String ModeUnitValue;
    private String MedianUnitValue;
    private double stdDevUnitValue;

// TODO ***************
    /**
     * Set the data veriables
     */
    public void setValues(){
        minUnitValue = ValueConverter.IntTimeIntToString((short)period.getDataStorage().getMinSunRise());
        maxUnitValue = ValueConverter.IntTimeIntToString((short)period.getDataStorage().getMaxSunRise());
        averageUnitValue = ValueConverter.IntTimeIntToString((short)period.getDataStorage().getMeanSunRise());
        ModeUnitValue = ValueConverter.IntTimeIntToString((short)period.getDataStorage().getModeSunRise());
        MedianUnitValue = ValueConverter.IntTimeIntToString((short)period.getDataStorage().getMedianSunRise());
        stdDevUnitValue = period.getDataStorage().getStandardDeviationSunRise();
    }

    // Runs when tab is opened
    @Override
    protected void OnOpen() {
        HelperFunctions.ClearTextDisplay();
        HelperFunctions.ClearAll();
        setPeriod();
        setValues();

        menuCounter=0;
        m_menu.DrawMenu();

        // TODO
        // Get current sunrise
        RawMeasurement rawData = DatabaseConnection.getMostRecentMeasurement();
        Measurement measurement = new Measurement(rawData);
        currentUnitValue = ValueConverter.IntTimeIntToString((short)measurement.GetSunRise());
        HelperFunctions.WriteOnMatrixScreen(String.format("\nSunrise\ncurrent: %s", currentUnitValue));
    }

    // Runs when tab is closed
    @Override
    protected void OnClose() {
        menuCounter = 0;
        HelperFunctions.ClearAll();
    }

    // Runs
    @Override
    protected void Run(double deltaTime) {
        // No graph available
    }

    // Runs when the second blue button is pressed
    @Override
    protected void OnButtonBlueTwo() {
        menuCounter++;
        HelperFunctions.ClearAll();
        m_menu.DrawMenu();

        switch (menuCounter % 7) {
            case 0:
                // Get current sunrise
                RawMeasurement rawData = DatabaseConnection.getMostRecentMeasurement();
                Measurement measurement = new Measurement(rawData);
                currentUnitValue = ValueConverter.IntTimeIntToString((short)measurement.GetSunRise());

                HelperFunctions.WriteOnMatrixScreen(String.format("\nSunrise\ncurrent: %s", currentUnitValue));
                break;
            case 1:
                HelperFunctions.WriteOnMatrixScreen(String.format("\nSunrise\nmin: %s", minUnitValue));
                break;
            case 2  :
                HelperFunctions.WriteOnMatrixScreen(String.format("\nSunrise\nmax: %s", maxUnitValue));
                break;
            case 3:
                HelperFunctions.WriteOnMatrixScreen(String.format("\nSunrise\naverage: %s", averageUnitValue));
                break;
            case 4:
                HelperFunctions.WriteOnMatrixScreen(String.format("\nSunrise\nmodus: %s", ModeUnitValue));
                break;
            case 5:
                HelperFunctions.WriteOnMatrixScreen(String.format("\nSunrise\nmedian: %s", MedianUnitValue));
                break;
            case 6:
                HelperFunctions.WriteOnMatrixScreen(String.format("\nSunrise\nstd deviation: %.2f", stdDevUnitValue));
                break;
        } // End switch-case

    }

    // Runs when the red button is pressed
    @Override
    protected void OnButtonRed() {
    }
}

