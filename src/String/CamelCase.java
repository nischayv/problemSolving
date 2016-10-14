package String;

import java.util.Scanner;

//Hackerrank CamelCase
public class CamelCase {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int count = 1;
        count  = count + s.length() - s.replaceAll("[A-Z]", "").length();
        System.out.println(count);
    }
}
