package dsAlgo;

import java.util.ArrayList;
import java.util.List;

public class PayPayRect {
    public static List<int[]> solution(int h, int w, List<String> queries) {
        boolean[][] board = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                board[i][j] = true;
            }
        }

        List<int[]> result = new ArrayList<>();

        for (String q : queries) {
            String[] parts = q.split(" ");
            String queryType = parts[0];
            int x = Integer.parseInt(parts[1]);
            int y = Integer.parseInt(parts[2]);

            switch (queryType) {
                case "x":
                    board[x][y] = false;
                    break;
                case ">":
                    boolean found = false;
                    for (int j = y + 1; j < w; j++) {
                        if (board[x][j]) {
                            result.add(new int[] {x, j});
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        result.add(new int[] {-1, -1});
                    }
                    break;
                case "<":
                    found = false;
                    for (int j = y - 1; j >= 0; j--) {
                        if (board[x][j]) {
                            result.add(new int[] {x, j});
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        result.add(new int[] {-1, -1});
                    }
                    break;
                case "v":
                    found = false;
                    for (int i = x + 1; i < h; i++) {
                        if (board[i][y]) {
                            result.add(new int[] {i, y});
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        result.add(new int[] {-1, -1});
                    }
                    break;
                case "^":
                    found = false;
                    for (int i = x - 1; i >= 0; i--) {
                        if (board[i][y]) {
                            result.add(new int[] {i, y});
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        result.add(new int[] {-1, -1});
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Invalid query type: " + queryType);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int h = 5;
        int w = 5;
        List<String> queries = new ArrayList<>();
        //queries = ["v 1 2", "x 2 2", "v 1 2", "> 2 1", "x 2 3", "> 2 1", "< 2 0"],
        queries.add("v 1 2");
        queries.add("x 2 2");
        queries.add("v 1 2");
        queries.add("> 2 1");
        queries.add("x 2 3");
        queries.add("> 2 1");
        queries.add("< 2 0");

        List<int[]> result = solution(3, 5, queries);
        for (int[] res : result) {
            System.out.println("[" + res[0] + ", " + res[1] + "]");
        }
    }
}
