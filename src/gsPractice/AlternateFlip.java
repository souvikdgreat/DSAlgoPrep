package gsPractice;

public class AlternateFlip {
    public static void main(String[] args) {
        String input = "001";
        //              010
        //              101
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (i % 2 != 0) {
                if (ch == '0') {
                    count1++;
                }
            } else {
                if (ch == '1') {
                    count1++;
                }
            }
        }

        System.out.println(count1);

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (i % 2 != 0) {
                if (ch == '1') {
                    count2++;
                }
            } else {
                if (ch == '0') {
                    count2++;
                }
            }
        }

        System.out.println(count2);
        System.out.println(Math.min(count1, count2));


    }
}
