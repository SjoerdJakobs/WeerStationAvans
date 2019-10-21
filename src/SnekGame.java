import java.util.ArrayList;
import java.util.Iterator;

public class SnekGame extends RunnableObject {

    Program m_program;
    GridNode[][] m_nodeGrid;
    PixelGrid m_pixelGrid;
    PixelGridDrawer m_Drawer;
    Snek m_snek;


    private Button m_buttonBlueOne = new Button((short) 0x90);
    private Button m_buttonBlueTwo = new Button((short) 0x100);
    private Button m_buttonRed = new Button((short) 0x80);

    double m_gameTickSpeed = 0.15;
    double m_gameTickTimer = 0.0;
    private int m_score = 0;

    ArrayList<GridNode> m_snekBody;

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
        m_snek = new Snek(this, 64, 16);
        m_Drawer = PixelGridDrawer.INSTANCE;
        m_Drawer.m_lastFrame = new boolean[32][128];


        for (int i = 0; i < m_nodeGrid.length; i++) {
            for (int j = 0; j < m_nodeGrid[0].length; j++) {
                m_nodeGrid[i][j] = new GridNode();
                m_nodeGrid[i][j].YPos = i;
                m_nodeGrid[i][j].XPos = j;
                if (i == 0 || j == 0 || i == m_nodeGrid.length - 1 || j == m_nodeGrid[0].length - 1) {
                    m_nodeGrid[i][j].Obstructed = true;
                    m_pixelGrid.PixelGrid[i][j] = true;
                } else {
                    m_nodeGrid[i][j].Obstructed = false;
                    m_pixelGrid.PixelGrid[i][j] = false;
                }
            }
        }
        m_snekBody = new ArrayList<GridNode>();
        MoveSnek(m_snek.SnekXpos, m_snek.SnekYpos, 1);

        m_score = 0;
        SpawnFood();
        SpawnFood();
        SpawnFood();
        SpawnFood();
    }

    @Override
    protected void InputLoop(double deltaTime) {
        CheckForButtonPress(m_buttonRed);
        CheckForButtonPress(m_buttonBlueOne);
        CheckForButtonPress(m_buttonBlueTwo);
    }

    @Override
    protected void MainLoop(double deltaTime) {
        m_gameTickTimer += deltaTime;
        if (m_gameTickTimer >= m_gameTickSpeed) {
            SnekMovement();
            m_Drawer.HardDraw(m_pixelGrid.PixelGrid);
            m_gameTickTimer = 0;
        }
    }

    @Override
    protected void RenderLoop(double deltaTime) {
        //m_Drawer.Draw(m_pixelGrid.PixelGrid);
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
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        this.Start();
    }

    private void SnekMovement() {
        switch (m_snek.SnekDirection) {
            case UP:
                if (m_nodeGrid[m_snek.SnekYpos + 1][m_snek.SnekXpos].Obstructed) {
                    OnDeath();
                    //ded
                } else if (m_nodeGrid[m_snek.SnekYpos + 1][m_snek.SnekXpos].HasFood) {
                    //add
                    SpawnFood();
                    m_score++;
                    m_snek.SnekYpos++;
                    MoveSnek(m_snek.SnekXpos, m_snek.SnekYpos, 1);
                } else {
                    //add
                    m_snek.SnekYpos++;
                    MoveSnek(m_snek.SnekXpos, m_snek.SnekYpos, 0);
                }
                break;

            case DOWN:
                if (m_nodeGrid[m_snek.SnekYpos - 1][m_snek.SnekXpos].Obstructed) {
                    OnDeath();
                    //ded
                } else if (m_nodeGrid[m_snek.SnekYpos - 1][m_snek.SnekXpos].HasFood) {
                    //add
                    SpawnFood();
                    m_score++;
                    m_snek.SnekYpos--;
                    MoveSnek(m_snek.SnekXpos, m_snek.SnekYpos, 1);
                } else {
                    //add
                    m_snek.SnekYpos--;
                    MoveSnek(m_snek.SnekXpos, m_snek.SnekYpos, 0);
                }
                break;
            case RIGHT:
                if (m_nodeGrid[m_snek.SnekYpos][m_snek.SnekXpos + 1].Obstructed) {
                    OnDeath();
                    //ded
                } else if (m_nodeGrid[m_snek.SnekYpos][m_snek.SnekXpos + 1].HasFood) {
                    //add
                    SpawnFood();
                    m_score++;
                    m_snek.SnekXpos++;
                    MoveSnek(m_snek.SnekXpos, m_snek.SnekYpos, 1);
                } else {
                    //add
                    m_snek.SnekXpos++;
                    MoveSnek(m_snek.SnekXpos, m_snek.SnekYpos, 0);
                }
                break;
            case LEFT:
                if (m_nodeGrid[m_snek.SnekYpos][m_snek.SnekXpos - 1].Obstructed) {
                    OnDeath();
                } else if (m_nodeGrid[m_snek.SnekYpos][m_snek.SnekXpos - 1].HasFood) {
                    //add
                    SpawnFood();
                    m_score++;
                    m_snek.SnekXpos--;
                    MoveSnek(m_snek.SnekXpos, m_snek.SnekYpos, 1);
                } else {
                    //add
                    m_snek.SnekXpos--;
                    MoveSnek(m_snek.SnekXpos, m_snek.SnekYpos, 0);
                }
                break;
        }
        HelperFunctions.WriteValueOnSegments(1, m_score, 0);
    }

    private void MoveSnek(int addXpos, int addYpos, int foodAmount) {
        m_snekBody.add(m_nodeGrid[addYpos][addXpos]);
        m_nodeGrid[addYpos][addXpos].Obstructed = true;
        m_nodeGrid[addYpos][addXpos].IsInSnakeCounter = m_snek.SnekLenght;
        m_pixelGrid.PixelGrid[addYpos][addXpos] = true;
        m_snek.SnekLenght += foodAmount;

        Iterator<GridNode> it = m_snekBody.iterator();
        while (it.hasNext()) {
            GridNode gn = it.next();
            gn.IsInSnakeCounter += foodAmount;
            if (gn.IsInSnakeCounter <= 0) {
                gn.Obstructed = false;
                m_pixelGrid.PixelGrid[gn.YPos][gn.XPos] = false;
                it.remove();
            } else {
                gn.IsInSnakeCounter--;
            }
        }
    }

    public void SpawnFood() {
        int y = 1 + (int) (Math.random() * (32 - 1));
        int x = 1 + (int) (Math.random() * (128 - 1));
        System.out.println(x + " " + y);
        m_nodeGrid[y][x].HasFood = true;
        m_pixelGrid.PixelGrid[y][x] = true;
    }

    public void OnDeath() {
        HelperFunctions.WriteOnMatrixScreen("       DED SNEK\n    Score: " + m_score);

        //a lazy way to make a delay to show the title a little longer
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        m_program.SwitchRunables();
    }

    /**
     * I know this code is in the menu class too and that i should write a input handler but life happened and I had to cut some corners
     */
    private void CheckForButtonPress(Button button) {
        if (IO.readShort(button.Address) != 0 && !button.On) {
            button.On = true;
            ButtonCall(button.Address);
        } else if (IO.readShort(button.Address) == 0 && button.On) {
            button.On = false;
            ButtonCall(button.Address);
        }
    }

    private void ButtonCall(short address) {
        if (address == 0x80) {
            //CurrentTab.OnButtonRed();
            m_program.SwitchRunables();

        } else if (address == 0x90) {
            m_snek.OnBlueButtonTwo();

        } else if (address == 0x100) {
            m_snek.OnBlueButtonOne();
        }
    }
}

