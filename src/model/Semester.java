package model;

public class Semester {

    private int year;
    private int consecutive;
    private Course[] courses; // Relacion con Course

    public Semester(int year, int consecutive) {
        this.year = year;
        this.consecutive = consecutive;
        courses = new Course[10];
        testInfo();
    }

    public void testInfo() {

        addCourse("12", "APO", 3, 2);

        addGradeInCourse(1, 5.0, 0.25);
        addGradeInCourse(1, 4.0, 0.75);

        addCourse("14", "Exploracion 1", 1, 1);
        addGradeInCourse(2, 5.0, 1);

    }

    public String getCourseTypeList(){

        String list="Estos son los tipos registrados\n";
        CourseType[] values = CourseType.values();

        for (int i = 0; i < values.length; i++) {
            list+=(i+1)+". "+values[i]+"\n";
        }
        return list;
    }

    public CourseType calculateCourseType(int type) {

        CourseType courseType = null;
        switch (type) {
            case 1:
                courseType = CourseType.EXPLORACION;
                break;
            case 2:
                courseType = CourseType.NUCLEO_PROFESIONAL;
                break;
            case 3:
                courseType = CourseType.PROYECCION_FLEXIBLE;
                break;
            case 4:
                courseType = CourseType.CURRICULO_CENTRAL;
                break;
            default:
                courseType = CourseType.NUCLEO_PROFESIONAL;
                break;
        }
        return courseType;
    }

    public boolean addCourse(String id, String name, int credits, int type) {

        Course newCourse = new Course(id, name, credits, calculateCourseType(type));

        for (int i = 0; i < courses.length; i++) {
            if (courses[i] == null) {
                courses[i] = newCourse;
                return true;
            }
        }
        return false;
    }

    public double calculateSemesterAverage() {

        double totalWeigthGrades = 0.0;
        double totalCredits = 0.0;

        for (int i = 0; i < courses.length; i++) {
            if (courses[i] != null) {
                double finalGrade = courses[i].calculateFinalGrade();
                totalWeigthGrades += finalGrade * courses[i].getCredits();
                totalCredits += courses[i].getCredits();
            }
        }
        return totalWeigthGrades / totalCredits;
    }

    public String getCourseList() {

        String msg = "";
        for (int i = 0; i < courses.length; i++) {
            if (courses[i] != null) { // Evalucion de nulidad
                msg += (i + 1) + ". " + courses[i].getName() + ":" + courses[i].getId() + "\n";
            }
        }
        return msg;
    }

    public boolean addGradeInCourse(int consecutive, double value, double weigth) {

        Course myCourse = courses[consecutive - 1];
        Grade newGrade = new Grade(value, weigth);
        return myCourse.addGrade(newGrade);

    }

    public double getCourseFinalGrade(int consecutive) {

        return courses[consecutive - 1].calculateFinalGrade();

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
