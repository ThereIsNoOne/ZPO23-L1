package list6;

public class Subject {

    private final String name;
    private String teacher;
    private final int hoursPerWeek;
    private final int EctsAmount;
    private final SubjectType type;
    private final EndsWith endsWith;

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

    public void setTeacher(String teacher) {
        if (teacher.isBlank()) {
            throw new IllegalArgumentException("Teacher name cannot be blank.");
        }
        this.teacher = teacher;
    }

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
