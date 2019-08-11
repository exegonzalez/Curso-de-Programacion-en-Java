package ar.com.gugler.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ar.com.gugler.sgc.modelo.TPEntrega1.Alumno;
import ar.com.gugler.dao.BaseDAO;

public class AlumnoDAO extends BaseDAO<Alumno>{

	private final String SQL_INSERT="INSERT INTO ALUMNO(ID,NUMERODOCUMENTO,APELLIDO,NOMBRES,FECHANACIMIENTO,DOMICILIO,TELEFONO,CORREOELECTRONICO,LEGAJO) VALUES(?,?,?,?,?,?,?,?,?)";
	
	private final String SQL_UPDATE="UPDATE ALUMNO SET NUMERODOCUMENTO = ?, APELLIDO = ?, NOMBRES = ?, FECHANACIMIENTO = ?, DOMICILIO = ?, TELEFONO = ?, CORREOELECTRONICO = ?, LEGAJO = ? WHERE ID = ?";
	
	private final String SQL_DELETE="DELETE FROM ALUMNO WHERE ID = ?";
	
	private final String SQL_SELECT="SELECT ID,NUMERODOCUMENTO,APELLIDO,NOMBRES,FECHANACIMIENTO,DOMICILIO,TELEFONO,CORREOELECTRONICO,LEGAJO FROM ALUMNO";
	
	//Insertar
	public void insert(Alumno a) {
		try {
			connect();
			stmt = con.prepareStatement(SQL_INSERT);

			stmt.setLong(1, a.getId());
			stmt.setString(2, a.getNumeroDocumento());
			stmt.setString(3, a.getApellido());
			stmt.setString(4, a.getNombres());
			java.util.Date fechadate = a.getFechaNacimiento();
			java.sql.Date fechasql = new java.sql.Date(fechadate.getTime());
			stmt.setDate(5, fechasql);
			stmt.setString(6, a.getDomicilio());
			stmt.setString(7, a.getTelefono());
			stmt.setString(8, a.getCorreoElectronico());
			stmt.setString(9, a.getLegajo());
			
			stmt.execute();
			closeConnection();
		}
		catch (SQLException ex) {
			System.out.println("Error insertando un alumno con los valores"
					+ a);
			ex.printStackTrace();
		}
	}
	
	//Modificar
	public void update(Alumno a) {
		try {
			connect();
			stmt = con.prepareStatement(SQL_UPDATE);
			
			stmt.setString(1, a.getNumeroDocumento());
			stmt.setString(2, a.getApellido());
			stmt.setString(3, a.getNombres());
			java.util.Date fechadate = a.getFechaNacimiento();
			java.sql.Date fechasql = new java.sql.Date(fechadate.getTime());
			stmt.setDate(4, fechasql);
			stmt.setString(5, a.getDomicilio());
			stmt.setString(6, a.getTelefono());
			stmt.setString(7, a.getCorreoElectronico());
			stmt.setString(8, a.getLegajo());
			stmt.setLong(9, a.getId());
			
			stmt.execute();
			closeConnection();
		}
		catch (SQLException ex) {
			System.out.println("Error modificando un alumno con los valores"
					+ a);
			ex.printStackTrace();
		}
	}
	
	//Eliminar
	public void delete(Alumno a) {
		try {
			connect();
			stmt = con.prepareStatement(SQL_DELETE);
			
			stmt.setLong(1, a.getId());

			stmt.execute();
			closeConnection();
		}
		catch (SQLException ex) {
			System.out.println("Error eliminando un alumno con los valores"
					+ (Alumno)a);
			ex.printStackTrace();
		}
	}
	
	//Listar
	public List<Alumno> getAll() {	
		
		List<Alumno> listadoAlumnos = new ArrayList<Alumno>();
			
		try {
			connect();
			stmt = con.prepareStatement(SQL_SELECT);
			
			ResultSet rset = stmt.executeQuery();
			
			System.out.println(rset);

			while(rset.next()) {
				
				Alumno a = new Alumno();
				a.setId(rset.getLong(1));
				a.setNumeroDocumento(rset.getString(2));
				a.setApellido(rset.getString(3));
				a.setNombres(rset.getString(4));
				a.setFechaNacimiento(rset.getDate(5));
				a.setDomicilio(rset.getString(6));
				a.setTelefono(rset.getString(7));
				a.setCorreoElectronico(rset.getString(8));
				a.setLegajo(rset.getString(9));
				listadoAlumnos.add(a);
			}
	
			closeConnection();

		}
		catch (SQLException ex) {
			System.out.println("Error trayendo el listado de alumnos");
			ex.printStackTrace();
		}
		return listadoAlumnos;
	}
}
