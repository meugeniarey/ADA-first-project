package db.inicial.menu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import db.inicial.controller.CursoController;

public class MenuCurso {
	public static int imprimirSubMenu(Scanner sc) {
		System.out.println();
		System.out.println("Submenu Curso: ");
		System.out.println("1. Alta curso");
		System.out.println("2. Listar cursos");
		System.out.println("3. Modificar curso");
		System.out.println("4. Baja curso");
		System.out.println("5. Buscar curso por nombre");
		System.out.println("0. Salir");
		System.out.println();
		System.out.println("Ingrese opcion: ");
		return sc.nextInt();

	}

	public static void listadoABML(Scanner sc, Connection connection, int cursoMenuOpcion) throws SQLException {
		switch (cursoMenuOpcion) {
		case 1:

			CursoController.alta(sc, connection);
			break;

		case 2:
			CursoController.lista(connection);
			break;
		case 3:
			CursoController.modificacion(sc, connection);
			break;
		case 4:
			CursoController.baja(sc, connection);
			break;
		case 5:
			CursoController.buscarPorNombre(sc, connection);
			break;

		}
	}

}
