package list7;

public class Main {
    public static void main(String[] args) {
        ComplexNumber.processComplexData("./src/main/resources/data.dat", false);
        Subject subject = new Subject("Math",
                "Professor",
                15,
                4,
                SubjectType.LABORATORY,
                EndsWith.EXAM);

    }
}
