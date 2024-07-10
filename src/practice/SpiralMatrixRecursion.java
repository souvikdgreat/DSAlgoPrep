package practice;


import java.util.List;

public class SpiralMatrixRecursion {
    public static void spiralRecursionHelper(int[][] matrix, int top, int bottom, int left, int right, List<Integer> spiralOutput) {
        if (top > bottom || left > right) {
            return;
        }

        for (int i = left; i <= right; i++) {
            spiralOutput.add(matrix[top][i]);
        }

        for (int i = top + 1; i <= bottom; i++) {
            spiralOutput.add(matrix[i][right]);
        }

        for (int i = right - 1; i >= left; i--) {
            spiralOutput.add(matrix[bottom][i]);
        }

        for (int i = bottom - 1; i >= top; i--) {
            spiralOutput.add(matrix[i][left]);
        }

        spiralRecursionHelper(matrix, top + 1, bottom - 1, left + 1, right - 1, spiralOutput);

    }


    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    }
}
