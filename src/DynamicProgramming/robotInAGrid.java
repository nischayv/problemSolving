package DynamicProgramming;

public class robotInAGrid {

    // Number of paths from top left to bottom right
    public static void main(String args[]) {

        System.out.println(findWays());
    }

    public static int findWays () {
        return waysIterative (new int[][]{{1,1,1},{1,0,1},{1,1,1}}, new int[][]{{0,0,0},{0,0,0},{0,0,0}});
    }

    public static int ways (int row, int col, int[][] a, int[][] b) {
        if (row == a.length - 1 && col == a.length - 1) {
            return 1;
        }

        if (row >= a.length || col >= a.length || a[row][col] == 0) {
            return 0;
        }

        if (b[row][col] != 0) {
            return b[row][col];
        }

        b[row][col] = ways(row+1, col, a, b) + ways(row, col+1, a, b);
        return b[row][col];
    }

    public static int waysIterative (int[][] a, int[][] b) {

        for(int i = a.length - 1; i >= 0; i--) {
            for(int j = a[i].length - 1; j>=0; j--) {
                if (a[i][j] != 0) {
                    if (j == a[a.length - 1].length - 1 || i == a.length - 1) {
                        b[i][j] = 1;
                    } else {
                        b[i][j] = b[i+1][j] + b[i][j+1];
                    }
                }
            }
        }
        return b[0][0];
    }
}
