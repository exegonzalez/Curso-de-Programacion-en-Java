package ar.com.gugler.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ar.com.gugler.sgc.modelo.TPEntrega1.Alumno;
import ar.com.gugler.sgc.modelo.TPEntrega1.Curso;
import ar.com.gugler.sgc.modelo.TPEntrega1.Profesor;
import ar.com.gugler.dao.BaseDAO;

public class CursoDAO extends BaseDAO<Curso>{

	private final String SQL_INSERT="INSERT INTO CURSO(ID,CODIGO,NOMBRE,CUPO) VALUES(?,?,?,?)";
	
	private final String SQL_UPDATE="UPDATE CURSO SET CODIGO = ?, NOMBRE = ?, CUPO = ? WHERE ID = ?";
	
	private final String SQL_DELETE="DELETE FROM CURSO WHERE ID = ?";	

	private final String SQL_SELECT="SELECT ID,CODIGO,NOMBRE,CUPO FROM CURSO";
	

	private final String SQL_INSERT2="INSERT INTO CURSO_PROFESOR(ID_CURSO,ID_PROFESOR) VALUES(?,?)";
	
	private final String SQL_DELETE2="DELETE FROM CURSO_PROFESOR WHERE ID = ?";	
	
	private final String SQL_SELECT2="SELECT ID FROM CURSO_PROFESOR WHERE ID_CURSO = ?";
	
	
	private final String SQL_INSERT3="INSERT INTO CURSO_ALUMNO(ID_CURSO,ID_ALUMNO) VALUES(?,?)";
	
	private final String SQL_DELETE3="DELETE FROM CURSO_ALUMNO WHERE ID = ?";	
	
	private final String SQL_SELECT3="SELECT ID FROM CURSO_ALUMNO WHERE ID_CURSO = ?";
	
	//Insertar
	public void insert(Curso c) {
		try {
			connect();
			stmt = con.prepareStatement(SQL_INSERT);
			stmt.setLong(1, c.getId());
			stmt.setInt(2, c.getCodigo());
			stmt.setString(3, c.getNombre());
			stmt.setInt(4, c.getCupo());			
			stmt.execute();
			
			ArrayList<Profesor> profesores = c.getProfesores(); //Creo un arraylist con los profesores de la clase Curso.
			for(Profesor pro : profesores){//Para cada Profesor del arraylist lo inserto en la tabla Curso_Profesor
				stmt = con.prepareStatement(SQL_INSERT2);
				stmt.setLong(1, c.getId());
				stmt.setLong(2, pro.getId());
				stmt.execute();
			}
			
			ArrayList<Alumno> alumnos = c.getAlumnos(); 
			for(Alumno alu : alumnos){
				stmt = con.prepareStatement(SQL_INSERT3);
				stmt.setLong(1, c.getId());
				stmt.setLong(2, alu.getId());
				stmt.execute();
			}
			
			closeConnection();
		}
		catch (SQLException ex) {
			System.out.println("Error insertando un curso con los valores"
					+ c);
			ex.printStackTrace();
		}
	}
	
	//Modificar
	public void update(Curso c) {
		try {
			connect();
			stmt = con.prepareStatement(SQL_UPDATE);
			
			stmt.setInt(1, c.getCodigo());
			stmt.setString(2, c.getNombre());
			stmt.setInt(3, c.getCupo());
			stmt.setLong(4, c.getId());
			
			stmt.execute();
			closeConnection();
		}
		catch (SQLException ex) {
			System.out.println("Error modificando un curso con los valores"
					+ c);
			ex.printStackTrace();
		}
	}
	
	//Eliminar
	public void delete(Curso c) {
		try {
			connect();
			
			/*Eliminar tuplas de Curso_Profesor*/
			stmt = con.prepareStatement(SQL_SELECT2);
			stmt.setLong(1, c.getId());	
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
			stmt.setLong(1, c.getId());			
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
			stmt.setLong(1, c.getId());
			stmt.execute();
			closeConnection();
		}
		catch (SQLException ex) {
			System.out.println("Error eliminando un curso con los valores"
					+ (Curso)c);
			ex.printStackTrace();
		}
	}	
	
	//Listar
	public List<Curso> getAll() {	
		
		List<Curso> listadoCursos = new ArrayList<Curso>();
		
		try {
			connect();
			stmt = con.prepareStatement(SQL_SELECT);
			
			ResultSet rset = stmt.executeQuery();

			while(rset.next()) {
			
				Curso c = new Curso();
				c.setId(rset.getLong(1));
				c.setCodigo(rset.getInt(2));
				c.setNombre(rset.getString(3));		
				c.setCupo(rset.getInt(4));
				listadoCursos.add(c);
			}
	
			closeConnection();

		}
		catch (SQLException ex) {
			System.out.println("Error trayendo el listado de cursos");
			ex.printStackTrace();
		}
		return listadoCursos;
	}
}

/*
select cp.id, c.nombre, p.apellido, p.nombres from curso_profesor cp, curso c, profesor p
where cp.id_curso = c.id and cp.id_profesor = p.id
group by cp.id
*/