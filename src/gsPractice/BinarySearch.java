package gsPractice;

import java.util.Arrays;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        Integer itemToBeSearched = 1;

        int low = 0;
        int high = integers.size();
        int mid;
        int result = -1;

        while (low <= high) {
            mid = (low + high) / 2;

            if (integers.get(mid).equals(itemToBeSearched)) {
                result = mid;
                break;
            }
            if (integers.get(mid) < itemToBeSearched) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.printf("item found at % d", result);
    }
}
