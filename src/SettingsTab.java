import java.time.LocalDate;

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

    int stepWidth = 0;
    boolean stepWidthAccord = true;

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
        } else if (state == 0 && menuState == 1){
            HelperFunctions.ClearTextDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Graph settings");
            menuState++;
            m_menu.DrawMenu();
        } else if (state == 0 && menuState == 2) {
            HelperFunctions.ClearMatrixDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Predefined");
            menuState++;
            m_menu.DrawMenu();
        } else if (state == 0 && menuState == 3) {
            HelperFunctions.ClearMatrixDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Exit settings");
            menuState++;
            m_menu.DrawMenu();
        } else if (state == 0 && menuState == 4) {
            HelperFunctions.ClearMatrixDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Shut down");
            menuState++;
            m_menu.DrawMenu();
        } else if (menuState > 4) {
            menuState = 0;
            HelperFunctions.ClearTextDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Settings: ");
            m_menu.DrawMenu();
        }

        /**
         * Set a year for the begin period
         */
        else if (state == 1 && periodState == 1 && yearState == 0) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2009");
            yearState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 1 && yearState == 1) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2010");
            yearState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 1 && yearState == 2) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2011");
            yearState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 1 && yearState == 3) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2012");
            yearState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 1 && yearState == 4) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2013");
            yearState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 1 && yearState == 5) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2014");
            yearState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 1 && yearState == 6) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2015");
            yearState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 1 && yearState == 7) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2016");
            yearState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 1 && yearState == 8) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2017");
            yearState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 1 && yearState == 9) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2018");
            yearState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 1 && yearState == 10) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2019");
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
            HelperFunctions.WriteOnMatrixScreen("\n Month: 1");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 2 && monthState == 1) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 2");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 2 && monthState == 2) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 3");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 2 && monthState == 3) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 4");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 2 && monthState == 4) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 5");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 2 && monthState == 5) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 6");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 2 && monthState == 6) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 7");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 2 && monthState == 7) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 8");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 2 && monthState == 8) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 9");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 2 && monthState == 9) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 10");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 2 && monthState == 10) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 11");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 2 && monthState == 11) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 12");
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
            HelperFunctions.WriteOnMatrixScreen("\n Day: 1");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 1) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 2");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 2) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 3");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 3) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 4");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 4) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 5");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 5) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 6");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 6) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 7");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 7) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 8");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 8) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 9");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 9) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 10");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 10) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 11");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 11) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 12");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 12) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 13");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 13) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 14");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 14) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 15");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 15) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 16");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 16) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 17");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 17) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 18");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 18) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 19");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 19) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 20");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 20) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 21");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 21) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 22");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 22) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 23");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 23) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 24");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 24) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 25");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 25) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 26");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 26) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 27");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 27) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 28");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 28) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 29");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 29) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 30");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 1 && periodState == 3 && dayState == 30) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 31");
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
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2009");
            yearState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 2 && yearState == 1) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2010");
            yearState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 2 && yearState == 2) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2011");
            yearState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 2 && yearState == 3) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 20012");
            yearState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 2 && yearState == 4) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2013");
            yearState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 2 && yearState == 5) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2014");
            yearState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 2 && yearState == 6) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2015");
            yearState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 2 && yearState == 7) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2016");
            yearState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 2 && yearState == 8) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2017");
            yearState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 2 && yearState == 9) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2018");
            yearState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 2 && yearState == 10) {
            HelperFunctions.WriteOnMatrixScreen("\n Year: 2019");
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
            HelperFunctions.WriteOnMatrixScreen("\n Month: 1");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 3 && monthState == 1) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 2");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 3 && monthState == 2) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 3");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 3 && monthState == 3) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 4");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 3 && monthState == 4) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 5");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 3 && monthState == 5) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 6");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 3 && monthState == 6) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 7");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 3 && monthState == 7) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 8");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 3 && monthState == 8) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 9");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 3 && monthState == 9) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 10");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 3 && monthState == 10) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 11");
            monthState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 3 && monthState == 11) {
            HelperFunctions.WriteOnMatrixScreen("\n Month: 12");
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
            HelperFunctions.WriteOnMatrixScreen("\n Day: 1");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 1) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 2");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 2) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 3");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 3) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 4");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 4) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 5");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 5) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 6");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 6) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 7");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 7) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 8");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 8) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 9");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 9) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 10");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 10) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 11");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 11) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 12");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 12) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 13");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 13) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 14");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 14) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 15");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 15) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 16");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 16) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 17");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 17) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 18");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 18) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 19");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 19) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 20");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 20) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 21");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 21) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 22");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 22) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 23");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 23) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 24");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 24) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 25");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 25) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 26");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 26) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 27");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 27) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 28");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 28) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 29");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 29) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 30");
            dayState++;
            m_menu.DrawMenu();
        } else if (state == 3 && periodState == 4 && dayState == 30) {
            HelperFunctions.WriteOnMatrixScreen("\n Day: 31");
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
            HelperFunctions.WriteOnMatrixScreen("\n Set graph step " +
                    "\n width: " + stepWidth);
            m_menu.DrawMenu();
            if (stepWidth == 0) {
                stepWidth = stepWidth + 1;
                HelperFunctions.ClearTextDisplay();
                HelperFunctions.WriteOnMatrixScreen("\n Set graph step " +
                        "\n width: " + stepWidth);
                m_menu.DrawMenu();
            }
            if (stepWidth > 50){
                stepWidth = stepWidth + 5;
                HelperFunctions.ClearTextDisplay();
                HelperFunctions.WriteOnMatrixScreen("\n Set graph step " +
                        "\n width: " + stepWidth);
                m_menu.DrawMenu();
            }
            if (stepWidth > 100){
                stepWidth = stepWidth + 10;
                HelperFunctions.ClearTextDisplay();
                HelperFunctions.WriteOnMatrixScreen("\n Set graph step " +
                        "\n width: " + stepWidth);
                m_menu.DrawMenu();
            }
            if (stepWidth > 200) {
                stepWidth = stepWidth + 30;
                HelperFunctions.ClearTextDisplay();
                HelperFunctions.WriteOnMatrixScreen("\n Set graph step " +
                        "\n width: " + stepWidth);
                m_menu.DrawMenu();
            }
            if (stepWidth > 500) {
                stepWidth = 0;
                SavedData.INSTANCE.SetGraphStep();
                HelperFunctions.ClearTextDisplay();
                HelperFunctions.WriteOnMatrixScreen("\n Set graph step " +
                        "\n width: auto");
                m_menu.DrawMenu();
            }
        }

        /**
         * Scroll through the predefined calculations
        */
        else if(state ==2&&menuState ==3&&preDefState ==1) {
            HelperFunctions.ClearMatrixDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Mist calculation");
            preDefState++;
            m_menu.DrawMenu();
        } else if(state ==2&&menuState ==3&&preDefState ==2) {
            HelperFunctions.ClearMatrixDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Max rain calculation");
            preDefState++;
            m_menu.DrawMenu();
        } else if(state ==2&&menuState ==3&&preDefState ==3) {
            HelperFunctions.ClearMatrixDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Crossing temperature");
            preDefState++;
            m_menu.DrawMenu();
        } else if(state ==2&&menuState ==3&&preDefState ==4) {
            HelperFunctions.ClearMatrixDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Degreedays" +
                "\n calculation");
            preDefState++;
            m_menu.DrawMenu();
        } else if(state ==2&&menuState ==3&&preDefState ==5) {
            HelperFunctions.ClearMatrixDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Rising temperature" +
                "\n duration");
            preDefState++;
            m_menu.DrawMenu();
        } else if(state == 2 && menuState == 3 && preDefState == 6){
            HelperFunctions.ClearTextDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Exit");
            preDefState++;
            m_menu.DrawMenu();
        } else if(preDefState > 6) {
            preDefState = 1;
            HelperFunctions.ClearTextDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Options: ");
            m_menu.DrawMenu();
        }

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
            m_menu.DrawMenu();
        } else if (menuState == 1 && state == 1 && periodState == 1) {
            beginYear = 2008 + yearState;
            if (beginYear == 2009){
                monthState = 6;
                beginYear = 2008 + yearState;
                HelperFunctions.ClearTextDisplay();
                HelperFunctions.WriteOnMatrixScreen("\n Choose a begin month: ");
                periodState++;
                m_menu.DrawMenu();
            } else {
                HelperFunctions.ClearTextDisplay();
                HelperFunctions.WriteOnMatrixScreen("\n Choose a begin month: ");
                periodState++;
                m_menu.DrawMenu();
            }
        } else if (menuState == 1 && state == 1 && periodState == 2) {
            beginMonth = monthState;
            HelperFunctions.ClearTextDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Choose a begin day: ");
            periodState++;
            m_menu.DrawMenu();
        } else if (menuState == 1 && state == 1 && periodState == 3) {
            beginDay = dayState;
            HelperFunctions.ClearTextDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Chosen begin period: " + beginYear +", " + beginMonth + ", " + beginDay);
            state = 3;
            periodState = 1;
            m_menu.DrawMenu();
        } else if (menuState == 1 && state == 3 && periodState == 1){
            yearState = beginYear;
            monthState = beginMonth -1;
            dayState = beginDay;
            HelperFunctions.ClearTextDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Choose an end year: ");
            periodState++;
            m_menu.DrawMenu();
        } else if (menuState == 1 && state == 3 && periodState == 2) {
            endYear = 2008 + yearState;
            HelperFunctions.ClearTextDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Choose an end month: ");
            periodState++;
            m_menu.DrawMenu();
        } else if (menuState == 1 && state == 3 && periodState == 3){
            endMonth = monthState;
            HelperFunctions.ClearTextDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Choose an end day: ");
            periodState++;
            m_menu.DrawMenu();
        } else if (menuState == 1 && state == 3 && periodState == 4){
            HelperFunctions.ClearTextDisplay();
            endDay = dayState;
            HelperFunctions.ClearTextDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Chosen end period: " + "\n " + endYear + ", " + endMonth + ", " + endDay);
            m_menu.DrawMenu();
            LocalDate startOfPeriod = LocalDate.of(beginYear, beginMonth, beginDay);
            LocalDate endOfPeriod = LocalDate.of(endYear, endMonth, endDay);
            SavedData.INSTANCE.SetPeriod(startOfPeriod,endOfPeriod);
            System.out.print(SavedData.INSTANCE.GetPeriod());
            state = 4;
        } else if (menuState == 1 && state == 4 && periodState == 4){
            state = 0;
            menuState = 0;
            periodState = 0;
            HelperFunctions.ClearTextDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Settings: ");
            m_menu.DrawMenu();
        }

        /**
         * Graph step setting
         */
        else if (state == 0 && menuState == 2){
            state = 5;
            stepWidthAccord = false;
            HelperFunctions.ClearTextDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Set graph step " +
                    "\n width: auto");
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
                HelperFunctions.WriteOnMatrixScreen("\n Settings: ");
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
            HelperFunctions.WriteOnMatrixScreen("\n Options: ");
            m_menu.DrawMenu();
        } else if (state == 2 && preDefState == 2){
            HelperFunctions.ClearTextDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Days with chance of " +
                    "\n mist: " + Calculations.mist(SavedData.INSTANCE.GetPeriod().getDataStorage().getPeriodMeasurements()));
            m_menu.DrawMenu();
            state = 0;
            menuState = 3;
        } else if (state == 2 && preDefState == 3) {
           // HelperFunctions.WriteOnMatrixScreen(Calculations.MaxRain(SavedData.INSTANCE.SavedPeriod.getDataStorage().getPeriodMeasurements()));
            Calculations.MaxRain();
            m_menu.DrawMenu();
            state = 0;
            menuState = 3;
        } else if (state == 2 && preDefState == 4) {
            HelperFunctions.ClearTextDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Amount of times " +
                    "\n crossed: " +
                    Calculations.tempChange(SavedData.INSTANCE.GetPeriod().getDataStorage().getPeriodMeasurements()));
            m_menu.DrawMenu();
            state = 0;
            menuState = 3;
        } else if (state == 2 && preDefState == 5) {
            HelperFunctions.ClearTextDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Amount of degreedays: " +
                    Calculations.calculateDegreeDays(SavedData.INSTANCE.GetPeriod().getDataStorage().getPeriodMeasurements()));
            m_menu.DrawMenu();
            state = 0;
            menuState = 3;
        } else if (state == 2 && preDefState == 6) {
            HelperFunctions.ClearTextDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Temeperature rising: " +
                    Calculations.risingTemperatureDuration(SavedData.INSTANCE.GetPeriod().getDataStorage().getPeriodMeasurements()));
            m_menu.DrawMenu();
            state = 0;
            menuState = 3;
        } else if (state == 2 && preDefState == 7){
            state = 0;
            menuState = 0;
            HelperFunctions.ClearTextDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Settings: ");
            m_menu.DrawMenu();
        }

        /**
         * When pressed, the settings menu should revert to the (first) tab with the current weather information
         */
        else if(state ==0 && menuState ==4){
            HelperFunctions.ClearMatrixDisplay();
            HelperFunctions.WriteOnMatrixScreen("\n Press first blue " +
                    "\n button to go back");
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