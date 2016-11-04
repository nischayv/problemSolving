package DynamicProgramming;

import sun.security.util.Length;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Building diving board with k planks. Each plank can be short or long.
 * Find total number of different sizes of board. Dynamic programming.
 */
public class DivingBoard {
    public static void main(String args[]) {


    }

    /**
     * Solution 1: Recursive
     * Time Complexity: O(2^n)
     */
    private static void getAllLengths1(int n, int total, int shorter, int longer, HashSet<Integer> lengths) {
        if(n == 0) {
            lengths.add(total);
            return;
        }
        getAllLengths1(n - 1, total + shorter, shorter, longer, lengths);
        getAllLengths1(n - 1, total + longer, shorter, longer, lengths);
    }

    /**
     * Solution 2: Memoization
     * Time Complexity: O(n^2)
     */
    private static void getAllLengths2(int n, int total, int shorter, int longer, HashSet<Integer> lengths, HashSet<String> checked) {
        if(n == 0) {
            lengths.add(total);
            return;
        }
        String key = n + " " + total;
        if(checked.contains(key)) {
            return;
        }
        getAllLengths2(n - 1, total + shorter, shorter, longer, lengths, checked);
        getAllLengths2(n - 1, total + longer, shorter, longer, lengths, checked);
        checked.add(key);
    }

    /**
     * Solution 3: Since max k planks, and 2 to choose from, iterative approach
     * Time Complexity: O(n)
     */
    private static HashSet<Integer> getAllLengths3(int n, int shorter, int longer) {
        HashSet<Integer> lenghts = new HashSet<>();
        for(int i = 0; i <= n; i++) {
            int length = shorter * i + longer * (n-i);
            lenghts.add(length);
        }
        return lenghts;
    }


}
