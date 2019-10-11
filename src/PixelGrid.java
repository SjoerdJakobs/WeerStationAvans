public class PixelGrid
{
    public boolean[][] PixelGrid = new boolean[32][128];

    boolean EqualsToGrid(PixelGrid otherGrid)
    {
        if(this.PixelGrid.length != otherGrid.PixelGrid.length || this.PixelGrid[0].length != otherGrid.PixelGrid[0].length)
        {
            return false;
        }
        for(int i = 0; i < this.PixelGrid.length; i++)
        {
            for(int j = 0; j < this.PixelGrid[0].length; j++)
            {
                if(this.PixelGrid[i][j] != otherGrid.PixelGrid[i][j])
                {
                    return false;
                }
            }
        }
        return true;
    }

    public void XorGrid(PixelGrid otherGrid) {
        for (int i = 0; i < this.PixelGrid.length; i++) {
            for (int j = 0; j < this.PixelGrid[0].length; j++) {
                this.PixelGrid[i][j] = (this.PixelGrid[i][j] || otherGrid.PixelGrid[i][j]) && (this.PixelGrid[i][j] != otherGrid.PixelGrid[i][j]);
            }
        }
    }

    public void OrGrid(PixelGrid otherGrid) {
        for (int i = 0; i < this.PixelGrid.length; i++) {
            for (int j = 0; j < this.PixelGrid[0].length; j++) {
                this.PixelGrid[i][j] = this.PixelGrid[i][j] || otherGrid.PixelGrid[i][j];
            }
        }
    }

    public void AndGrid(PixelGrid otherGrid) {
        for (int i = 0; i < this.PixelGrid.length; i++) {
            for (int j = 0; j < this.PixelGrid[0].length; j++) {
                this.PixelGrid[i][j] = this.PixelGrid[i][j] && otherGrid.PixelGrid[i][j];
            }
        }
    }
}

