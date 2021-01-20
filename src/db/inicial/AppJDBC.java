package db.inicial;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import db.inicial.DAO.AdminDB;
import db.inicial.menu.MenuCurso;
import db.inicial.menu.MenuEstudiante;
import db.inicial.menu.MenuInscripcion;
import db.inicial.menu.MenuOpciones;
import db.inicial.menu.MenuProfesor;

//Menu: 1.cursos 2:estudiantes 3:inscripciones
//Necesitamos alta, listado, modificacion y baja de alumno y de curso
//Inscripcion, cancelacion, listados (varios)

//5/1 Retorno a clases: consultas sobre el trabajo.
//Consigna del trabajo para el 7/1:
//OK1. ABML de profes
//2. Inscripcion y cancelacion de inscripcion -> columna estado_inscripcion 1 Activo 0:Cancelado
// Inscripcion y cancelacion por Id de estudiante y Id de curso
//OK3. Agregar 2 notas a la tabla inscripcion (int)
//OK4. Agregar columna id_profesor en la inscripcion
//OK5. Agregar columna comision (varchar) en la inscripcion
//5. 2 Listados de inscripcion:
//a - esutiantes de un curso seleccionado (a eleccion)
//b - notas de un estudiante en un curso

public class AppJDBC {
	public static void main(String[] args) {

		try {
			Connection connection = AdminDB.obtenerConexion("com.mysql.cj.jdbc.Driver");
			System.out.println("SISTEMA DE CURSOS");
			Scanner sc = new Scanner(System.in);
			System.out.println();
			int opcion = MenuOpciones.imprimirMenuOpciones(sc);

			while (opcion != 0) {
				try {

					switch (opcion) {
					case 1:
						curso(sc, connection);
						break;
					case 2:
						estudiante(sc, connection);
						break;
					case 3:
						profesor(sc, connection);
						break;
					case 4:
						inscripcion(sc, connection);
						break;
					}
				} catch (SQLException e) {
					System.err.println("Error: " + e.getMessage());
				} catch (Exception e) {
					System.err.println("Error: " + e.getMessage());
				}

				opcion = MenuOpciones.imprimirMenuOpciones(sc);
			}
			connection.close(); // esta bien aca?

		} catch (Exception e) {
			System.err.println("Error en ejecución SQL: " + e.getMessage());
		}

	}

	private static void curso(Scanner sc, Connection connection) throws SQLException {
		int cursoMenuOpcion = MenuCurso.imprimirSubMenu(sc);
		while (cursoMenuOpcion != 0) {
			MenuCurso.listadoABML(sc, connection, cursoMenuOpcion);
			cursoMenuOpcion = MenuCurso.imprimirSubMenu(sc);
		}

	}

	private static void estudiante(Scanner sc, Connection connection) throws SQLException {
		int estudianteMenuOpcion = MenuEstudiante.imprimirSubMenu(sc);
		while (estudianteMenuOpcion != 0) {
			MenuEstudiante.listadoABML(sc, connection, estudianteMenuOpcion);
			estudianteMenuOpcion = MenuCurso.imprimirSubMenu(sc);

		}
	}

	private static void profesor(Scanner sc, Connection connection) throws SQLException {
		int profesorMenuOpcion = sc.nextInt();
		while (profesorMenuOpcion != 0) {
			MenuProfesor.listadoABML(sc, connection, profesorMenuOpcion);
			profesorMenuOpcion = MenuProfesor.imprimirSubMenu(sc);

		}

	}

	private static void inscripcion(Scanner sc, Connection connection) throws SQLException {
		int InscripcionMenuOpcion = sc.nextInt();
		while (InscripcionMenuOpcion != 0) {
			MenuInscripcion.listadoABML(sc, connection, InscripcionMenuOpcion);
			InscripcionMenuOpcion = MenuInscripcion.imprimirSubMenu(sc);

		}

	}

}
