public class DewPointTab extends Tab
{
    private int counter = 0;
    protected DewPointTab(Menu menu) {
        super(menu);
    }

    @Override
    protected void OnOpen() {
        setValues();
        RawMeasurement rawData = DatabaseConnection.getMostRecentMeasurement();
        Measurement measurement = new Measurement(rawData);
        current = Calculations.dewPoint(measurement.getOutsideTemp(),measurement.getOutsideHum());
        HelperFunctions.WriteOnMatrixScreen(String.format("\nDew point\ncurrent:%.2f",current));

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

        if (counter == 1){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nDew point\nmin:%.2f",min));
        }

        else if (counter == 2){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nDew point\nmax:%.2f",max));
        }

        else if (counter == 3){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nDew point\naverage:%.2f",average));
        }

        else if (counter == 4){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nDew point\nmodus:%.2f",Mode));
        }

        else if (counter == 5){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nDew point\nmedian:%.2f",Median));
        }

        else if (counter == 6){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nDew point\nstandard deviation:%.2f",stdDev));
        }
        else if (counter > 6){
            HelperFunctions.WriteOnMatrixScreen(String.format("\nDew point\ncurrent:%.2f",current));
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
        min = Calculations.dewPoint(period.getDataStorage().getMinOutsideTemp(),period.getDataStorage().getMinOutsideHum());
        max = Calculations.dewPoint(period.getDataStorage().getMaxOutsideTemp(),period.getDataStorage().getMaxOutsideHum());
        average = Calculations.dewPoint(period.getDataStorage().getMeanOutsideTemp(),period.getDataStorage().getMeanOutsideHum());
        Mode = Calculations.dewPoint(period.getDataStorage().getModeOutsideTemp(),period.getDataStorage().getModeOutsideHum());
        Median = Calculations.dewPoint(period.getDataStorage().getMedianOutsideTemp(),period.getDataStorage().getMedianOutsideHum());
        stdDev = Calculations.dewPoint(period.getDataStorage().getStandardDeviationOutsideTemp(),period.getDataStorage().getStandardDeviationOutsideHum());
    }

    @Override
    protected void OnButtonRed() {
        //runs when red button is pressed(runs once, its an actual bu)
    }
}

