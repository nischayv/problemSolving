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
        int middleRow = matrix.length/2;
        int middleCol = matrix[0].length/2;
        System.out.println(move(matrix, middleRow, middleCol));
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
        System.out.println("move1: " + move1 + " move2: " + move2 + " move3: " + move3 + " move4: " + move4);
        int max = Math.max(Math.max(move1, move2), Math.max(move3, move4));

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

}
