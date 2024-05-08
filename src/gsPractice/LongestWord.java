package gsPractice;

import java.util.*;

public class LongestWord {
    public static void main(String[] args) {
        List<String> dictionary = List.of("to", "toe", "toes");
        TreeMap<String, String> wordMap = new TreeMap<>((i1,i2) -> i2.length()-i1.length());
        String wordToBeSearched = "soet";
        String transformedWord = transformer(wordToBeSearched);

        String res = "";

        dictionary.forEach(word -> wordMap.put(transformer(word), word));

        System.out.println(wordMap);

        for(Map.Entry<String, String> entry : wordMap.entrySet()){
            if(transformedWord.contains(entry.getKey())){
                res = entry.getValue();
                break;
            }
        }
        System.out.println(res);
    }


    private static String transformer(String word) {
        char[] charactersInword = word.toCharArray();
        Arrays.sort(charactersInword);
        return new String(charactersInword);
    }
}
