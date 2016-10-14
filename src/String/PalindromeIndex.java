package String;

import java.util.Scanner;

//Hackerrank PalindromeIndex
//Can be optimized further
public class PalindromeIndex {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        boolean flag;

        for(int k = 0; k < n; k++) {
            flag = true;
            String a = s.next();
            for(int i = 0, j = a.length() - 1 ; i < j; i++, j--) {
                if(a.charAt(i) != a.charAt(j)) {
                    if(a.charAt(i) == a.charAt(j-1)) {
                        System.out.println(j);
                    }
                    else {
                        System.out.println(i);
                    }
                    flag = false;
                    break;
        }
    }
            if(flag) {
                System.out.println("-1");
            }
        }
    }
}
