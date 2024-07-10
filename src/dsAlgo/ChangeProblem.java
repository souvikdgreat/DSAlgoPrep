package dsAlgo;

import java.util.ArrayList;
import java.util.List;

public class ChangeProblem {
    public static void main(String[] args) {
        Double[] changeMoney = new Double[]{100d, 50d, 20d, 10d, 5d, 2d, 1d, 0.5, 0.25, 0.1, 0.05, 0.01};
        double pp = 230;
        double cash = 500.0;
        double remaining = cash - pp;
        List<Double> changeResult = new ArrayList<>();

        while (remaining > 0) {
            Double getNextSmallerElement = getNextSmallerElement(changeMoney, remaining);
            changeResult.add(getNextSmallerElement);
            remaining -= getNextSmallerElement;
        }
        System.out.println(changeResult);
    }

    public static Double getNextSmallerElement(Double[] changeMoney, Double num) {
        Double result = -1d;
        for (Double d : changeMoney) {
            if (d.equals(num)) {
                return d;
            } else if (d < num) {
                return d;
            }
        }
        return result;
    }
}
