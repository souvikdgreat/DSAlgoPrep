import java.util.Arrays;
import java.util.HashMap;

public class MaximumRepatingCharInString {
    public static void main(String[] args) {
        String input = "aabbbbcdAA101aaa";
        int[] result = maxContinuousCount(input);
        System.out.println(Arrays.toString(result)); // Output: [2, 4]
    }

    public static int[] maxContinuousCount(String input) {
        int maxCount = 0;
        int currentCount = 1;
        int startIndex = 0;

        for (int i = 1; i <= input.length(); i++) {
            if (i < input.length() && input.charAt(i) == input.charAt(i - 1)) {
                currentCount++;
            } else {
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    startIndex = i - maxCount;
                }
                currentCount = 1;
            }
        }

        return new int[]{startIndex, maxCount};
    }
}
