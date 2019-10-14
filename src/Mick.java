public class Mick extends Tab
{
    /**
     * A way for a period to be given or get is currently not possible, the variable chunk will be the placeholder period.
     * @param menu
     */
    protected Mick (Menu menu) {
        super(menu);
    }

    @Override
    protected void OnOpen() {
        Period chunk = new Period(365);
        int mist = chunk.getDataStorage().getMist();
        String mistResult = Integer.toString(mist);
        String mistText = " Days with chance of mist";
        HelperFunctions.WriteOnMatrixScreen(mistResult + mistText);
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