package practice;

public class LargestPalindrome {
    public static void main(String[] args) {
        String input = "arora";

        String result = "";

        for (int i = 0; i < input.length(); i++) {
            if(input.length()%2 !=0){
                int left = i;
                int right = i;

                while (left >= 0 && right < input.length() && input.charAt(left) == input.charAt(right)) {
                    if (right - left + 1 > result.length()) {
                        result = input.substring(left, right + 1);
                    }
                    left = left - 1;
                    right = right + 1;
                }
            } else {
                int left = i;
                int right = i+1;

                while (left >= 0 && right < input.length() && input.charAt(left) == input.charAt(right)) {
                    if (right - left + 1 > result.length()) {
                        result = input.substring(left, right + 1);
                    }
                    left = left - 1;
                    right = right + 1;
                }
            }

        }
        System.out.println(result);


    }
}
