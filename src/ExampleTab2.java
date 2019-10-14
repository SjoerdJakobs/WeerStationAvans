public class ExampleTab2 extends Tab
{
    protected ExampleTab2(Menu menu) {
        super(menu);
    }

    @Override
    protected void OnOpen() {
        //runs when tab is opened
        System.out.println("exampletab 2 opened");
        HelperFunctions.ClearTextDisplay();
        HelperFunctions.WriteOnMatrixScreen("\n hey 2");
    }

    @Override
    protected void OnClose() {
        //runs when tab is closed
        System.out.println("exampletab 2 closed");

    }

    @Override
    protected void Run(double deltaTime) {
        //runs every frame when tab is opened
        //System.out.println("exampletab 2 run");

    }

    @Override
    protected void OnButtonBlueTwo() {
        //runs when red button is pressed(runs once, its an actual bu)

        System.out.println("exampletab 2  bluebutton pressed");
    }

    @Override
    protected void OnButtonRed() {
        //runs when red button is pressed(runs once, its an actual bu)

        System.out.println("exampletab 2 redbutton pressed");
    }
}
