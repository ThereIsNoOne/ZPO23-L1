package list6;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("Running demo for exercise 1");
        exerciseOne();
        System.out.println("Running demo for exercise 2");
        exerciseTwo();
    }

    
    private static void exerciseOne() {
        SentenceAnalyzer sentenceAnalyzer = new SentenceAnalyzer("Long sentence for test." +
                " It has to contain all words breaking like \\n for example here.\nAnd now" +
                " we have new sentence separated from previous sentence only by .\\n. Let's check, how it works?!!BLa");

        System.out.printf("Sentence was analyzed:\nNumber od words:\n%s\nNumber of chars:\n%s\n",
                sentenceAnalyzer.getNumberOfWords(), sentenceAnalyzer.getNumberOfChars());

        SentenceAnalyzer sentenceAnalyzer2 = new SentenceAnalyzer("Test test test\nTest\nTest??test");

        System.out.printf("Sentence was analyzed:\nNumber od words:\n%s\nNumber of chars:\n%s\n",
                sentenceAnalyzer2.getNumberOfWords(), sentenceAnalyzer2.getNumberOfChars());

        System.out.printf("Length of longest word of sentence <' '>:\n%s\n and for sentence <' bla bla blah'>:\n%s\n",
                new SentenceAnalyzer(" ").getLengthLongestWord(), new SentenceAnalyzer(" bla bla blah").getLengthLongestWord());

    }
    
    private static void exerciseTwo() {
        SubjectStore store = getSubjectStore();

        Subject biologyLab = new Subject("Advanced biology", "Gregor Mendel", 3, 4, SubjectType.LABORATORY, EndsWith.CREDIT);
        System.out.printf("Subjects:\n%s\n", store);

        store.add("BL000423L", biologyLab);
        System.out.printf("Subjects after addition:\n%s\n", store);

        store.set("BL000423L", new Subject("Advanced microbiology", "Julie Theriot", 3, 5, SubjectType.LABORATORY, EndsWith.CREDIT));
        System.out.printf("Subjects after change:\n%s\n", store);

        store.remove("BL000423L");
        System.out.printf("Subjects after removal:\n%s\n", store);
    }

    private static SubjectStore getSubjectStore() {
        Subject analysis = new Subject("Mathematical analysis", "Issac Newton", 2, 5, SubjectType.LECTURE, EndsWith.EXAM);
        Subject biology = new Subject("Advanced biology", "Gregor Mendel", 1, 3, SubjectType.EXERCISE, EndsWith.CREDIT);
        Subject analysisA2 = new Subject("Mathematical analysis", "Carl F. Gauss", 3, 10, SubjectType.LECTURE, EndsWith.CREDIT);

        return new SubjectStore(new HashMap<>() {{
            put("MA000123W", analysis);
            put("BL00424C", biology);
            put("MA000423W", analysisA2);
        }});
    }
}
