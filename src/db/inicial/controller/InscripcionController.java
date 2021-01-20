package db.inicial.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import db.inicial.DAO.CursoDAO;
import db.inicial.DAO.EstudianteDAO;
import db.inicial.DAO.InscripcionDAO;
import db.inicial.model.Curso;
import db.inicial.model.Estudiante;
import db.inicial.model.Inscripcion;

public class InscripcionController {
	public static void alta(Scanner sc, Connection connection) throws SQLException {
		System.out.println("Ingrese ID del estudiante: ");
		int idEstudiante = sc.nextInt();
		Estudiante estudianteAInscribir = EstudianteDAO.findById(idEstudiante, connection);
		System.out.println("El estudiante que inscribirá es " + estudianteAInscribir.getNombre() + " "
				+ estudianteAInscribir.getApellido());
		System.out.println("Ingrese ID del curso al que desea inscribir a este estudiante: ");
		int idCurso = sc.nextInt();
		Curso cursoAInscribir = CursoDAO.findById(idCurso, connection);
		System.out.println("Se inscribirá el estudiante en el curso " + cursoAInscribir.getName());
		int estado_inscripcion = 1;
		System.out.println("Ingrese la comisión a la que desea inscribir a este estudiante: ");
		int comision = sc.nextInt();
		System.out.println("Se inscribirá el estudiante en la comision " + comision);

		Inscripcion inscripcion = new Inscripcion(idEstudiante, idCurso, estado_inscripcion, comision);
		InscripcionDAO.insert(inscripcion, connection);
		System.out.println("Inscripcion exitosa!");

	}

	public static void cancelacion(Connection connection) {
		// TODO Auto-generated method stub

	}

	public static void listaInscriptosPorCurso(Scanner sc, Connection connection) {
		// TODO Auto-generated method stub

	}

	public static void listaNotasPorCurso(Scanner sc, Connection connection) {
		// TODO Auto-generated method stub

	}

}
