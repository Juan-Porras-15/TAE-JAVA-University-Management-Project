package services;

import models.*;
import utils.InputValidator;
import java.util.List;

public class UniversityService implements IUniversityService {
    private final University university;

    public UniversityService() {
        this.university = new University();
    }

    @Override
    public void displayAllTeachers() {
        System.out.println("\n--- ALL TEACHERS ---");
        for (Teacher t : university.getTeachers()) {
            System.out.printf("Name: %-15s | Base Salary: $%-8.2f | Final Salary: $%-8.2f\n",
                    t.getName(), t.getBaseSalary(), t.calculateSalary());
        }
    }

    @Override
    public void displayClassesAndDetails() {
        List<UniversityClass> classes = university.getClasses();
        System.out.println("\n--- ALL CLASSES ---");
        for (int i = 0; i < classes.size(); i++) {
            System.out.println((i + 1) + ". " + classes.get(i).getName());
        }

        int choice = InputValidator.readInt("Please select a class to se its details (0 to go back): ", 0, classes.size());
        if (choice == 0) return;

        UniversityClass selected = classes.get(choice - 1);
        System.out.println("\n--- CLASS DETAIL ---");
        System.out.println("Class: " + selected.getName() + " | Classroom: " + selected.getClassroom());
        System.out.println("Teacher: " + selected.getTeacher().getName());
        System.out.println("Enrolled Students:");
        for (Student s : selected.getStudentList()) {
            System.out.println(" - " + s.getName() + " (ID: " + s.getId() + ")");
        }
    }

    @Override
    public void registerNewStudent() {
        System.out.println("\n--- REGISTER NEW STUDENT ---");

        String name = InputValidator.readNonEmptyString("Student's Name: ");
        int age = InputValidator.readInt("Age: ", 15, 99);

        Student newStudent = new Student(name, age);
        university.addStudent(newStudent);

        System.out.println("The student was created successfully! It's ID is: " + newStudent.getId());

        System.out.println("\nSelect a class to enroll the student:");
        displayClassesShort();
        int classChoice = InputValidator.readInt("Class number: ", 1, university.getClasses().size());
        UniversityClass selectedClass = university.getClasses().get(classChoice - 1);

        if (selectedClass.addStudentToClass(newStudent)) {
            System.out.println("Success: " + name + " was enrolled in:  " + selectedClass.getName());
        } else {
            System.out.println("Error: The student is already enrolled in this class");
        }
    }

    @Override
    public void createNewUniversityClass() {
        String name = InputValidator.readNonEmptyString("Class Name: ");
        String room = InputValidator.readNonEmptyString("Classroom: ");

        System.out.println("Please assign a teacher:");
        List<Teacher> teachers = university.getTeachers();
        for (int i = 0; i < teachers.size(); i++) {
            System.out.println((i + 1) + ". " + teachers.get(i).getName());
        }
        int tIdx = InputValidator.readInt("Select the teacher: ", 1, teachers.size());

        UniversityClass newClass = new UniversityClass(name, room, teachers.get(tIdx - 1));

        int numStudents = InputValidator.readInt("How many students would you like to enroll?: ", 1, university.getStudents().size());
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Select the student " + (i+1) + ":");
            displayStudentsShort();
            int sIdx = InputValidator.readInt("Student Number: ", 1, university.getStudents().size());
            newClass.addStudentToClass(university.getStudents().get(sIdx - 1));
        }

        university.addClass(newClass);
        System.out.println("Class created successfully!");
    }

    @Override
    public void listClassesByStudentId() {
        int id = InputValidator.readInt("Input the ID of the student to search: ", 1, 999999);
        List<UniversityClass> matches = university.getClassesByStudentId(id);

        if (matches.isEmpty()) {
            System.out.println("No classes enrolled for student with ID: " + id);
        } else {
            System.out.println("The student is enrolled in:");
            for (UniversityClass c : matches) {
                System.out.println(" - " + c.getName() + " (" + c.getClassroom() + ")");
            }
        }
    }

    @Override
    public void displayAllStudents() {
        List<Student> students = university.getStudents();

        if (students.isEmpty()) {
            System.out.println("\nNo students registered in the system.");
            return;
        }

        System.out.println("\n--- DETAILED STUDENT LIST ---");
        System.out.printf("%-5s | %-20s | %-5s | %-30s\n", "ID", "NOMBRE", "EDAD", "CLASES INSCRITAS");
        System.out.println("--------------------------------------------------------------------------------");

        for (Student s : students) {
            List<UniversityClass> studentClasses = university.getClassesByStudentId(s.getId());

            String classNames = studentClasses.isEmpty() ? "None" : "";
            for (int i = 0; i < studentClasses.size(); i++) {
                classNames += studentClasses.get(i).getName();
                if (i < studentClasses.size() - 1) classNames += ", ";
            }

            System.out.printf("%-5d | %-20s | %-5d | %-30s\n",
                    s.getId(), s.getName(), s.getAge(), classNames);
        }
    }

    @Override
    public void enrollExistingStudentToClass() {
        System.out.println("\n--- ENROLL EXISTING STUDENT ---");

        int id = InputValidator.readInt("Provide the student ID: ", 1, 999999);
        Student student = university.getStudentById(id);

        if (student == null) {
            System.out.println("Error: No student found with ID: " + id);
            return;
        }

        System.out.println("Selected student: " + student.getName());

        System.out.println("Select a class to enroll the student.");
        displayClassesShort();
        int classChoice = InputValidator.readInt("Class number: ", 1, university.getClasses().size());
        UniversityClass selectedClass = university.getClasses().get(classChoice - 1);

        if (selectedClass.addStudentToClass(student)) {
            System.out.println("Success! " + student.getName() + " is now enrolled in " + selectedClass.getName());
        } else {
            System.out.println("Warning: The student was already enrolled in this class.");
        }
    }

    private void displayClassesShort() {
        for (int i = 0; i < university.getClasses().size(); i++) {
            System.out.println((i + 1) + ". " + university.getClasses().get(i).getName());
        }
    }

    private void displayStudentsShort() {
        for (int i = 0; i < university.getStudents().size(); i++) {
            System.out.println((i + 1) + ". " + university.getStudents().get(i).getName());
        }
    }
}