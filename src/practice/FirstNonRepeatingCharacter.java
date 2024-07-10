package practice;

import java.util.*;
import java.util.stream.Collectors;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        System.out.println(firstNonRepeatingCharUsingArray("xxyyzz"));
        System.out.println(
                firstNonRepeatingCharUsingHash("xxyyzz")
        );

    }

    public static char firstNonRepeatingCharUsingArray(String input) {
        int[] frequencyArray = new int[256];
        char res = '0';

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            frequencyArray[ch] = frequencyArray[ch] + 1;
        }

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (frequencyArray[ch] == 1) {
                res = ch;
                break;
            }
        }
        return res;
    }

    public static char firstNonRepeatingCharUsingHash(String input) {
        return input
                .chars()
                .mapToObj(it -> (char) it)
                .collect(Collectors.groupingBy(it -> it, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElseGet(()-> '0');
    }
}
