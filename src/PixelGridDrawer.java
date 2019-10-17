public enum PixelGridDrawer
{
        INSTANCE_DRAWER;

        public boolean[][] m_lastFrame = new boolean[32][128];
        public void Draw(boolean[][] newFrame)
        {
                for(int i = 0; i < newFrame.length; i++) {
                        for (int j = 0; j < newFrame[0].length; j++) {
                                if (newFrame[i][j] != m_lastFrame[i][j]) {
                                        HelperFunctions.SetDisplayPixel(newFrame[i][j], j, i);
                                }
                        }
                }
                m_lastFrame = newFrame;
        }

        public void HardDraw(boolean[][] newFrame) {
                for (int i = 0; i < newFrame.length; i++) {
                        for (int j = 0; j < newFrame[0].length; j++) {
                                HelperFunctions.SetDisplayPixel(newFrame[i][j], j, i);
                        }
                }
                m_lastFrame = newFrame;
        }

        public void AddDraw(boolean[][] newFrame) {
                for (int i = 0; i < newFrame.length; i++) {
                        for (int j = 0; j < newFrame[0].length; j++) {
                                if (newFrame[i][j] == true) {
                                        HelperFunctions.SetDisplayPixel(newFrame[i][j], j, i);
                                }
                        }
                }
                m_lastFrame = newFrame;
        }

        public void SelectHardDraw(boolean[][] newFrame, int topBoundary, int rightBoundary, int bottomBoundary, int leftBoundary) {
                for (int i = topBoundary; i < bottomBoundary; i++) {
                        for (int j = leftBoundary; j < rightBoundary; j++) {
                                HelperFunctions.SetDisplayPixel(newFrame[i][j], j, i);
                        }
                }
                m_lastFrame = newFrame;
        }
}
