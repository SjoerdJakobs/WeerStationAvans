public enum PixelGridDrawer
{
        INSTANCE;

        public boolean[][] m_lastFrame = new boolean[32][128];
        public void Draw(boolean[][] newFrame)
        {
                for(int i = 0; i < newFrame.length; i++)
                {
                        for(int j = 0; j < newFrame[0].length; j++)
                        {
                                if(newFrame[i][j] != m_lastFrame[i][j])
                                {
                                        HelperFunctions.SetDisplayPixel(newFrame[i][j],j,i);
                                }
                        }
                }
                m_lastFrame = newFrame;
        }
}
