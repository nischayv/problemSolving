package String;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Hackerrank Sherlock and Anagrams
 * Should be able to improve the performance
 */
public class SherlockAndAnagrams {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        for(int i = 0; i < n; i++) {
            String str = s.next();
            int count = 0;

            for(int j = 1; j < str.length(); j++) {
                for(int k = 0; k < str.length() - j + 1; k++) {
                    String substr = str.substring(k, j + k);
                    for(int l = k + 1; l < str.length() - j + 1; l++) {
                        if(l != k) {
                            String substr1 = str.substring(l, j + l);
                            if(checkAnagram(substr, substr1)) {
                                count++;
                            }
                        }

                    }
                }
            }
            System.out.println(count);
        }

    }

    private static boolean checkAnagram(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for(int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
