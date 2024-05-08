

import java.util.HashMap;

public class Test {
    public static int maxConsecutiveOccurrence(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        HashMap<Character, Integer> charCountMap = new HashMap<>();
        char prevChar = '\0';
        int maxCount = 0;
        int count = 0;

        for (char c : str.toCharArray()) {
            if (c == prevChar) {
                count++;
            } else {
                count = 1;
            }
            charCountMap.put(c, Math.max(charCountMap.getOrDefault(c, 0), count));
            maxCount = Math.max(maxCount, count);
            prevChar = c;
        }

        return maxCount;
    }

    public static void main(String[] args) {
        String input = "aaaabbbcccaa";
        System.out.println("Maximum consecutive occurrence count of a: " + maxConsecutiveOccurrence(input));
    }
}
