package ar.com.gugler.sgc.modelo.TPEntrega1;

import java.util.Date;

public class Profesor extends Persona {
	private String cuil;
	private Date fechaIngreso;
	
	//Constructores 
	public Profesor() {
		this("",null);
	}
	
	public Profesor(String cuil, Date fechaIngreso) {
		super();
		this.cuil = cuil;
		this.fechaIngreso = fechaIngreso;
	}

	public Profesor(Long id, String numeroDocumento, String apellido,
			String nombres, Date fechaNacimiento, String domicilio,
			String telefono, String correoElectronico, String cuil,
			Date fechaIngreso) {
		super(id, numeroDocumento, apellido, nombres, fechaNacimiento,
				domicilio, telefono, correoElectronico);
		this.cuil = cuil;
		this.fechaIngreso = fechaIngreso;
	}

	//Getters y Setters
	public String getCuil() {
		return cuil;
	}
	public void setCuil(String cuil) {
		this.cuil = cuil;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	//toString
	public String toString() {
		return "Profesor [cuil=" + cuil + ", fechaIngreso=" + fechaIngreso
				+ "]";
	}
	
	//Equals
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profesor other = (Profesor) obj;
		if (cuil == null) {
			if (other.cuil != null)
				return false;
		} else if (!cuil.equals(other.cuil))
			return false;
		if (fechaIngreso == null) {
			if (other.fechaIngreso != null)
				return false;
		} else if (!fechaIngreso.equals(other.fechaIngreso))
			return false;
		return true;		
		}
	
	//Metodos
	 public String mostrarInformacion() {		
		 StringBuilder sb = new StringBuilder();		
		 	sb.append("Nombre: " + nombres.toUpperCase() + '\n');
		 	sb.append("Apellido: " + apellido.toUpperCase() + '\n');
			sb.append("Cuil: " + cuil + '\n');	
		return sb.toString();
 	}
}
