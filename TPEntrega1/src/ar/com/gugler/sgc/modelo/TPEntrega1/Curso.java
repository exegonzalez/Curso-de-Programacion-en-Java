package ar.com.gugler.sgc.modelo.TPEntrega1;
import java.util.ArrayList;

import ar.com.gugler.sgc.modelo.TPEntrega1.Administrable;

public class Curso extends Asignatura implements Administrable{
	private int cupo;

	//Constructores
	public Curso(){
		this(0);
	}
	
	public Curso(int cupo) {
		super();
		this.cupo = cupo;
	}

	public Curso(Long id, int codigo, String nombre, ArrayList<Alumno> alumnos,
			ArrayList<Profesor> profesores, int cupo) {
		super(id, codigo, nombre, alumnos, profesores);
		this.cupo = cupo;
	}

	//Getters y Setters
	public int getCupo() {
		return cupo;
	}
	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	//toString
	public String toString() {
		return "Curso [cupo=" + cupo + "]";
	}

	//Equals
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		if (cupo != other.cupo)
			return false;
		return true;
	}
	
	//Metodos
	
	public void agregarAlumno(Alumno a){
		if (admiteInscripciones()){
			alumnos.add(a);
			System.out.println("Alumno agregado correctamente");
		}
		else{
			System.out.println("El cupo del curso esta completo");
		}
	}
	
	public void eliminarAlumno(Alumno a){
		alumnos.remove(a);
	}
	
	public boolean admiteInscripciones(){
		if (alumnos.size()<this.cupo){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void agregarProfesor(Profesor p){
		profesores.add(p);
		System.out.println("Profesor agregado correctamente");
	}
	
	public void eliminarProfesor(Profesor p){
		profesores.remove(p);
	}
}
