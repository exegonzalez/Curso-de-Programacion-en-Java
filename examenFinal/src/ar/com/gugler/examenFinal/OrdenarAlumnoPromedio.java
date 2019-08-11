package ar.com.gugler.examenFinal;
import java.util.Comparator;

public class OrdenarAlumnoPromedio implements Comparator<Alumno> {
	public int compare(Alumno o1, Alumno o2) {
		return o1.getPromedio().compareTo(o2.getPromedio()); 
	    }
	}

