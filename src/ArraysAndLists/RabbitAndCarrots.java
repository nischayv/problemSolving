package ArraysAndLists;

public class RabbitAndCarrots {

    public static void main(String args[]) {
        // should give 27
        int[][] matrix = {
                {5,7,8,6,3},
                {0,0,7,0,4},
                {4,6,3,4,9},
                {3,1,0,5,8}
        };
        System.out.println(calc(matrix));
    }

    private static int calc(int[][] matrix) {
        int numOfRows = matrix.length;
        int numOfCols = matrix[0].length;
        int midRow = numOfRows/2;
        int midCol = numOfCols/2;

        if (matrix.length % 2 == 0 && matrix[0].length % 2 == 0) {
            // Number of rows and number of columns are even
            // Find max of middle 4 center positions in 2-D array
            int max = findMax(matrix[midRow][midCol], matrix[midRow-1][midCol], matrix[midRow][midCol-1], matrix[midRow-1][midCol-1]);

            if (max == matrix[midRow][midCol]) {
                return move(matrix, midRow, midCol);
            } else if (max == matrix[midRow-1][midCol]) {
                return move(matrix, midRow-1, midCol);
            } else if(max == matrix[midRow][midCol-1]) {
                return move(matrix, midRow, midCol-1);
            } else {
                return move(matrix, midRow-1, midCol-1);
            }
        } else if (matrix.length % 2 == 0){
            // Number of rows is even and cols is odd
            if (matrix[midRow][midCol] > matrix[midRow-1][midCol]) {
                return move(matrix, midRow, midCol);
            } else {
                return move(matrix, midRow-1, midCol);
            }
        } else if (matrix[0].length % 2 == 0){
            // Number of rows is odd and cols are even
            if (matrix[midRow][midCol] > matrix[midRow][midCol-1]) {
                return move(matrix, midRow, midCol);
            } else {
                return move(matrix, midRow, midCol-1);
            }
        } else {
            return move(matrix, midRow, midCol);
        }
    }


    private static int move(int[][] matrix, int row, int col) {
        // Check is pos is valid
        if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length) {
            return 0;
        }
        // Checks if any surrounding ones are valid
        if (isTimeToSleep(matrix, row, col)) {
            return matrix[row][col];
        }

        int move1 = isValidIndex(matrix, row-1, col) ? matrix[row-1][col] : 0;
        int move2 = isValidIndex(matrix, row+1, col) ? matrix[row+1][col] : 0;
        int move3 = isValidIndex(matrix, row, col-1) ? matrix[row][col-1] : 0;
        int move4 = isValidIndex(matrix, row, col+1) ? matrix[row][col+1] : 0;
        int max = findMax(move1, move2, move3, move4);

        int val = matrix[row][col];
        matrix[row][col] = 0;
        if (max == move1) {
            return val + move(matrix, row-1, col);
        } else if (max == move2) {
            return val + move(matrix, row+1, col);
        } else if (max == move3) {
            return val + move(matrix, row, col-1);
        } else {
            return val + move(matrix, row, col+1);
        }

    }

    private static boolean isValidIndex(int matrix[][], int row, int col) {
        return row >= 0 && col >= 0 && row < matrix.length && col < matrix[0].length && matrix[row][col] != 0;
    }

    private static boolean isTimeToSleep(int[][] matrix, int row, int col) {
        return !isValidIndex(matrix, row + 1, col) && !isValidIndex(matrix, row - 1, col) && !isValidIndex(matrix, row, col - 1) && !isValidIndex(matrix, row, col + 1);
    }

    // Finds max of 4 values
    private static int findMax(int a, int b, int c, int d) {
        return Math.max(Math.max(a,b), Math.max(c,d));
    }

}
