import java.util.ArrayList;
import java.time.LocalDate;

public class ExampleTab3 extends Tab
{
    private int counter = 0;
    private boolean showGraph = false;
    
    protected ExampleTab3(Menu menu) {
        super(menu);
    }

    @Override
    protected void OnOpen() {
        m_menu.DrawMenu();
        setValues();
        RawMeasurement rawData = DatabaseConnection.getMostRecentMeasurement();
        Measurement measurement = new Measurement(rawData);
        current = measurement.getOutsideTemp();
        HelperFunctions.WriteOnMatrixScreen(String.format("\nOutside Temperature\ncurrent:%.2f",current)+ " C");
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

        switch (counter % 8) {
            case 0:
                showGraph = false;
                HelperFunctions.WriteOnMatrixScreen(String.format("\nOutside Temperature\ncurrent:%.2f",current)+ " C");
                break;
            case 1:
                HelperFunctions.WriteOnMatrixScreen(String.format("\nOutside Temperature\nmin:%.2f",min)+ " C");
                break;
            case 2:
                HelperFunctions.WriteOnMatrixScreen(String.format("\nOutside Temperature\nmax:%.2f",max)+ " C");
                break;
            case 3:
                HelperFunctions.WriteOnMatrixScreen(String.format("\nOutside Temperature\naverage:%.2f",average)+ " C");
                break;
            case 4:
                HelperFunctions.WriteOnMatrixScreen(String.format("\nOutside Temperature\nmodus:%.2f",Mode));
                break;
            case 5:
                HelperFunctions.WriteOnMatrixScreen(String.format("\nOutside Temperature\nmedian:%.2f",Median));
                break;
            case 6:
                HelperFunctions.WriteOnMatrixScreen(String.format("\nOutside Temperature\nstd deviation:%.2f",stdDev));
                break;
            case 7:
                pixelGrid = GraphMaker.createAxels(pixelGrid);
                PixelGridDrawer.INSTANCE.Draw(pixelGrid.PixelGrid);
                showGraph = true;


        } // End switch case
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
        min = period.getDataStorage().getMinOutsideTemp();
        max = period.getDataStorage().getMaxOutsideTemp();
        average = period.getDataStorage().getMeanOutsideTemp();
        Mode = period.getDataStorage().getModeOutsideTemp();
        Median = period.getDataStorage().getMedianOutsideTemp();
        stdDev = period.getDataStorage().getStandardDeviationOutsideTemp();
    }

    @Override
    protected void OnButtonRed() {
        //runs when red button is pressed(runs once, its an actual bu)
    }
}