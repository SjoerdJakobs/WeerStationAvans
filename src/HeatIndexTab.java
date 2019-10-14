public class HeatIndexTab extends Tab
{
    private int counter = 0;
    protected HeatIndexTab(Menu menu) {
        super(menu);
    }

    @Override
    protected void OnOpen() {
        setValues();
        RawMeasurement rawData = DatabaseConnection.getMostRecentMeasurement();
        Measurement measurement = new Measurement(rawData);
        current = Calculations.dewPoint(measurement.getInsideTemp(),measurement.getInsideHum());
        HelperFunctions.WriteOnMatrixScreen(String.format("\nHeat index\ncurrent:%.2f",current));
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

            HelperFunctions.WriteOnMatrixScreen(String.format("\nHeat index\nmin:%.2f",min));
        }

        else if (counter == 2){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nHeat index\nmax:%.2f",max));
        }

        else if (counter == 3){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nHeat index\naverage:%.2f",average));
        }

        else if (counter == 4){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nHeat index\nmodus:%.2f",Mode));
        }

        else if (counter == 5){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nHeat index\nmedian:%.2f",Median));
        }

        else if (counter == 6){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nHeat index\nstandard deviation:%.2f",stdDev));
        }
        else if (counter > 6){
            HelperFunctions.WriteOnMatrixScreen(String.format("\nHeat index\ncurrent:%.2f",current));
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
        min = Calculations.dewPoint(period.getDataStorage().getMinInsideTemp(),period.getDataStorage().getMinInsideHum());
        max = Calculations.dewPoint(period.getDataStorage().getMaxInsideTemp(),period.getDataStorage().getMaxInsideHum());
        average = Calculations.dewPoint(period.getDataStorage().getMeanInsideTemp(),period.getDataStorage().getMeanInsideHum());
        Mode = Calculations.dewPoint(period.getDataStorage().getModeInsideTemp(),period.getDataStorage().getModeInsideHum());
        Median = Calculations.dewPoint(period.getDataStorage().getMedianInsideTemp(),period.getDataStorage().getMedianInsideHum());
        stdDev = Calculations.dewPoint(period.getDataStorage().getStandardDeviationInsideTemp(),period.getDataStorage().getStandardDeviationInsideHum());
    }

    @Override
    protected void OnButtonRed() {
        //runs when red button is pressed(runs once, its an actual bu)
    }
}

