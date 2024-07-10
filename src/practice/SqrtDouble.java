package practice;

public class SqrtDouble {
    public static double sqrt(double num) {
        if (num == 0 || num == 1) {
            return num;
        }

        double start = 0;
        double end = num;
        double result = 0;

        double precision = 1e-15;

        while (end - start > precision) {
            double mid = (start + end) / 2;
            result = mid * mid;
            if (Math.abs(result - num) <= precision) {
                return mid;
            } else if (result < num) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        double number = 2;

        double result = sqrt(number);

        System.out.println("Square root of " + number + " is: " + result);
    }
}
