package db.inicial.menu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import db.inicial.controller.EstudianteController;

public class MenuEstudiante {
	public static int imprimirSubMenu(Scanner sc) {
		System.out.println();
		System.out.println("Submenu Estudiante: ");
		System.out.println("1. Alta estudiante");
		System.out.println("2. Listar estudiante");
		System.out.println("3. Modificar estudiante");
		System.out.println("4. Baja estudiante");
		System.out.println("5. Buscar estudiante por apellido");
		System.out.println("0. Salir");
		System.out.println();
		System.out.println("Ingrese opcion: ");
		return sc.nextInt();
	}

	public static void listadoABML(Scanner sc, Connection connection, int estudianteMenuOpcion) throws SQLException {
		switch (estudianteMenuOpcion) {
		case 1:

			EstudianteController.alta(sc, connection);
			break;

		case 2:
			EstudianteController.lista(connection);
			break;
		case 3:
			EstudianteController.modificacion(sc, connection);
			break;
		case 4:
			EstudianteController.baja(sc, connection);
			break;
		case 5:
			EstudianteController.buscarPorApellido(sc, connection);
			break;

		}
	}
}
