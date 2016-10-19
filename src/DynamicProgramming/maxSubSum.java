package DynamicProgramming;

import java.util.Scanner;

/**
 * Max Subsequence sum of array
 * Kadane's Algorithm
 * Printing the indices as well
 */
public class maxSubSum {

    public static void main(String args[]) {
        System.out.println("Enter the size of the array");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        System.out.println("Max sum is: " + maxSum(arr));
    }

    private static int maxSum(int[] arr) {
        int newsum = arr[0];
        int max = arr[0];
        int start = 0, end = 0;

        for(int i = 1; i < arr.length; i++){
            //newsum = Math.max(newsum + arr[i], arr[i]);
            if(newsum + arr[i] > arr[i]) {
                newsum += arr[i];
                end = i;
            }
            else {
                newsum = arr[i];
                start = i;
                end = i;
            }
            max = Math.max(max, newsum);
        }
        start += 1;
        end += 1;
        System.out.println("Start index: " + start + " End index: " + end);
        return max;
    }
}
