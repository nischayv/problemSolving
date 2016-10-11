import java.util.Arrays;

public class ZigZagArray {

    public static void main(String args[]) {

    }

    static int[] wiggleArrangeArray(int[] intArr) {
        int n = intArr.length;
        int[] newArr = new int[n];
        Arrays.sort(intArr);
        int k = 0;

        for(int i = 0, j = n -1; i <= j; i++, j--) {
            if(i == j) {
                newArr[k] = intArr[i];
            }
            else {
                newArr[k] = intArr[j];
                k++;
                newArr[k] = intArr[i];
                k++;
            }
        }

        for(int i = 0; i < intArr.length; i ++){
            System.out.println(newArr[i]);
        }
        return newArr;
    }
}
