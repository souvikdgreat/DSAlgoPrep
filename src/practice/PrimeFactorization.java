package practice;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorization {
    public static void main(String[] args) {
        System.out.println(primeFactorisation(6));
    }

    public static List<Integer> primeFactorisation(int num) {
        List<Integer> result = new ArrayList<>();

        for (int i = 2; i <= num; i++) {
            while (num % i == 0) {
                result.add(i);
                num = num / i;
            }
        }
        return result;
    }
}
