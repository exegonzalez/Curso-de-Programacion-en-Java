package ar.com.gugler.sgc.modelo.TPEntrega1;

import java.util.ArrayList;

import ar.com.gugler.sgc.modelo.TPEntrega1.BaseModelo;

public class Asignatura extends BaseModelo{
	private int codigo;
	private String nombre;
	protected ArrayList<Alumno> alumnos;
	protected ArrayList<Profesor> profesores;
	
	//constructores
	public Asignatura(){
		this(null, 0,"",null,null);
	}

	public Asignatura(Long id, int codigo, String nombre,
			ArrayList<Alumno> alumnos, ArrayList<Profesor> profesores) {
		super(id);
		this.codigo = codigo;
		this.nombre = nombre;
		this.alumnos = alumnos;
		this.profesores = profesores;
	}

	//Getters y Setters
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(ArrayList<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	public ArrayList<Profesor> getProfesores() {
		return profesores;
	}
	public void setProfesores(ArrayList<Profesor> profesores) {
		this.profesores = profesores;
	}

	//toString
	public String toString() {
		return "Asignatura [codigo=" + codigo + ", nombre=" + nombre
				+ ", alumnos=" + alumnos + ", profesores=" + profesores + "]";
	}

	//Equals
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asignatura other = (Asignatura) obj;
		if (alumnos == null) {
			if (other.alumnos != null)
				return false;
		} else if (!alumnos.equals(other.alumnos))
			return false;
		if (codigo != other.codigo)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (profesores == null) {
			if (other.profesores != null)
				return false;
		} else if (!profesores.equals(other.profesores))
			return false;
		return true;
	}
}
