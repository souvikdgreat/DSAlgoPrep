package practice;

import java.util.Set;
import java.util.stream.Collectors;

public class Panagram {
    public static void main(String[] args) {
        String input = "abdefghijklnopqrstuwxyz";
        input = input.toLowerCase().replace(" ", "");

        Set<Character> charSet = input.chars().mapToObj(it -> (char) it).collect(Collectors.toSet());
        System.out.println(charSet.size() == 26);
    }
}
