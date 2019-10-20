import java.util.ArrayList;

public class RainRateTab extends Tab
{
    protected RainRateTab(Menu menu) {
        super(menu);
    }
    private Period period;
    public void setPeriod(){period = SavedData.INSTANCE.GetPeriod(); }

    // Get raw measurements of period
    private ArrayList<Measurement> measurements;
    public void setMeasurements(){
        measurements = period.getDataStorage().getPeriodMeasurements();

    }
    // Get the correct values from the measurement
    private ArrayList<Double> unitValues;
    public void setUnitValues(){
        unitValues = GetUnit(measurements);
    }

    // Create a PixelGrid to keep track of the shown dots
    GraphMaker graph = new GraphMaker();

    // MENU VARIABLES
    private int menuCounter = 0;
    private boolean runGraph = false;

    // DATA VARIABLES
    private double currentUnitValue;
    private double minUnitValue;
    private double maxUnitValue;
    private double averageUnitValue;
    private double ModeUnitValue;
    private double MedianUnitValue;
    private double stdDevUnitValue;

// TODO ***************
    /**
     * Set the data variables
     */
    public void setValues(){
        minUnitValue = period.getDataStorage().getMinRainRate();
        maxUnitValue = period.getDataStorage().getMaxRainRate();
        averageUnitValue = period.getDataStorage().getMeanRainRate();
        ModeUnitValue = period.getDataStorage().getModeRainRate();
        MedianUnitValue = period.getDataStorage().getMedianRainRate();
        stdDevUnitValue = period.getDataStorage().getStandardDeviationRainRate();
    }

    // GRAPH VARIABLES
    private double deltaTimer = 0;
    private double graphSpeed = 0.03;

    // Runs when tab is opened
    @Override
    protected void OnOpen() {
        HelperFunctions.ClearTextDisplay();
        HelperFunctions.ClearAll();
        setPeriod();
        setValues();
        setMeasurements();
        setUnitValues();

        menuCounter=0;
        m_menu.DrawMenu();

        // TODO
        // Get current rain rate
        Measurement measurement = SavedData.INSTANCE.GetLastMeasurement();
        currentUnitValue = measurement.getRainRate();
        HelperFunctions.WriteOnMatrixScreen(String.format("\nRain rate\ncurrent: %.1f", currentUnitValue) + " mm/hour");

        graph.initialise(unitValues);
    }

    // Runs when tab is closed
    @Override
    protected void OnClose() {
        menuCounter = 0;
        runGraph = false;
        HelperFunctions.ClearAll();
    }

    // Runs always but content is run only when runGraph is true
    @Override
    protected void Run(double deltaTime) {
        deltaTimer += deltaTime;

        if (runGraph && deltaTimer >= SavedData.INSTANCE.GetGraphSpeed()) {
            deltaTimer = 0;
            graph.RunCycle();
        }
    }

    // Runs when the second blue button is pressed
    @Override
    protected void OnButtonBlueTwo() {
        menuCounter++;
        HelperFunctions.ClearAll();
        m_menu.DrawMenu();

        switch (menuCounter % 8) {
            case 0:
                runGraph = false;

                // Get current rain rate
                Measurement measurement = SavedData.INSTANCE.GetLastMeasurement();
                currentUnitValue = measurement.getRainRate();

                if (Double.isNaN(currentUnitValue))
                    HelperFunctions.WriteOnMatrixScreen(String.format("\nRain rate\ncurrent: no value"));
                else
                    HelperFunctions.WriteOnMatrixScreen(String.format("\nRain rate\ncurrent: %.1f", currentUnitValue) + " mm/hour");
                break;
            case 1:
                HelperFunctions.WriteOnMatrixScreen(String.format("\nRain rate\nmin: %.1f", minUnitValue) + " mm/hour");
                break;
            case 2  :
                HelperFunctions.WriteOnMatrixScreen(String.format("\nRain rate\nmax: %.1f", maxUnitValue) + " mm/hour");
                break;
            case 3:
                HelperFunctions.WriteOnMatrixScreen(String.format("\nRain rate\naverage: %.1f", averageUnitValue) + " mm/hour");
                break;
            case 4:
                HelperFunctions.WriteOnMatrixScreen(String.format("\nRain rate\nmodus: %.1f", ModeUnitValue) + " mm/hour");
                break;
            case 5:
                HelperFunctions.WriteOnMatrixScreen(String.format("\nRain rate\nmedian: %.1f", MedianUnitValue) + " mm/hour");
                break;
            case 6:
                HelperFunctions.WriteOnMatrixScreen(String.format("\nRain rate\nstd deviation: %.2f", stdDevUnitValue));
                break;
            case 7:
                runGraph = true;
                graph.DrawAxels();
                break;
        } // End switch-case

    }

    // Runs when the red button is pressed
    @Override
    protected void OnButtonRed() {
        if (menuCounter % 8 == 7) runGraph = !runGraph;
    }

    /**
     * Getting the values of a predefined unit
     * @param measurements ArrayList with all unitValues
     * @return ArrayList with values of only unit
     */
    private ArrayList<Double> GetUnit(ArrayList<Measurement> measurements) {
        ArrayList<Double> data = new ArrayList<>(); // TODO
        for (int i = 0; i < measurements.size(); i++) data.add(measurements.get(i).getRainRate());
        return data;
    }
}

