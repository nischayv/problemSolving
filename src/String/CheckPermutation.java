package String;

import java.util.Arrays;

/**
 * Cracking the coding interview CheckPermutation
 * Check is either string is a permutation of the other
 */
public class CheckPermutation {

    public static void main(String args[]) {
        System.out.println("abcd " + "dcaba " + isPermutation("abcd", "dcaba"));
        System.out.println("abcd " + "dcab " + isPermutation("abcd", "dcab"));
    }

    private static boolean isPermutation(String s1, String s2){
        if(s1.length() != s2.length()) {
            return false;
        }

        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();
        Arrays.sort(char1);
        Arrays.sort(char2);

        for(int i = 0; i < char1.length; i++) {
            if(char1[i] != char2[i]) {
                return false;
            }
        }
        return true;
    }
}
