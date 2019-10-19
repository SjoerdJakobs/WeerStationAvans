import java.util.ArrayList;

public class AirPressureTab extends Tab
{
    protected AirPressureTab(Menu menu) {
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

    /**
     * Set the data veriables
     */
    public void setValues(){
        minUnitValue = period.getDataStorage().getMinAirPressure();
        maxUnitValue = period.getDataStorage().getMaxAirPressure();
        averageUnitValue = period.getDataStorage().getMeanAirPressure();
        ModeUnitValue = period.getDataStorage().getModeAirPressure();
        MedianUnitValue = period.getDataStorage().getMedianAirPressure();
        stdDevUnitValue = period.getDataStorage().getStandardDeviationAirPressure();
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

        // Get current temperature
        RawMeasurement rawData = DatabaseConnection.getMostRecentMeasurement();
        Measurement measurement = new Measurement(rawData);
        currentUnitValue = measurement.getBarometer();
        HelperFunctions.WriteOnMatrixScreen(String.format("\nAir Pressure\ncurrent: %.1f", currentUnitValue) + " hP");

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

                // Get current temperature
                RawMeasurement rawData = DatabaseConnection.getMostRecentMeasurement();
                Measurement measurement = new Measurement(rawData);
                currentUnitValue = measurement.getBarometer();

                if (Double.isNaN(currentUnitValue))
                HelperFunctions.WriteOnMatrixScreen(String.format("\nAir Pressure\ncurrent: no value"));
                else
                HelperFunctions.WriteOnMatrixScreen(String.format("\nAir Pressure\ncurrent: %.1f", currentUnitValue) + " hP");
                break;
            case 1:
                HelperFunctions.WriteOnMatrixScreen(String.format("\nAir Pressure\nmin: %.1f", minUnitValue) + " hP");
                break;
            case 2  :
                HelperFunctions.WriteOnMatrixScreen(String.format("\nAir Pressure\nmax: %.1f", maxUnitValue) + " hP");
                break;
            case 3:
                HelperFunctions.WriteOnMatrixScreen(String.format("\nAir Pressure\naverage: %.1f", averageUnitValue) + " hP");
                break;
            case 4:
                HelperFunctions.WriteOnMatrixScreen(String.format("\nAir Pressure\nmodus: %.1f", ModeUnitValue) + " hP");
                break;
            case 5:
                HelperFunctions.WriteOnMatrixScreen(String.format("\nAir Pressure\nmedian: %.1f", MedianUnitValue) + " hP");
                break;
            case 6:
                HelperFunctions.WriteOnMatrixScreen(String.format("\nAir Pressure\nstd deviation: %.2f", stdDevUnitValue));
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
        if (menuCounter == 7) runGraph = !runGraph;
    }

    /**
     * Getting the values of a predefined unit
     * @param measurements ArrayList with all unitValues
     * @return ArrayList with values of only unit
     */
    private ArrayList<Double> GetUnit(ArrayList<Measurement> measurements) {
        ArrayList<Double> data = new ArrayList<>();
        for (int i = 0; i < measurements.size(); i++) data.add(measurements.get(i).getBarometer());
        return data;
    }
}

