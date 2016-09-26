/*
CafeWall.java created by Chris Carrillo for EGR222
This program displays grids of squares (Black & White)
after passing in the x & y start, the number of pairs,
the size, and the offset. The MORTAR adjusts the spacing.
 */

import java.awt.*;

public class CafeWall {

    // Sets the MORTAR (the spacing between the rows)
    public static final int MORTAR = 2;

    // Creates drawing panel and calls the drawRow and drawGrid methods to be displayed
    public static void main(String[] args) {
        DrawingPanel p = new DrawingPanel(650, 400);
        p.setBackground(Color.GRAY);
        Graphics g = p.getGraphics();

        drawRow(0, 0, 4, 20, g);
        drawRow(50, 70, 5, 30, g);
        drawGrid(10, 150, 4, 25, 0, g);
        drawGrid(250, 200, 3, 25, 10, g);
        drawGrid(425, 180, 5, 20, 10, g);
        drawGrid(400, 20, 2, 35, 35, g);
    }

    // draws the row according to the parameters passed in. for loop draws until reaching the # of pairs
    public static void drawRow(int x, int y, int n, int size, Graphics g) {
        for (int i = 1; i <= n; i++) {
            g.setColor(Color.BLACK);
            g.fillRect(x + ((i - 1) * size * 2), y, size, size);
            g.setColor(Color.BLUE);
            g.drawLine(x + ((i - 1) * size * 2), y, x + ((i - 1) * size * 2) + size, y + size);
            g.drawLine(x + ((i - 1) * size * 2), y + size, x + size + ((i - 1) * size * 2), y);
            g.setColor(Color.WHITE);
            g.fillRect(x + ((i - 1) * size * 2) + size, y, size, size);
        }
    }

    // draws the grid and offsets any rows if needed. the offset parameter shifts the row to the right
    public static void drawGrid(int x, int y, int numOfPairs, int size, int offset, Graphics g) {
        int s = 0;
        for (int line = 1; line <= numOfPairs; line++) {
            drawRow(x, y + s, numOfPairs, size, g);
            y += MORTAR;
            drawRow(x + offset, y + size + s, numOfPairs, size, g);
            y += MORTAR;
            s += size * 2;
        }
    }
}