package db.inicial.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.inicial.model.Profesor;

public class ProfesorDAO {

	public static void insert(Profesor profesor, Connection connection) throws SQLException {
		PreparedStatement stmt = connection
				.prepareStatement("INSERT INTO PROFESOR (NOMBRE, APELLIDO, EMAIL) VALUES(?, ?, ?)");
		stmt.setString(1, profesor.getNombre());
		stmt.setString(2, profesor.getApellido());
		stmt.setString(3, profesor.getEmail());
		stmt.executeUpdate();

	}

	public static List<Profesor> findAll(Connection connection) throws SQLException {
		List<Profesor> listaProfesores = new ArrayList<Profesor>();
		String sql = "SELECT * FROM PROFESOR";
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			String nombreProfesor = rs.getString(2);
			String apellidoProfesor = rs.getString(3);
			String emailProfesor = rs.getString(4);
			int idProfesor = rs.getInt(1);

			Profesor profesor = new Profesor(nombreProfesor, apellidoProfesor, emailProfesor);
			profesor.setId(idProfesor);
			listaProfesores.add(profesor);
		}

		return listaProfesores;
	}

	public static Profesor findById(int idProfesor, Connection connection) throws SQLException {
		String sql = "SELECT * FROM PROFESOR WHERE ID = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, idProfesor);
		ResultSet rs = stmt.executeQuery();

		Profesor profesor = null;
		if (rs.next()) {
			profesor = new Profesor(rs.getString(2), rs.getString(3), rs.getString(4));
		}
		return profesor;
	}

	public static int updateProfesor(Profesor profesor, Connection connection) throws SQLException {
		PreparedStatement prepStmt = connection
				.prepareStatement("UPDATE PROFESOR SET NOMBRE = ?, APELLIDO = ?, EMAIL = ? WHERE ID = ?");
		prepStmt.setString(1, profesor.getNombre());
		prepStmt.setString(2, profesor.getApellido());
		prepStmt.setString(3, profesor.getEmail());
		prepStmt.setInt(4, profesor.getId());
		return prepStmt.executeUpdate();
	}

	public static int delete(int idProfesor, Connection connection) throws SQLException {
		PreparedStatement prepStmt = connection.prepareStatement("DELETE FROM PROFESOR WHERE ID = ?");
		prepStmt.setInt(1, idProfesor);
		return prepStmt.executeUpdate();
	}

	public static List<Profesor> findByName(String nombreProfesor, Connection connection) throws SQLException {
		String sql = "SELECT * FROM PROFESOR WHERE NOMBRE LIKE '" + nombreProfesor + "%' ORDER BY NOMBRE";
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		List<Profesor> lista = new ArrayList<Profesor>();
		Profesor profesor = null;
		while (rs.next()) {
			profesor = new Profesor(rs.getString(2), rs.getString(3), rs.getString(4));
			lista.add(profesor);
		}
		return lista;
	}

}
