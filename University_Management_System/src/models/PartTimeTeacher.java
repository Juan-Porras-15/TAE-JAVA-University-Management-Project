package models;

public class PartTimeTeacher extends Teacher {
    private int activeHoursPerWeek;

    public PartTimeTeacher(String name, double baseSalary, int activeHoursPerWeek) {
        super(name, baseSalary); //
        this.activeHoursPerWeek = activeHoursPerWeek;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() * activeHoursPerWeek;
    }

    public int getActiveHoursPerWeek() {
        return activeHoursPerWeek;
    }
}