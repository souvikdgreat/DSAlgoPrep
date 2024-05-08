package gsPractice;

import java.util.List;
import java.util.stream.Collectors;

public class LongestElementSorted {
    public static void main(String[] args) {
        List<Integer> inputs = List.of(1, 34, 3, 98, 9, 76, 45, 4);

        List<Integer> sortedList = inputs
                .stream()
                .sorted((i1, i2) -> {
                    Integer temp1 = (int) i1.toString().charAt(0);
                    Integer temp2 = (int) i2.toString().charAt(0);
                    if (temp1.equals(temp2)) {
                        String num1 = i1 + "" + i2;
                        String num2 = i2 + "" + i1;
                        return (num2.compareTo(num1));
                    }
                    return temp2 - temp1;
                }).collect(Collectors.toList());

        String result = sortedList.stream()
                .map(it -> it + "")
                .collect(Collectors.joining(""));

        System.out.print(result);

    }
}
