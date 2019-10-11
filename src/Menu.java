import java.util.ArrayList;

public class Menu extends RunableObject
{
    int m_currentTab = 0;

    public  ArrayList<Tab> ParentTabs;


    public Callback onButtonBlueOneCall;
    public Callback onButtonBlueTwoCall;
    public Callback onButtonRedCall;

    protected Menu(Program program, boolean usesInput, boolean usesMain, boolean usesRenderer) {
        super(program, usesInput, usesMain, usesRenderer);

    }

    @Override
    protected void Start() {
        super.Start();

    }

    @Override
    protected void InputLoop(double deltaTime) {
    }

    @Override
    protected void MainLoop(double deltaTime) {

    }

    @Override
    protected void RenderLoop(double deltaTime) {

    }

    @Override
    protected void Destroy(Program program) {
        super.Destroy(program);
    }
}

