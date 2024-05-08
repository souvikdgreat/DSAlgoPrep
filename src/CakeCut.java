import java.util.Arrays;

public class CakeCut {

    public static void main(String[] args) {
        // Visualize the cake before cutting
        String[][] cakeBefore = {
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}
        };
        System.out.println("Cake before cutting:");
        printCake(cakeBefore);

        // Make the first cut (horizontal)
        String[][] cakeAfter1 = makeHorizontalCut(cakeBefore);
        System.out.println("\nCake after first cut (horizontal):");
        printCake(cakeAfter1);

        // Make the second cut (vertical)
        String[][] cakeAfter2 = makeVerticalCut(cakeAfter1);
        System.out.println("\nCake after second cut (vertical):");
        printCake(cakeAfter2);

        // Make the third cut (diagonal)
        String[][] cakeAfter3 = makeDiagonalCut(cakeAfter2);
        System.out.println("\nCake after third cut (diagonal):");
        printCake(cakeAfter3);
    }

    public static String[][] makeHorizontalCut(String[][] cake) {
        String[][] newCake = Arrays.copyOf(cake, cake.length);
        int half = cake.length / 2;
        for (int i = 0; i < half; i++) {
            Arrays.fill(newCake[i], "0");
        }
        return newCake;
    }

    public static String[][] makeVerticalCut(String[][] cake) {
        String[][] newCake = Arrays.copyOf(cake, cake.length);
        for (int i = 0; i < cake.length; i++) {
            Arrays.fill(newCake[i], cake[i].length / 2, cake[i].length, "0");
        }
        return newCake;
    }

    public static String[][] makeDiagonalCut(String[][] cake) {
        String[][] newCake = Arrays.copyOf(cake, cake.length);
        for (int i = 0; i < cake.length; i++) {
            Arrays.fill(newCake[i], i, i + 1, "0");
        }
        return newCake;
    }

    public static void printCake(String[][] cake) {
        for (String[] row : cake) {
            for (String slice : row) {
                System.out.print(slice + " ");
            }
            System.out.println();
        }
    }
}
