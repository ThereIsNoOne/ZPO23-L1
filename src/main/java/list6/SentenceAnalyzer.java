package list6;

import java.util.*;

public class SentenceAnalyzer {
    private String sentence;
    private Map<Character, Integer> numberOfChars = new HashMap<>();
    private Map<String, Integer> numberOfWords = new HashMap<>();

    private List<String> words;
    private List<Character> chars;

    public SentenceAnalyzer(String sentence) {
        this.sentence = sentence;
        getListsOfWordsAndChars();
        atSentenceChange();
    }

    private void getListsOfWordsAndChars() {
        words = Arrays.stream(sentence.split("[ \n!?.,]+")).toList();
        chars = new ArrayList<>();
        sentence.chars().forEach(c -> chars.add((char) c));
    }

    private void atSentenceChange() {
        numberOfChars = new HashMap<>();
        numberOfWords = new HashMap<>();
        countCharacters();
        countWords();
    }

    private void countWords() {
        words.stream()
                .distinct()
                .forEach(keyWord -> numberOfWords.put(keyWord, (int) words.stream()
                                .filter(valueWord -> valueWord.equals(keyWord))
                                .count()
                        )
                );
    }

    private void countCharacters() {
        chars.stream()
                .distinct()
                .filter(Character::isLetterOrDigit)
                .forEach(keyChar -> numberOfChars.put(keyChar, (int) chars.stream()
                                .filter(valueChar -> valueChar.equals(keyChar))
                                .count()
                        )
                );
    }

    public int getLengthLongestWord() {
        OptionalInt longestWord = words.stream()
                .mapToInt(String::length)
                .max();
        return longestWord.isPresent() ? longestWord.getAsInt() : -1;
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
