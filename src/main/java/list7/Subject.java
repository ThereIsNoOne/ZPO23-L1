package list7;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

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

    public static Subject getFromJson() {
        File file = new File("./src/main/resources/subject.json");
        if (!file.exists()) {
            throw new RuntimeException("Could not find file:" + file.getPath());
        }
        return parseFromJson(file);
    }

    public static Subject getFromJson(String path) {
        File file = new File(path);
        if (!file.exists()) {
            throw new RuntimeException("Could not find file:" + file.getAbsolutePath());
        }
        return parseFromJson(file);
    }

    private static Subject parseFromJson(File file) {
        Subject subject;
        try (FileReader reader = new FileReader(file)) {
            JSONTokener jsonTokener = new JSONTokener(reader);
            JSONObject subjectObject = new JSONObject(jsonTokener);

            String name = subjectObject.getString("name");
            String teacher = subjectObject.getString("teacher");
            int hoursPerWeek = subjectObject.getInt("hoursPerWeek");
            int ectsAmount = subjectObject.getInt("ectsAmount");
            SubjectType type = SubjectType.valueOf(subjectObject.getString("subjectType"));
            EndsWith endsWith = EndsWith.valueOf(subjectObject.getString("endsWith"));
            subject = new Subject(name, teacher, hoursPerWeek, ectsAmount, type, endsWith);
        } catch (IOException e) {
            throw new RuntimeException("Could not read file:" + e.getMessage());
        }
        return subject;
    }

    public void putToJson(String outputPath) {
        File outputFile = new File(outputPath);

        if (!outputFile.exists()) {
            try {
                Files.createFile(Paths.get(outputPath));
            } catch (IOException e) {
                throw new RuntimeException("Could not create file: " + e.getMessage());
            }
        }

        parseToJson(outputFile);
    }

    public void putToJson() {
        File outputFile = new File(
                String.format("./src/main/resources/subject.json")
        );

        if (!outputFile.exists()) {
            try {
                Files.createFile(Paths.get(outputFile.getPath()));
            } catch (IOException e) {
                throw new RuntimeException("Could not create file: " + e.getMessage());
            }
        }

        parseToJson(outputFile);
    }

    private void parseToJson(File outputFile) {
        JSONObject subjectJson = new JSONObject();
        subjectJson.put("name", name);
        subjectJson.put("teacher", teacher);
        subjectJson.put("hoursPerWeek", hoursPerWeek);
        subjectJson.put("ectsAmount", EctsAmount);
        subjectJson.put("subjectType", type.name());
        subjectJson.put("endsWith", endsWith.name());

        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write(subjectJson.toString(4));
        } catch (IOException e) {
            throw new RuntimeException("Could not write to file: " + e.getMessage());
        }
    }


}
