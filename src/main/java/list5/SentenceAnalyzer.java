package list5;

import java.util.HashMap;
import java.util.Map;

public class SentenceAnalyzer {
    private String sentence;
    private Map<Character, Integer> numberOfChars = new HashMap<>();
    private Map<String, Integer> numberOfWords = new HashMap<>();

    public SentenceAnalyzer(String sentence) {
        this.sentence = sentence;
        atSentenceChange();
    }

    private void atSentenceChange() {
        numberOfChars = new HashMap<>();
        numberOfWords = new HashMap<>();
        countCharacters();
        countWords();
    }

    private void countWords() {
        String[] words = sentence.split("[ \n!?.,]+");
        for (String word : words) {
            int wordNumber = numberOfWords.get(word)==null ? 0 : numberOfWords.get(word);
            numberOfWords.put(word, wordNumber+1);
        }
    }

    private void countCharacters() {
        char[] chars = sentence.toCharArray();
        for (char c : chars) {
            if (!Character.isLetterOrDigit(c)) {
                continue;
            }
            int charNumber = numberOfChars.get(c)==null ? 0 : numberOfChars.get(c);
            numberOfChars.put(c, charNumber+1);
        }
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
        atSentenceChange();
    }

    public Map<Character, Integer> getNumberOfChars() {
        return numberOfChars;
    }

    public Map<String, Integer> getNumberOfWords() {
        return numberOfWords;
    }
}
