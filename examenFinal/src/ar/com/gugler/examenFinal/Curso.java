package ar.com.gugler.examenFinal;

import java.util.ArrayList;

public class Curso {
	private String nombre;
	protected ArrayList<Alumno> alumnos;

	public Curso(String nombre, ArrayList<Alumno> alumnos) {
		super();
		this.nombre = nombre;
		this.alumnos = alumnos;
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

	
	
	public void agregarAlumno(Alumno a){
		alumnos.add(a);
		System.out.println("Alumno agregado correctamente");
	}
	public void eliminarAlumno(Alumno a){
		alumnos.remove(a);
	}
	
	
	
	public void ListarAlumnosPorPromedio(){
		alumnos.sort(new OrdenarAlumnoPromedio());
		System.out.println(" Listado de alumnos ordenados por promedio");
		for (Alumno alumno : alumnos){ 
			System.out.println(alumno.mostrarInformacion());
		}
	}

	
	public void ListarAlumnosAprobados(){
		Integer aux;
		Integer cont;
		System.out.println(" Listado de alumnos aprobados");
		for (Alumno alumno : alumnos){
			aux = 0;
			cont = 0;
			if(alumno.getPromedio()>=80){
				for (Integer nota : alumno.getNotas()){
					++aux;
					if (nota>=70){
						++cont;
					}
				}
				if (aux==cont){
					System.out.println(alumno.mostrarInformacion());
				}
			}
		}
	}
	
	public void ListarAlumnosDesaprobados(){
		Integer aux;
		Integer cont;
		System.out.println(" Listado de alumnos desaprobados");
		for (Alumno alumno : alumnos){
			aux = 0;
			cont = 0;
			if(alumno.getPromedio()<80){
				System.out.println(alumno.mostrarInformacion());
			}
			else{
				for (Integer nota : alumno.getNotas()){
					++aux;
					if (nota>=70){
						++cont;
					}
				}
				if (aux!=cont){
					System.out.println(alumno.mostrarInformacion());
				}
			}
		}
	}
	
}
