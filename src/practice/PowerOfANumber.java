package practice;

public class PowerOfANumber {
    public static void main(String[] args) {
        System.out.println(exponentValue(5, 3));
    }

    public static long exponentValue(int num, int exponent) {
        if (exponent == 0) {
            return 1L;
        }
        if (exponent % 2 == 0) {
            long res = exponentValue(num, exponent / 2);
            return res * res;
        } else {
            return exponentValue(num, exponent - 1) * num;
        }
    }
}
