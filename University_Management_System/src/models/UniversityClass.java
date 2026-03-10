package models;

import java.util.ArrayList;
import java.util.List;

public class UniversityClass {
    private String name;
    private String classroom;
    private List<Student> studentList;
    private Teacher teacher;

    public UniversityClass(String name, String classroom, Teacher teacher) {
        this.name = name;
        this.classroom = classroom;
        this.teacher = teacher;
        this.studentList = new ArrayList<>();
    }

    public boolean addStudentToClass(Student student) {
        for (Student s : studentList) {
            if (s.getId() == student.getId()) {
                return false;
            }
        }
        this.studentList.add(student);
        return true;
    }

    public String getName() {
        return name;
    }
    public String getClassroom() {
        return classroom;
    }
    public Teacher getTeacher() {
        return teacher;
    }
    public List<Student> getStudentList() {
        return studentList;
    }
}