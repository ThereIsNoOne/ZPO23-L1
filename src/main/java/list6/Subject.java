package list6;

/**
 * Class representing subject.
 */
public class Subject {

    private final String name;
    private String teacher;
    private final int hoursPerWeek;
    private final int EctsAmount;
    private final SubjectType type;
    private final EndsWith endsWith;

    /**
     * Initialize the subject instance.
     * @param name name of the subject.
     * @param teacher the teacher of the subject.
     * @param hoursPerWeek the hours of the subject in a week.
     * @param EctsAmount amount of ECTS points.
     * @param type type of the subject.
     * @param endsWith type of the test at the end of the subject.
     * @throws IllegalArgumentException if name or teacher is blank, hours per
     * week is not in range [0, 40) or when ECTS amount is negative.
     */
    public Subject(String name,
                   String teacher,
                   int hoursPerWeek,
                   int EctsAmount,
                   SubjectType type,
                   EndsWith endsWith) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Subject name cannot be blank.");
        }
        if (teacher.isBlank()) {
            throw new IllegalArgumentException("Teacher name cannot be blank.");
        }
        if (hoursPerWeek <= 0 || hoursPerWeek > 40) {
            throw new IllegalArgumentException("HoursPerWeek must be between 0 and 40");
        }
        if (EctsAmount < 0) {
            throw new IllegalArgumentException("EctsAmount must be positive");
        }
        this.type = type;
        this.EctsAmount = EctsAmount;
        this.name = name;
        this.teacher = teacher;
        this.hoursPerWeek = hoursPerWeek;
        this.endsWith = endsWith;
    }

    /**
     * Setter for the teacher field.
     * @param teacher name of the teacher.
     */
    public void setTeacher(String teacher) {
        if (teacher.isBlank()) {
            throw new IllegalArgumentException("Teacher name cannot be blank.");
        }
        this.teacher = teacher;
    }

    /**
     * To string method.
     * @return string representation of subject.
     */
    @Override
    public String toString() {
        return String.format("Subject: %s, teacher: %s, hors per week: %d, ECTS: %d, Type: %s and ends with: %S",
                name,
                teacher,
                hoursPerWeek,
                EctsAmount,
                type.name(),
                endsWith.name());
    }
}
