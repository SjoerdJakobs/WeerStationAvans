public class OutsideHumTab extends Tab
{
    private int counter = 0;
    protected OutsideHumTab(Menu menu) {
        super(menu);
    }

    @Override
    protected void OnOpen() {
        m_menu.DrawMenu();
        setValues();
        RawMeasurement rawData = DatabaseConnection.getMostRecentMeasurement();
        Measurement measurement = new Measurement(rawData);
        current = measurement.getOutsideHum();
        HelperFunctions.WriteOnMatrixScreen(String.format("\nOutside humidity\ncurrent:%.2f",current) + "%");

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

            HelperFunctions.WriteOnMatrixScreen(String.format("\nOutside humidity\nmin:%.2f",min) + "%");
        }

        else if (counter == 2){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nOutside humidity\nmax:%.2f",max) + "%");
        }

        else if (counter == 3){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nOutside humidity\naverage:%.2f",average) + "%");
        }

        else if (counter == 4){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nOutside humidity\nmodus:%.2f",Mode));
        }

        else if (counter == 5){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nOutside humidity\nmedian:%.2f",Median));
        }

        else if (counter == 6){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nOutside humidity\nstd deviation:%.2f",stdDev));
        }
        else if (counter > 6){
            HelperFunctions.WriteOnMatrixScreen(String.format("\nOutside humidity\ncurrent:%.2f",current) + "%");
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
        min = period.getDataStorage().getMinOutsideHum();
        max = period.getDataStorage().getMaxOutsideHum();
        average = period.getDataStorage().getMeanOutsideHum();
        Mode = period.getDataStorage().getModeOutsideHum();
        Median = period.getDataStorage().getMedianOutsideHum();
        stdDev = period.getDataStorage().getStandardDeviationOutsideHum();
    }

    @Override
    protected void OnButtonRed() {
        //runs when red button is pressed(runs once, its an actual bu)
    }
}

