package String;

/**
 * Cracking the coding interview URLify
 */
public class URLify {

    public static void main(String args[]){
        char[] str = {'t', 'e', 's', 't', ' ', 't', 'e', 's', 't', ' ', ' ', ' ', ' '};
        replaceSpaces(str, 9);
        System.out.println(str);
    }

    private static void replaceSpaces(char[] str, int truelength) {
        int spaces = 0;
        for(int i = 0; i < truelength; i++) {
            if(str[i] == ' ') {
                spaces++;
            }
        }
        int index = (truelength + spaces * 2) - 1;
        for(int i = truelength - 1; i >= 0; i--) {
            if(str[i] == ' '){
                str[index] = '0';
                str[index - 1] = '2';
                str[index - 2] = '%';
                index -= 3;
            }
            else {
                str[index] = str[i];
                index--;
            }
        }
    }
}
