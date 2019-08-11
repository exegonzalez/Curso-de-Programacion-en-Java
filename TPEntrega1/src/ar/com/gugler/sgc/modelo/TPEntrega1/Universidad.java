package ar.com.gugler.sgc.modelo.TPEntrega1;

public class Universidad {
	public static void mostrarDatos(Persona persona) {

	if (persona instanceof Alumno) {
		System.out.println("Visualizando un alumno...");
	}

	if (persona instanceof Profesor) {
		System.out.println("Visualizando un profesor...");
	}
	
	System.out.println(persona.mostrarInformacion());
	}
}
