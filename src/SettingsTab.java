
import java.lang.reflect.Array;
import java.util.ArrayList;

public class SettingsTab extends Tab {
    protected SettingsTab(Menu menu) {
        super(menu);
    }

    int state = 0;
    int menuState = 0;

    int periodState = 0;
    int yearState = 0;
    int monthState = 0;
    int dayState = 0;
    int beginYear;
    int beginMonth;
    int beginDay;
    int endYear;
    int endMonth;
    int endDay;

    int preDefState;

    @Override
    protected void OnOpen() {
        //runs when tab is opened
        // show:
        // Period
        // Predefined
        // Exit menu
        // Shut down program
        HelperFunctions.ClearMatrixDisplay();
        m_menu.DrawMenu();
        HelperFunctions.WriteOnMatrixScreen("\n Settings: ");
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
        HelperFunctions.ClearMatrixDisplay();
        /**
         * Scroll through main menu
         */
        if (state == 0 && menuState == 0) {
            HelperFunctions.ClearMatrixDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Set period");
            menuState++;
            m_menu.DrawMenu();
        } else if (state == 0 && menuState == 1) {
            HelperFunctions.ClearMatrixDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Predefined");
            menuState++;
            m_menu.DrawMenu();
        } else if (state == 0 && menuState == 2) {
            HelperFunctions.ClearMatrixDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Exit settings");
            menuState++;
            m_menu.DrawMenu();
        } else if (state == 0 && menuState == 3) {
            HelperFunctions.ClearMatrixDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Shut down");
            menuState++;
            m_menu.DrawMenu();
        } else if (menuState > 3) {
            menuState = 0;
        }

        /**
         * Set a year for the begin period
         */
        else if (state == 1 && periodState == 1 && yearState == 0) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2006");
            yearState++;
        } else if (state == 1 && periodState == 1 && yearState == 1) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2007");
            yearState++;
        } else if (state == 1 && periodState == 1 && yearState == 2) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2008");
            yearState++;
        } else if (state == 1 && periodState == 1 && yearState == 3) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2009");
            yearState++;
        } else if (state == 1 && periodState == 1 && yearState == 4) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2010");
            yearState++;
        } else if (state == 1 && periodState == 1 && yearState == 5) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2011");
            yearState++;
        } else if (state == 1 && periodState == 1 && yearState == 6) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2012");
            yearState++;
        } else if (state == 1 && periodState == 1 && yearState == 7) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2013");
            yearState++;
        } else if (state == 1 && periodState == 1 && yearState == 8) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2014");
            yearState++;
        } else if (state == 1 && periodState == 1 && yearState == 9) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2015");
            yearState++;
        } else if (state == 1 && periodState == 1 && yearState == 10) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2016");
            yearState++;
        } else if (state == 1 && periodState == 1 && yearState == 11) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2017");
            yearState++;
        } else if (state == 1 && periodState == 1 && yearState == 12) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2018");
            yearState++;
        } else if (state == 1 && periodState == 1 && yearState == 13) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2019");
            yearState++;
        } else if (yearState > 13) {
            yearState = 0;
        }
        /**
         * Set a month for the begin period
         */
        else if (state == 1 && periodState == 2 && monthState == 0) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 1");
            monthState++;
        } else if (state == 1 && periodState == 2 && monthState == 1) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 2");
            monthState++;
        } else if (state == 1 && periodState == 2 && monthState == 2) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 3");
            monthState++;
        } else if (state == 1 && periodState == 2 && monthState == 3) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 4");
            monthState++;
        } else if (state == 1 && periodState == 2 && monthState == 4) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 5");
            monthState++;
        } else if (state == 1 && periodState == 2 && monthState == 5) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 6");
            monthState++;
        } else if (state == 1 && periodState == 2 && monthState == 6) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 7");
            monthState++;
        } else if (state == 1 && periodState == 2 && monthState == 7) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 8");
            monthState++;
        } else if (state == 1 && periodState == 2 && monthState == 8) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 9");
            monthState++;
        } else if (state == 1 && periodState == 2 && monthState == 9) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 10");
            monthState++;
        } else if (state == 1 && periodState == 2 && monthState == 10) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 11");
            monthState++;
        } else if (state == 1 && periodState == 2 && monthState == 11) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 12");
            monthState++;
        } else if (monthState > 11) {
            monthState = 0;
        }

        /**
         * Set a day for the begin period
         */
        else if (state == 1 && periodState == 3 && dayState == 0) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 1");
            dayState++;
        } else if (state == 1 && periodState == 3 && dayState == 1) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 2");
            dayState++;
        } else if (state == 1 && periodState == 3 && dayState == 2) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 3");
            dayState++;
        } else if (state == 1 && periodState == 3 && dayState == 3) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 4");
            dayState++;
        } else if (state == 1 && periodState == 3 && dayState == 4) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 5");
            dayState++;
        } else if (state == 1 && periodState == 3 && dayState == 5) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 6");
            dayState++;
        } else if (state == 1 && periodState == 3 && dayState == 6) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 7");
            dayState++;
        } else if (state == 1 && periodState == 3 && dayState == 7) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 8");
            dayState++;
        } else if (state == 1 && periodState == 3 && dayState == 8) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 9");
            dayState++;
        } else if (state == 1 && periodState == 3 && dayState == 9) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 10");
            dayState++;
        } else if (state == 1 && periodState == 3 && dayState == 10) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 11");
            dayState++;
        } else if (state == 1 && periodState == 3 && dayState == 11) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 12");
            dayState++;
        } else if (state == 1 && periodState == 3 && dayState == 12) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 13");
            dayState++;
        } else if (state == 1 && periodState == 3 && dayState == 13) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 14");
            dayState++;
        } else if (state == 1 && periodState == 3 && dayState == 14) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 15");
            dayState++;
        } else if (state == 1 && periodState == 3 && dayState == 15) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 16");
            dayState++;
        } else if (state == 1 && periodState == 3 && dayState == 16) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 17");
            dayState++;
        } else if (state == 1 && periodState == 3 && dayState == 17) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 18");
            dayState++;
        } else if (state == 1 && periodState == 3 && dayState == 18) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 19");
            dayState++;
        } else if (state == 1 && periodState == 3 && dayState == 19) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 20");
            dayState++;
        } else if (state == 1 && periodState == 3 && dayState == 20) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 21");
            dayState++;
        } else if (state == 1 && periodState == 3 && dayState == 21) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 22");
            dayState++;
        } else if (state == 1 && periodState == 3 && dayState == 22) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 23");
            dayState++;
        } else if (state == 1 && periodState == 3 && dayState == 23) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 24");
            dayState++;
        } else if (state == 1 && periodState == 3 && dayState == 24) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 25");
            dayState++;
        } else if (state == 1 && periodState == 3 && dayState == 25) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 26");
            dayState++;
        } else if (state == 1 && periodState == 3 && dayState == 26) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 27");
            dayState++;
        } else if (state == 1 && periodState == 3 && dayState == 27) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 28");
            dayState++;
        } else if (state == 1 && periodState == 3 && dayState == 28) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 29");
            dayState++;
        } else if (state == 1 && periodState == 3 && dayState == 29) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 30");
            dayState++;
        } else if (state == 1 && periodState == 3 && dayState == 30) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 31");
            dayState++;
        } else if (dayState > 30) {
            dayState = 0;
        }

        /**
         * Set a month for the end period
         */
        else if (state == 3 && periodState == 2 && yearState == 0) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2006");
            yearState++;
        } else if (state == 3 && periodState == 2 && yearState == 1) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2007");
            yearState++;
        } else if (state == 3 && periodState == 2 && yearState == 2) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2008");
            yearState++;
        } else if (state == 3 && periodState == 2 && yearState == 3) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2009");
            yearState++;
        } else if (state == 3 && periodState == 2 && yearState == 4) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2010");
            yearState++;
        } else if (state == 3 && periodState == 2 && yearState == 5) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2011");
            yearState++;
        } else if (state == 3 && periodState == 2 && yearState == 6) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2012");
            yearState++;
        } else if (state == 3 && periodState == 2 && yearState == 7) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2013");
            yearState++;
        } else if (state == 3 && periodState == 2 && yearState == 8) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2014");
            yearState++;
        } else if (state == 3 && periodState == 2 && yearState == 9) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2015");
            yearState++;
        } else if (state == 3 && periodState == 2 && yearState == 10) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2016");
            yearState++;
        } else if (state == 3 && periodState == 2 && yearState == 11) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2017");
            yearState++;
        } else if (state == 3 && periodState == 2 && yearState == 12) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2018");
            yearState++;
        } else if (state == 3 && periodState == 2 && yearState == 13) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2019");
            yearState++;
        } else if (yearState > 13) {
            yearState = 0;
        }

        /**
         * Set a month for the end period
         */
        else if (state == 3 && periodState == 3 && monthState == 0) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 1");
            monthState++;
        } else if (state == 3 && periodState == 3 && monthState == 1) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 2");
            monthState++;
        } else if (state == 3 && periodState == 3 && monthState == 2) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 3");
            monthState++;
        } else if (state == 3 && periodState == 3 && monthState == 3) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 4");
            monthState++;
        } else if (state == 3 && periodState == 3 && monthState == 4) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 5");
            monthState++;
        } else if (state == 3 && periodState == 3 && monthState == 5) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 6");
            monthState++;
        } else if (state == 3 && periodState == 3 && monthState == 6) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 7");
            monthState++;
        } else if (state == 3 && periodState == 3 && monthState == 7) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 8");
            monthState++;
        } else if (state == 3 && periodState == 3 && monthState == 8) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 9");
            monthState++;
        } else if (state == 3 && periodState == 3 && monthState == 9) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 10");
            monthState++;
        } else if (state == 3 && periodState == 3 && monthState == 10) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 11");
            monthState++;
        } else if (state == 3 && periodState == 3 && monthState == 11) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 12");
            monthState++;
        } else if (monthState > 11) {
            monthState = 1;
        }

        /**
         * Set a day for the end period
         */
        else if (state == 3 && periodState == 4 && dayState == 0) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 1");
            dayState++;
        } else if (state == 3 && periodState == 4 && dayState == 1) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 2");
            dayState++;
        } else if (state == 3 && periodState == 4 && dayState == 2) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 3");
            dayState++;
        } else if (state == 3 && periodState == 4 && dayState == 3) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 4");
            dayState++;
        } else if (state == 3 && periodState == 4 && dayState == 4) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 5");
            dayState++;
        } else if (state == 3 && periodState == 4 && dayState == 5) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 6");
            dayState++;
        } else if (state == 3 && periodState == 4 && dayState == 6) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 7");
            dayState++;
        } else if (state == 3 && periodState == 4 && dayState == 7) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 8");
            dayState++;
        } else if (state == 3 && periodState == 4 && dayState == 8) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 9");
            dayState++;
        } else if (state == 3 && periodState == 4 && dayState == 9) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 10");
            dayState++;
        } else if (state == 3 && periodState == 4 && dayState == 10) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 11");
            dayState++;
        } else if (state == 3 && periodState == 4 && dayState == 11) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 12");
            dayState++;
        } else if (state == 3 && periodState == 4 && dayState == 12) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 13");
            dayState++;
        } else if (state == 3 && periodState == 4 && dayState == 13) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 14");
            dayState++;
        } else if (state == 3 && periodState == 4 && dayState == 14) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 15");
            dayState++;
        } else if (state == 3 && periodState == 4 && dayState == 15) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 16");
            dayState++;
        } else if (state == 3 && periodState == 4 && dayState == 16) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 17");
            dayState++;
        } else if (state == 3 && periodState == 4 && dayState == 17) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 18");
            dayState++;
        } else if (state == 3 && periodState == 4 && dayState == 18) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 19");
            dayState++;
        } else if (state == 3 && periodState == 4 && dayState == 19) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 20");
            dayState++;
        } else if (state == 3 && periodState == 4 && dayState == 20) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 21");
            dayState++;
        } else if (state == 3 && periodState == 4 && dayState == 21) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 22");
            dayState++;
        } else if (state == 3 && periodState == 4 && dayState == 22) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 23");
            dayState++;
        } else if (state == 3 && periodState == 4 && dayState == 23) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 24");
            dayState++;
        } else if (state == 3 && periodState == 4 && dayState == 24) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 25");
            dayState++;
        } else if (state == 3 && periodState == 4 && dayState == 25) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 26");
            dayState++;
        } else if (state == 3 && periodState == 4 && dayState == 26) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 27");
            dayState++;
        } else if (state == 3 && periodState == 4 && dayState == 27) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 28");
            dayState++;
        } else if (state == 3 && periodState == 4 && dayState == 28) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 29");
            dayState++;
        } else if (state == 3 && periodState == 4 && dayState == 29) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 30");
            dayState++;
        } else if (state == 3 && periodState == 4 && dayState == 30) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 31");
            dayState++;
        } else if (dayState > 30)
            dayState = 0;


        /**
         * Scroll through the predefined calculations
        */
        else if(state ==2&&menuState ==2&&preDefState ==1) {
            HelperFunctions.ClearMatrixDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Mist calculation");
            preDefState++;
        } else if(state ==2&&menuState ==2&&preDefState ==2) {
            HelperFunctions.ClearMatrixDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Max rain calculation");
            preDefState++;
        } else if(state ==2&&menuState ==2&&preDefState ==3) {
            HelperFunctions.ClearMatrixDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Crossing temperature");
            preDefState++;
        } else if(state ==2&&menuState ==2&&preDefState ==4) {
            HelperFunctions.ClearMatrixDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Degreedays" +
                "\n calculation");
            preDefState++;
        } else if(state ==2&&menuState ==2&&preDefState ==5) {
            HelperFunctions.ClearMatrixDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Rising temperature" +
                "\n duration");
            preDefState++;
        } else if(preDefState >5) {
            preDefState = 1;
    }

        /*
        /**
         * Exit settings menu
         */
        /*if (state == 0 && menuState == 3) {

        }

        /**
         * Shut down GUI
         */
        /*if (state == 0 && menuState == 4) {
            HelperFunctions.ClearMatrixDisplay();
            HelperFunctions.WriteOnMatrixScreen("Shut Down? (press red button");
        }*/
    //m_menu.DrawMenu();}
    }

    protected void OnButtonRed() {
        //runs when red button is pressed(runs once, its an actual bu)
        /**
         * When pressed on the red button, the state is changed into 1. This opens up a new "menu" to select year, month and day,
         * seperated by a click on the red button
         */
        if (menuState == 1 && periodState == 0) {
            state = 1;
            periodState = 1;
            HelperFunctions.ClearTextDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Choose a begin year: ");
        } else if (menuState == 1 && state == 1 && periodState == 1) {
            beginYear = 2005 + yearState;
            HelperFunctions.ClearTextDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Choose a begin month: ");
            periodState++;
        } else if (menuState == 1 && state == 1 && periodState == 2) {
            beginMonth = monthState;
            HelperFunctions.ClearTextDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Choose a begin day: ");
            periodState++;
        } else if (menuState == 1 && state == 1 && periodState == 3) {
            beginDay = dayState;
            Period beginPeriod = new Period();
            beginPeriod.setStart(beginYear, beginMonth, beginDay);
            HelperFunctions.ClearTextDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Chosen begin period: " + beginYear +", " + beginMonth + ", " + beginDay);
            state = 3;
            periodState = 1;
        } else if (menuState == 1 && state == 3 && periodState == 1){
            //resets year to 2006, month to 1, day to 1. Maybe better to keep counting from the last year, month, and day input?
            //(that is what is happening now)
            //yearState = 0;
            //monthState = 1;
            //dayState = 1;
            HelperFunctions.ClearTextDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Choose an end year: ");
            periodState++;
        } else if (menuState == 1 && state == 3 && periodState == 2) {
            endYear = 2005 + yearState;
            HelperFunctions.ClearTextDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Choose an end month: ");
            periodState++;
        } else if (menuState == 1 && state == 3 && periodState == 3){
            endMonth = monthState;
            HelperFunctions.ClearTextDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Choose an end day: ");
            periodState++;
        } else if (menuState == 1 && state == 3 && periodState == 4){
            HelperFunctions.ClearTextDisplay();
            endDay = dayState;
            Period endPeriod = new Period();
            endPeriod.setEnd(endYear, endMonth, endDay);
            //RawMeasurement rawData = new RawMeasurement();
            //Measurement measurement = new Measurement(rawData);
            HelperFunctions.ClearTextDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Chosen end period: " + "\n " + endYear + ", " + endMonth + ", " + endDay);
        }

        /**
         * When pressed on the red button, it opens up a new menu to scroll through the predefined calculations (individual assignments)
         */
        else if (state == 0 && menuState == 2) {
            preDefState = 1;
            state = 2;
            HelperFunctions.ClearTextDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Options: ");
        } else if (state == 2 && preDefState == 2){
            Period chunk = new Period(365);
            int mist = chunk.getDataStorage().getMist();
            String mistResult = Integer.toString(mist);
            HelperFunctions.ClearTextDisplay();
            String mistText = " days with chance of mist";
            HelperFunctions.WriteOnMatrixScreen("\n" + mistResult + mistText);
        } else if (state == 2 && preDefState == 3) {
            //RawMeasurement rawData = DatabaseConnection.getMostRecentMeasurement();
            //Measurement measurement = new Measurement(rawData);
            Calculations.MaxRain();
        } else if (state == 2 && preDefState == 4) {
            ArrayList<RawMeasurement> rawData = DatabaseConnection.getMeasurementsLastMonth();
            ArrayList<Measurement> measurement = new ArrayList<Measurement>();
            for (int i = 0; i < rawData.size(); i++) {
                measurement.add(new Measurement(rawData.get(i)));
            }
            HelperFunctions.ClearTextDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Amount of times crossed: " + Calculations.tempChange(measurement));
        } else if (state == 2 && preDefState == 5) {
            ArrayList<RawMeasurement> rawData = DatabaseConnection.getMeasurementsLastYear();
            ArrayList<Measurement> measurement = new ArrayList<Measurement>();
            for (int i = 0; i < rawData.size(); i++) {
                measurement.add(new Measurement(rawData.get(i)));
            }
            HelperFunctions.ClearTextDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Amount of degreedays last year: " + Calculations.calculateDegreeDays(measurement));
        } else if (state == 2 && preDefState == 6) {
            ArrayList<RawMeasurement> rawData = DatabaseConnection.getMeasurementsLastMonth();
            ArrayList<Measurement> measurement = new ArrayList<Measurement>();
            for (int i = 0; i < rawData.size(); i++) {
                measurement.add(new Measurement(rawData.get(i)));
            }
            HelperFunctions.ClearTextDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Temeperature rising: " + Calculations.risingTemperatureDuration(measurement));
        }

        /**
         * When pressed, the settings menu should revert to the tab with the current weather information
         */
        else if(state ==0 && menuState ==3){
            HelperFunctions.ClearMatrixDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Press first blue button to o back to the first tab");
        }
        /**
         * When pressed, the GUI should quit
         */
        else if (state == 0 && menuState == 4) {
            HelperFunctions.ClearMatrixDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Goodbye!");
            //IO.delay(500);
            //m_menu.m_
        }
    }
}



