import java.time.LocalDate;

public class SettingsTab extends Tab {
    protected SettingsTab(Menu menu) {
        super(menu);
    }
    /**
     * all the variables used in the settingsTab
     * int state = overall state of the settings menu
     * int menuState = keeps count on which setting the user is on
     * int period state = keeps count on which period state (in the year, month, or day) the user is when setting a custom period
     * int year/month/day state = keeps count on which year/month/day the user is on
     * int beginYear/beginMonth/beginDay = the time period the user inserted for the first time
     * int endYear/endMonth/endDay = the time period the user inserted the second time
     * boolean redButtonPushed = dis/enables the red button when needed
     * int stepWidth = used for the stepWidth of the drawn points in the graphs
     * boolean stepWidthAccord = equals true if the user accepts the set stepWidth for the graphs
     * int preDefState = keeps count on which predefined (individual) assignment the user is on
     * m_menu.DrawMenu() = draws the menu balk on top
     */
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

    boolean redButtonPushed = true;

    int stepWidth = 0;
    boolean stepWidthAccord = true;

    int preDefState;

    @Override
    protected void OnOpen() {
        //runs when tab is opened
        HelperFunctions.ClearMatrixDisplay();
        m_menu.DrawMenu();
        HelperFunctions.WriteOnMatrixScreen("\nSettings: ");
    }

    @Override
    protected void OnClose() {
        HelperFunctions.ClearTextDisplay();
        state = 0;
        menuState = 0;
        //resets state and menuState, such that upon opening this tab with the left blue button, the user starts from the top again
        //instead of where they left off
        //runs when tab is closed
    }

    @Override
    protected void Run(double deltaTime) {
        //runs every frame when tab is opened
    }

    @Override
    protected void OnButtonBlueTwo() {
        HelperFunctions.ClearMatrixDisplay();
        redButtonPushed = true;
        /**
         * Scroll through main settings menu
         */
        if (state == 0 && menuState == 0) {
            HelperFunctions.ClearMatrixDisplay();
            HelperFunctions.WriteOnMatrixScreen("\nSet period");
            menuState++;
            m_menu.DrawMenu();
        } else if (state == 0 && menuState == 1){
            HelperFunctions.ClearTextDisplay();
            HelperFunctions.WriteOnMatrixScreen("\nGraph settings");
            menuState++;
            m_menu.DrawMenu();
        } else if (state == 0 && menuState == 2) {
            HelperFunctions.ClearMatrixDisplay();
            HelperFunctions.WriteOnMatrixScreen("\nPredefined");
            menuState++;
            m_menu.DrawMenu();
        } else if (state == 0 && menuState == 3) {
            HelperFunctions.ClearMatrixDisplay();
            HelperFunctions.WriteOnMatrixScreen("\nExit settings");
            menuState++;
            m_menu.DrawMenu();
        } else if (state == 0 && menuState == 4) {
            HelperFunctions.ClearMatrixDisplay();
            HelperFunctions.WriteOnMatrixScreen("\nShut down");
            menuState++;
            m_menu.DrawMenu();
        } else if (menuState > 4) {
            menuState = 0;
            HelperFunctions.ClearTextDisplay();
            HelperFunctions.WriteOnMatrixScreen("\nSettings: ");
            m_menu.DrawMenu();
        }

        /**
         * Set a year for the begin period
         */
        else if (state == 1 && periodState == 1 && yearState == 0) {
            HelperFunctions.WriteOnMatrixScreen("\nYear: 2009");
            yearState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 1 && yearState == 1) {
            HelperFunctions.WriteOnMatrixScreen("\nYear: 2010");
            yearState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 1 && yearState == 2) {
            HelperFunctions.WriteOnMatrixScreen("\nYear: 2011");
            yearState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 1 && yearState == 3) {
            HelperFunctions.WriteOnMatrixScreen("\nYear: 2012");
            yearState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 1 && yearState == 4) {
            HelperFunctions.WriteOnMatrixScreen("\nYear: 2013");
            yearState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 1 && yearState == 5) {
            HelperFunctions.WriteOnMatrixScreen("\nYear: 2014");
            yearState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 1 && yearState == 6) {
            HelperFunctions.WriteOnMatrixScreen("\nYear: 2015");
            yearState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 1 && yearState == 7) {
            HelperFunctions.WriteOnMatrixScreen("\nYear: 2016");
            yearState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 1 && yearState == 8) {
            HelperFunctions.WriteOnMatrixScreen("\nYear: 2017");
            yearState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 1 && yearState == 9) {
            HelperFunctions.WriteOnMatrixScreen("\nYear: 2018");
            yearState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 1 && yearState == 10) {
            HelperFunctions.WriteOnMatrixScreen("\nYear: 2019");
            yearState++;
            m_menu.DrawMenu();
        } else if (yearState > 10) {
            yearState = 0;
            m_menu.DrawMenu();
        }

        /**
         * Set a month for the begin period
         */
        else if (state == 1 && periodState == 2 && monthState == 0) {
            HelperFunctions.WriteOnMatrixScreen("\nMonth: 1");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 2 && monthState == 1) {
            HelperFunctions.WriteOnMatrixScreen("\nMonth: 2");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 2 && monthState == 2) {
            HelperFunctions.WriteOnMatrixScreen("\nMonth: 3");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 2 && monthState == 3) {
            HelperFunctions.WriteOnMatrixScreen("\nMonth: 4");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 2 && monthState == 4) {
            HelperFunctions.WriteOnMatrixScreen("\nMonth: 5");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 2 && monthState == 5) {
            HelperFunctions.WriteOnMatrixScreen("\nMonth: 6");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 2 && monthState == 6) {
            HelperFunctions.WriteOnMatrixScreen("\nMonth: 7");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 2 && monthState == 7) {
            HelperFunctions.WriteOnMatrixScreen("\nMonth: 8");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 2 && monthState == 8) {
            HelperFunctions.WriteOnMatrixScreen("\nMonth: 9");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 2 && monthState == 9) {
            HelperFunctions.WriteOnMatrixScreen("\nMonth: 10");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 2 && monthState == 10) {
            HelperFunctions.WriteOnMatrixScreen("\nMonth: 11");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 2 && monthState == 11) {
            HelperFunctions.WriteOnMatrixScreen("\nMonth: 12");
            monthState++;
            m_menu.DrawMenu();
        } else if (monthState > 11) {
            monthState = 0;
            m_menu.DrawMenu();
        }

        /**
         * Set a day for the begin period
         */
        else if (state == 1 && periodState == 3 && dayState == 0) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 1");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 1) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 2");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 2) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 3");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 3) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 4");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 4) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 5");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 5) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 6");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 6) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 7");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 7) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 8");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 8) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 9");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 9) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 10");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 10) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 11");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 11) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 12");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 12) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 13");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 13) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 14");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 14) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 15");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 15) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 16");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 16) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 17");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 17) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 18");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 18) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 19");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 19) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 20");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 20) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 21");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 21) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 22");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 22) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 23");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 23) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 24");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 24) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 25");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 25) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 26");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 26) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 27");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 27) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 28");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 28) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 29");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 29) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 30");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 30) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 31");
            dayState++;
            m_menu.DrawMenu();
        } else if (dayState > 30) {
            dayState = 0;
            m_menu.DrawMenu();
        }

        /**
         * Set a month for the end period
         */
        else if (state == 3 && periodState == 2 && yearState == 0) {
            HelperFunctions.WriteOnMatrixScreen("\nYear: 2009");
            yearState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 2 && yearState == 1) {
            HelperFunctions.WriteOnMatrixScreen("\nYear: 2010");
            yearState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 2 && yearState == 2) {
            HelperFunctions.WriteOnMatrixScreen("\nYear: 2011");
            yearState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 2 && yearState == 3) {
            HelperFunctions.WriteOnMatrixScreen("\nYear: 2012");
            yearState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 2 && yearState == 4) {
            HelperFunctions.WriteOnMatrixScreen("\nYear: 2013");
            yearState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 2 && yearState == 5) {
            HelperFunctions.WriteOnMatrixScreen("\nYear: 2014");
            yearState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 2 && yearState == 6) {
            HelperFunctions.WriteOnMatrixScreen("\nYear: 2015");
            yearState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 2 && yearState == 7) {
            HelperFunctions.WriteOnMatrixScreen("\nYear: 2016");
            yearState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 2 && yearState == 8) {
            HelperFunctions.WriteOnMatrixScreen("\nYear: 2017");
            yearState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 2 && yearState == 9) {
            HelperFunctions.WriteOnMatrixScreen("\nYear: 2018");
            yearState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 2 && yearState == 10) {
            HelperFunctions.WriteOnMatrixScreen("\nYear: 2019");
            yearState++;
            m_menu.DrawMenu();
        } else if (yearState > 10) {
            yearState = 0;
            m_menu.DrawMenu();
        }

        /**
         * Set a month for the end period
         */
        else if (state == 3 && periodState == 3 && monthState == 0) {
            HelperFunctions.WriteOnMatrixScreen("\nMonth: 1");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 3 && monthState == 1) {
            HelperFunctions.WriteOnMatrixScreen("\nMonth: 2");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 3 && monthState == 2) {
            HelperFunctions.WriteOnMatrixScreen("\nMonth: 3");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 3 && monthState == 3) {
            HelperFunctions.WriteOnMatrixScreen("\nMonth: 4");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 3 && monthState == 4) {
            HelperFunctions.WriteOnMatrixScreen("\nMonth: 5");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 3 && monthState == 5) {
            HelperFunctions.WriteOnMatrixScreen("\nMonth: 6");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 3 && monthState == 6) {
            HelperFunctions.WriteOnMatrixScreen("\nMonth: 7");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 3 && monthState == 7) {
            HelperFunctions.WriteOnMatrixScreen("\nMonth: 8");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 3 && monthState == 8) {
            HelperFunctions.WriteOnMatrixScreen("\nMonth: 9");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 3 && monthState == 9) {
            HelperFunctions.WriteOnMatrixScreen("\nMonth: 10");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 3 && monthState == 10) {
            HelperFunctions.WriteOnMatrixScreen("\nMonth: 11");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 3 && monthState == 11) {
            HelperFunctions.WriteOnMatrixScreen("\nMonth: 12");
            monthState++;
            m_menu.DrawMenu();
        } else if (monthState > 11) {
            monthState = 1;
            m_menu.DrawMenu();
        }

        /**
         * Set a day for the end period
         */
        else if (state == 3 && periodState == 4 && dayState == 0) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 1");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 1) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 2");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 2) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 3");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 3) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 4");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 4) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 5");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 5) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 6");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 6) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 7");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 7) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 8");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 8) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 9");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 9) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 10");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 10) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 11");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 11) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 12");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 12) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 13");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 13) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 14");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 14) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 15");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 15) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 16");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 16) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 17");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 17) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 18");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 18) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 19");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 19) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 20");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 20) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 21");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 21) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 22");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 22) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 23");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 23) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 24");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 24) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 25");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 25) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 26");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 26) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 27");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 27) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 28");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 28) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 29");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 29) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 30");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 30) {
            HelperFunctions.WriteOnMatrixScreen("\nDay: 31");
            dayState++;
            m_menu.DrawMenu();
        } else if (dayState > 30){
            dayState = 0;
        m_menu.DrawMenu();
        }

        /**
         * Graph step settings
         */
        else if (state == 5 && menuState == 2 && stepWidthAccord == false) {
            stepWidth = stepWidth + 5;
            HelperFunctions.ClearTextDisplay();
            HelperFunctions.WriteOnMatrixScreen("\nSet graph step " +
                    "\nwidth: " + stepWidth);
            m_menu.DrawMenu();
            if (stepWidth == 0) {
                stepWidth = stepWidth + 1;
                HelperFunctions.ClearTextDisplay();
                HelperFunctions.WriteOnMatrixScreen("\nSet graph step " +
                        "\nwidth: " + stepWidth);
                m_menu.DrawMenu();
            }
            if (stepWidth > 50){
                stepWidth = stepWidth + 5;
                HelperFunctions.ClearTextDisplay();
                HelperFunctions.WriteOnMatrixScreen("\nSet graph step " +
                        "\nwidth: " + stepWidth);
                m_menu.DrawMenu();
            }
            if (stepWidth > 100){
                stepWidth = stepWidth + 10;
                HelperFunctions.ClearTextDisplay();
                HelperFunctions.WriteOnMatrixScreen("\nSet graph step " +
                        "\nwidth: " + stepWidth);
                m_menu.DrawMenu();
            }
            if (stepWidth > 200) {
                stepWidth = stepWidth + 30;
                HelperFunctions.ClearTextDisplay();
                HelperFunctions.WriteOnMatrixScreen("\nSet graph step " +
                        "\nwidth: " + stepWidth);
                m_menu.DrawMenu();
            }
            if (stepWidth > 500) {
                stepWidth = 0;
                SavedData.INSTANCE.SetGraphStep();
                HelperFunctions.ClearTextDisplay();
                HelperFunctions.WriteOnMatrixScreen("\nSet graph step " +
                        "\nwidth: auto");
                m_menu.DrawMenu();
            }
        }

        /**
         * Scroll through the predefined (individual assignments) calculations
        */
        else if(state ==2&&menuState ==3&&preDefState ==1) {
            HelperFunctions.ClearMatrixDisplay();
            HelperFunctions.WriteOnMatrixScreen("\nMist calculation");
            preDefState++;
            m_menu.DrawMenu();
        } else if(state ==2&&menuState ==3&&preDefState ==2) {
            HelperFunctions.ClearMatrixDisplay();
            HelperFunctions.WriteOnMatrixScreen("\nMax rain calculation");
            preDefState++;
            m_menu.DrawMenu();
        } else if(state ==2&&menuState ==3&&preDefState ==3) {
            HelperFunctions.ClearMatrixDisplay();
            HelperFunctions.WriteOnMatrixScreen("\nCrossing temperature");
            preDefState++;
            m_menu.DrawMenu();
        } else if(state ==2&&menuState ==3&&preDefState ==4) {
            HelperFunctions.ClearMatrixDisplay();
            HelperFunctions.WriteOnMatrixScreen("\nDegreedays" +
                "\ncalculation");
            preDefState++;
            m_menu.DrawMenu();
        } else if(state ==2&&menuState ==3&&preDefState ==5) {
            HelperFunctions.ClearMatrixDisplay();
            HelperFunctions.WriteOnMatrixScreen("\nRising temperature" +
                "\nduration");
            preDefState++;
            m_menu.DrawMenu();
        } else if(state == 2 && menuState == 3 && preDefState == 6){
            HelperFunctions.ClearTextDisplay();
            HelperFunctions.WriteOnMatrixScreen("\nExit");
            preDefState++;
            m_menu.DrawMenu();
        } else if(preDefState > 6) {
            preDefState = 1;
            HelperFunctions.ClearTextDisplay();
            HelperFunctions.WriteOnMatrixScreen("\nOptions: ");
            m_menu.DrawMenu();
        }

    }

    protected void OnButtonRed() {
        //runs when red button is pressed(runs once, its an actual bu)
        /**
         * When pressed on the red button, the state is changed into 1. This opens up a new "menu" to select year, month and day,
         * seperated by a click on the red button
         */
        if (redButtonPushed){
            if (menuState == 1 && periodState == 0) {
                redButtonPushed = false;
                state = 1;
                periodState = 1;
                HelperFunctions.ClearTextDisplay();
                HelperFunctions.WriteOnMatrixScreen("\nChoose a begin year: ");
                m_menu.DrawMenu();

            } else if (menuState == 1 && state == 1 && periodState == 1) {
                redButtonPushed = false;
                beginYear = 2008 + yearState;
                if (beginYear == 2009){
                    monthState = 6;
                    beginYear = 2008 + yearState;
                    HelperFunctions.ClearTextDisplay();
                    HelperFunctions.WriteOnMatrixScreen("\nChoose a begin month: ");
                    periodState++;
                    m_menu.DrawMenu();
                } else {
                    HelperFunctions.ClearTextDisplay();
                    HelperFunctions.WriteOnMatrixScreen("\nChoose a begin month: ");
                    periodState++;
                    m_menu.DrawMenu();
                }
            } else if (menuState == 1 && state == 1 && periodState == 2) {
                redButtonPushed = false;
                beginMonth = monthState;
                HelperFunctions.ClearTextDisplay();
                HelperFunctions.WriteOnMatrixScreen("\nChoose a begin day: ");
                periodState++;
                m_menu.DrawMenu();
            } else if (menuState == 1 && state == 1 && periodState == 3) {
                beginDay = dayState;
                HelperFunctions.ClearTextDisplay();
                HelperFunctions.WriteOnMatrixScreen("\nChosen begin period: " + beginYear +", " + beginMonth + ", " + beginDay);
                state = 3;
                periodState = 1;
                //continue setting the desired period from the year, month and day that was put in for the begin period
                yearState = beginYear;
                monthState = beginMonth -1;
                dayState = beginDay;
                m_menu.DrawMenu();
            } else if (menuState == 1 && state == 3 && periodState == 1){
                redButtonPushed = false;
                HelperFunctions.ClearTextDisplay();
                HelperFunctions.WriteOnMatrixScreen("\nChoose an end year: ");
                periodState++;
                m_menu.DrawMenu();
            } else if (menuState == 1 && state == 3 && periodState == 2) {
                redButtonPushed = false;
                endYear = 2008 + yearState;
                HelperFunctions.ClearTextDisplay();
                HelperFunctions.WriteOnMatrixScreen("\nChoose an end month: ");
                periodState++;
                m_menu.DrawMenu();
            } else if (menuState == 1 && state == 3 && periodState == 3){
                redButtonPushed = false;
                endMonth = monthState;
                HelperFunctions.ClearTextDisplay();
                HelperFunctions.WriteOnMatrixScreen("\nChoose an end day: ");
                periodState++;
                m_menu.DrawMenu();
            } else if (menuState == 1 && state == 3 && periodState == 4){
                endDay = dayState;
                HelperFunctions.ClearTextDisplay();
                HelperFunctions.WriteOnMatrixScreen("\nChosen end period: " + "\n" + endYear + ", " + endMonth + ", " + endDay);
                m_menu.DrawMenu();
                //set a new dateStamp for the desired period of time
                LocalDate startOfPeriod = LocalDate.of(beginYear, beginMonth, beginDay);
                LocalDate endOfPeriod = LocalDate.of(endYear, endMonth, endDay);
                SavedData.INSTANCE.SetPeriod(startOfPeriod,endOfPeriod);
                state = 4;
            } else if (menuState == 1 && state == 4 && periodState == 4){
                //reset state, menuState to go back to main settings menu
                //reset yearState, monthState, dayState for the next time a period is set
                redButtonPushed = false;
                state = 0;
                menuState = 0;
                periodState = 0;
                yearState = 0;
                monthState = 1;
                dayState = 1;
                HelperFunctions.ClearTextDisplay();
                HelperFunctions.WriteOnMatrixScreen("\nSettings: ");
                m_menu.DrawMenu();
            }

            /**
             * Graph step setting
             */
            else if (state == 0 && menuState == 2){
                state = 5;
                stepWidthAccord = false;
                HelperFunctions.ClearTextDisplay();
                HelperFunctions.WriteOnMatrixScreen("\nSet graph step " +
                        "\nwidth: auto");
                m_menu.DrawMenu();
            } else if (state == 5 && menuState == 2 && stepWidthAccord == false){
                stepWidthAccord = true;
                if (state == 5 && menuState == 2 && stepWidthAccord ==true){
                    if (stepWidth != 0) SavedData.INSTANCE.SetGraphStep(stepWidth);
                    else SavedData.INSTANCE.SetGraphStep();
                    stepWidth = 0; // Reset stepWidth
                    state = 0;
                    menuState = 2;
                    HelperFunctions.ClearTextDisplay();
                    HelperFunctions.WriteOnMatrixScreen("\nSettings: ");
                    m_menu.DrawMenu();
                }
            }

            /**
             * When pressed on the red button, it opens up a new menu to scroll through the predefined calculations (individual assignments)
             */
            else if (state == 0 && menuState == 3) {
                preDefState = 1;
                state = 2;
                HelperFunctions.ClearTextDisplay();
                HelperFunctions.WriteOnMatrixScreen("\nOptions: ");
                m_menu.DrawMenu();
            } else if (state == 2 && preDefState == 2){
                HelperFunctions.ClearTextDisplay();
                HelperFunctions.WriteOnMatrixScreen("\nDays with chance of " +
                        "\nmist: " + Calculations.mist(SavedData.INSTANCE.GetPeriod().getDataStorage().getPeriodMeasurements()));
                m_menu.DrawMenu();
                state = 0; //reset state & menuState to go back to predefined options menu
                menuState = 3;
            } else if (state == 2 && preDefState == 3) {
                HelperFunctions.ClearTextDisplay();
                HelperFunctions.WriteOnMatrixScreen("\nMax rainfall in" +
                        "\nperiod: " +
                        String.format("%.2f", Calculations.MaxRain(SavedData.INSTANCE.GetPeriod().getDataStorage().getPeriodMeasurements())));
                m_menu.DrawMenu();
                state = 0;
                menuState = 3;
            } else if (state == 2 && preDefState == 4) {
                HelperFunctions.ClearTextDisplay();
                HelperFunctions.WriteOnMatrixScreen("\nAmount of times " +
                        "\ncrossed: " +
                        Calculations.tempChange(SavedData.INSTANCE.GetPeriod().getDataStorage().getPeriodMeasurements()));
                m_menu.DrawMenu();
                state = 0;
                menuState = 3;
            } else if (state == 2 && preDefState == 5) {
                HelperFunctions.ClearTextDisplay();
                HelperFunctions.WriteOnMatrixScreen("\nAmount of degreedays: " +
                        Calculations.calculateDegreeDays(SavedData.INSTANCE.GetPeriod().getDataStorage().getPeriodMeasurements()));
                m_menu.DrawMenu();
                state = 0;
                menuState = 3;
            } else if (state == 2 && preDefState == 6) {
                HelperFunctions.ClearTextDisplay();
                HelperFunctions.WriteOnMatrixScreen("\nTemperature rising: " +
                        Calculations.risingTemperatureDuration(SavedData.INSTANCE.GetPeriod().getDataStorage().getPeriodMeasurements()));
                m_menu.DrawMenu();
                state = 0;
                menuState = 3;
            } else if (state == 2 && preDefState == 7){
                state = 0; //reset state & menuState to go back to main setting menu
                menuState = 0;
                HelperFunctions.ClearTextDisplay();
                HelperFunctions.WriteOnMatrixScreen("\nSettings: ");
                m_menu.DrawMenu();
            }

            /**
             * When pressed, the settings menu should revert to the (first) tab with the current weather information
             */
            else if(state ==0 && menuState ==4){
                HelperFunctions.ClearMatrixDisplay();
                HelperFunctions.WriteOnMatrixScreen("\n Press first blue " +
                        "\n button to go forward");
                state = 0;
                menuState = 0;
                m_menu.DrawMenu();
            }
            /**
             * When pressed, the GUI should quit
             */
            else if (state == 0 && menuState == 5) {
                m_menu.DrawMenu();
                HelperFunctions.ClearMatrixDisplay();
                HelperFunctions.WriteOnMatrixScreen("\n Goodbye!");
                IO.delay(500);
                HelperFunctions.ClearTextDisplay();
                m_menu.m_program.ExitProgram();
            }
        }

    }
}