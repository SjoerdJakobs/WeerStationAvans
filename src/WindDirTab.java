public class WindDirTab extends Tab
{
    private int counter = 0;
    protected WindDirTab(Menu menu) {
        super(menu);
    }

    @Override
    protected void OnOpen() {
        m_menu.DrawMenu();
        setValues();
        RawMeasurement rawData = DatabaseConnection.getMostRecentMeasurement();
        Measurement measurement = new Measurement(rawData);
        current = measurement.getWindDir();
        HelperFunctions.WriteOnMatrixScreen(String.format("\nWind direction\ncurrent:%.2f",current)+ " degrees");

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

            HelperFunctions.WriteOnMatrixScreen(String.format("\nWind direction\nmin:%.2f",min)+ " degrees");
        }

        else if (counter == 2){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nWind direction\nmax:%.2f",max)+ " degrees");
        }

        else if (counter == 3){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nWind direction\naverage:%.2f",average)+ " degrees");
        }

        else if (counter == 4){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nWind direction\nmodus:%.2f",Mode));
        }

        else if (counter == 5){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nWind direction\nmedian:%.2f",Median));
        }

        else if (counter == 6){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nWind direction\nstd deviation:%.2f",stdDev));
        }
        else if (counter > 6){
            HelperFunctions.WriteOnMatrixScreen(String.format("\nWind direction\ncurrent:%.2f",current)+ " degrees");
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
        min = period.getDataStorage().getMinWindDir();
        max = period.getDataStorage().getMaxWindDir();
        average = period.getDataStorage().getMeanWindDir();
        Mode = period.getDataStorage().getModeWindDir();
        Median = period.getDataStorage().getMedianWindDir();
        stdDev = period.getDataStorage().getStandardDeviationWindDir();
        
    }

    @Override
    protected void OnButtonRed() {
        //runs when red button is pressed(runs once, its an actual bu)
    }
}

