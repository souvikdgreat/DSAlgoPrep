import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RainWaterTapping {
    public static void main(String[] args) {
        List<Integer> integers = List.of(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1);
        List<Integer> leftMax = new ArrayList<>(integers.size());
        List<Integer> rightMax = new ArrayList<>(integers.size());
        Integer max = -999;

        for (int i = 0; i < integers.size(); i++) {
            if (max < integers.get(i)) {
                max = integers.get(i);
            }
            leftMax.add(max);
        }

        max = -999;

        for (int i = integers.size() - 1; i >= 0; i--) {
            if (max < integers.get(i)) {
                max = integers.get(i);
            }
            rightMax.add(max);
        }

        Collections.reverse(rightMax);

        int unit = 0;
        for (int i = 0; i < integers.size(); i++) {
            unit += Math.min(leftMax.get(i), rightMax.get(i)) - integers.get(i);
        }

        System.out.println(unit);

    }
}
