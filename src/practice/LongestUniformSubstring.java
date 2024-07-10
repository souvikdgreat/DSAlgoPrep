package practice;

public class LongestUniformSubstring {
    public static void main(String[] args) {
        int[] longestSubstring = longestUniformSubstring("aaaabbcccddeaa");
        for (int i = 0; i < longestSubstring.length; i++) {
            System.out.print(longestSubstring[i]);
        }
    }

    public static int[] longestUniformSubstring(String input) {
        Character prevChar = null;
        int maxLength = 0;
        int currentLength = 0;
        int currentStart = 0;
        int maxStart = 0;

        StringBuilder response = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            Character currentChar = input.charAt(i);
            if (currentChar.equals(prevChar)) {
                currentLength++;
            } else {
                prevChar = currentChar;
                currentLength = 1;
                currentStart = i;
            }
            if (currentLength > maxLength) {
                maxLength = currentLength;
                maxStart = currentStart;
            }
        }
        System.out.println(response);
        return new int[]{maxStart, maxLength};
    }
}
