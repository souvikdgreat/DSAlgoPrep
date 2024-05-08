package gsPractice;


public class OptimalPath2 {
    public static void main(String[] args) {
        Integer[][] grid = new Integer[][]{{0, 0, 0, 0, 5}, {0, 1, 1, 1, 0}, {2, 0, 0, 0, 0}};
        int n = grid.length;
        int m = grid[0].length;
        Integer[][] dp = new Integer[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                dp[i][j] = -1;

        }
        System.out.println(optimalPath(grid, n - 1, 0, m, dp));
        System.out.println(iterativeDP(grid, dp));
        System.out.println(optimalPathIterative(grid, dp));
    }

    private static int optimalPath(Integer[][] grid, int i, int j, int m, Integer[][] dp) {

        if (i == 0 && j == m - 1)
            return grid[0][m - 1];
        if (i < 0 || j > m - 1)
            return Integer.MIN_VALUE;
		/*if (dp[i][j] != -1)
			return dp[i][j];*/
        int up = optimalPath(grid, i - 1, j, m, dp) + grid[i][j];
        int right = optimalPath(grid, i, j + 1, m, dp) + grid[i][j];

        return Math.max(up, right);
        //return dp[i][j];
    }

    private static int iterativeDP(Integer grid[][], Integer[][] dp) {

        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {

            for (int j = m - 1; j >= 0; j--) {

                if (i == 0 && j == m - 1)
                    dp[i][j] = grid[i][j];
                else {

                    int down = grid[i][j];
                    if (i > 0)
                        down = down + dp[i - 1][j];
                    else
                        down = down + Integer.MIN_VALUE;
                    int left = grid[i][j];
                    if (j < m - 1)
                        left = dp[i][j + 1] + left;
                    else
                        left = left + Integer.MIN_VALUE;

                    dp[i][j] = Math.max(left, down);

                }

            }


        }
        return dp[n - 1][0];
    }

    private static int optimalPathIterative(Integer[][] grid, Integer[][] dp) {

        int n = grid.length;
        int m = grid[0].length;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {

                if (i == n - 1 && j == m - 1)
                    dp[n - 1][m - 1] = grid[n - 1][m - 1];
                else {
                    int up = grid[i][j];
                    if (i < n - 1)
                        up = up + dp[i + 1][j];
                    else
                        up = up + Integer.MIN_VALUE;
                    int left = grid[i][j];
                    if (j < m - 1)
                        left = left + dp[i][j + 1];
                    else
                        left = left + Integer.MIN_VALUE;
                    dp[i][j] = Math.max(left, up);

                }
            }

        }
        return dp[0][0];

    }
}