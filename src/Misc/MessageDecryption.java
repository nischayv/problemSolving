package Misc;

import java.util.ArrayList;

/**
 * Interview Question
 * Decryption of message based on given key
 */
public class MessageDecryption {

    public static void main(String args[]) {
        System.out.println(decrypt("Otjfvknou kskgnl, K mbxg iurtsvcnb ksgq hoz atv. Vje xcxtyqrl vt ujg smewfv vrmcxvtg rwqr ju vhm ytsf elwepuqyez. -Atvt hrqgse, Cnikg"));
    }

    static String decrypt(String encrypted_message) {
        int[] code = {8, 2, 5, 1, 2, 2, 0};
        StringBuilder newString  = new StringBuilder();
        int j = 0;
        boolean isLower;

        for(int i = 0; i < encrypted_message.length(); i++) {
            if(Character.isAlphabetic(encrypted_message.charAt(i))) {
                int temp = encrypted_message.charAt(i);
                isLower = temp >= 97;
                temp = Math.abs(temp - code[j]);
                temp = isLower && temp < 97 || temp < 65 ? temp + 26 : temp;
                newString.append((char) temp);
                j = j + 1 < code.length ? j + 1 : 0;
            }
            else {
                newString.append(encrypted_message.charAt(i));
            }
        }
        return newString.toString();
    }
}
