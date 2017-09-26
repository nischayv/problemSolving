package Recursion;

public class PaintFill {

    public static boolean paintFill(int[][] screen, int r, int c, int oldColor, int newColor){
        if(r < 0 || r > screen.length || c < 0 || c > screen[0].length) {
            return false;
        }

        if (screen[r][c] == oldColor){
            screen[r][c] = newColor;
            paintFill(screen, r+1, c, oldColor, newColor);
            paintFill(screen, r-1, c, oldColor, newColor);
            paintFill(screen, r, c+1, oldColor, newColor);
            paintFill(screen, r, c-1, oldColor, newColor);
        }
        return true;
    }
}
