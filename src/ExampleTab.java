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
        HelperFunctions.WriteOnMatrixScreen("\n hey");
        m_menu.DrawMenu();
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
