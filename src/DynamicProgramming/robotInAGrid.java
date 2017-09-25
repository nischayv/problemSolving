package DynamicProgramming;

public class robotInAGrid {

    // Number of paths from top left to bottom right
    public static void main(String args[]) {

        System.out.println(findWays());
    }

    public static int findWays () {
        return ways (0, 0, new int[][]{{1,1,1},{1,1,1},{1,1,1}}, new int[][]{{0,0,0},{0,0,0},{0,0,0}});
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
}
