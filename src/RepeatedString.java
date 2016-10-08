import java.util.Scanner;

public class RepeatedString {

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        String s = in.next();
        long n = in.nextLong();
        int total = s.length() - s.replace("a", "").length();
        long d = n/s.length();
        long m = n % (s.length());
        if(m == 0) {
            System.out.println(total * d);
        }
        else {
            int a_in_m = s.substring(0,(int) m).length() - s.substring(0, (int) m).replace("a","").length();
            System.out.println(total * d + (a_in_m));
        }
    }
}
