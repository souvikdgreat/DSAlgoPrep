package practice;

import java.util.Arrays;
import java.util.List;

public class MaxSubarrayWithSumK {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 5, 2, 7, 1, 9);
        int k = 15;
        int left = 0;
        int right = 0;
        int sum = 0;
        int length = 0;

        while (right < list.size()) {
            sum += list.get(right);

            while (sum > k) {
                sum -= list.get(left);
                left++;
            }

            if (sum == k) {
                length = Math.max(length, (right - left) + 1);
            }
            right++;
        }
        System.out.println(length);

    }
}
