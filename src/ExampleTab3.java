public class ExampleTab3 extends Tab
{
    protected ExampleTab3(Menu menu) {
        super(menu);
    }

    @Override
    protected void OnOpen() {
        //runs when tab is opened
        System.out.println("exampletab 3 opened");
        HelperFunctions.ClearTextDisplay();
        HelperFunctions.WriteOnMatrixScreen("\n hey 3");
        m_menu.DrawMenu();
    }

    @Override
    protected void OnClose() {
        //runs when tab is closed
        System.out.println("exampletab 3 closed");

    }

    @Override
    protected void Run(double deltaTime) {
        //runs every frame when tab is opened
        //System.out.println("exampletab 3 run");

    }

    @Override
    protected void OnButtonBlueTwo() {
        //runs when red button is pressed(runs once, its an actual bu)

        System.out.println("exampletab 3  bluebutton pressed");
    }

    @Override
    protected void OnButtonRed() {
        //runs when red button is pressed(runs once, its an actual bu)

        System.out.println("exampletab 3 redbutton pressed");
    }
}
