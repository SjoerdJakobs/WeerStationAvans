public class RedButton extends Tab{
    protected RedButton(Menu menu) {
        super(menu);
    }
    int count = 0;

    String text1 = "Set period";
    String text2 = "Predefined";
    String text3 = "Exit menu";
    String text4 = "Shut down";

    @Override
    protected void OnOpen() {
        //runs when tab is opened
        // show:
        // Period
        // Predefined
        // Exit menu
        // Shut down program
        HelperFunctions.WriteOnMatrixScreen(text1);
    }

    @Override
    protected void OnClose() {
        //runs when tab is closed
        HelperFunctions.ClearMatrixDisplay();

    }

    @Override
    protected void Run(double deltaTime) {
        //runs every frame when tab is opened

    }

    @Override
    protected void OnButtonBlueTwo() {
        count++;

        if(count == 0) {
            HelperFunctions.WriteOnMatrixScreen("Set period");
        } else if (count == 1){
            HelperFunctions.WriteOnMatrixScreen("Predefined");
        } else if (count == 2){
            HelperFunctions.WriteOnMatrixScreen("Exit menu");
        } else if (count == 3){
            HelperFunctions.WriteOnMatrixScreen("Shut down");
        } else if (count > 3){
            count = 0;
        }
    }
    protected void OnButtonRed() {
        //runs when red button is pressed(runs once, its an actual bu)
        //When on Period --> run Period
        //When on Predefined --> run PredefinedTab
        //When on ExitMenu --> go back to main menu
        //When on ShutDown --> run ShutDownTab
        if (count == 0){
            SetPeriodTab; //???
        } else if (count == 1){
            PredefinedTab;
        } else if (count == 2){
            ExitMenuTab;
            //Terug naar main menu misschien?
        } else if (count == 3){
            ShutDownTab(OnButtonRed());
        }
    }
}
