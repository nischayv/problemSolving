package Moderate;

/**
 * Find max of two numbers without if else or any operators
 */
public class NumberMax {

    public static void main(String args[]) {
        System.out.println(max(-5, 10));
    }

    private static int max(int a, int b) {
        int c = a - b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);

        int use_sign_of_a = sa ^ sb;
        int user_sign_of_c = flip(use_sign_of_a);
        int k = use_sign_of_a * sa + user_sign_of_c * sc;
        int q = flip(k);

        return a*k + b*q;
    }


    /**
     * Flip 1 to 0 and 0 to 1
     */
    private static int flip(int bit) {
        return 1^bit;
    }

    /**
     * Get the sign of a number, 1 if positive, 0 if negative
     */
    private static int sign(int num) {
        return flip(num >> 31 & 0x1);
    }
}
