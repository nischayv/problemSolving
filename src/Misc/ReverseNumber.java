package Misc;

public class ReverseNumber {

    public static void main(String args[]) {
        System.out.println(reverse(543210));
    }

    private static int reverse(int n) {
        int num = 0;
        while (n > 0) {
            int v = n % 10;
            num = num*10 + v;
            n /= 10;
        }
        return num;
    }
}
