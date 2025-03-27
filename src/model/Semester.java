package model;

public class Semester {

    private int year;
    private int consecutive;
    private Course[] courses; // Relacion con Course

    public Semester(int year, int consecutive) {
        this.year = year;
        this.consecutive = consecutive;
        courses = new Course[10];
    }

    public boolean addCourse(String id, String name, int credits){

        Course newCourse = new Course(id, name, credits);

        for (int i = 0; i < courses.length; i++) {
            if(courses[i]==null){
                courses[i]= newCourse;
                return true;
            }
        }
        return false;
    }

    public double calculateSemesterAverage(){

        

        return 0.0;
    }

    public Course[] getCourses() {
        return courses;
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
