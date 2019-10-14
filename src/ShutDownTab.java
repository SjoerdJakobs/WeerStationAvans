public class ShutDownTab extends Tab {
    protected ShutDownTab(Menu menu) {
        super(menu);
    }

   @Override
    protected void OnOpen() {
        //runs when tab is opened
       HelperFunctions.WriteOnMatrixScreen("Shut down? (Press red button)");

    }

    /*@Override
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
        //Next tab
    }*/

    @Override
    protected void OnButtonRed() {
        //runs when red button is pressed(runs once, its an actual bu)
        HelperFunctions.WriteOnMatrixScreen("Goodbye!");
        IO.delay(500);
        System.exit(0); //denk ik?
    }
}
