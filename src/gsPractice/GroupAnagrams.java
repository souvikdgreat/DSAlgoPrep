package gsPractice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(group(List.of("dog", "god", "cat")));

    }

    public static Collection<Set<String>> group(List<String> words) {
        Map<String, Set<String>> collect = words.stream()
                .collect(Collectors.groupingBy(
                        GroupAnagrams::transformedString,
                        Collectors.mapping(Function.identity(), Collectors.toSet())
                ));
        return collect.values();
    }

    public static String transformedString(String input) {
        char[] charactersInInput = input.toCharArray();
        Arrays.sort(charactersInInput);
        return new String(charactersInInput);
    }
}
