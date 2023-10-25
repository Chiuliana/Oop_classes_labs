package labtwo.behavior;

import labtwo.models.Faculty;
import labtwo.models.Student;
import labtwo.models.StudyField;
import labtwo.models.University;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ApplicationLoop {
    private Scanner scanner;
    private University university;

    public ApplicationLoop() {
        this.scanner = new Scanner(System.in);
        this.university = new University();
    }
    public void run() {
        boolean quit = false;
        while (!quit) {
            System.out.println("Welcome to TUM's student management system!");
            System.out.println("What do you want to do?");
            System.out.println("g - General operations");
            System.out.println("f - Faculty operations");
            System.out.println("s - Student operations");
            System.out.println("q - Quit Program");

            String input = scanner.nextLine();

            switch (input) {
                case "g":
                    boolean generalQuit = false;
                    while (!generalQuit) {
                        System.out.println("General operations");
                        System.out.println("What do you want to do?");
                        System.out.println("nf/<faculty name>/<faculty abbreviation>/<field> - create faculty");
                        System.out.println("ss/<student email> - search student and show faculty");
                        System.out.println("df - display faculties");
                        System.out.println("df/<field> - display all faculties of a field");
                        System.out.println("b - Back");
                        System.out.println("q - Quit Program");

                        String generalInput = scanner.nextLine();

                        switch (generalInput) {
                            case "nf":
                                System.out.println("Enter faculty name:");
                                String facultyName = scanner.nextLine();

                                System.out.println("Enter faculty abbreviation:");
                                String facultyAbbreviation = scanner.nextLine();

                                System.out.println("Enter field:");
                                String field = scanner.nextLine();

                                // Display faculty information
                                displayFacultyInformation(facultyName, facultyAbbreviation, field);

                                // Create a new faculty
                                Faculty newFaculty = new Faculty(facultyName, facultyAbbreviation, new ArrayList<>(), StudyField.valueOf(field));

                                // Add the new faculty to the university
                                university.addFaculty(newFaculty);

                                System.out.println("Faculty created successfully.");
                                break;

                            case "ss":
                                System.out.println("Enter student email:");
                                String studentEmail = scanner.nextLine();

                                // Find the student by email
                                Student student = findStudentByEmail(studentEmail);

                                if (student != null) {
                                    // Find the faculty of the student
                                    Faculty faculty = findFacultyForStudent(student);

                                    if (faculty != null) {
                                        System.out.println("Student belongs to Faculty:");
                                        System.out.println("Name: " + faculty.getName() + ", Abbreviation: " + faculty.getAbbreviation() + ", Field: " + faculty.getStudyField());

                                        // Display faculty information
                                        displayFacultyInformation(faculty.getName(), faculty.getAbbreviation(), faculty.getStudyField().toString());
                                    } else {
                                        System.out.println("Student does not belong to any faculty.");
                                    }
                                } else {
                                    System.out.println("Student not found.");
                                }
                                break;

                            case "df":
                                System.out.println("University Faculties:");
                                for (Faculty faculty : university.getFaculties()) {
                                    System.out.println("Name: " + faculty.getName() + ", Abbreviation: " + faculty.getAbbreviation() + ", Field: " + faculty.getStudyField());
                                }
                                break;
                            case "df/<field>":
                                System.out.println("Enter field:");
                                String displayField = scanner.nextLine();

                                try {
                                    StudyField fieldToDisplay = StudyField.valueOf(displayField);

                                    System.out.println("Faculties belonging to " + fieldToDisplay + ":");
                                    for (Faculty faculty : university.getFaculties()) {
                                        if (faculty.getStudyField() == fieldToDisplay) {
                                            System.out.println("Name: " + faculty.getName() + ", Abbreviation: " + faculty.getAbbreviation());
                                        }
                                    }
                                } catch (IllegalArgumentException e) {
                                    System.out.println("Invalid input. Please try again.");
                                }

                                break;
                            case "b":
                                generalQuit = true;
                                break;
                            case "q":
                                quit = true;
                                System.out.println("Program terminated.");
                                break;
                            default:
                                System.out.println("Invalid input. Please try again.");
                                break;
                        }
                    }
                    break;
                case "f":
                    boolean facultyQuit = false;
                    while (!facultyQuit) {
                        System.out.println("Faculty operations");
                        System.out.println("What do you want to do?");
                        System.out.println("ns/<faculty abbreviation>/<first name>/<last name>/<email>/<day>/<month>/<year> - create student");
                        System.out.println("gs/<email> - graduate student");
                        System.out.println("ds/<faculty abbreviation> - display enrolled students");
                        System.out.println("dg/<faculty abbreviation> - display graduated students");
                        System.out.println("bf/<faculty abbreviation>/<email> - check if student belongs to faculty");
                        System.out.println("b - Back");
                        System.out.println("q - Quit Program");

                        String facultyInput = scanner.nextLine();

                        switch (facultyInput) {
                            case "ns":
                                createAndAssignStudentToFaculty();
                                break;
                            case "gs":
                                graduateStudentFromFaculty();
                                break;
                            case "ds":
                                displayEnrolledStudents();
                                break;
                            case "dg":
                                displayGraduates();
                                break;
                            case "bf":
                                checkStudentBelongs();
                                break;
                            case "b":
                                facultyQuit = true;
                                break;
                            case "q":
                                quit = true;
                                System.out.println("Program terminated.");
                                break;
                            default:
                                System.out.println("Invalid input. Please try again.");
                                break;
                        }
                    }
                    break;
                case "s":
                    boolean studentQuit = false;
                    while (!studentQuit) {
                        System.out.println("Student operations");
                        System.out.println("What do you want to do?");
                        System.out.println("ns/<faculty abbreviation>/<first name>/<last name>/<email>/<day>/<month>/<year> - create student");
                        System.out.println("ds/<faculty abbreviation>/<email> - display student details");
                        System.out.println("ms/<faculty abbreviation>/<email> - modify student details");
                        System.out.println("rs/<faculty abbreviation>/<email> - remove student from faculty");
                        System.out.println("ls/<faculty abbreviation> - list all students enrolled in faculty");
                        System.out.println("lg/<faculty abbreviation> - list all graduates from faculty");
                        System.out.println("b - Back");

                        String studentInput = scanner.nextLine();

                        switch (studentInput) {
                            case "ns":
                                createAndAssignStudentToFaculty();
                                break;
                            case "ds":
                                displayStudentDetails();
                                break;
                            case "ms":
                                modifyStudentDetails();
                                break;
                            case "rs":
                                removeStudentFromFaculty();
                                break;
                            case "ls":
                                listEnrolledStudents();
                                break;
                            case "lg":
                                listGraduates();
                                break;
                            case "b":
                                studentQuit = true;
                                break;
                            default:
                                System.out.println("Invalid input. Please try again.");
                                break;
                        }
                    }
                    break;
                case "q":
                    quit = true;
                    System.out.println("Program terminated.");
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        }
    }
    private void displayFacultyInformation(String facultyName, String facultyAbbreviation, String field) {
        System.out.println("Faculty Information:");
        System.out.println("Name: " + facultyName);
        System.out.println("Abbreviation: " + facultyAbbreviation);
        System.out.println("Field: " + field);
    }


    // 1. Create and assign a student to a faculty
    private void createAndAssignStudentToFaculty() {
        System.out.println("Enter faculty abbreviation:");
        String facultyAbbreviation = scanner.nextLine();

        // Find the faculty with the given abbreviation
        Faculty faculty = findFacultyByAbbreviation(facultyAbbreviation);

        if (faculty != null) {
            // Gather student information
            System.out.println("Enter student first name:");
            String firstName = scanner.nextLine();

            System.out.println("Enter student last name:");
            String lastName = scanner.nextLine();

            System.out.println("Enter student email:");
            String email = scanner.nextLine();

            // a method to input dates
            Date enrollmentDate = inputEnrollmentDate();
            Date dateOfBirth = inputDateOfBirth();

            // Create a new student
            Student student = new Student(firstName, lastName, email, enrollmentDate, dateOfBirth);

            // Assign the student to the faculty
            faculty.addStudent(student);

            System.out.println("Student created and assigned successfully.");
        } else {
            System.out.println("Faculty not found.");
        }
    }private void displayStudentDetails() {
        System.out.println("Enter faculty abbreviation:");
        String facultyAbbreviation = scanner.nextLine();

        System.out.println("Enter student email:");
        String studentEmail = scanner.nextLine();

        // Find the faculty with the given abbreviation
        Faculty faculty = findFacultyByAbbreviation(facultyAbbreviation);

        if (faculty != null) {
            // Find the student by email
            Student student = findStudentByEmail(studentEmail);

            if (student != null) {
                System.out.println("Student Details:");
                System.out.println("First Name: " + student.getFirstName());
                System.out.println("Last Name: " + student.getLastName());
                System.out.println("Email: " + student.getEmail());
                System.out.println("Enrollment Date: " + student.getEnrollmentDate());
                System.out.println("Date of Birth: " + student.getDateOfBirth());
            } else {
                System.out.println("Student not found.");
            }
        } else {
            System.out.println("Faculty not found.");
        }
    }
    private void modifyStudentDetails() {
        System.out.println("Enter faculty abbreviation:");
        String facultyAbbreviation = scanner.nextLine();

        System.out.println("Enter student email:");
        String studentEmail = scanner.nextLine();

        // Find the faculty with the given abbreviation
        Faculty faculty = findFacultyByAbbreviation(facultyAbbreviation);

        if (faculty != null) {
            // Find the student by email
            Student student = findStudentByEmail(studentEmail);

            if (student != null) {
                // Gather modified student information
                System.out.println("Enter new first name:");
                String newFirstName = scanner.nextLine();

                System.out.println("Enter new last name:");
                String newLastName = scanner.nextLine();

                System.out.println("Enter new email:");
                String newEmail = scanner.nextLine();

                // a method to input dates
                Date newEnrollmentDate = inputEnrollmentDate();
                Date newDateOfBirth = inputDateOfBirth();

                // Modify the student details
                student.setFirstName(newFirstName);
                student.setLastName(newLastName);
                student.setEmail(newEmail);
                student.setEnrollmentDate(newEnrollmentDate);
                student.setDateOfBirth(newDateOfBirth);

                System.out.println("Student details modified successfully.");
            } else {
                System.out.println("Student not found.");
            }
        } else {
            System.out.println("Faculty not found.");
        }
    }
    private void removeStudentFromFaculty() {
        System.out.println("Enter faculty abbreviation:");
        String facultyAbbreviation = scanner.nextLine();

        System.out.println("Enter student email:");
        String studentEmail = scanner.nextLine();

        // Find the faculty with the given abbreviation
        Faculty faculty = findFacultyByAbbreviation(facultyAbbreviation);

        if (faculty != null) {
            // Find the student by email
            Student student = findStudentByEmail(studentEmail);

            if (student != null) {
                // Remove the student from the faculty
                faculty.removeStudent(student);

                System.out.println("Student removed from faculty successfully.");
            } else {
                System.out.println("Student not found.");
            }
        } else {
            System.out.println("Faculty not found.");
        }
    }
    private void listEnrolledStudents() {
        System.out.println("Enter faculty abbreviation:");
        String facultyAbbreviation = scanner.nextLine();

        // Find the faculty with the given abbreviation
        Faculty faculty = findFacultyByAbbreviation(facultyAbbreviation);

        if (faculty != null) {
            System.out.println("Enrolled students in " + faculty.getName() + ":");
            for (Student student : faculty.getStudents()) {
                System.out.println(student.getFirstName() + " " + student.getLastName());
            }
        } else {
            System.out.println("Faculty not found.");
        }
    }
    private void listGraduates() {
        System.out.println("Enter faculty abbreviation:");
        String facultyAbbreviation = scanner.nextLine();

        // Find the faculty with the given abbreviation
        Faculty faculty = findFacultyByAbbreviation(facultyAbbreviation);

        if (faculty != null) {
            System.out.println("Graduates from " + faculty.getName() + ":");
            for (Student student : faculty.getGraduates()) {
                System.out.println(student.getFirstName() + " " + student.getLastName());
            }
        } else {
            System.out.println("Faculty not found.");
        }
    }

    private Faculty findFacultyByAbbreviation(String abbreviation) {
        for (Faculty faculty : university.getFaculties()) {
            if (faculty.getAbbreviation().equals(abbreviation)) {
                return faculty;
            }
        }
        return null;
    }
    private Date inputDate(String message) {
        System.out.println(message);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;

        boolean validInput = false;
        while (!validInput) {
            String userInput = scanner.nextLine();
            try {
                date = dateFormat.parse(userInput);
                validInput = true;
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please use dd/MM/yyyy.");
            }
        }

        return date;
    }

    private Date inputEnrollmentDate() {
        Date date = inputDate("Enter enrollment date (dd/MM/yyyy):");
        if (date != null && date.after(new Date())) {
            System.out.println("Enrollment date cannot be in the future.");
            return null;
        }
        return date;
    }

    private Date inputDateOfBirth() {
        return inputDate("Enter date of birth (dd/MM/yyyy):");
    }
    // 2. Graduate a student from a faculty
    private void graduateStudentFromFaculty() {
        System.out.println("Enter faculty abbreviation:");
        String facultyAbbreviation = scanner.nextLine();

        // Find the faculty with the given abbreviation
        Faculty faculty = findFacultyByAbbreviation(facultyAbbreviation);

        if (faculty != null) {
            System.out.println("Enter student email:");
            String studentEmail = scanner.nextLine();

            // Find the student by email
            Student student = findStudentByEmail(studentEmail);

            if (student != null) {
                // Remove the student from the faculty
                faculty.removeStudent(student);

                System.out.println("Student graduated successfully.");
            } else {
                System.out.println("Student not found.");
            }
        } else {
            System.out.println("Faculty not found.");
        }
    }
    private Student findStudentByEmail(String email) {
        for (Faculty faculty : university.getFaculties()) {
            for (Student student : faculty.getStudents()) {
                if (student.getEmail().equals(email)) {
                    return student;
                }
            }
        }
        return null;
    }
    private Faculty findFacultyForStudent(Student student) {
        for (Faculty faculty : university.getFaculties()) {
            if (faculty.getStudents().contains(student)) {
                return faculty;
            }
        }
        return null;
    }

    // 3. Display current enrolled students
    private void displayEnrolledStudents() {
        System.out.println("Enter faculty abbreviation:");
        String facultyAbbreviation = scanner.nextLine();

        // Find the faculty with the given abbreviation
        Faculty faculty = findFacultyByAbbreviation(facultyAbbreviation);

        if (faculty != null) {
            System.out.println("Enrolled students:");
            for (Student student : faculty.getStudents()) {
                System.out.println(student.getFirstName() + " " + student.getLastName());
            }
        } else {
            System.out.println("Faculty not found.");
        }
    }
    // 4. Display graduates
    private void displayGraduates() {
        System.out.println("Enter faculty abbreviation:");
        String facultyAbbreviation = scanner.nextLine();

        // Find the faculty with the given abbreviation
        Faculty faculty = findFacultyByAbbreviation(facultyAbbreviation);

        if (faculty != null) {
            System.out.println("Graduated students:");
            for (Student student : faculty.getGraduates()) {
                System.out.println(student.getFirstName() + " " + student.getLastName());
            }
        } else {
            System.out.println("Faculty not found.");
        }
    }
    // 5. Tell or not if a student belongs to this faculty
    private void checkStudentBelongs() {
        System.out.println("Enter faculty abbreviation:");
        String facultyAbbreviation = scanner.nextLine();

        // Find the faculty with the given abbreviation
        Faculty faculty = findFacultyByAbbreviation(facultyAbbreviation);

        if (faculty != null) {
            System.out.println("Enter student email:");
            String studentEmail = scanner.nextLine();

            // Find the student by email
            Student student = findStudentByEmail(studentEmail);

            if (student != null && faculty.getStudents().contains(student)) {
                System.out.println("Yes, the student belongs to this faculty.");
            } else {
                System.out.println("No, the student does not belong to this faculty.");
            }
        } else {
            System.out.println("Faculty not found.");
        }
    }

}

