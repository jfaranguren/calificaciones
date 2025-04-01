package model;

public class Course {

    private String id;
    private String name;
    private int credits;
    private CourseType type;
    private Grade[] grades; // Relacion en el diagrama de clases

    public Course(String id, String name, int credits, CourseType type) {
        this.id = id;
        this.name = name;
        this.credits = credits;
        this.type = type;
        grades = new Grade[4];
    }

    public double calculateFinalGrade() {

        double finalGrade = 0.0;

        for (int i = 0; i < grades.length; i++) {

            if (grades[i] != null) {
                finalGrade += grades[i].getValue() * grades[i].getWeigth();
            }
        }

        return finalGrade;
    }

    public boolean addGrade(Grade newGrade) {

        for (int i = 0; i < grades.length; i++) {
            if (grades[i] == null) {
                grades[i] = newGrade;
                return true;
            }

        }
        return false;
    }

    public Grade[] getGrades() {
        return grades;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

}
