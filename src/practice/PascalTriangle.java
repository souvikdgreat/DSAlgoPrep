package practice;

public class PascalTriangle {
    public static void main(String[] args) {
        int n = 7;
        int[][] pascalTriangle = new int[n][n];
        int row = 2;
        int column = 1;
        int ans = -1;

        label1:for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    pascalTriangle[i][j] = 1;
                } else {
                    pascalTriangle[i][j] = pascalTriangle[i - 1][j - 1] + pascalTriangle[i - 1][j];
                }
                if (i == row && j == column) {
                    ans = pascalTriangle[i][j];
                    break label1;
                }
            }
        }
        System.out.println(ans);

    }
}
