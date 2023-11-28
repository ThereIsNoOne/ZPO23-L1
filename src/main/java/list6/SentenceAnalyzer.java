package list6;

import java.util.*;

/**
 * Class provides methods to analyze sentence, provided by user.
 */
public class SentenceAnalyzer {
    private String sentence;
    private Map<Character, Integer> numberOfChars = new HashMap<>();
    private Map<String, Integer> numberOfWords = new HashMap<>();

    private List<String> words;
    private List<Character> chars;

    /**
     * Initialize the instance of analyzer, for sentence given by user.
     * @param sentence the sentence to be analyzed.
     */
    public SentenceAnalyzer(String sentence) {
        this.sentence = sentence;
        getListsOfWordsAndChars();
        atSentenceChange();
    }

    /**
     * Gets list of words and chars.
     */
    private void getListsOfWordsAndChars() {
        words = Arrays.stream(sentence.split("[ \n!?.,]+")).toList();
        chars = new ArrayList<>();
        sentence.chars().forEach(c -> chars.add((char) c));
    }

    /**
     * Method invoked on sentence change.
     */
    private void atSentenceChange() {
        numberOfChars = new HashMap<>();
        numberOfWords = new HashMap<>();
        countCharacters();
        countWords();
    }

    /**
     * Method count number of occurrences for all words in the sentence.
     */
    private void countWords() {
        words.stream()
                .distinct()
                .forEach(keyWord -> numberOfWords.put(keyWord, (int) words.stream()
                                .filter(valueWord -> valueWord.equals(keyWord))
                                .count()
                        )
                );
    }

    /**
     * Method counts number of occurrences for all chars in the sentence.
     */
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

    /**
     * Calculates length of the longest word in the sentence.
     * @return the length of the longest word in the sentence
     */
    public int getLengthLongestWord() {
        OptionalInt longestWord = words.stream()
                .mapToInt(String::length)
                .max();
        return longestWord.isPresent() ? longestWord.getAsInt() : -1;
    }

    /**
     * Sentence getter.
     * @return sentence.
     */
    public String getSentence() {
        return sentence;
    }

    /**
     * Setter for sentence.
     * @param sentence new sentence to be analyzed.
     */
    public void setSentence(String sentence) {
        this.sentence = sentence;
        atSentenceChange();
    }

    /**
     * Return map with all characters in the sentence with number of occurrences.
     * @return map in form of k, v where key is character and v is number
     *      of occurrences of this character.
     */
    public Map<Character, Integer> getNumberOfChars() {
        return numberOfChars;
    }

    /**
     * Return map with all words in the sentence with number of occurrences.
     * @return map in form of k, v where key is word and v is number
     *      of occurrences of this word.
     */
    public Map<String, Integer> getNumberOfWords() {
        return numberOfWords;
    }
}
