public class Staircase {
    public static int findStep(int n) {
        if (n <= 2)
            return n;

        return  findStep(n - 2)
                + findStep(n - 1);
    }

    // Driver function
    public static void main(String argc[]) {
        int n = 4;
        System.out.println(findStep(n));
    }


}
