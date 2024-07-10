package practice;

import java.util.HashMap;
import java.util.Map;

public class LongestUniqueSubstring {
    public static void main(String[] args) {
        String input = "ABCABCDA";

        Map<Character, Integer> positionIndex = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxLength = 0;
        int startIndex = 0;

        for (right = 0; right < input.length(); right++) {
            char ch = input.charAt(right);
            if (positionIndex.containsKey(ch) && positionIndex.get(ch) >= left) {
                left = positionIndex.get(ch) + 1;
            }
            positionIndex.put(ch, right);
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                startIndex = left;
            }
        }
        System.out.println(maxLength);
        System.out.println(startIndex);
    }
}
