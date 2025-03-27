package ui;

import java.util.Scanner;

public class Executable {

    private Scanner reader;

    public Executable() {
        reader = new Scanner(System.in);
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

            switch (option) {
                case 0:
                    System.out.println("Adios :D");
                    break;
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;

                default:
                    System.out.println("Opcion invalida");
                    break;
            }

        } while (option != 0);

    }

}