package db.inicial.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import db.inicial.DAO.CursoDAO;
import db.inicial.model.Curso;

public class CursoController {

	public static void alta(Scanner sc, Connection connection) throws SQLException {
		System.out.println("Ingrese nombre curso: ");
		String nombreCurso = sc.next();
		Curso curso = new Curso(nombreCurso);
		CursoDAO.insert(curso, connection);
		System.out.println("Curso ingresado con éxito!");

	}

	public static void lista(Connection connection) throws SQLException {
		System.out.println("LISTA CURSOS:");
		List<Curso> listaCursos = CursoDAO.findAll(connection);
		for (Curso curso : listaCursos) {
			System.out.println(curso.getId() + " - " + curso.getName());
		}
	}

	public static void modificacion(Scanner sc, Connection connection) throws SQLException {
		System.out.println("Ingrese ID del curso a modificar:");
		int idCurso = sc.nextInt();
		// AGREGAR VALIDACION PARA VERICAR QUE EXISTA EL CURSO
		System.out.println("Ingrese nuevo nombre del curso:");
		String nuevoNombre = sc.next();
		// VALIDAR EL NUEVO NOMBRE -> CANTIDAD MINIMA DE CARACTERES
		Curso curso = new Curso(nuevoNombre);
		curso.setId(idCurso);
		int updated = CursoDAO.update(curso, connection);
		if (updated == 1) {
			System.out.println("Modificacion realizada");
		} else {
			System.err.println("Error en la modificacion de curso: actualizados = " + updated);
		}

	}

	public static void baja(Scanner sc, Connection connection) throws SQLException {
		System.out.println("Ingrese ID del curso a borrar:");
		int idCurso = sc.nextInt();
		Curso cursoDelete = CursoDAO.findById(idCurso, connection);

		if (cursoDelete != null) {
			int modificadas = CursoDAO.delete(idCurso, connection);
			if (modificadas == 1) {
				System.out.println("Baja realizada");
			} else {
				System.err.println("No se realizo la baja");
			}
		} else {
			System.err.println("No se encontro el curso");
		}

	}

	public static void buscarPorNombre(Scanner sc, Connection connection) throws SQLException {
		System.out.println("Buscar curso por nomnre");
		System.out.println();
		System.out.println("Ingrese nombre del curso: ");
		String nombre = sc.next();
		List<Curso> listaCursos = CursoDAO.findByName(nombre, connection);
		System.out.println();
		listaCursos.forEach(curso -> System.out.println(curso.getId() + " - " + curso.getName()));

	}
}
