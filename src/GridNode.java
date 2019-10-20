public class GridNode
{
    boolean m_obstructed;
    boolean m_hasFood;
    Direction direction;
    public GridNode()
    {
        m_obstructed = false;
        m_hasFood = false;
        direction = Direction.DEFAULT;
    }
}
