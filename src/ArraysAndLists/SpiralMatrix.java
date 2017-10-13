package ArraysAndLists;

public class SpiralMatrix {

    public static void main(String args[]) {
        int[][] a = {
                {1,2,3,11},
                {4,5,6,12},
                {7,8,9,13}
        };
        printMatrix(a);
    }

    private static void printMatrix(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        int direction = 0;

        while (left <= right && top <= bottom) {
            if (direction == 0) {
                for (int i = left; i <= right; i++) {
                    System.out.print(matrix[top][i] + " ");
                }
                top++;
            } else if (direction == 1) {
                for (int i = top; i <= bottom; i++) {
                    System.out.print(matrix[i][right] + " ");
                }
                right--;
            } else if (direction == 2) {
                for (int i = right; i >= left; i--) {
                    System.out.print(matrix[bottom][i] + " ");
                }
                bottom--;
            } else {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(matrix[i][left] + " ");
                    left++;
                }
            }
            direction = (direction+1)%4;
        }
    }
}
