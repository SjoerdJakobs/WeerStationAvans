public class HeatIndexTab extends Tab
{
    protected HeatIndexTab(Menu menu) {
        super(menu);
    }

    @Override
    protected void OnOpen() {

        RawMeasurement rawData = DatabaseConnection.getMostRecentMeasurement();
        Measurement measurement = new Measurement(rawData);
        System.out.println(Calculations.heatIndex(measurement.getInsideTemp(),measurement.getInsideHum()));
        HelperFunctions.WriteOnMatrixScreen("Most recent heat index measurement: " +Calculations.heatIndex(measurement.getInsideTemp(),measurement.getInsideHum()) );


        //runs when tab is opened

    }

    @Override
    protected void OnClose() {
        //runs when tab is closed

    }

    @Override
    protected void Run(double deltaTime) {
        //runs every frame when tab is opened

    }

    @Override
    protected void OnButtonBlueTwo() {
        //runs when red button is pressed(runs once, its an actual bu)
    }

    @Override
    protected void OnButtonRed() {
        //runs when red button is pressed(runs once, its an actual bu)
    }
}

