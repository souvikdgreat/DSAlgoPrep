package practice;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    /**
     * right
     * top      [1 2 3 4 5 6]
     * [7 8 9 10 11 12]
     * bottom   [13 14 15 16 17 18]
     * left
     * print left to right (top will be fixed)
     * print top to bottom (right will be fixed)
     * print right to left  (bottom will be fixed)
     * print bottom to top (left will be fixed)
     */
    public static void main(String[] args) {
        List<Integer> spiralOutput = new ArrayList<>();

        int[][] matrix = {{1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12}, {13, 14, 15, 16, 17, 18}};
        int top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int left = 0;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                spiralOutput.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                spiralOutput.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    spiralOutput.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    spiralOutput.add(matrix[i][left]);
                }
                left++;
            }
        }
        System.out.println(spiralOutput);
    }

}
