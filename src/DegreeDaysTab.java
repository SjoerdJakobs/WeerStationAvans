public class DegreeDaysTab extends Tab
{
    private int counter = 0;
    protected DegreeDaysTab(Menu menu) {
        super(menu);
    }

    @Override
    protected void OnOpen() {
        m_menu.DrawMenu();
        setValues();
        AmountOfDegreeDays = period.getDataStorage().getDegreeDays();
        HelperFunctions.WriteOnMatrixScreen(String.format("\nDegree days\ngiven period: "+AmountOfDegreeDays));

    }

    @Override
    protected void OnClose() {
        HelperFunctions.ClearTextDisplay();
    }

    @Override
    protected void Run(double deltaTime) {
        //runs every frame when tab is opened

    }

    @Override
    protected void OnButtonBlueTwo() {
        counter++;
        HelperFunctions.ClearTextDisplay();
        m_menu.DrawMenu();


        if (counter == 1){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nDegree days\nlast 7 days: "+ (int)seven));
        }

        else if (counter == 2){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nDegree days\nlast 14 days: "+ (int)fourteen));
        }

        else if (counter == 3){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nDegree days\nlast 21 days: "+(int)twentyone));
        }

        else if (counter == 4){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nDegree days\nlast 28 days: "+(int)twentyeight));
        }

        else if (counter == 5){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nDegree days\nlast 2 months: "+(int)sixtyone));
        }

        else if (counter == 6){

            HelperFunctions.WriteOnMatrixScreen(String.format("\nDegree days\nlast year: "+(int)year));
        }
        else if (counter > 6){
            HelperFunctions.WriteOnMatrixScreen(String.format("\nDegree days\ngiven period:: "+AmountOfDegreeDays));
            counter = 0;

        }
    }

    Period period = new Period();
    Period sevenPeriod = new Period(7);
    Period fourteenPeriod = new Period(14);
    Period twentyonePeriod = new Period(21);
    Period twentyeightPeriod = new Period(28);
    Period sixtyonePeriod = new Period(61);
    Period yearPeriod = new Period(365);


    private int AmountOfDegreeDays;
    private double seven;
    private double fourteen;
    private double twentyone;
    private double twentyeight;
    private double sixtyone;
    private double year;

    public void setValues(){
        seven = sevenPeriod.getDataStorage().getDegreeDays();
        fourteen = fourteenPeriod.getDataStorage().getDegreeDays();
        twentyone = twentyonePeriod.getDataStorage().getDegreeDays();
        twentyeight = twentyeightPeriod.getDataStorage().getDegreeDays();
        sixtyone = sixtyonePeriod.getDataStorage().getDegreeDays();
        year = yearPeriod.getDataStorage().getDegreeDays();
    }

    @Override
    protected void OnButtonRed() {
        //runs when red button is pressed(runs once, its an actual bu)
    }
}
