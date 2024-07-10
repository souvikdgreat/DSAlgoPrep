package practice;


import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Panagram2 {
    //missing words
    public static void main(String[] args) {
        int start = 97;
        List<Character> alphabets = IntStream.range(0, 26)
                .map(it -> it + start)
                .mapToObj(it -> (char) it)
                .toList();

        Set<Character> input = "The Slow purple oryx meanders past the quiescent canine"
                .toLowerCase()
                .replaceAll(" ", "")
                .chars()
                .mapToObj(it -> (char) it)
                .collect(Collectors.toSet());


        Map<Boolean, List<Character>> collect = alphabets
                .stream()
                .collect(Collectors.partitioningBy(it -> input.contains(it)));
        System.out.println(collect.get(false));
    }


}
