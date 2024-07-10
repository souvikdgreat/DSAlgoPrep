package practice;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class ApacheLog {
    public static void main(String[] args) {
        String [] lines = new String[]{
                "10.0.0.1 - frank",
                "10.0.0.1 - frank",
                "10.0.0.2 - nancy"
        };

        String s = Arrays.stream(lines)
                .sequential()
                .collect(Collectors.groupingBy(it -> it.split("-")[0], Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .get();


        Arrays.stream(lines)
                .sequential()
                .collect(Collectors.groupingBy(it -> it.split("-")[0],Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByKey())
                .map(it -> it.getKey())
                .get();
        System.out.println(s);

    }
}
