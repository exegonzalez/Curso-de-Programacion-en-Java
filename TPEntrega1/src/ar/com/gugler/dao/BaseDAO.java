package ar.com.gugler.dao;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
import java.sql.SQLException; 
import java.sql.Statement;
import java.util.List;

import ar.com.gugler.sgc.modelo.TPEntrega1.BaseModelo;

public abstract class BaseDAO<T extends BaseModelo> {
	protected Connection con;
	protected PreparedStatement stmt;
	
	public void connect()  {
		try {
			Class. forName ("org.h2.Driver"); 
			con =   DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
			//createTables(con);
		} 
		catch 
			(Exception e) { e.printStackTrace(); 
			System. out .println("Error conectandose a la base de datos"); 
		}
	}
	
	public void closeConnection() {
		try {
			con.close(); 
		} 
		catch (SQLException e) { e.printStackTrace(); 
			System. out .println("Error cerrando la conexion a la base"); 
		}
	}
	
	private static void createTables(Connection con) throws SQLException {
		Statement st = con.createStatement();
		st.execute("CREATE TABLE alumno ("
				+ "id long(11) NOT NULL, "
				+ "numeroDocumento text(20) NOT NULL, "
				+ "apellido varchar(20) NOT NULL, "
				+ "nombres varchar(20) NOT NULL, "
				+ "fechaNacimiento date(11) NOT NULL, "
				+ "domicilio varchar(20) NOT NULL, "
				+ "telefono varchar(20) NOT NULL, "
				+ "correoElectronico varchar(20) NOT NULL, "
				+ "legajo varchar(20) NOT NULL, "
				+ "PRIMARY KEY (id))");
		st.execute("CREATE TABLE profesor ("
				+ "id long(11) NOT NULL, "
				+ "numeroDocumento text(20) NOT NULL, "
				+ "apellido varchar(20) NOT NULL, "
				+ "nombres varchar(20) NOT NULL, "
				+ "fechaNacimiento date(11) NOT NULL, "
				+ "domicilio varchar(20) NOT NULL, "
				+ "telefono varchar(20) NOT NULL, "
				+ "correoElectronico varchar(20) NOT NULL, "
				+ "cuil varchar(20) NOT NULL, "
				+ "fechaIngreso date(11) NOT NULL, "
				+ "PRIMARY KEY (id))");
		st.execute("CREATE TABLE materia ("
				+ "id long(11) NOT NULL, "
				+ "codigo integer(10) NOT NULL, "
				+ "nombre varchar(20) NOT NULL, "
				+ "anio integer(10) NOT NULL, "
				+ "PRIMARY KEY (id))");
		st.execute("CREATE TABLE curso ("
				+ "id long(11) NOT NULL, "
				+ "codigo integer(10) NOT NULL, "
				+ "nombre varchar(20) NOT NULL, "
				+ "cupo integer(10) NOT NULL, "
				+ "PRIMARY KEY (id))");
		st.execute("CREATE TABLE curso_profesor ("
				+ "id long(11) AUTO_INCREMENT NOT NULL, "
				+ "id_curso long(11) NOT NULL, "
				+ "id_profesor long(11) NOT NULL, "
				+ "PRIMARY KEY (id))");
		st.execute("CREATE TABLE curso_alumno ("
				+ "id long(11) AUTO_INCREMENT NOT NULL, "
				+ "id_curso long(11) NOT NULL, "
				+ "id_alumno long(11) NOT NULL, "
				+ "PRIMARY KEY (id))");
		st.execute("CREATE TABLE materia_profesor ("
				+ "id long(11) AUTO_INCREMENT NOT NULL, "
				+ "id_materia long(11) NOT NULL, "
				+ "id_profesor long(11) NOT NULL, "
				+ "PRIMARY KEY (id))");
		st.execute("CREATE TABLE materia_alumno ("
				+ "id long(11) AUTO_INCREMENT NOT NULL, "
				+ "id_materia long(11) NOT NULL, "
				+ "id_alumno long(11) NOT NULL, "
				+ "PRIMARY KEY (id))");
		st.close();
	}
	
	public abstract void insert(T b) throws SQLException;	
	
	public abstract void delete(T b) throws SQLException;

	public abstract void update(T b);

	public abstract List<T> getAll() throws SQLException;	
}


