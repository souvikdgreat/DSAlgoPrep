package gsPractice;

public class TilingProblem {
    /*
     *   if n == m then 2
     *   1<=n<m then 1
     *   else count(n) = count (n-1) + count(n-m)
     *
     * */
    public static void main(String[] args) {
        int n = 4, m = 4;
        int[] arr = new int[n + 1];
        arr[0] = 0;

        for (int i = 1; i <= n; i++) {
            if (i > m) {
                arr[i] = arr[i - 1] + arr[i - m];
            } else if (i < m || i == 1) {
                arr[i] = 1;
            } else {
                arr[i] = 2;
            }
        }
        System.out.println(arr[n]);
    }
}