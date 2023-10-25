package labtwo.models;

import labtwo.models.StudyField;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private String name;
    private String abbreviation;
    private List<Student> students;
    private List<Student> graduates;
    private StudyField studyField;

    public Faculty(String name, String abbreviation, List<Student> students, StudyField studyField) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.students = students;
        this.studyField = studyField;
        this.graduates = new ArrayList<>();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public StudyField getStudyField() { // Change the return type to StudyField enum
        return studyField;
    }

    public void setStudyField(StudyField studyField) { // Change the parameter type
        this.studyField = studyField;
    }

    // Additional methods for managing students
    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
    }
    public List<Student> getGraduates() {
        return graduates;
    }

    public void addGraduate(Student student) {
        graduates.add(student);
        students.remove(student); // Remove from enrolled students
    }

}
