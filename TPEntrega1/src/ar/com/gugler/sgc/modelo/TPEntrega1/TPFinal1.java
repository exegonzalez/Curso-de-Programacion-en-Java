package ar.com.gugler.sgc.modelo.TPEntrega1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import ar.com.gugler.dao.AlumnoDAO;
import ar.com.gugler.dao.CursoDAO;
import ar.com.gugler.dao.MateriaDAO;
import ar.com.gugler.dao.ProfesorDAO;

public class TPFinal1 {

	public static void main(String[] args) throws ParseException{
		AlumnoDAO a = new AlumnoDAO();
		ProfesorDAO p = new ProfesorDAO();
		CursoDAO c = new CursoDAO();
		MateriaDAO m = new MateriaDAO();
		
		//Cargamos alumnos
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String fecha1 = "14/08/1998";
		Date Nacimiento1 = sdf.parse(fecha1);
		
		String fecha2 = "20/03/1999";
		Date Nacimiento2 = sdf.parse(fecha2);
	
		a.connect();
		Alumno a1 = new Alumno(1L,"10","Perez","Juan",Nacimiento1,"Calle 1","3442","Juan@gmail","1234");
		Alumno a2 = new Alumno(2L,"20","Gonzalez","Pablo",Nacimiento2,"Calle 2","3445","Pablo@gmail","2222");
		a.insert(a1);		
		a.insert(a2);
		a.closeConnection();
		
		//Cargamos profesor
		String fecha3 = "15/09/1974";
		Date Nacimiento3 = sdf.parse(fecha3);
		
		String fecha4 = "10/03/2000";
		Date Ingreso = sdf.parse(fecha4);
		
		p.connect();
		Profesor p1 = new Profesor(1L, "10","Rodriguez","Lucas",Nacimiento3,"Calle 2","3442","Lucas@gmail","20229",Ingreso);
		Profesor p2 = new Profesor(2L, "20","Lopez","Daniel",Nacimiento3,"Calle 1","3445","Dani@gmail","20009",Ingreso);		
		p.insert(p1);
		p.insert(p2);
		p.closeConnection();
		
		//Llamamos al metodo mostrarDatos de Universidad
		Universidad.mostrarDatos(a1);
		Universidad.mostrarDatos(a2);
		Universidad.mostrarDatos(p1);
		Universidad.mostrarDatos(p2);
		
		//Creamos un curso, y asignamos al profesor y los alumnos
		ArrayList<Alumno> listaAlu = new ArrayList<Alumno>();
		ArrayList<Profesor> listaProf = new ArrayList<Profesor>();
		
		c.connect();
		Curso c1 = new Curso(1L,122,"Programacion en Java", listaAlu,listaProf, 24);
		c1.agregarAlumno(a1);
		c1.agregarAlumno(a2);
		c1.agregarProfesor(p2);
		c1.agregarProfesor(p1);
		c.insert(c1);
		c.closeConnection();
		
		//Creamos una materia, y asignamos al profesor y los alumnos
		ArrayList<Alumno> listaAlu2 = new ArrayList<Alumno>();
		ArrayList<Profesor> listaProf2 = new ArrayList<Profesor>();
		
		m.connect();
		Materia m1 = new Materia(1L,122,"Programacion I", listaAlu2,listaProf2, 2019);
		m1.agregarAlumno(a1);
		m1.agregarAlumno(a2);
		m1.agregarProfesor(p1);
		m1.agregarProfesor(p2);
		m.insert(m1);
		m.closeConnection();
		
	}
}
