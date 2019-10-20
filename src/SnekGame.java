public class SnekGame extends RunnableObject
{
    Program m_program;
    GridNode[][] m_nodeGrid;
    PixelGrid m_pixelGrid;
    PixelGridDrawer m_Drawer;
    Snek m_snek;

    protected SnekGame(Program program, boolean usesInput, boolean usesMain, boolean usesRenderer, boolean startsActivated) {
        super(program, usesInput, usesMain, usesRenderer, startsActivated);
        m_program = program;
    }

    @Override
    protected void Start() {
        super.Start();

        HelperFunctions.ClearAll();

        m_nodeGrid = new GridNode[32][128];
        m_pixelGrid = new PixelGrid();
        m_snek = new Snek(this);
        m_Drawer = PixelGridDrawer.INSTANCE;
        m_Drawer.m_lastFrame = new boolean[32][128];

        for (int i = 0; i < m_nodeGrid.length; i++) {
            for (int j = 0; j < m_nodeGrid[0].length; j++) {
                if(i == 0 || j == 0 || i == m_nodeGrid.length-1 || j == m_nodeGrid[0].length-1)
                {
                    m_nodeGrid[i][j] = new GridNode();
                    m_nodeGrid[i][j].m_obstructed = true;
                    m_pixelGrid.PixelGrid[i][j] = true;
                }
            }
        }
    }

    @Override
    protected void InputLoop(double deltaTime) {
    }

    @Override
    protected void MainLoop(double deltaTime) {
    }

    @Override
    protected void RenderLoop(double deltaTime) {
        m_Drawer.Draw(m_pixelGrid.PixelGrid);
        //System.out.println("draw");
    }

    @Override
    protected void Destroy() {
        super.Destroy();
    }

    @Override
    protected void Awake() {
        super.Awake();

        HelperFunctions.ClearAll();

        HelperFunctions.WriteOnMatrixScreen("\n        SNEK");

        //a lazy way to make a delay to show the title a little longer
        try
        {
            Thread.sleep(3000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }

        this.Start();
    }
}

