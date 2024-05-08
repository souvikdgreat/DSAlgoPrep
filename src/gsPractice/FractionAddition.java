package gsPractice;

import java.util.TreeSet;

public class FractionAddition {
    public static void main(String[] args) {
        int[] result = addFractions(new int[]{2, 3}, new int[]{1, 2});

        System.out.println("---"+gcdRecursion(8,2));
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    public static int[] addFractions(int[] fraction1,
                                     int[] fraction2) {
        int[] result = new int[2];

        int lcmOfDenominators = lcm(fraction1[1], fraction2[1]);

        int fraction1Numerator = fraction1[0];
        int fraction2Numerator = fraction2[0];
        int fraction1Denominator = fraction1[1];
        int fraction2Denominator = fraction2[1];

        result[0] = ((lcmOfDenominators / fraction1Denominator) * fraction1Numerator) + ((lcmOfDenominators / fraction2Denominator) * fraction2Numerator);
        result[1] = lcmOfDenominators;
        return result;
    }

    public static int lcm(int num1, int num2) {
        return (num1 * num2) / gcd(Math.max(num1, num2), Math.min(num1, num2));
    }

    public static int gcd(int num1, int num2) {
        //here num2 <num1
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }


    public static  int gcdRecursion(int num1, int num2){
        if(num2 == 0){
            return num1;
        }
        return gcd(num2, num1%num2);
    }
}
