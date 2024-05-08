package gsPractice;

public class PowerOfTen {
    public static void main(String[] args) {
        int number = 1;
        int counter = 0;

        while (number > 10 && number % 10 == 0) {
            counter++;
            number = number / 10;
        }

        if (number / 10 == 1 || number % 10 == 1) {
            System.out.printf("%d %s", counter + 1, true);
        } else {
            System.out.println(false);
        }
    }
}
