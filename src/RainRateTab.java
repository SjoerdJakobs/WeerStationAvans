public class RainRateTab extends Tab
{
    private int counter = 0;
    protected RainRateTab(Menu menu) {
        super(menu);
    }

    @Override
    protected void OnOpen() {
        m_menu.DrawMenu();
        setValues();
        RawMeasurement rawData = DatabaseConnection.getMostRecentMeasurement();
        Measurement measurement = new Measurement(rawData);
        current = measurement.getRainRate();
        HelperFunctions.WriteOnMatrixScreen(String.format("\nRain rate\ncurrent:%.2f",current)+ "mm/hour");

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

            HelperFunctions.WriteOnMatrixScreen(String.format("\nRain rate\nmin:%.2f",min)+ "mm/hour");
        }

        else if (counter == 2){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nRain rate\nmax:%.2f",max)+ "mm/hour");
        }

        else if (counter == 3){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nRain rate\naverage:%.2f",average)+ "mm/hour");
        }

        else if (counter == 4){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nRain rate\nmodus:%.2f",Mode));
        }

        else if (counter == 5){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nRain rate\nmedian:%.2f",Median));
        }

        else if (counter == 6){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nRain rate\nstd deviation:%.2f",stdDev));
        }
        else if (counter > 6){
            HelperFunctions.WriteOnMatrixScreen(String.format("\nRain rate\ncurrent:%.2f",current)+ "mm/hour");
            counter = 0;

        }
    }

    Period period = new Period();

    private double current;
    private double min;
    private double max;
    private double average;
    private double Mode;
    private double Median;
    private double stdDev;

    public void setValues(){
        min = period.getDataStorage().getMinRainRate();
        max = period.getDataStorage().getMaxRainRate();
        average = period.getDataStorage().getMeanRainRate();
        Mode = period.getDataStorage().getModeRainRate();
        Median = period.getDataStorage().getMedianRainRate();
        stdDev = period.getDataStorage().getStandardDeviationRainRate();
    }

    @Override
    protected void OnButtonRed() {
        //runs when red button is pressed(runs once, its an actual bu)
    }
}

