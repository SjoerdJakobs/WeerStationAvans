public class ExitMenuTab extends Tab{

    protected ExitMenuTab (Menu menu) {
        super(menu);
    }

    @Override
    protected void OnOpen() {
        //runs when tab is opened

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
        //runs when red button is pressed(runs once, its an actual bu)
        //Next tab
    }

    @Override
    protected void OnButtonRed() {
        //runs when red button is pressed(runs once, its an actual bu)
        //Back to previous menu
    }
}
