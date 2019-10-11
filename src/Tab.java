public class Tab
{
    Menu m_menu;
    protected Tab(Menu menu)
    {
        m_menu = menu;
        menu.onButtonBlueTwoCall = () -> {
            OnButtonBlueTwo();
        };
        menu.onButtonRedCall = () -> {
            OnButtonRed();
        };
    }

    protected void OnOpen()
    {
        //change screen
    }

    protected void OnClose()
    {

    }

    protected void OnButtonBlueTwo()
    {

    }
    protected void OnButtonRed()
    {

    }

    protected void Run(double deltaTime)
    {

    }
}

