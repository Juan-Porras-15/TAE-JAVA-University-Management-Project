package models;

public class Student {
    private static int nextId = 106;
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = ++nextId;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }
}