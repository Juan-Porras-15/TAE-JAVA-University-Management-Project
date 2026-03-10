package model;

public class FullTimeTeacher extends Teacher {
    private int experienceYears;

    public FullTimeTeacher(String name, double baseSalary, int experienceYears) {
        super(name, baseSalary);
        this.experienceYears = experienceYears;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() * (1.1 * experienceYears);
    }

    public int getExperienceYears() {
        return experienceYears;
    }
}