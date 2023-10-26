package lab_one.models;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Faculty> faculties = new ArrayList<>();
    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }
    public List<Faculty> getFaculties() {
        return faculties;
    }

}

