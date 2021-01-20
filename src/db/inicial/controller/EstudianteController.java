package db.inicial.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import db.inicial.DAO.EstudianteDAO;
import db.inicial.model.Estudiante;

public class EstudianteController {
	public static void alta(Scanner sc, Connection connection) throws SQLException {
		System.out.println("Ingrese nombre del estudiante: ");
		String nombreEstudiante = sc.next();
		System.out.println("Ingrese apellido del estudiante: ");
		String apellidoEstudiante = sc.next();
		Estudiante estudiante = new Estudiante(nombreEstudiante, apellidoEstudiante);
		EstudianteDAO.insert(estudiante, connection);
		System.out.println("Estudiante ingresado con éxito!");

	}

	public static void lista(Connection connection) throws SQLException {
		System.out.println("LISTA DE ESTUDIANTES:");
		List<Estudiante> listaEstudiantes = EstudianteDAO.findAll(connection);
		for (Estudiante estudiante : listaEstudiantes) {
			System.out.println(estudiante.getId() + " - " + estudiante.getNombre() + " - " + estudiante.getApellido());
		}

	}

	public static void modificacion(Scanner sc, Connection connection) throws SQLException {
		System.out.println("Ingrese ID del estudiante a modificar:");
		int idEstudiante = sc.nextInt();
		Estudiante estudianteModificar = EstudianteDAO.findById(idEstudiante, connection);

		if (estudianteModificar != null) {
			System.out.println(
					"El estudiante es " + estudianteModificar.getNombre() + " " + estudianteModificar.getApellido());
			System.out.println("Ingrese nuevo nombre del estudiante:");
			String nuevoNombre = sc.next();
			System.out.println("Ingrese nuevo apellido del estudiante:");
			String nuevoApellido = sc.next();
			Estudiante estudiante = new Estudiante(nuevoNombre, nuevoApellido);
			estudiante.setId(idEstudiante);

			int modificado = EstudianteDAO.updateEstudiante(estudiante, connection);
			if (modificado == 1) {
				System.out.println("Modificación realizada");
			} else {
				System.err.println("No se realizo la modificación");
			}
		} else {
			System.err.println("No se encontro el estudiante");
		}

	}

	public static void baja(Scanner sc, Connection connection) throws SQLException {
		System.out.println("Ingrese ID del estudiante a borrar:");
		int idEstudiante = sc.nextInt();
		Estudiante estudianteDelete = EstudianteDAO.findById(idEstudiante, connection);

		if (estudianteDelete != null) {
			int borrado = EstudianteDAO.delete(idEstudiante, connection);
			if (borrado == 1) {
				System.out.println("Baja realizada");
			} else {
				System.err.println("No se realizo la baja");
			}
		} else {
			System.err.println("No se encontro el estudiante");
		}

	}

	public static void buscarPorApellido(Scanner sc, Connection connection) throws SQLException {
		System.out.println("Buscar estudiante por apellido");
		System.out.println();
		System.out.println("Ingrese apellido del estudiante: ");
		String apellido = sc.next();
		List<Estudiante> listaEstudiantes = EstudianteDAO.findByLastName(apellido, connection);
		System.out.println();
		listaEstudiantes.forEach(estudiante -> System.out
				.println(estudiante.getId() + " - " + estudiante.getNombre() + " - " + estudiante.getApellido()));

	}

}
