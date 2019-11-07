import java.util.ArrayList;
import java.util.Iterator;

public class Program
{
    private boolean run;

    ArrayList<RunnableObject>Objects = new ArrayList<RunnableObject>();
    ArrayList<RunnableObject>InputObjects = new ArrayList<RunnableObject>();
    ArrayList<RunnableObject>MainObjects = new ArrayList<RunnableObject>();
    ArrayList<RunnableObject>RenderObjects = new ArrayList<RunnableObject>();

    SnekGame m_snek;
    Menu m_menu;

    public Program()
    {
    }

    public void Run() {

        IO.init();
        HelperFunctions.ClearAll();

        m_snek = new SnekGame(this,true,true,true,false);
        m_menu = new Menu(this, true ,true ,true, true);

        long lastTime = System.nanoTime();

        run = true;
        while (run) {


            /**
             * calculate deltatime
             */
            long time = System.nanoTime();
            double deltaTime = ((double)(time - lastTime) / 1000_000_000);//delta time in seconds
            lastTime = time;

            //uncomment to print the deltatime in seconds
            //String s = String.format("%.5f", deltaTime);
            //System.out.println(s);

            for (RunnableObject object : InputObjects) {
                object.InputLoop(deltaTime);
            }
            for (RunnableObject object : MainObjects) {
                object.MainLoop(deltaTime);
            }
            for (RunnableObject object : RenderObjects) {
                object.RenderLoop(deltaTime);
            }

            Iterator<RunnableObject> it = Objects.iterator();
            while (it.hasNext()) {
                RunnableObject ro = it.next();
                if (ro.ShouldDestruct) {
                    ro.Destroy();
                    it.remove();
                }
                else if(ro.Active && !ro.Activated)
                {
                    ro.AddToLoops();
                    ro.Activated = true;
                    ro.Awake();
                }
                else if(!ro.Active && ro.Activated)
                {
                    ro.RemoveFromLoops();
                    ro.Activated = false;
                }
            }
        }
    }

    public void ExitProgram()
    {
        HelperFunctions.ClearAll();
        run = false;
    }


    int m_codeStep = 0;
    public void DetectCode(int codeInput)
    {
        if(m_codeStep == 0 && codeInput == 0)
        {
            m_codeStep ++;
        }
        else if(m_codeStep == 1 && codeInput == 0)
        {
            m_codeStep ++;
        }
        else if(m_codeStep == 2 && codeInput == 1)
        {
            m_codeStep ++;
        }
        else if(m_codeStep == 3 && codeInput == 1)
        {
            m_codeStep ++;
        }
        else if(m_codeStep == 4 && codeInput == 0)
        {
            m_codeStep ++;
        }
        else if(m_codeStep == 5 && codeInput == 1)
        {
            m_codeStep ++;
        }
        else if(m_codeStep == 6 && codeInput == 0)
        {
            m_codeStep ++;
        }
        else if(m_codeStep == 7)
        {
            SwitchRunables();
            m_codeStep = 0;
        }
        else
        {
            m_codeStep = 0;
        }
        //System.out.println(m_codeStep);
    }
    public void SwitchRunables()
    {
        m_menu.Active = !m_menu.Active;
        m_snek.Active = !m_snek.Active;
    }
}

