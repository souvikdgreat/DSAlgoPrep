package gsPractice;

public class Staircase {
    public static void main(String[] args) {
        int staircases = 4;
        int[] arr = new int[staircases + 1];

        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i <= staircases; i++) {
            arr[i] = arr[i - 3] + arr[i - 2] + arr[i - 1];
            System.out.println(arr[i]);
        }
        System.out.println(arr[staircases]);


    }

}
