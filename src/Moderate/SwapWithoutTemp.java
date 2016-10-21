package Moderate;

import java.util.Scanner;

/**
 * Cracking the Coding Interview add without plus
 */
public class SwapWithoutTemp {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
//        Easy Solution
//        a = a + b;
//        b = a - b;
//        a = a - b;

//      Works for other datatypes as well
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a: " + a + " b: " + b);
    }
}
