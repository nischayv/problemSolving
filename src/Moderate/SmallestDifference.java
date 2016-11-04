package Moderate;

import java.util.Arrays;

/**
 * Given two arrays, calculate smallest pair (1 from each)
 */
public class SmallestDifference {

    public static void main(String args[]) {
        int a[] = {3, 7, 12, 1, 0, 81, -5};
        int b[] = {-10, 15, 3, 67, 10};
        System.out.println(minDifference(a, b));
    }

    private static int minDifference(int a[], int b[]) {
        Arrays.sort(a);
        Arrays.sort(b);
        int p1 = 0;
        int p2 = 0;
        int min = Integer.MAX_VALUE;

        while(p1 < a.length && p2 < b.length) {
            if(Math.abs(a[p1] - b[p2]) < min) {
                min = Math.abs(a[p1] - b[p2]);
            }

            if(a[p1] > b[p2]) {
                p2++;
            }
            else {
                p1++;
            }
        }
        return min;
    }
}
