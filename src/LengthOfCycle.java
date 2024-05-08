import java.util.HashSet;
import java.util.Set;

public class LengthOfCycle {

    public static int findCycleLength(int[] arr, int startIndex) {
        if (arr == null || arr.length == 0 || startIndex < 0 || startIndex >= arr.length)
            return -1; // Invalid input

        Set<Integer> visited = new HashSet<>();
        int currentIndex = startIndex;
        int steps = 0;

        while (!visited.contains(currentIndex)) {
            visited.add(currentIndex);
            currentIndex = arr[currentIndex];
            steps++;

            // If the currentIndex is out of bounds, return -1 (no cycle)
            if (currentIndex < 0 || currentIndex >= arr.length)
                return -1;
        }

        // Check if currentIndex is part of the cycle or just a repetition
        int cycleLength = 0;
        int nextIndex = arr[currentIndex];
        while (nextIndex != currentIndex) {
            cycleLength++;
            nextIndex = arr[nextIndex];
        }

        return cycleLength + 1; // Add 1 to include the currentIndex in the cycle
    }

    public static void main(String[] args) {
        //int[] arr = {1, 2, 3,1};
        int[] arr = {1, 2,0};
        int startIndex = 0;

        int cycleLength = findCycleLength(arr, startIndex);
        System.out.println("Cycle Length: " + cycleLength); // Output: 3
    }
}
