import java.util.ArrayList;
import java.util.Iterator;

public class Program
{
    private boolean run;

    ArrayList<RunableObject>Objects = new ArrayList<RunableObject>();
    ArrayList<RunableObject>InputObjects = new ArrayList<RunableObject>();
    ArrayList<RunableObject>MainObjects = new ArrayList<RunableObject>();
    ArrayList<RunableObject>RenderObjects = new ArrayList<RunableObject>();

    public Program()
    {
        Menu menu = new Menu(this, true ,true ,true);
    }

    public void Run() {

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

            for (RunableObject object : InputObjects) {
                object.InputLoop(deltaTime);
            }
            for (RunableObject object : MainObjects) {
                object.MainLoop(deltaTime);
            }
            for (RunableObject object : RenderObjects) {
                object.RenderLoop(deltaTime);
            }

            Iterator<RunableObject> it = Objects.iterator();
            while (it.hasNext()) {
                RunableObject ro = it.next();
                if (ro.ShouldDestruct) {
                    ro.Destroy(this);
                    it.remove();
                }
            }
        }
    }

    public void ExitProgram()
    {
        run = false;
    }
}

