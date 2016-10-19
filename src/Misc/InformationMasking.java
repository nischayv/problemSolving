package Misc;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Interview Question
 * Masking the email address and phone number
 */
public class InformationMasking {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        while(s.hasNextLine()) {
            String str = s.nextLine();
            if(str.split(":")[0].trim().charAt(0) == 'E') {
                str = str.split(":")[1].trim();
                System.out.println("E:" + maskEmail(str));
            }
            else {
                str = str.split(":")[1].trim();
                System.out.println("P:" + maskPhone(str));
            }
        }
    }

    private static String maskPhone(String string) {
        StringBuilder newString = new StringBuilder();
        int n = 0;
        for(int i = 0; i < string.length(); i++) {
            if(Character.isDigit(string.charAt(i))) {
                n++;
            }
        }
        if(n > 10) {
            newString.append("+");
            for (int i = 0; i < n - 10; i++) {
                newString.append("*");
            }
            newString.append("-");
        }
        for(int i = n - 10; i < n - 4; i++) {
            if(i == n - 4 || i == n - 7) {
                newString.append("-");
            }
            newString.append("*");
        }
        newString.append("-" + string.substring(string.length()-4, string.length()));
        string = newString.toString();
        return string;
    }

    private static String maskEmail(String string) {
        String temp = string.split("@")[0];
        temp = temp.charAt(0) + "*****" + temp.charAt(temp.length() - 1) + "@" + string.split("@")[1];
        return temp;
    }
}
