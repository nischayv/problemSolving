package Misc;

/**
 * Find square root of a whole number without sqrt function
 */
public class SquareRoot {
    public static void main(String[] args) {
        System.out.println(squareRoot(1, 0, 1));
    }

    private static int squareRoot(int num, int start, int end) {
        int mid = (start+end)/2;
        int square = mid * mid;
        if(square == num) {
            return mid;
        }
        else if(square < num){
            return squareRoot(num, mid + 1, end);
        }
        else {
            return squareRoot(num, start, mid - 1);
        }
    }
}
