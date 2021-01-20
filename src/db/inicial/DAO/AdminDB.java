package db.inicial.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AdminDB {

	public static Connection obtenerConexion(String driver) throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cursos?serverTimezone=UTC", "root", "");
	}
}
