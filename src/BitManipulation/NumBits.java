package BitManipulation;

/**
 * Count 1's in a number
 */
public class NumBits {

    private static int count(long n) {
        int count = 0;
        while(n != 0) {
            count += 1 & n;
            n >>= 1;
        }
        return count;
    }

    /**
     * Brian Kernighan’s Algorithm
     * Time Complexity : O(logn)
     */
    private static int countBits(long n) {
        int count = 0;
        while(n != 0) {
            n &= (n-1) ;
            count++;
        }
        return count;
    }
}
