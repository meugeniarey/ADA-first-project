package db.inicial.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.inicial.model.Estudiante;

public class EstudianteDAO {

	public static void insert(Estudiante estudiante, Connection connection) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement("INSERT INTO ALUMNO (NOMBRE, APELLIDO) VALUES(?, ?)");
		stmt.setString(1, estudiante.getNombre());
		stmt.setString(2, estudiante.getApellido());
		stmt.executeUpdate();

	}

	public static List<Estudiante> findAll(Connection connection) throws SQLException {
		List<Estudiante> listaEstudiantes = new ArrayList<Estudiante>();
		String sql1 = "SELECT * FROM ALUMNO";
		PreparedStatement stmt = connection.prepareStatement(sql1);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			String nombreEstudiante = rs.getString(2);
			String apellidoEstudiante = rs.getString(3);
			int idEstudiante = rs.getInt(1);
			Estudiante estudiante = new Estudiante(nombreEstudiante, apellidoEstudiante);
			estudiante.setId(idEstudiante);
			listaEstudiantes.add(estudiante);
		}

		return listaEstudiantes;
	}

	public static Estudiante findById(int idEstudiante, Connection connection) throws SQLException {
		String sql = "SELECT * FROM ALUMNO WHERE ID = ?";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setInt(1, idEstudiante);
		ResultSet rs = stmt.executeQuery();

		Estudiante estudiante = null;
		if (rs.next()) {
			estudiante = new Estudiante(rs.getString(2), rs.getString(3));
		}
		return estudiante;
	}

	public static int updateEstudiante(Estudiante estudiante, Connection connection) throws SQLException {
		PreparedStatement prepStmt = connection
				.prepareStatement("UPDATE ALUMNO SET NOMBRE = ?, APELLIDO = ? WHERE ID = ?");
		prepStmt.setString(1, estudiante.getNombre());
		prepStmt.setString(2, estudiante.getApellido());
		prepStmt.setInt(3, estudiante.getId());
		return prepStmt.executeUpdate();
	}

	public static int delete(int idEstudiante, Connection connection) throws SQLException {
		PreparedStatement prepStmt = connection.prepareStatement("DELETE FROM ALUMNO WHERE ID = ?");
		prepStmt.setInt(1, idEstudiante);
		return prepStmt.executeUpdate();
	}

	public static List<Estudiante> findByLastName(String apellido, Connection connection) throws SQLException {
		String sql = "SELECT * FROM ALUMNO WHERE APELLIDO LIKE '" + apellido + "%' ORDER BY APELLIDO";
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		List<Estudiante> lista = new ArrayList<Estudiante>();
		Estudiante estudiante = null;
		while (rs.next()) {
			estudiante = new Estudiante(rs.getString(1), rs.getString(2));
			lista.add(estudiante);

		}
		return lista;

	}
}
