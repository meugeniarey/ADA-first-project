package db.inicial.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.inicial.model.Inscripcion;

public class InscripcionDAO {

	public static void insert(Inscripcion inscripcion, Connection connection) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement(
				"INSERT INTO INSCRIPCION (ID_ALUMNO, ID_CURSO, ESTADO_INSCRIPCION, ID_PROFESOR, COMISION, NOTA1, NOTA2) VALUES(?, ?, ?, ?, ?, ?, ?)");
		stmt.setInt(1, inscripcion.getIdEstudiante());
		stmt.setInt(2, inscripcion.getIdCurso());
		stmt.setInt(3, inscripcion.getEstado_inscripcion());
		stmt.setInt(4, inscripcion.getIdProfesor());
		stmt.setInt(5, inscripcion.getComision());
		stmt.setInt(6, inscripcion.getNota1());
		stmt.setInt(7, inscripcion.getNota2());
		stmt.executeUpdate();

	}

}
