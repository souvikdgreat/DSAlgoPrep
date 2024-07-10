import java.util.List;

public class Kadane {
    public static void main(String[] args) {
        List<Integer> integers = List.of(-2, -3, 4, -1, -2, 1, 5, -3);

        int globalSum = integers.get(0);
        int currentSum = integers.get(0);

        for (int i = 1; i < integers.size(); i++) {
            currentSum = Math.max(integers.get(i), currentSum + integers.get(i));
            //System.out.println(currentSum);

            if (globalSum < currentSum) {
                globalSum = currentSum;
            }
        }
        System.out.println(globalSum);
    }
}
