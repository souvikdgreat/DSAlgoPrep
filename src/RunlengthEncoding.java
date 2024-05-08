
public class RunlengthEncoding {
    public static String encode(String input) {
        int count = 1;
        int i = 0;
        StringBuffer encodedString = new StringBuffer();
        for (; i < input.length(); i++) {
            if (i < input.length() - 1 && input.charAt(i) == input.charAt(i + 1)) {
                count++;
            } else {
                encodedString
                        .append(input.charAt(i))
                        .append(count);
                count = 1;
            }
        }
        return encodedString.toString();
    }

    public static String runlengthEncoding2(String input) {
        int j = 1;
        int currentCount = 1;
        int maxCount = -999;
        int maxIndex = -999;
        int currentIndex = 0;
        while (j <= input.length()) {
            if (j < input.length() && input.charAt(j) == input.charAt(j - 1)) {
                currentCount += 1;
            } else {
                currentIndex = j;
                currentCount = 1;
            }
            j++;
            if (maxCount < currentCount) {
                maxCount = currentCount;
                maxIndex = currentIndex;
            }
            System.out.println(maxIndex + " " + maxCount);
        }

        System.out.println(maxIndex + " " + maxCount);
        return null;
    }


    public static void main(String[] args) {
//        String original = "AAAABBBCCDA";
//        System.out.println("Original: " + original);
//
//        String encoded = encode(original);
//        System.out.println("Encoded: " + encoded);
        String s = "aaabbbbcccddeaa";
        System.out.println(runlengthEncoding2(s));
    }
}
