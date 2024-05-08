package gsPractice;


/*
 * array is sorted
 * */
public class FirstAndLastOccurance {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 8, 8, 8, 8, 9, 10};
        System.out.println(getFirstOccurance(arr, 8));
        System.out.println(getLastOccurance(arr, 8));
        System.out.println(getFirstAndLastOccurance(arr, 8)[0] + " " + getFirstAndLastOccurance(arr, 8)[1]);
    }


    public static int[] getFirstAndLastOccurance(int[] arr, int num) {
        int[] result = new int[2];
        int first = getFirstOccurance(arr, num);
        if (first == -1) {
            return new int[]{-1, -1};
        }
        int last = getLastOccurance(arr, num);

        result[0] = first;
        result[1] = last;
        return result;
    }

    public static int getFirstOccurance(int[] arr, int num) {
        int first = -1;
        int left = 0;
        int right = arr.length - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] == num) {
                first = mid;
                right = mid - 1;
            } else if (arr[mid] > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return first;
    }

    public static int getLastOccurance(int[] arr, int num) {
        int last = -1;
        int left = 0;
        int right = arr.length - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] == num) {
                last = mid;
                left = mid + 1;
            } else if (arr[mid] > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return last;
    }

}