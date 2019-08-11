package ar.com.gugler.sgc.modelo.TPEntrega1;

import java.util.ArrayList;

public class Materia extends Asignatura{
	private int anio;
	
	//Constructores
	public Materia(){
		this(0);
	}
	
	public Materia(int anio) {
		super();
		this.anio = anio;
	}

	public Materia(Long id, int codigo, String nombre,
			ArrayList<Alumno> alumnos, ArrayList<Profesor> profesores, int anio) {
		super(id, codigo, nombre, alumnos, profesores);
		this.anio = anio;
	}

	//Getters y Setters
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}

	//toString
	public String toString() {
		return "Materia [anio=" + anio + "]";
	}

	//Equals
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Materia other = (Materia) obj;
		if (anio != other.anio)
			return false;
		return true;
	}
	
	//Metodos
	public void agregarAlumno(Alumno a){
			alumnos.add(a);
			System.out.println("Alumno agregado correctamente");
	}
	
	public void eliminarAlumno(Alumno a){
		alumnos.remove(a);
	}
	
	public void agregarProfesor(Profesor p){
		profesores.add(p);
		System.out.println("Profesor agregado correctamente");
	}
	
	public void eliminarProfesor(Profesor p){
		profesores.remove(p);
	}
}
