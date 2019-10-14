public class RedButton extends Tab{
    protected RedButton(Menu menu) {
        super(menu);
    }

    String text1 = "Period";
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

    }

    @Override
    protected void Run(double deltaTime) {
        //runs every frame when tab is opened

    }

    @Override
    protected void OnButtonBlueTwo() {
        //runs when red button is pressed(runs once, its an actual bu)
        if (text1.equals("Period")){
            HelperFunctions.WriteOnMatrixScreen(text2);
        }
        if (text2.equals("Predefined")){
            HelperFunctions.WriteOnMatrixScreen(text3);
        }
        if (text3.equals("Exit menu")) {
            HelperFunctions.WriteOnMatrixScreen(text4);
        }
        if (text4.equals("Shut down")) {
            HelperFunctions.WriteOnMatrixScreen(text1);
        }
    }
    protected void OnButtonRed() {
        //runs when red button is pressed(runs once, its an actual bu)
        //When on Period --> run Period
        //When on Predefined --> run PredefinedTab
        //When on ExitMenu --> go back to main menu
        //When on ShutDown --> run ShutDownTab
        if (text1.equals("Period")){
            Period; //???
        }
        if (text2.equals("Predefined")){
            PredefinedTab;
        }
        if (text3.equals("Exit menu")){
            ExitMenuTab;
            //        Terug naar main menu misschien?
        }
        if (text4.equals("Shut down")){
            ShutDownTab;
            // Of meteen:
            //        HelperFunctions.WriteOnMatrixScreen("Goodbye!");
            //        IO.delay(500);
            //        System.exit(0); //denk ik?
        }
    }
}
