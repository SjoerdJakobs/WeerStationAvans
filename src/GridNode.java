public class GridNode
{
    public boolean Obstructed;
    public boolean HasFood;

    public int XPos;
    public int YPos;

    public int IsInSnakeCounter;

    public GridNode()
    {
        IsInSnakeCounter = 0;
        Obstructed = false;
        HasFood = false;
    }
}
