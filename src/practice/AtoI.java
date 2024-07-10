package practice;

public class AtoI {
    public static void main(String[] args) {
        int res = 0;
        String input = "123";

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            res = res * 10 + ch - '0';
        }

        System.out.println(res);
    }
}
