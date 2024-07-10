package dsAlgo;

import java.util.*;

public class WordLadder {
    record Word(String word, Integer level) {
    }

    public static void main(String[] args) {
        String targetWord = "cog";
        String beginWord = "hit";
        Word result = null;
        List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");
        // hit -> hot -> dot -> dog -> cog
        Queue<Word> helperQueue = new LinkedList<>();
        Set<String> uniqueSet = new HashSet<>(wordList);
        int level = 1;
        helperQueue.add(new Word(beginWord, level));

        while (!helperQueue.isEmpty()) {
            Word newBeginWord = helperQueue.poll();
            if (newBeginWord.word.equals(targetWord)) {
                result = newBeginWord;
                break;
            }
            method(newBeginWord.word, uniqueSet, helperQueue, newBeginWord.level + 1);
        }

        if (result != null) {
            System.out.println(result.word + " " + result.level);

        } else {
            System.out.println("no Such word");
        }
    }


    public static void method(String beginWord, Set<String> uniqueSet, Queue<Word> helperQueue, int level) {
        for (int i = 0; i < beginWord.length(); i++) {
            generateWordForAfterReplacingWithIndex(i, beginWord, uniqueSet, helperQueue, level);
        }
    }

    public static void generateWordForAfterReplacingWithIndex(
            int index,
            String beginWord,
            Set<String> uniqueSet,
            Queue<Word> helperQueue,
            int level
    ) {

        for (int i = 97; i < 97 + 26; i++) {
            char[] charsInword = beginWord.toCharArray();
            charsInword[index] = (char) i;
            String newWord = new String(charsInword);
            if (uniqueSet.contains(newWord)) {
                helperQueue.add(new Word(newWord, level));
                uniqueSet.remove(newWord);
            }
        }
    }
}
