package ui;

import java.util.Scanner;
import model.Semester;

public class Executable {

    private Scanner reader;
    private Semester icesi;

    public Executable() {
        reader = new Scanner(System.in);
        icesi = new Semester(2025, 1);
    }

    public static void main(String[] args) {
        Executable exe = new Executable();
        exe.menu();

    }

    public void menu() {

        int option = 0;

        do {

            System.out.println("Bienvenido a Calificaciones");
            System.out.println("1. Registrar curso");
            System.out.println("2. Registrar calificacion en curso");
            System.out.println("3. Calcular nota definitiva de un curso");
            System.out.println("4. Calcular promedio del semestre");
            System.out.println("0. Salir");
            option = reader.nextInt();

            switch (option) {
                case 0:
                    System.out.println("Adios :D");
                    break;
                case 1:
                    registerCourse();
                    break;
                case 2:
                    registerGradeInCourse();
                    break;
                case 3:
                    showCourseFinalGrade();
                    break;
                case 4:
                    showSemesterAverage();
                    break;

                default:
                    System.out.println("Opcion invalida");
                    break;
            }

        } while (option != 0);

    }

    // Registrar un curso
    public void registerCourse() {

        reader.nextLine(); // Limpieza de buffer

        System.out.println("Digite el codigo del curso");
        String id = reader.nextLine();

        System.out.println("Digite el nombre del curso");
        String name = reader.nextLine();

        System.out.println("Digite los creditos del curso");
        int credits = reader.nextInt();

        System.out.println(icesi.getCourseTypeList());

        System.out.println("Digite el tipo del curso");
        int type = reader.nextInt();

        icesi.addCourse(id, name, credits, type); // Mensajes de confirmacion
    }

    // Registrar calificacion en curso

    public void registerGradeInCourse() {

        System.out.println("A que curso desea agregarle una nota?");
        System.out.println(icesi.getCourseList());
        int course = reader.nextInt();

        System.out.println("Digite el valor de la nota");
        double value = reader.nextDouble();

        System.out.println("Digite el peso de la nota");
        double weigth = reader.nextDouble();

        icesi.addGradeInCourse(course, value, weigth);

    }

    public void showCourseFinalGrade() {

        System.out.println("A que curso desea calcularle la nota definitiva?");
        System.out.println(icesi.getCourseList());
        int course = reader.nextInt();

        System.out.println(icesi.getCourseFinalGrade(course));

    }

    public void showSemesterAverage(){

        System.out.println(icesi.calculateSemesterAverage());

    }

}