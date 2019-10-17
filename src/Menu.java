import java.util.ArrayList;

public class Menu extends RunableObject
{
    private PixelGrid m_pixelGrid;

    public int CurrentTabIndex = 0;
    public Tab CurrentTab;

    //list off all the tabs
    private ArrayList<Tab> m_tabs;

    public Callback onButtonBlueOneCall;
    public Callback onButtonBlueTwoCall;
    public Callback onButtonRedCall;

    private Button m_buttonBlueOne = new Button((short) 0x90);
    private Button m_buttonBlueTwo = new Button((short) 0x100);
    private Button m_buttonRed = new Button((short) 0x80);

    protected Menu(Program program, boolean usesInput, boolean usesMain, boolean usesRenderer) {
        super(program, usesInput, usesMain, usesRenderer);
    }

    @Override
    protected void Start() {
        super.Start();
        m_pixelGrid = new PixelGrid();
        m_tabs = new ArrayList<Tab>();
        m_tabs.add(new ExampleTab(this));
        m_tabs.add(new TabOutsideTemperature(this));
        CurrentTabIndex = 0;
        CurrentTab = m_tabs.get(CurrentTabIndex);
        CurrentTab.OnOpen();

    }

    @Override
    protected void InputLoop(double deltaTime) {
        CheckForButtonPress(m_buttonRed);
        CheckForButtonPress(m_buttonBlueOne);
        CheckForButtonPress(m_buttonBlueTwo);
    }

    @Override
    protected void MainLoop(double deltaTime) {
        CurrentTab.Run(deltaTime);
    }

    @Override
    protected void RenderLoop(double deltaTime) {

        //HelperFunctions.SetDisplayPixel(true,60,3);
        //draw stuff
    }


    /**
     * go to the next tab in the arraylist
     */
    private void NextTab()
    {
        CurrentTabIndex ++;
        if(CurrentTabIndex >= m_tabs.size())
        {
            CurrentTabIndex = 0;
        }
        JumpTab(CurrentTabIndex);
    }

    /**
     * jumpt to a specified tab in the arrayList
     * the also calls the close method on last tab and open method on the new tab
     * @param TabIndex the nr of the postion of the tab you want from the arrayList
     */
    private void JumpTab(int TabIndex)
    {
        CurrentTab.OnClose();
        CurrentTab = m_tabs.get(TabIndex);
        CurrentTab.OnOpen();
    }

    /**
     * the buttons in the gui are not buttons but switches, this will make the buttons behave as buttons.
     * the visual buttons still look like switches and will have to be changed later.
     * @param button give a button class with its respective address
     */
    private void CheckForButtonPress(Button button)
    {
        if ( IO.readShort(button.Address) != 0 && !button.On)
        {
            button.On = true;
            ButtonCall(button.Address);
        }
        else if ( IO.readShort(button.Address) == 0 && button.On)
        {
            button.On = false;
            ButtonCall(button.Address);
        }
    }

    /**
     * call the right action for the right button address
     * @param address the button address
     */
    private void ButtonCall(short address)
    {
        if(address == 0x80)
        {
            CurrentTab.OnButtonRed();
        }
        else if(address == 0x90)
        {
            NextTab();
        }
        else if(address == 0x100)
        {
            CurrentTab.OnButtonBlueTwo();
        }
    }

    public void DrawMenu() {
        for (int i = 0; i < m_pixelGrid.PixelGrid.length; i++) {
            for (int j = 0; j < m_pixelGrid.PixelGrid[0].length; j++) {
                if (i < 7) {
                    if (i == 6) {
                        HelperFunctions.SetDisplayPixel(true, j, i);
                    }
                    else if(j>(m_pixelGrid.PixelGrid[0].length/m_tabs.size())*CurrentTabIndex && j < (m_pixelGrid.PixelGrid[0].length/m_tabs.size())*(CurrentTabIndex+1))
                    {
                        HelperFunctions.SetDisplayPixel(true,j,i);
                    }
                    else if (j % (int) (m_pixelGrid.PixelGrid[0].length / m_tabs.size()) == 0) {
                        if (Math.abs(m_pixelGrid.PixelGrid[0].length - j) < 4) {
                            HelperFunctions.SetDisplayPixel(true, m_pixelGrid.PixelGrid[0].length - 1, i);
                        } else {
                            HelperFunctions.SetDisplayPixel(true, j, i);
                        }
                    }
                }
            }
        }

    }

    @Override
    protected void Destroy(Program program) {
        super.Destroy(program);
    }
}