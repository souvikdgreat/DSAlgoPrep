import java.util.*;
import java.util.stream.Collectors;


class MedianFinder {
    private final List<Integer> sortedList;

    public MedianFinder() {
        sortedList = new ArrayList<>();
    }

    public void addNum(int num) {
        sortedList.add(num);
        Collections.sort(sortedList);
    }

    public double findMedian() {
        int size = sortedList.size();
        if (size % 2 == 0) {
            int mid1 = size / 2 - 1;
            int mid2 = size / 2;
            return (sortedList.get(mid1) + sortedList.get(mid2)) / 2.0;
        } else {
            return sortedList.get(size / 2);
        }
    }
}

public class MedianInStreamOfInt {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        int[] stream = {5, 15, 1, 3};

        for (int num : stream) {
            medianFinder.addNum(num);
            System.out.println("Median after reading " + num + " - " + medianFinder.findMedian());
        }
    }
}
