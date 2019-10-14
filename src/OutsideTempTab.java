public class OutsideTempTab extends Tab
{
    protected OutsideTempTab(Menu menu) {
        super(menu);
    }

    @Override
    protected void OnOpen() {

        RawMeasurement rawData = DatabaseConnection.getMostRecentMeasurement();
        Measurement measurement = new Measurement(rawData);
        HelperFunctions.WriteOnMatrixScreen("Most recent outside temperature measurement: " +measurement.getOutsideTemp() );
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

