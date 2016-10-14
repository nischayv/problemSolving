package ArraysAndLists;

import java.util.Scanner;

//Hackerrank Circular Array Rotation
public class CircularArrayRotation {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();
        int[] a = new int[n];
        k = k % n;

        for(int i = 0; i < n; i++){
            a[i] = in.nextInt();
        }

        for(int j = 0; j < q; j++){
            int m = in.nextInt();
            System.out.println(a[(n + m - k) % n]);
        }
    }
}
