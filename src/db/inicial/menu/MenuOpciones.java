package db.inicial.menu;

import java.util.Scanner;

public class MenuOpciones {
	public static int imprimirMenuOpciones(Scanner sc) {
		System.out.println();
		System.out.println("Menu: ");
		System.out.println("1. Curso");
		System.out.println("2. Estudiantes");
		System.out.println("3. Profesores");
		System.out.println("4. Inscripcion");
		System.out.println("0. Salir");
		System.out.println();
		System.out.println("Ingrese el numero de opcion: ");
		return sc.nextInt();
	}

}
