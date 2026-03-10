package models;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Teacher> teachers;
    private List<Student> students;
    private List<UniversityClass> classes;

    public University() {
        this.teachers = new ArrayList<>();
        this.students = new ArrayList<>();
        this.classes = new ArrayList<>();

        initializeData();
    }

    private void initializeData() {
        FullTimeTeacher ft1 = new FullTimeTeacher("Dr. Smith", 2000, 10);
        FullTimeTeacher ft2 = new FullTimeTeacher("Dra. García", 2000, 5);
        PartTimeTeacher pt1 = new PartTimeTeacher("Ing. Perez", 50, 20);
        PartTimeTeacher pt2 = new PartTimeTeacher("Lic. Sosa", 50, 15);

        teachers.add(ft1);
        teachers.add(ft2);
        teachers.add(pt1);
        teachers.add(pt2);

        students.add(new Student(101, "Alice Johnson", 20));
        students.add(new Student(102, "Bob Miller", 22));
        students.add(new Student(103, "Charlie Davis", 19));
        students.add(new Student(104, "Diana Prince", 21));
        students.add(new Student(105, "Ethan Hunt", 23));
        students.add(new Student(106, "Fiona Apple", 20));

        UniversityClass math = new UniversityClass("Mathematics 101", "Room A1", ft1);
        math.addStudentToClass(students.get(0));
        math.addStudentToClass(students.get(1));

        UniversityClass physics = new UniversityClass("General Physics", "Room B2", ft2);
        physics.addStudentToClass(students.get(2));
        physics.addStudentToClass(students.get(3));

        UniversityClass programming = new UniversityClass("Java Basics", "Lab 1", pt1);
        programming.addStudentToClass(students.get(4));
        programming.addStudentToClass(students.get(0));

        UniversityClass history = new UniversityClass("World History", "Room C3", pt2);
        history.addStudentToClass(students.get(5));

        classes.add(math);
        classes.add(physics);
        classes.add(programming);
        classes.add(history);
    }

    public List<UniversityClass> getClassesByStudentId(int studentId) {
        List<UniversityClass> studentClasses = new ArrayList<>();
        for (UniversityClass uClass : classes) {
            for (Student student : uClass.getStudentList()) {
                if (student.getId() == studentId) {
                    studentClasses.add(uClass);
                    break;
                }
            }
        }
        return studentClasses;
    }

    public List<Teacher> getTeachers() { return teachers; }
    public List<Student> getStudents() { return students; }
    public List<UniversityClass> getClasses() { return classes; }

    public void addStudent(Student student)
    {
        this.students.add(student);
    }

    public void addClass(UniversityClass newClass)
    {
        this.classes.add(newClass);
    }

    public Student getStudentById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }
}