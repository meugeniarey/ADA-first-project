package db.inicial.menu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import db.inicial.controller.InscripcionController;

public class MenuInscripcion {
	public static int imprimirSubMenu(Scanner sc) {
		System.out.println();
		System.out.println("Submenu Inscripciones: ");
		System.out.println("1. Alta de Inscripción");
		System.out.println("2. Cancelación de Inscripción");
		System.out.println("3. Listado de estudiantes por curso");
		System.out.println("4. Listado de notas de estudiantes por curso");
		System.out.println("0. Salir");
		System.out.println();
		System.out.println("Ingrese opcion: ");
		return sc.nextInt();
	}

	public static void listadoABML(Scanner sc, Connection connection, int InscripcionMenuOpcion) throws SQLException {
		switch (InscripcionMenuOpcion) {
		case 1:

			InscripcionController.alta(sc, connection);
			break;

		case 2:
			InscripcionController.cancelacion(connection);
			break;
		case 3:
			InscripcionController.listaInscriptosPorCurso(sc, connection);
			break;
		case 4:
			InscripcionController.listaNotasPorCurso(sc, connection);
			break;

		}
	}
}
