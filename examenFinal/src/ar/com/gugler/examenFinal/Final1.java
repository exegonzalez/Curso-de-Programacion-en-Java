package ar.com.gugler.examenFinal;

import java.util.ArrayList;

public class Final1 {

	public static void main(String[] args) {
		
		ArrayList<Integer> notas1 = new ArrayList<Integer>();
		ArrayList<Integer> notas2 = new ArrayList<Integer>();
		
		Alumno a1 = new Alumno(1,"Rodriguez","Juan",notas1);
		Alumno a2 = new Alumno(2,"Gonzalez","Maria",notas2);
		
		a1.agregarNota(80);
		a1.agregarNota(70);
		a1.agregarNota(100);
		
		a2.agregarNota(80);
		a2.agregarNota(50);
		a2.agregarNota(100);
	
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		Curso c1 = new Curso("Programacion",alumnos);
		
		c1.agregarAlumno(a1);
		c1.agregarAlumno(a2);
	
		c1.ListarAlumnosPorPromedio();
		System.out.println("");
		c1.ListarAlumnosAprobados();
		System.out.println("");
		c1.ListarAlumnosDesaprobados();
	}

}
