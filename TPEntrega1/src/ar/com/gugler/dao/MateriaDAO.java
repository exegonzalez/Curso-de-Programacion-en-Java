package ar.com.gugler.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ar.com.gugler.sgc.modelo.TPEntrega1.Materia;
import ar.com.gugler.sgc.modelo.TPEntrega1.Alumno;
import ar.com.gugler.sgc.modelo.TPEntrega1.Profesor;
import ar.com.gugler.dao.BaseDAO;

public class MateriaDAO extends BaseDAO<Materia>{

	private final String SQL_INSERT="INSERT INTO MATERIA(ID,CODIGO,NOMBRE,ANIO) VALUES(?,?,?,?)";
	
	private final String SQL_UPDATE="UPDATE MATERIA SET CODIGO = ?, NOMBRE = ?, ANIO = ? WHERE ID = ?";
	
	private final String SQL_DELETE="DELETE FROM MATERIA WHERE ID = ?";
	
	private final String SQL_SELECT="SELECT ID,CODIGO,NOMBRE,ANIO FROM MATERIA";
	
	
	private final String SQL_INSERT2="INSERT INTO MATERIA_PROFESOR(ID_MATERIA,ID_PROFESOR) VALUES(?,?)";
	
	private final String SQL_DELETE2="DELETE FROM MATERIA_PROFESOR WHERE ID = ?";	
	
	private final String SQL_SELECT2="SELECT ID FROM MATERIA_PROFESOR WHERE ID_MATERIA = ?";
	
	
	private final String SQL_INSERT3="INSERT INTO MATERIA_ALUMNO(ID_MATERIA,ID_ALUMNO) VALUES(?,?)";
	
	private final String SQL_DELETE3="DELETE FROM MATERIA_ALUMNO WHERE ID = ?";	
	
	private final String SQL_SELECT3="SELECT ID FROM MATERIA_ALUMNO WHERE ID_MATERIA = ?";
	
	//Insertar
	public void insert(Materia m) {
		try {
			connect();
			stmt = con.prepareStatement(SQL_INSERT);
			stmt.setLong(1, m.getId());
			stmt.setInt(2, m.getCodigo());
			stmt.setString(3, m.getNombre());
			stmt.setInt(4, m.getAnio());			
			stmt.execute();
			
			ArrayList<Profesor> profesores = m.getProfesores(); //Creo un arraylist con los profesores de la clase Materia.
			for(Profesor pro : profesores){//Para cada Profesor del arraylist lo inserto en la tabla Materia_Profesor
				stmt = con.prepareStatement(SQL_INSERT2);
				stmt.setLong(1, m.getId());
				stmt.setLong(2, pro.getId());
				stmt.execute();
			}
			
			ArrayList<Alumno> alumnos = m.getAlumnos(); 
			for(Alumno alu : alumnos){
				stmt = con.prepareStatement(SQL_INSERT3);
				stmt.setLong(1, m.getId());
				stmt.setLong(2, alu.getId());
				stmt.execute();
			}
			
			closeConnection();
		}
		catch (SQLException ex) {
			System.out.println("Error insertando una materia con los valores"
					+ m);
			ex.printStackTrace();
		}
	}
	
	//Modificar
	public void update(Materia m) {
		try {
			connect();
			stmt = con.prepareStatement(SQL_UPDATE);
			
			stmt.setInt(1, m.getCodigo());
			stmt.setString(2, m.getNombre());
			stmt.setInt(3, m.getAnio());
			stmt.setLong(4, m.getId());
			
			stmt.execute();
			closeConnection();
		}
		catch (SQLException ex) {
			System.out.println("Error modificando una materia con los valores"
					+ m);
			ex.printStackTrace();
		}
	}
	
	//Eliminar
	public void delete(Materia m) {
		try {
			connect();
			
			/*Eliminar tuplas de Curso_Profesor*/
			stmt = con.prepareStatement(SQL_SELECT2);
			stmt.setLong(1, m.getId());	
			ResultSet rset = stmt.executeQuery();
			List<Long> lista = new ArrayList<Long>();
			while(rset.next()) {
				lista.add(rset.getLong(1));
			}
			for(Long l : lista){
				stmt = con.prepareStatement(SQL_DELETE2);
				stmt.setLong(1, l);
				stmt.execute();
			}		
			
			/*Eliminar tuplas de Curso_Alumno*/
			stmt = con.prepareStatement(SQL_SELECT3);
			stmt.setLong(1, m.getId());			
			ResultSet rset2 = stmt.executeQuery();
			List<Long> lista1 = new ArrayList<Long>();
			while(rset2.next()) {
				lista1.add(rset2.getLong(1));
			}			
			for(Long l : lista1){
				stmt = con.prepareStatement(SQL_DELETE3);
				stmt.setLong(1, l);
				stmt.execute();
			}
			
			/*Eliminar tupla de Curso*/
			stmt = con.prepareStatement(SQL_DELETE);
			stmt.setLong(1, m.getId());
			stmt.execute();
			closeConnection();
		}
		catch (SQLException ex) {
			System.out.println("Error eliminando una materia con los valores"
					+ (Materia)m);
			ex.printStackTrace();
		}
	}
	
	//Listar
	public List<Materia> getAll() {	
		
		List<Materia> listadoMaterias = new ArrayList<Materia>();
			
		try {
			connect();
			stmt = con.prepareStatement(SQL_SELECT);
			
			ResultSet rset = stmt.getResultSet();

			while(rset.next()) {
				
				Materia m = new Materia();
				m.setId(rset.getLong(1));
				m.setCodigo(rset.getInt(2));
				m.setNombre(rset.getString(3));
				m.setAnio(rset.getInt(4));
				listadoMaterias.add(m);
			}
	
			closeConnection();

		}
		catch (SQLException ex) {
			System.out.println("Error trayendo el listado de materias");
			ex.printStackTrace();
		}
		return listadoMaterias;
	}

}
	

