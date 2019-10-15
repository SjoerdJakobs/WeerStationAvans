public class InsideTempTab extends Tab
{
    private int counter = 0;
    protected InsideTempTab(Menu menu) {
        super(menu);
    }

    @Override
    protected void OnOpen() {
        m_menu.DrawMenu();
        setValues();
        RawMeasurement rawData = DatabaseConnection.getMostRecentMeasurement();
        Measurement measurement = new Measurement(rawData);
        current = measurement.getInsideTemp();
        HelperFunctions.WriteOnMatrixScreen(String.format("\nInside Temperature\ncurrent:%.2f",current)+ " C");

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

            HelperFunctions.WriteOnMatrixScreen(String.format("\nInside Temperature\nmin:%.2f",min)+ " C");
        }

        else if (counter == 2){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nInside Temperature\nmax:%.2f",max)+ " C");
        }

        else if (counter == 3){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nInside Temperature\naverage:%.2f",average)+ " C");
        }

        else if (counter == 4){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nInside Temperature\nmodus:%.2f",Mode));
        }

        else if (counter == 5){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nInside Temperature\nmedian:%.2f",Median));
        }

        else if (counter == 6){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nInside Temperature\nstd deviation:%.2f",stdDev));
        }
        else if (counter > 6){
            HelperFunctions.WriteOnMatrixScreen(String.format("\nInside Temperature\ncurrent:%.2f",current)+ " C");
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
        min = period.getDataStorage().getMinInsideTemp();
        max = period.getDataStorage().getMaxInsideTemp();
        average = period.getDataStorage().getMeanInsideTemp();
        Mode = period.getDataStorage().getModeInsideTemp();
        Median = period.getDataStorage().getMedianInsideTemp();
        stdDev = period.getDataStorage().getStandardDeviationInsideTemp();
    }

    @Override
    protected void OnButtonRed() {
        //runs when red button is pressed(runs once, its an actual bu)
    }
}

