package ArraysAndLists;

import java.util.Arrays;

/**
 * Cracking the Coding Interview RotateMatrix
 */
public class RotateMatrix {

    public static void main(String args[]) {
        int arr[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        for(int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        arr = rotate(arr);
        System.out.println("");
        for(int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    private static int[][] rotate(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length != matrix.length) {
            return matrix;
        }
        int n = matrix.length;
        for(int i = 0; i < n/2; i++) {
            int last = n - i - 1;
            int first = i;
            for(int j = first; j < last; j++) {
                int offset = j - i;
                int temp = matrix[first][j];
                // top <-- left
                matrix[first][j] = matrix[last - offset][first];
                // left <-- bottom
                matrix[last - offset][i] = matrix[last][last - offset];
                // bottom <-- right
                matrix[last][last - offset] = matrix[j][last];
                // right <-- top
                matrix[j][last] = temp;
            }
        }
        return matrix;

    }


}
