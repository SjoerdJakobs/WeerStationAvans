public class SetPeriodTab extends Tab{
    protected SetPeriodTab(Menu menu) {
        super(menu);
    }

    @Override
    protected void OnOpen() {
        //runs when tab is opened
        int year = 2006;
        int month = 1;
        int day = 1;
        int count = 1;
        boolean acknowlegde = false;

        HelperFunctions.WriteOnMatrixScreen("Set period:");
        while (acknowlegde){
            HelperFunctions.WriteOnMatrixScreen("\n Year: " + year);
            if (OnButtonBlueTwo()){
                HelperFunctions.WriteOnMatrixScreen("\n Year: " + year);
                year = year + count;

                if (IO.readShort(0x80) == 1){
                    int beginYear = year;
                    acknowlegde = true;
                }
            }
        }
        while (acknowlegde){
            HelperFunctions.WriteOnMatrixScreen("\n Month: " + month);
            if (OnButtonBlueTwo()){
                HelperFunctions.WriteOnMatrixScreen("\n Month: " + month);
                month = month + count;

                if (IO.readShort(0x80) == 1){
                    int beginMonth = month;
                    acknowlegde = true;
                }
            }
        }
        while (acknowlegde){
            HelperFunctions.WriteOnMatrixScreen("\n Day: " + day);
            if (OnButtonBlueTwo()){
                HelperFunctions.WriteOnMatrixScreen("\n Day: " + day);
                day = day + count;

                if (IO.readShort(0x80) == 1){
                    int beginDay = day;
                    acknowlegde = true;
                }
            }
        }

        while (acknowlegde){
            HelperFunctions.WriteOnMatrixScreen("\n Year: " + year);
            if (OnButtonBlueTwo()){
                HelperFunctions.WriteOnMatrixScreen("\n Year: " + year);
                year = year + count;

                if (IO.readShort(0x80) == 1){
                    int endYear = year;
                    acknowlegde = true;
                }
            }
        }
        while (acknowlegde){
            HelperFunctions.WriteOnMatrixScreen("\n Month: " + month);
            if (OnButtonBlueTwo()){
                HelperFunctions.WriteOnMatrixScreen("\n Month: " + month);
                month = month + count;

                if (IO.readShort(0x80) == 1){
                    int endMonth = month;
                    acknowlegde = true;
                }
            }
        }
        while (acknowlegde){
            HelperFunctions.WriteOnMatrixScreen("\n Day: " + day);
            if (OnButtonBlueTwo()){
                HelperFunctions.WriteOnMatrixScreen("\n Day: " + day);
                day = day + count;

                if (IO.readShort(0x80) == 1){
                    int endDay = day;
                    acknowlegde = true;
                }
            }
        }


        Period givenPeriod = new Period((beginYear, beginMoth, beginYear),(endYear, endMonth, endDay));

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
    }

    @Override
    protected void OnButtonRed() {
        //runs when red button is pressed(runs once, its an actual bu)
    }
}
