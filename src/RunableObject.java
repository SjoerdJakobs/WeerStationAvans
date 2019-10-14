public class RunableObject
{
    public boolean ShouldDestruct;
    public boolean UsesInput;
    public boolean UsesMain;
    public boolean UsesRenderer;

    protected RunableObject(Program program)
    {
        this(program, true, true, true);
    }

    protected RunableObject(Program program, boolean usesInput, boolean usesMain, boolean usesRenderer) {
        UsesInput = usesInput;
        UsesMain = usesMain;
        UsesRenderer = usesRenderer;

        ShouldDestruct = false;

        program.Objects.add(this);

        if (UsesInput) {
            program.InputObjects.add(this);
        }
        if (UsesMain) {
            program.MainObjects.add(this);
        }
        if (UsesRenderer) {
            program.RenderObjects.add(this);
        }
        this.Start();
    }

    protected void InputLoop(double deltaTime)
    {

    }

    protected void MainLoop(double deltaTime)
    {

    }

    protected void RenderLoop(double deltaTime)
    {

    }

    protected void Start()
    {

    }

    protected void Destroy(Program program)
    {
        if (UsesInput)
        {
            program.InputObjects.remove(this);
        }
        if (UsesMain)
        {
            program.MainObjects.remove(this);
        }
        if (UsesRenderer)
        {
            program.RenderObjects.remove(this);
        }
    }
}

