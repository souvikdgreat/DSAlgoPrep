package practice;

public class SmallestElementInASortedArray {
    public static void main(String[] args) {
        int[] numbers = new int[]{3, 4, 5, 6, 1, 2};
        System.out.println(smallestElement(numbers));
    }

    public static int smallestElement(int[] arr) {
        int high = arr.length - 1;
        int low = 0;
        int mid;
        int min = 999;

        while (low <= high) {
            mid = (low + high) / 2;

            if (arr[mid] > arr[low]) {
                min = Math.min(min, arr[low]);
                low = mid + 1;
            } else {
                min = Math.min(min, arr[mid]);
                high = mid - 1;
            }
        }
        return min;
    }
}
