package list6;


import java.util.Map;

/**
 * Class storing subjects.
 */
public class SubjectStore {
    private Map<String, Subject> subjects;

    /**
     * Initializes a new instance of the SubjectStore class.
     * @param subjects subjects to store.
     */
    public SubjectStore(Map<String, Subject> subjects) {
        this.subjects = subjects;
    }

    /**
     * Adds new Subject to the list of subjects.
     * @param code Subject code.
     * @param subject Subject to add.
     * @throws KeyAlreadyExist if the Subject with given code already exists.
     */
    public void add(String code, Subject subject) {
        if (subjects.containsKey(code)) {
            throw new KeyAlreadyExist("Key already exists!");
        }
        subjects.put(code, subject);
    }

    /**
     * Sets the subject for given code, if code do not exist, method creates it.
     * Works similarly to {@link #add(String, Subject)}, but do not prevent
     * modification of existing Subject.
     * @param code Subject code.
     * @param subject Subject to add/set.
     */
    public void set(String code, Subject subject) {
        subjects.put(code, subject);
    }

    /**
     * Removes subject with given code.
     * @param code code of subject to be removed.
     */
    public void remove(String code) {
        subjects.remove(code);
    }

    /**
     * String representation of Subject store object.
     * @return representation of subject store object.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Subject> entry : subjects.entrySet()) {
            builder.append(String.format("%s -> %s\n", entry.getKey(), entry.getValue()));
        }
        return builder.toString();
    }
    
}
