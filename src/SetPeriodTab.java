public class SetPeriodTab extends Tab{
    protected SetPeriodTab(Menu menu) {
        super(menu);
    }

    @Override
    protected void OnOpen() {
        //runs when tab is opened
        int year = 2006;
        int maxYear = 2019;
        int month = 1;
        int maxMonth = 12;
        int day = 1;
        int maxDay = 30;
        int count = 1;
        boolean acknowlegde = false;

        HelperFunctions.WriteOnMatrixScreen("Set period:");
        while (acknowlegde){
            HelperFunctions.WriteOnMatrixScreen("\n Year: " + year);
            if (OnButtonBlueTwo()){

                if (year <= maxYear){
                    HelperFunctions.WriteOnMatrixScreen("\n Year: " + year);
                    year = year + count;

                    if (IO.readShort(0x80) == 1){
                        int beginYear = year;
                        acknowlegde = true;
                    }
                } else {
                    year = 2006;
                }

            }
        }
        while (acknowlegde){
            HelperFunctions.WriteOnMatrixScreen("\n Month: " + month);
            if (OnButtonBlueTwo()) {
                if (month <= maxMonth) {
                    HelperFunctions.WriteOnMatrixScreen("\n Month: " + month);
                    month = month + count;

                    if (IO.readShort(0x80) == 1) {
                        int beginMonth = month;
                        acknowlegde = true;
                    }
                } else {
                    month = 1;
                }
            }
        }
        while (acknowlegde){
            HelperFunctions.WriteOnMatrixScreen("\n Day: " + day);
            if (OnButtonBlueTwo()){
                if (day < maxDay){
                    HelperFunctions.WriteOnMatrixScreen("\n Day: " + day);
                    day = day + count;

                    if (IO.readShort(0x80) == 1){
                        int beginDay = day;
                        acknowlegde = true;
                    }
                } else {
                    day = 1;
                }
            }
        }

        while (acknowlegde){
            HelperFunctions.WriteOnMatrixScreen("\n Year: " + year);
            if (OnButtonBlueTwo()){
                if (year <= maxYear){
                    HelperFunctions.WriteOnMatrixScreen("\n Year: " + year);
                    year = year + count;

                    if (IO.readShort(0x80) == 1){
                        int endYear = year;
                        acknowlegde = true;
                    }
                } else {
                    year = 2006;
                }
            }
        }

        while (acknowlegde){
            HelperFunctions.WriteOnMatrixScreen("\n Month: " + month);
            if (OnButtonBlueTwo()){
                if (month < maxMonth){
                    HelperFunctions.WriteOnMatrixScreen("\n Month: " + month);
                    month = month + count;

                    if (IO.readShort(0x80) == 1){
                        int endMonth = month;
                        acknowlegde = true;
                    }
                } else {
                    month = 1;
                }
            }
        }
        while (acknowlegde){
            HelperFunctions.WriteOnMatrixScreen("\n Day: " + day);
            if (OnButtonBlueTwo()){
                if (day <= maxDay){
                    HelperFunctions.WriteOnMatrixScreen("\n Day: " + day);
                    day = day + count;

                    if (IO.readShort(0x80) == 1){
                        int endDay = day;
                        acknowlegde = true;
                    }
                } else {
                    day = 1;
                }
            }
        }

        Period givenPeriod = new Period((beginYear, beginMoth, beginYear),(endYear, endMonth, endDay))//??????
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
