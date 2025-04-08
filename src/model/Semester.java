package model;

import java.util.ArrayList;

public class Semester {

    private int year;
    private int consecutive;
    private ArrayList<Course> courses; // Relacion con Course

    public Semester(int year, int consecutive) {
        this.year = year;
        this.consecutive = consecutive;
        courses = new ArrayList<Course>();
        testInfo();
    }

    public void testInfo() {

        addCourse("12", "APO", 3, 2);

        System.out.println(courses);

        addGradeInCourse("APO", 5.0, 0.25);
        addGradeInCourse("APO", 4.0, 0.75);

        addCourse("14", "Exploracion 1", 1, 1);
        
        addGradeInCourse("Exploracion 1", 5.0, 1);

    }

    public String getCourseTypeList() {

        String list = "";

        CourseType[] values = CourseType.values();

        for (int i = 0; i < values.length; i++) {

            list += (i + 1) + ". " + values[i] + "\n";

        }

        return list;

    }

    public CourseType calculateCourseType(int value) {

        CourseType type = CourseType.EXPLORACION;

        switch (value - 1) {
            case 1:
                type = CourseType.EXPLORACION;
                break;
            case 2:
                type = CourseType.NUCLEO_PROFESIONAL;
                break;
            case 3:
                type = CourseType.CURRICULO_CENTRAL;
                break;
            default:
                type = null;
                break;
        }

        return type;

    }

    public boolean addCourse(String id, String name, int credits, int type) {

        CourseType courseType = calculateCourseType(type);

        if (courseType == null) {
            return false;
        }

        Course newCourse = new Course(id, name, credits, courseType);

        return courses.add(newCourse);
    }

    public double calculateSemesterAverage() {

        double totalWeigthGrades = 0.0;
        double totalCredits = 0.0;

        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i) != null) {
                double finalGrade = courses.get(i).calculateFinalGrade();
                totalWeigthGrades += finalGrade * courses.get(i).getCredits();
                totalCredits += courses.get(i).getCredits();
            }
        }
        return totalWeigthGrades / totalCredits;
    }

    public String getCourseList() {

        String msg = "";
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i) != null) { // Evalucion de nulidad
                msg += (i + 1) + ". " + courses.get(i).getName() + ":" + courses.get(i).getId() + "\n";
            }
        }
        return msg;
    }

    public boolean addGradeInCourse(String name, double value, double weigth) {

        if (!courses.isEmpty()) {

            for (int i = 0; i < courses.size(); i++) {
                if(courses.get(i).getName().equals(name)){
                    return courses.get(i).addGrade(new Grade(value, weigth));
                }
            }
           
        }
        return false;

    }

    public double getCourseFinalGrade(int consecutive) {

        return courses.get(consecutive - 1).calculateFinalGrade();

    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getConsecutive() {
        return consecutive;
    }

    public void setConsecutive(int consecutive) {
        this.consecutive = consecutive;
    }

}
