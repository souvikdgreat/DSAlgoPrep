package gsPractice;

public class SubarrayExceedingSum {
    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3, 4};
        int k = 6;
        System.out.println(subArrayLengthExceedingSum(numbers, k));
    }

    public static int subArrayLengthExceedingSum(int[] arr, int k) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int ans = 999;

        while (i < arr.length) {
            sum += arr[i];
            while (sum > k) {
                ans = Math.min(Math.abs(i - j) + 1, ans);
                sum = sum - arr[j];
                j++;
            }
            i++;
        }
        return ans;
    }
}
