public class RunnableObject
{
    public boolean Active;
    public boolean Activated;
    public boolean ShouldDestruct;
    public boolean UsesInput;
    public boolean UsesMain;
    public boolean UsesRenderer;

    public Program m_program;

    protected RunnableObject(Program program)
    {
        this(program, true, true, true, true);
    }

    protected RunnableObject(Program program, boolean usesInput, boolean usesMain, boolean usesRenderer, boolean startsActivated) {
        m_program = program;
        UsesInput = usesInput;
        UsesMain = usesMain;
        UsesRenderer = usesRenderer;

        ShouldDestruct = false;

        if(startsActivated) {
            Active = true;
            Activated = true;
            AddToLoops();
        }
        else
        {
            Active = false;
            Activated = false;
        }

        program.Objects.add(this);

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

    protected void Awake()
    {

    }

    protected void RemoveFromLoops()
    {
        if (UsesInput)
        {
            m_program.InputObjects.remove(this);
        }
        if (UsesMain)
        {
            m_program.MainObjects.remove(this);
        }
        if (UsesRenderer)
        {
            m_program.RenderObjects.remove(this);
        }
    }

    protected void AddToLoops()
    {
        if (UsesInput)
        {
            m_program.InputObjects.add(this);
        }
        if (UsesMain)
        {
            m_program.MainObjects.add(this);
        }
        if (UsesRenderer)
        {
            m_program.RenderObjects.add(this);
        }
    }

    protected void Destroy()
    {
        RemoveFromLoops();
    }
}

