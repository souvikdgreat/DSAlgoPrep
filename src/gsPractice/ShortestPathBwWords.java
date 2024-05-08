package gsPractice;

public class ShortestPathBwWords {
    public static double shortestDistance(final String document, String word1, String word2) {
        final String[] words = document.split(" ");

        int wordCount = 0;
        double wordOneCount = 0;
        double wordTwoCount = 0;
        double shortestDistance = Double.MAX_VALUE;
        for (String word : words) {
            if (word.equalsIgnoreCase(word1)) {
                wordOneCount = wordCount + (word.length() / 2d);
            } else if (word.equalsIgnoreCase(word2)) {
                wordTwoCount = wordCount + (word.length() / 2d);
            }

            if (wordOneCount > 0 && wordTwoCount > 0) {
                shortestDistance = Math.min(shortestDistance, Math.abs(wordTwoCount - wordOneCount));
            }

            wordCount += word.length() + 1;
        }

        System.out.println(String.format("Word1 : %s, word2: %s, distance: %s", word1, word2, shortestDistance));

        return shortestDistance;
    }

    public static void main(String[] args) {
        String word1 = "is";
        String word2 = "a";

//        String document = "In publishing and graphic design, lorem ipsum is a filler text commonly used to demonstrate the graphic elements";
        String document = "is a";

        System.out.println(shortestDistance(document, word1, word2));
    }
}
