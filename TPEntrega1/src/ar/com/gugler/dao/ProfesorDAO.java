package ar.com.gugler.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ar.com.gugler.sgc.modelo.TPEntrega1.Profesor;
import ar.com.gugler.dao.BaseDAO;

public class ProfesorDAO extends BaseDAO<Profesor>{
	
	private final String SQL_INSERT="INSERT INTO PROFESOR(ID,NUMERODOCUMENTO,APELLIDO,NOMBRES,FECHANACIMIENTO,DOMICILIO,TELEFONO,CORREOELECTRONICO,CUIL,FECHAINGRESO) VALUES(?,?,?,?,?,?,?,?,?,?)";
	
	private final String SQL_UPDATE="UPDATE PROFESOR SET NUMERODOCUMENTO = ?, APELLIDO = ?, NOMBRES = ?, FECHANACIMIENTO = ?, DOMICILIO = ?, TELEFONO = ?, CORREOELECTRONICO = ?, CUIL = ?, FECHAINGRESO = ? WHERE ID = ?";
	
	private final String SQL_DELETE="DELETE FROM PROFESOR WHERE ID = ?";
	
	private final String SQL_SELECT="SELECT ID,NUMERODOCUMENTO,APELLIDO,NOMBRES,FECHANACIMIENTO,DOMICILIO,TELEFONO,CORREOELECTRONICO,CUIL,FECHAINGRESO FROM PROFESOR";
	
	//Insertar
	public void insert(Profesor p) {
		java.util.Date fechadate;
		java.sql.Date fechasql;
		try {
			connect();
			stmt = con.prepareStatement(SQL_INSERT);

			stmt.setLong(1, p.getId());
			stmt.setString(2, p.getNumeroDocumento());
			stmt.setString(3, p.getApellido());
			stmt.setString(4, p.getNombres());
			fechadate = p.getFechaNacimiento();
			fechasql = new java.sql.Date(fechadate.getTime());
			stmt.setDate(5,fechasql);
			stmt.setString(6, p.getDomicilio());
			stmt.setString(7, p.getTelefono());
			stmt.setString(8, p.getCorreoElectronico());
			stmt.setString(9, p.getCuil());
			fechadate = p.getFechaIngreso();
			fechasql = new java.sql.Date(fechadate.getTime());
			stmt.setDate(10,fechasql);
			
			stmt.execute();
			closeConnection();
		}
		catch (SQLException ex) {
			System.out.println("Error insertando un profesor con los valores"
					+ p);
			ex.printStackTrace();
		}
	}
	
	//Modificar
	public void update(Profesor p) {
		java.util.Date fechadate;
		java.sql.Date fechasql;
		try {
			connect();
			stmt = con.prepareStatement(SQL_UPDATE);
			
			stmt.setString(1, p.getNumeroDocumento());
			stmt.setString(2, p.getApellido());
			stmt.setString(3, p.getNombres());
			fechadate = p.getFechaNacimiento();
			fechasql = new java.sql.Date(fechadate.getTime());
			stmt.setDate(4, fechasql);
			stmt.setString(5, p.getDomicilio());
			stmt.setString(6, p.getTelefono());
			stmt.setString(7, p.getCorreoElectronico());
			stmt.setString(8, p.getCuil());
			fechadate = p.getFechaIngreso();
			fechasql = new java.sql.Date(fechadate.getTime());
			stmt.setDate(9,fechasql);
			stmt.setLong(10, p.getId());
			
			stmt.execute();
			closeConnection();
		}
		catch (SQLException ex) {
			System.out.println("Error modificando un profesor con los valores"
					+ p);
			ex.printStackTrace();
		}
	}
	
	//Eliminar
	public void delete(Profesor p) {
		try {
			connect();
			stmt = con.prepareStatement(SQL_DELETE);
			
			stmt.setLong(1, p.getId());

			stmt.execute();
			closeConnection();
		}
		catch (SQLException ex) {
			System.out.println("Error eliminando un profesor con los valores"
					+ (Profesor)p);
			ex.printStackTrace();
		}
	}
	
	//Listar
	public List<Profesor> getAll() {	
		
		List<Profesor> listadoProfesores = new ArrayList<Profesor>();
			
		try {
			connect();
			stmt = con.prepareStatement(SQL_SELECT);
			
			ResultSet rset = stmt.executeQuery();

			while(rset.next()) {
				
				Profesor p = new Profesor();
				p.setId(rset.getLong(0));
				p.setNumeroDocumento(rset.getString(1));
				p.setApellido(rset.getString(2));
				p.setNombres(rset.getString(3));
				p.setFechaNacimiento(rset.getDate(4));
				p.setDomicilio(rset.getString(5));
				p.setTelefono(rset.getString(6));
				p.setCorreoElectronico(rset.getString(7));
				p.setCuil(rset.getString(8));
				p.setFechaIngreso(rset.getDate(9));
				listadoProfesores.add(p);
			}
	
			closeConnection();

		}
		catch (SQLException ex) {
			System.out.println("Error trayendo el listado de profesores");
			ex.printStackTrace();
		}
		return listadoProfesores;
	}
}
