package model;
import java.util.ArrayList;

public class Course {

    private String id;
    private String name;
    private int credits;
    private CourseType type;
    private ArrayList<Grade> grades; // Relacion en el diagrama de clases

    public Course(String id, String name, int credits, CourseType type) {
        this.id = id;
        this.name = name;
        this.credits = credits;
        this.type = type;
        grades = new ArrayList<Grade>();
    }

    public double calculateFinalGrade() {

        double finalGrade = 0.0;

        for (int i = 0; i < grades.size(); i++) {

            if (grades.get(i) != null) {
                finalGrade += grades.get(i).getValue() * grades.get(i).getWeigth();
            }
        }

        return finalGrade;
    }

    public boolean addGrade(Grade newGrade) {
        return grades.add(newGrade);
    }

    public ArrayList<Grade> getGrades() {
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

    public CourseType getType() {
        return type;
    }

    public void setType(CourseType type) {
        this.type = type;
    }

    

}
