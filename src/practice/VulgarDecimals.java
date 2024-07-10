package practice;

/*
 *   (1,2) -> 0.5
 *   (1,3) -> 0.(3)
 *   (1,30) -> 0.0(3)
 *   (1,75) -> 0.01(3)
 *   (4,7)  -> 0.(571428)
 * */

import java.util.HashMap;

public class VulgarDecimals {
    public static void main(String[] args) {
        System.out.println(getDecimalNotation(4, 7));
    }

    public static String getDecimalNotation(long number, long denominator) {
        StringBuilder result = new StringBuilder();
        long remainder = number % denominator;
        long quotient = number / denominator;
        result.append(quotient);
        if (remainder == 0) {
            return result.toString();
        } else {
            HashMap<Long, Long> numberPositionMap = new HashMap<>();
            result.append(".");
            while (remainder != 0) {
                remainder = remainder * 10;
                quotient = remainder / denominator;
                if (numberPositionMap.containsKey(quotient)) {
                    Long position = numberPositionMap.get(quotient);
                    result.insert(position.intValue(), "(");
                    result.append(")");
                    break;
                } else {
                    numberPositionMap.put(quotient, (long) result.length());
                    remainder = remainder % denominator;
                    result.append(quotient);
                }
            }
        }
        return result.toString();
    }
}