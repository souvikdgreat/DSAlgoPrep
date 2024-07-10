package practice;

import java.util.HashSet;
import java.util.Set;

public class UniqueTuples {

    public static void main(String[] args) {
        String string = "abbccde";
        int size = 2;
        Set<String> tuples = new HashSet<>();

        for (int i = 0; i <= string.length() - size; i++) {
            String tuple = string.substring(i, i+size);
            tuples.add(tuple);
        }
        System.out.println(tuples);
    }
}
