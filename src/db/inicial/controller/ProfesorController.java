package db.inicial.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import db.inicial.DAO.ProfesorDAO;
import db.inicial.model.Profesor;

public class ProfesorController {
	public static void alta(Scanner sc, Connection connection) throws SQLException {
		System.out.println("Ingrese nombre del profesor: ");
		String nombreProfesor = sc.next();
		System.out.println("Ingrese apellido del profesor: ");
		String apellidoProfesor = sc.next();
		System.out.println("Ingrese email del profesor: ");
		String emailProfesor = sc.next();
		Profesor profesor = new Profesor(nombreProfesor, apellidoProfesor, emailProfesor);
		ProfesorDAO.insert(profesor, connection);
		System.out.println("Profesor ingresado con éxito!");

	}

	public static void lista(Connection connection) throws SQLException {
		System.out.println("LISTA DE PROFESORES:");
		List<Profesor> listaProfesores = ProfesorDAO.findAll(connection);
		for (Profesor profesor : listaProfesores) {
			System.out.println(profesor.getId() + " - " + profesor.getNombre() + " - " + profesor.getApellido());
		}

	}

	public static void modificacion(Scanner sc, Connection connection) throws SQLException {
		System.out.println("Ingrese ID del profesor a modificar:");
		int idProfesor = sc.nextInt();
		Profesor profesorModificar = ProfesorDAO.findById(idProfesor, connection);

		if (profesorModificar != null) {
			System.out
					.println("El profesor es " + profesorModificar.getNombre() + " " + profesorModificar.getApellido());
			System.out.println("Ingrese nuevo nombre del profesor:");
			String nuevoNombre = sc.next();
			System.out.println("Ingrese nuevo apellido del profesor:");
			String nuevoApellido = sc.next();
			System.out.println("Ingrese nuevo email del profesor:");
			String nuevoEmail = sc.next();
			Profesor profesor = new Profesor(nuevoNombre, nuevoApellido, nuevoEmail);
			profesor.setId(idProfesor);
			int updated = ProfesorDAO.updateProfesor(profesor, connection);
			if (updated == 1) {
				System.out.println("Modificacion realizada");
			} else {
				System.err.println("Error en la modificacion de profesor: actualizados = " + updated);
			}
		}

	}

	public static void baja(Scanner sc, Connection connection) throws SQLException {
		System.out.println("Ingrese ID del profesor a borrar:");
		int idProfesor = sc.nextInt();
		Profesor profesorDelete = ProfesorDAO.findById(idProfesor, connection);

		if (profesorDelete != null) {
			int borrado = ProfesorDAO.delete(idProfesor, connection);
			if (borrado == 1) {
				System.out.println("Baja realizada");
			} else {
				System.err.println("No se realizo la baja");
			}
		} else {
			System.err.println("No se encontro el profesor");
		}

	}

	public static void buscarPorNombre(Scanner sc, Connection connection) throws SQLException {
		System.out.println("Buscar profesor por nomnre");
		System.out.println();
		System.out.println("Ingrese nombre del profesor: ");
		String nombreProfesor = sc.next();
		List<Profesor> listaProfesores = ProfesorDAO.findByName(nombreProfesor, connection);
		System.out.println();
		if (listaProfesores != null) { // esto esta bien?
			listaProfesores.forEach(curso -> System.out
					.println(curso.getId() + " - " + curso.getNombre() + " - " + curso.getApellido()));

		} else {
			System.err.println("No se encontro el profesor");
		}

	}

}
