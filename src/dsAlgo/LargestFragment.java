package dsAlgo;

public class LargestFragment {
    public static void main(String[] args) {
        String input = "50552";
        int largest = -999;

        for (int i = 0; i < input.length()-1; i++) {
            Integer num = Integer.parseInt(input.charAt(i) + "" + input.charAt(i + 1));
            largest = Math.max(largest, num);
        }

        System.out.println(largest);
    }
}
