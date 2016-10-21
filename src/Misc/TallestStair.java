package Misc;

/**
 * Tallest stair in the staircase
 */
public class TallestStair {

    public static void main(String args[]) {
        calculate(8);
    }

    public static void calculate(int bricks) {
        double temp = Math.sqrt(1 + 4 * 2 * bricks);
        double root = (-1 +  temp) / (2) ;
        System.out.println((int) root);
    }
}
