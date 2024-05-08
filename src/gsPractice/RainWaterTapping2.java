package gsPractice;

import java.util.List;

public class RainWaterTapping2 {
    public static void main(String[] args) {
        List<Integer> integers = List.of(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1);
        int left = 0;
        int right = 0;
        int result = 0;

        for (int i = 1; i < integers.size() - 1; i++) {
            left = integers.get(i);

            for (int j = 0; j < i; j++) {
                left = Math.max(integers.get(j), left);
            }

            right = integers.get(i);
            for (int j = i + 1; j < integers.size(); j++) {
                right = Math.max(right, integers.get(j));
            }

            result += Math.min(left, right) - integers.get(i);
        }

        System.out.println(result);


    }
}
