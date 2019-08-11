package ar.com.gugler.sgc.modelo.TPEntrega1;

import java.util.Date;

public class Alumno extends Persona {
	private String legajo;

	//Constructores
	public Alumno() {
		this("");
	}

	public Alumno(String legajo) {
		super();
		this.legajo = legajo;
	}

	public Alumno(Long id, String numeroDocumento, String apellido,
			String nombres, Date fechaNacimiento, String domicilio,
			String telefono, String correoElectronico, String legajo) {
		super(id, numeroDocumento, apellido, nombres, fechaNacimiento,
				domicilio, telefono, correoElectronico);
		this.legajo = legajo;
	}

	//Getters y Setters
	public String getLegajo() {
		return legajo;
	}
	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	//toString
	public String toString() {
		return "Alumno [legajo=" + legajo + "]";
	}

	//Equals
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		if (legajo == null) {
			if (other.legajo != null)
				return false;
		} else if (!legajo.equals(other.legajo))
			return false;
		return true;
	}
	
	//Metodos
	public String mostrarInformacion() {	
		 StringBuilder sb = new StringBuilder();		
		 	sb.append("Nombre: " + nombres+ '\n');
		 	sb.append("Apellido: " + apellido+ '\n');
			sb.append("DNI: " + numeroDocumento + '\n');	
		 return sb.toString();
	}
}
