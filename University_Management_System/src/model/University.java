package model;

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