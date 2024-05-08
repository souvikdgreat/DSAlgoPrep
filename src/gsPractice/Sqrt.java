package gsPractice;

public class Sqrt {
    public static void main(String[] args) {
        int number = 24;
        int end = number;
        int start = 0;
        int mid;
        int ans = 0;

        while (start <= end) {
            mid = (start + end) / 2;

            if (mid * mid == number) {
                ans = mid;
                break;
            }

            if (mid * mid > number) {
                end = mid - 1;

            } else {
                start = mid + 1;
                ans = mid;
            }
        }
        System.out.println(ans);
    }
}
