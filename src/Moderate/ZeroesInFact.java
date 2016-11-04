package Moderate;

/**
 * Calculate Trailing zeroes in n factorial
 */
public class ZeroesInFact {

    public static  void main(String args[]) {
        System.out.println(countZeroes(125));
    }

    private static int countZeroes(int n) {
        if(n < 0) {
            return -1;
        }
        int count = 0;
        for(int i = 5; i <= n; i *= 5) {
            count += n/i;
        }
        return count;
    }
}
