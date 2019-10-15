public class Tab
{
    Menu m_menu;
    protected Tab(Menu menu)
    {
        m_menu = menu;
    }

    protected void OnOpen()
    {
        m_menu.onButtonBlueTwoCall = () -> {
        OnButtonBlueTwo();
    };
        m_menu.onButtonRedCall = () -> {
            OnButtonRed();
        };
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

