
import java.util.ArrayList;

public class SettingsTab extends Tab {
    protected SettingsTab(Menu menu) {
        super(menu);
    }

    int state = 0;
    int menuState = 0;

    int periodState = 0;
    int yearState = 0;
    int monthState = 1;
    int dayState = 1;
    int year;
    int month;
    int day;

    int preDefState;
    int shutDownState;

    String text1 = "Set period";
    String text2 = "Predefined";
    String text3 = "Exit menu";
    String text4 = "Shut down";

    @Override
    protected void OnOpen() {
        //runs when tab is opened
        // show:
        // Period
        // Predefined
        // Exit menu
        // Shut down program
        HelperFunctions.ClearMatrixDisplay();
        HelperFunctions.WriteOnMatrixScreen("\n Settings");
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
        HelperFunctions.ClearMatrixDisplay();
        /**
         * Scroll through main menu
         */
        if (state == 0 && menuState == 0) {
            System.out.print("mS: "+ menuState);
            System.out.print("State: "+ state);
            HelperFunctions.ClearMatrixDisplay();
            HelperFunctions.WriteOnMatrixScreen(text1);
            menuState++;
        } else if (state == 0 && menuState == 1) {
            System.out.print("mS: "+menuState);
            System.out.print("State: "+ state);
            HelperFunctions.ClearMatrixDisplay();
            HelperFunctions.WriteOnMatrixScreen(text2);
            menuState++;
        } else if (state == 0 && menuState == 2) {
            System.out.print("mS: "+menuState);
            System.out.print("State: "+ state);
            HelperFunctions.ClearMatrixDisplay();
            HelperFunctions.WriteOnMatrixScreen(text3);
            menuState++;
        } else if (state == 0 && menuState == 3) {
            System.out.print("mS: "+ menuState);
            System.out.print("State: "+ state);
            HelperFunctions.ClearMatrixDisplay();
            HelperFunctions.WriteOnMatrixScreen(text4);
            menuState++;
        } else if (menuState > 3) {
            menuState = 0;
            System.out.print("State: "+ state);
            System.out.print(menuState);
        }

        /**
         * Set a year for the begin period
         */
        if (state == 1 && periodState == 0 && yearState == 0) {
            HelperFunctions.WriteOnMatrixScreen("Year: 2006");
            System.out.println("yS: " + yearState);
            yearState++;
        } else if (state == 1 && periodState == 0 && yearState == 1) {
            HelperFunctions.WriteOnMatrixScreen("Year: 2007");
            System.out.println("yS: " + yearState);

            yearState++;
        } else if (state == 1 && periodState == 0 && yearState == 2) {
            HelperFunctions.WriteOnMatrixScreen("Year: 2008");
            System.out.println("yS: " + yearState);
            yearState++;
        } else if (state == 1 && periodState == 0 && yearState == 3) {
            HelperFunctions.WriteOnMatrixScreen("Year: 2009");
            System.out.println("yS: " + yearState);
            yearState++;
        } else if (state == 1 && periodState == 0 && yearState == 4) {
            System.out.println("yS: " + yearState);
            HelperFunctions.WriteOnMatrixScreen("Year: 2010");
            yearState++;
        } else if (state == 1 && periodState == 0 && yearState == 5) {
            HelperFunctions.WriteOnMatrixScreen("Year: 2011");
            System.out.println("yS: " + yearState);
            yearState++;
        } else if (state == 1 && periodState == 0 && yearState == 6) {
            HelperFunctions.WriteOnMatrixScreen("Year: 2012");
            System.out.println("yS: " + yearState);
            yearState++;
        } else if (state == 1 && periodState == 0 && yearState == 7) {
            HelperFunctions.WriteOnMatrixScreen("Year: 2013");
            System.out.println("yS: " + yearState);
            yearState++;
        } else if (state == 1 && periodState == 0 && yearState == 8) {
            HelperFunctions.WriteOnMatrixScreen("Year: 2014");
            System.out.println("yS: " + yearState);
            yearState++;
        } else if (state == 1 && periodState == 0 && yearState == 9) {
            HelperFunctions.WriteOnMatrixScreen("Year: 2015");
            System.out.println("yS: " + yearState);
            yearState++;
        } else if (state == 1 && periodState == 0 && yearState == 10) {
            HelperFunctions.WriteOnMatrixScreen("Year: 2016");
            System.out.println("yS: " + yearState);
            yearState++;
        } else if (state == 1 && periodState == 0 && yearState == 11) {
            HelperFunctions.WriteOnMatrixScreen("Year: 2017");
            System.out.println("yS: " + yearState);
            yearState++;
        } else if (state == 1 && periodState == 0 && yearState == 12) {
            HelperFunctions.WriteOnMatrixScreen("Year: 2018");
            System.out.println("yS: " + yearState);
            yearState++;
        } else if (state == 1 && periodState == 0 && yearState == 13) {
            HelperFunctions.WriteOnMatrixScreen("Year: 2019");
            System.out.println("yS: " + yearState);
            yearState++;
        } else if (yearState > 13) {
                yearState = 0;
        }
        /**
         * Set a month for the begin period
         */
        else if (state == 1 && periodState == 1 && monthState == 1) {
            HelperFunctions.WriteOnMatrixScreen("Month: 1");
            System.out.print("mthS: "+ monthState);
            monthState++;
        } else if (state == 1 && periodState == 1 && monthState == 2) {
            HelperFunctions.WriteOnMatrixScreen("Month: 2");
            System.out.print("mthS: "+ monthState);
            monthState++;
        } else if (state == 1 && periodState == 1 && monthState == 3) {
            HelperFunctions.WriteOnMatrixScreen("Month: 3");
            System.out.print("mthS: "+ monthState);
            monthState++;
        } else if (state == 1 && periodState == 1 && monthState == 4) {
            HelperFunctions.WriteOnMatrixScreen("Month: 4");
            System.out.print("mthS: "+ monthState);
            monthState++;
        } else if (state == 1 && periodState == 1 && monthState == 5) {
            HelperFunctions.WriteOnMatrixScreen("Month: 5");
            System.out.print("mthS: "+ monthState);
            monthState++;
        } else if (state == 1 && periodState == 1 && monthState == 6) {
            HelperFunctions.WriteOnMatrixScreen("Month: 6");
            System.out.print("mthS: "+ monthState);
            monthState++;
        } else if (state == 1 && periodState == 1 && monthState == 7) {
            HelperFunctions.WriteOnMatrixScreen("Month: 7");
            System.out.print("mthS: "+ monthState);
            monthState++;
        } else if (state == 1 && periodState == 1 && monthState == 8) {
            HelperFunctions.WriteOnMatrixScreen("Month: 8");
            System.out.print("mthS: "+ monthState);
            monthState++;
        } else if (state == 1 && periodState == 1 && monthState == 9) {
            HelperFunctions.WriteOnMatrixScreen("Month: 9");
            System.out.print("mthS: "+ monthState);
            monthState++;
        } else if (state == 1 && periodState == 1 && monthState == 10) {
            HelperFunctions.WriteOnMatrixScreen("Month: 10");
            System.out.print("mthS: "+ monthState);
            monthState++;
        } else if (state == 1 && periodState == 1 && monthState == 11) {
            HelperFunctions.WriteOnMatrixScreen("Month: 11");
            System.out.print("mthS: "+ monthState);
            monthState++;
        } else if (state == 1 && periodState == 1 && monthState == 12) {
            HelperFunctions.WriteOnMatrixScreen("Month: 12");
            System.out.print("mthS: "+ monthState);
            monthState++;
        } else if (monthState > 12) {
            monthState = 1;
        }

        /**
         * Set a day for the begin period
         */
        else if (state == 1 && periodState == 2 && dayState == 1) {
            HelperFunctions.WriteOnMatrixScreen("Day: 1");
            dayState++;
        } else if (state == 1 && periodState == 2 && dayState == 2) {
            HelperFunctions.WriteOnMatrixScreen("Day: 2");
            dayState++;
        } else if (state == 1 && periodState == 2 && dayState == 3) {
            HelperFunctions.WriteOnMatrixScreen("Day: 3");
            dayState++;
        } else if (state == 1 && periodState == 2 && dayState == 4) {
            HelperFunctions.WriteOnMatrixScreen("Day: 4");
            dayState++;
        } else if (state == 1 && periodState == 2 && dayState == 5) {
            HelperFunctions.WriteOnMatrixScreen("Day: 5");
            dayState++;
        } else if (state == 1 && periodState == 2 && dayState == 6) {
            HelperFunctions.WriteOnMatrixScreen("Day: 6");
            dayState++;
        } else if (state == 1 && periodState == 2 && dayState == 7) {
            HelperFunctions.WriteOnMatrixScreen("Day: 7");
            dayState++;
        } else if (state == 1 && periodState == 2 && dayState == 8) {
            HelperFunctions.WriteOnMatrixScreen("Day: 8");
            dayState++;
        } else if (state == 1 && periodState == 2 && dayState == 9) {
            HelperFunctions.WriteOnMatrixScreen("Day: 9");
            dayState++;
        } else if (state == 1 && periodState == 2 && dayState == 10) {
            HelperFunctions.WriteOnMatrixScreen("Day: 10");
            dayState++;
        } else if (state == 1 && periodState == 2 && dayState == 11) {
            HelperFunctions.WriteOnMatrixScreen("Day: 11");
            dayState++;
        } else if (state == 1 && periodState == 2 && dayState == 12) {
            HelperFunctions.WriteOnMatrixScreen("Day: 12");
            dayState++;
        } else if (state == 1 && periodState == 2 && dayState == 13) {
            HelperFunctions.WriteOnMatrixScreen("Day: 13");
            dayState++;
        } else if (state == 1 && periodState == 2 && dayState == 14) {
            HelperFunctions.WriteOnMatrixScreen("Day: 14");
            dayState++;
        } else if (state == 1 && periodState == 2 && dayState == 15) {
            HelperFunctions.WriteOnMatrixScreen("Day: 15");
            dayState++;
        } else if (state == 1 && periodState == 2 && dayState == 16) {
            HelperFunctions.WriteOnMatrixScreen("Day: 16");
            dayState++;
        } else if (state == 1 && periodState == 2 && dayState == 17) {
            HelperFunctions.WriteOnMatrixScreen("Day: 17");
            dayState++;
        } else if (state == 1 && periodState == 2 && dayState == 18) {
            HelperFunctions.WriteOnMatrixScreen("Day: 18");
            dayState++;
        } else if (state == 1 && periodState == 2 && dayState == 19) {
            HelperFunctions.WriteOnMatrixScreen("Day: 19");
            dayState++;
        } else if (state == 1 && periodState == 2 && dayState == 20) {
            HelperFunctions.WriteOnMatrixScreen("Day: 20");
            dayState++;
        } else if (state == 1 && periodState == 2 && dayState == 21) {
            HelperFunctions.WriteOnMatrixScreen("Day: 21");
            dayState++;
        } else if (state == 1 && periodState == 2 && dayState == 22) {
            HelperFunctions.WriteOnMatrixScreen("Day: 22");
            dayState++;
        } else if (state == 1 && periodState == 2 && dayState == 23) {
            HelperFunctions.WriteOnMatrixScreen("Day: 23");
            dayState++;
        } else if (state == 1 && periodState == 2 && dayState == 24) {
            HelperFunctions.WriteOnMatrixScreen("Day: 24");
            dayState++;
        } else if (state == 1 && periodState == 2 && dayState == 25) {
            HelperFunctions.WriteOnMatrixScreen("Day: 25");
            dayState++;
        } else if (state == 1 && periodState == 2 && dayState == 26) {
            HelperFunctions.WriteOnMatrixScreen("Day: 26");
            dayState++;
        } else if (state == 1 && periodState == 2 && dayState == 27) {
            HelperFunctions.WriteOnMatrixScreen("Day: 27");
            dayState++;
        } else if (state == 1 && periodState == 2 && dayState == 28) {
            HelperFunctions.WriteOnMatrixScreen("Day: 28");
            dayState++;
        } else if (state == 1 && periodState == 2 && dayState == 29) {
            HelperFunctions.WriteOnMatrixScreen("Day: 29");
            dayState++;
        } else if (state == 1 && periodState == 2 && dayState == 30) {
            HelperFunctions.WriteOnMatrixScreen("Day: 30");
            dayState++;
        } else if (dayState > 30) {
            dayState = 0;
        }

        /**
         * Scroll through the predefined calculations
         */
        if (state == 0 && menuState == 1 && preDefState == 1) {
            HelperFunctions.ClearMatrixDisplay();
            HelperFunctions.WriteOnMatrixScreen("Mist calculation");
            System.out.print("preDefS: " + preDefState);
            preDefState++;
        } else if (state == 0 && menuState == 1 && preDefState == 2) {
            HelperFunctions.ClearMatrixDisplay();
            HelperFunctions.WriteOnMatrixScreen("Max rain calculation");
            System.out.print("preDefS: " + preDefState);
            preDefState++;
        } else if (state == 0 && menuState == 1 && preDefState == 3) {
            HelperFunctions.ClearMatrixDisplay();
            HelperFunctions.WriteOnMatrixScreen("Crossing temperatures");
            System.out.print("preDefS: " + preDefState);
            preDefState++;
        } else if (state == 0 && menuState == 1 && preDefState == 4) {
            HelperFunctions.ClearMatrixDisplay();
            HelperFunctions.WriteOnMatrixScreen("Degreedays calculation");
            System.out.print("preDefS: " + preDefState);
            preDefState++;
        } else if (state == 0 && menuState == 1 && preDefState == 5) {
            HelperFunctions.ClearMatrixDisplay();
            HelperFunctions.WriteOnMatrixScreen("Rising temperature duration");
            System.out.print("preDefS: " + preDefState);
            preDefState++;
        } else if (preDefState > 5) {
            preDefState = 1;
            System.out.print("preDefS: " + preDefState);
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
        //m_menu.DrawMenu();
    }

    protected void OnButtonRed() {
        //runs when red button is pressed(runs once, its an actual bu)
        /**
         * When pressed on the red button, the state is changed into 1. This opens up a new "menu" to select year, month and day,
         * seperated by a click on the red button
         */
        if (menuState == 1) {
            state = 1;
            System.out.print("State: "+ state);

        }
        if (state == 1 && periodState == 0) {
            year = 2006 + yearState;
            periodState++;
        } else if (state == 1 && periodState == 1) {
            month = monthState;
            periodState++;
        } else if (state == 1 && periodState == 2) {
            day = dayState;
            periodState++;

            Period beginPeriod = new Period();
            beginPeriod.setStart(year, month, day);
            periodState++;
        }


        /**
         * When pressed on the red button, it opens up a new menu to scroll through the predefined calculations (individual assignments)
         */
        if (state == 0 && menuState == 2) {
            preDefState = 1;
        }
        if (menuState == 2 && preDefState == 1){
            Period chunk = new Period(365);
            int mist = chunk.getDataStorage().getMist();
            String mistResult = Integer.toString(mist);
            String mistText = " \n Days with chance of mist";
            HelperFunctions.WriteOnMatrixScreen(mistResult + mistText);
        } else if (menuState == 2 && preDefState == 2) {
            //RawMeasurement rawData = DatabaseConnection.getMostRecentMeasurement();
            //Measurement measurement = new Measurement(rawData);
            Calculations.MaxRain();
        } else if (menuState == 2 && preDefState == 3) {
            ArrayList<RawMeasurement> rawData = DatabaseConnection.getMeasurementsLastMonth();
            ArrayList<Measurement> measurement = new ArrayList<Measurement>();
            for (int i = 0; i < rawData.size(); i++) {
                measurement.add(new Measurement(rawData.get(i)));
            }
            HelperFunctions.WriteOnMatrixScreen("\n Amount of times crossed: " + Calculations.tempChange(measurement));
        } else if (menuState == 2 && preDefState == 4) {
            ArrayList<RawMeasurement> rawData = DatabaseConnection.getMeasurementsLastYear();
            ArrayList<Measurement> measurement = new ArrayList<Measurement>();
            for (int i = 0; i < rawData.size(); i++) {
                measurement.add(new Measurement(rawData.get(i)));
            }
            HelperFunctions.WriteOnMatrixScreen("\n Amount of degreedaysCalculations last year: " + Calculations.calculateDegreeDays(measurement));
        } else if (menuState == 2 && preDefState == 5) {
            ArrayList<RawMeasurement> rawData = DatabaseConnection.getMeasurementsLastMonth();
            ArrayList<Measurement> measurement = new ArrayList<Measurement>();
            for (int i = 0; i < rawData.size(); i++) {
                measurement.add(new Measurement(rawData.get(i)));
            }
            HelperFunctions.WriteOnMatrixScreen("\n Temeperature rising: " + Calculations.risingTemperatureDuration(measurement));
        }

            /**
             * When pressed, the settings menu should revert to the tab with the current weather information
             */
            else if(state ==0 && menuState ==3){
                HelperFunctions.ClearMatrixDisplay();
                HelperFunctions.WriteOnMatrixScreen("Press first blue button");
            }

            /**
             * When pressed, the GUI should quit
             */
            else if (state == 0 && menuState == 4) {
                HelperFunctions.ClearMatrixDisplay();
                HelperFunctions.WriteOnMatrixScreen("Goodbye!");
                //IO.delay(500);
                //m_menu.m_
            }
        }

}
