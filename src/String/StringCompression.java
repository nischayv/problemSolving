package String;

import java.util.Scanner;

/**
 * Cracking the coding interview String Compression
 */
public class StringCompression {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        StringBuilder finalString = new StringBuilder();
        int count = 0;

        for(int i = 0; i < s.length(); i++) {
            count++;

            if((i+1) == s.length() || s.charAt(i) != s.charAt(i+1)) {
                finalString.append(s.charAt(i));
                finalString.append(count);
                count = 0;
            }
        }

        if(finalString.length() < s.length()) {
            System.out.println(finalString);
        }
        else {
            System.out.println(s);
        }
    }
}
