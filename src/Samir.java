import java.util.ArrayList;

public class Samir extends Tab
{
    private int counter = 0;

    protected Samir(Menu menu) {
        super(menu);
    }

    @Override
    protected void OnOpen() {

        Period a = new Period(7);
        int temp = a.getDataStorage().getDegreeDays();
        String degreeDaysResult = Integer.toString(temp);
        HelperFunctions.WriteOnMatrixScreen("Degree days: " + degreeDaysResult);
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

