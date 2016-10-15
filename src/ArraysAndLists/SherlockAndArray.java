package ArraysAndLists;

import java.util.Scanner;

/**
 * Hackerrrank Sherlock and Array
 */
public class SherlockAndArray {

    public static void main(String args[]) {
        Scanner s  = new Scanner(System.in);
        int cases = s.nextInt();

        for(int i = 0; i < cases; i++) {
            int n = s.nextInt();
            int leftSum = 0;
            int rightSum = 0;
            int[] arr = new int[n];
            boolean flag = false;

            for(int j = 0; j < n; j++) {
                arr[j] = s.nextInt();
                rightSum += arr[j];
            }

            for(int j = 0; j < n; j++) {
                rightSum -= arr[j];
                if(leftSum == rightSum) {
                    flag = true;
                    break;
                }
                leftSum += arr[j];
            }

            if(flag) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}
