package gsPractice;

public class OptimalPath {
    private static Integer optimalPath(final Integer[][] grid) {
        /**
         [0 0 0 0 5]  -> [00 01 02 03 04]
         [0 1 1 1 0]     [10 11 12 13 14]
         [2 0 0 0 0]     [20 21 22 23 24]

         [0 0 0 0 5]  -> [00 01 02 03 04]
         [0 1 1 1 0]     [10 11 12 13 14]
         [2 2 2 2 2]     [20 21 22 23 24]

         [2 0 0 0 5]  -> [00 01 02 03 04]
         [2 1 1 1 0]     [10 11 12 13 14]
         [2 2 2 2 2]     [20 21 22 23 24]




         [2 0 0 0 0]
         [2 0 0 0 0]
         [2 0 0 0 0]


         */

        Integer noOfRows = grid.length;
        Integer noOfColumns = grid[0].length;

        int[][] resultMatrix = new int[noOfRows][noOfColumns];
        //starting point
        resultMatrix[noOfRows - 1][0] = grid[noOfRows - 1][0];
        for (int i = noOfRows - 2; i >= 0; i--) {
            resultMatrix[i][0] = resultMatrix[i + 1][0]+ grid[i][0];
        }

        for (int i = 1; i < noOfColumns; i++) {
            resultMatrix[noOfRows - 1][i] = grid[noOfRows - 1][i] + resultMatrix[noOfRows - 1][i - 1];
        }

        for (int i = noOfRows - 2; i >= 0; i--) {
            for (int j = 1; j < noOfColumns; j++) {
                resultMatrix[i][j] = grid[i][j] + Math.max(
                        resultMatrix[i + 1][j], resultMatrix[i][j - 1]
                );
            }
        }
        printMatrix(resultMatrix);
        return resultMatrix[0][noOfColumns-1];
    }

    public static void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Integer[][] arr = new Integer[][]{
                {0, 0, 0, 0, 5},
                {0, 1, 1, 1, 0},
                {2, 0, 0, 0, 0}};

        Integer[][] arrIntegers= new Integer[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(optimalPath(arrIntegers));
    }
}