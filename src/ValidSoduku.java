import java.util.*;

public class ValidSoduku {
    public static void main(String[] args) {
        int[][] board = {
                {7, 9, 2, 1, 5, 4, 3, 8, 6},
                {6, 4, 3, 8, 2, 7, 1, 5, 9},
                {8, 5, 1, 3, 9, 6, 7, 2, 4},
                {2, 6, 5, 9, 7, 3, 8, 4, 1},
                {4, 8, 9, 5, 6, 1, 2, 7, 3},
                {3, 1, 7, 4, 8, 2, 9, 6, 5},
                {1, 3, 6, 7, 4, 8, 5, 9, 2},
                {9, 7, 4, 2, 1, 5, 6, 3, 8},
                {5, 2, 8, 6, 3, 9, 4, 1, 7}
        };

        int rows = board.length;
        int columns = board[0].length;

        boolean result = true;

        //row wise
        for (int i = 0; i < rows; i++) {
            Set<Integer> sodukoInput = new LinkedHashSet<>();
            for (int j = 0; j < columns; j++) {
                sodukoInput.add(board[i][j]);
            }
            result = result && isValid(sodukoInput);
            if (!result) {
                break;
            }
        }

        //column wise
        for (int i = 0; i < rows; i++) {
            Set<Integer> sodukoInput = new LinkedHashSet<>();
            for (int j = 0; j < columns; j++) {
                sodukoInput.add(board[j][i]);
            }
            result = result && isValid(sodukoInput);
            if (!result) {
                break;
            }
        }

        System.out.println(result && display3By3Matrix(rows, columns, board));

    }

    public static boolean isValid(Set<Integer> soduku) {
        return soduku.size() == 9;
    }

    public static boolean display3By3Matrix(int row, int column, int[][] board) {
        boolean result = true;
        int rowStart = 0;
        int colStart = 0;
        label1 :while (rowStart < row) {
            while (colStart < column) {
                HashSet<Integer> sodukoInput = new HashSet<>();
                for (int i = rowStart; i < rowStart + 3; i++) {
                    for (int j = colStart; j < colStart + 3; j++) {
                        sodukoInput.add(board[i][j]);
                    }
                }
                result = result && isValid(sodukoInput);
                if (!result){
                    break label1;
                }
                colStart = colStart + 3;
            }
            colStart = 0;
            rowStart = rowStart + 3;
        }
        return result;
    }


}
