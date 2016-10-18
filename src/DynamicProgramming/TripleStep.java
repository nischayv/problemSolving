package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Cracking the Coding Interview Triple Step
 * Making use of memoization to improve time complexity
 */
public class TripleStep {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n+1];
        Arrays.fill(arr, -1);
        System.out.println("Number of ways: " + countPaths(n, arr));
    }

    private static int countPaths(int n, int[] arr) {
        if(n == 0) {
            return 1;
        }
        else if(n < 0) {
            return 0;
        }
        if(arr[n] == -1){
            arr[n] = countPaths(n-1, arr) + countPaths(n-2, arr) + countPaths(n-3, arr) ;
        }
        return arr[n];
    }
}
