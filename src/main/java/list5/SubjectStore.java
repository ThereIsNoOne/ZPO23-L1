package list5;

import java.util.HashMap;
import java.util.Map;

public class SubjectStore {
    private Map<String, Subject> subjects;

    public SubjectStore(Map<String, Subject> subjects) {
        this.subjects = subjects;
    }

    public void add(String code, Subject subject) {
        if (subjects.containsKey(code)) {
            throw new KeyAlreadyExist("Key already exists!");
        }
        subjects.put(code, subject);
    }

    public void set(String code, Subject subject) {
        subjects.put(code, subject);
    }

    public void remove(String code) {
        subjects.remove(code);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Subject> entry : subjects.entrySet()) {
            builder.append(String.format("%s -> %s\n", entry.getKey(), entry.getValue()));
        }
        return builder.toString();
    }
    
}
