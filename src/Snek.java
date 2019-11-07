public class Snek {

    public Direction SnekDirection;
    public int SnekXpos;
    public int SnekYpos;
    public int SnekLenght;

    public Snek()
    {

    }

    public Snek(SnekGame game, int xStartPos,int yStartPos)
    {
        SnekLenght = 0;
        SnekXpos = xStartPos;
        SnekYpos = yStartPos;
        SnekDirection = Direction.UP;
    }

    public void OnBlueButtonOne()
    {
        switch (SnekDirection)
        {
            case UP:
                SnekDirection = Direction.LEFT;
                break;
            case LEFT:
                SnekDirection = Direction.DOWN;
                break;
            case DOWN:
                SnekDirection = Direction.RIGHT;
                break;
            case RIGHT:
                SnekDirection = Direction.UP;
                break;
        }
    }

    public void OnBlueButtonTwo()
    {
        switch (SnekDirection)
        {
            case UP:
                SnekDirection = Direction.RIGHT;
                break;
            case RIGHT:
                SnekDirection = Direction.DOWN;
                break;
            case DOWN:
                SnekDirection = Direction.LEFT;
                break;
            case LEFT:
                SnekDirection = Direction.UP;
                break;
        }

    }

}
