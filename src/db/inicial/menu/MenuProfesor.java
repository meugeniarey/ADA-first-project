package db.inicial.menu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import db.inicial.controller.ProfesorController;

public class MenuProfesor {
	public static int imprimirSubMenu(Scanner sc) {
		System.out.println();
		System.out.println("Submenu Profesor: ");
		System.out.println("1. Alta Profesor");
		System.out.println("2. Listar Profesores");
		System.out.println("3. Modificar Profesor");
		System.out.println("4. Baja Profesor");
		System.out.println("5. Buscar Profesor por nombre");
		System.out.println("0. Salir");
		System.out.println();
		System.out.println("Ingrese opcion: ");
		return sc.nextInt();
	}

	public static void listadoABML(Scanner sc, Connection connection, int profesorMenuOpcion) throws SQLException {
		switch (profesorMenuOpcion) {
		case 1:

			ProfesorController.alta(sc, connection);
			break;

		case 2:
			ProfesorController.lista(connection);
			break;
		case 3:
			ProfesorController.modificacion(sc, connection);
			break;
		case 4:
			ProfesorController.baja(sc, connection);
			break;
		case 5:
			ProfesorController.buscarPorNombre(sc, connection);
			break;

		}
	}

}
