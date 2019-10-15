import java.util.ArrayList;

public class ExampleTab extends Tab
{
    protected ExampleTab(Menu menu) {
        super(menu);
    }

    @Override
    protected void OnOpen() {
        //runs when tab is opened
        System.out.println("example tab opened");
        HelperFunctions.ClearTextDisplay();
        m_menu.DrawMenu();

        // Get raw measurements of period
        Period period = new Period(2);

        // Get measurements from period
        ArrayList<Measurement> measurements = new ArrayList<>();
        measurements = period.getDataStorage().getPeriodMeasurements();

        // Get temperatures of measurements
        ArrayList<Double> temperatures = new ArrayList<>();
        for (int i = 0; i < measurements.size(); i++) temperatures.add(measurements.get(i).getOutsideTemp());

        GraphMaker.createGraph(temperatures);
    }

    @Override
    protected void OnClose() {
        //runs when tab is closed
        System.out.println("example tab closed");

    }

    @Override
    protected void Run(double deltaTime) {
        //runs every frame when tab is opened

        //System.out.println("exampletab run");

    }

    @Override
    protected void OnButtonBlueTwo() {
        //runs when red button is pressed(runs once, its an actual bu)

        System.out.println("example blue tab button pressed");
    }

    @Override
    protected void OnButtonRed() {
        //runs when red button is pressed(runs once, its an actual bu)

        System.out.println("example tab red button pressed");
    }
}
