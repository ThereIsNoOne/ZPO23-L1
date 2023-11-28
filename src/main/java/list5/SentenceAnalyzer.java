package list5;

import java.util.HashMap;
import java.util.Map;

/**
 * Class provides methods to analyze sentence, provided by user.
 */
public class SentenceAnalyzer {
    private String sentence;
    private Map<Character, Integer> numberOfChars = new HashMap<>();
    private Map<String, Integer> numberOfWords = new HashMap<>();

    /**
     * Initialize the instance of analyzer, for sentence given by user.
     * @param sentence the sentence to be analyzed.
     */
    public SentenceAnalyzer(String sentence) {
        this.sentence = sentence;
        atSentenceChange();
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
        String[] words = sentence.split("[ \n!?.,]+");
        for (String word : words) {
            int wordNumber = numberOfWords.get(word)==null ? 0 : numberOfWords.get(word);
            numberOfWords.put(word, wordNumber+1);
        }
    }

    /**
     * Method counts number of occurrences for all chars in the sentence.
     */
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
