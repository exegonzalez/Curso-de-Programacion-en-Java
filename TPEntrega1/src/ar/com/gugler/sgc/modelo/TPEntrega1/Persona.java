package ar.com.gugler.sgc.modelo.TPEntrega1;

import java.util.Date;

import ar.com.gugler.sgc.modelo.TPEntrega1.BaseModelo;

public abstract class Persona extends BaseModelo{
	protected String numeroDocumento;
	protected String apellido;
	protected String nombres;
	protected Date	fechaNacimiento;
	protected String domicilio;
	protected String telefono;
	protected String correoElectronico;
	
	//Constructores
	public Persona() {
		this(null, "", "", "", null, "", "", "");
	}
	
	public Persona(Long id, String numeroDocumento, String apellido,
			String nombres, Date fechaNacimiento, String domicilio,
			String telefono, String correoElectronico) {
		super(id);
		this.numeroDocumento = numeroDocumento;
		this.apellido = apellido;
		this.nombres = nombres;
		this.fechaNacimiento = fechaNacimiento;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
	}

	//Getters y Setters
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	//toString
	public String toString() {
		return "Persona [numeroDocumento=" + numeroDocumento + ", apellido="
				+ apellido + ", nombres=" + nombres + ", fechaNacimiento="
				+ fechaNacimiento + ", domicilio=" + domicilio + ", telefono="
				+ telefono + ", correoElectronico=" + correoElectronico + "]";
	}

	//equals
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (correoElectronico == null) {
			if (other.correoElectronico != null)
				return false;
		} else if (!correoElectronico.equals(other.correoElectronico))
			return false;
		if (domicilio == null) {
			if (other.domicilio != null)
				return false;
		} else if (!domicilio.equals(other.domicilio))
			return false;
		if (fechaNacimiento == null) {
			if (other.fechaNacimiento != null)
				return false;
		} else if (!fechaNacimiento.equals(other.fechaNacimiento))
			return false;
		if (nombres == null) {
			if (other.nombres != null)
				return false;
		} else if (!nombres.equals(other.nombres))
			return false;
		if (numeroDocumento == null) {
			if (other.numeroDocumento != null)
				return false;
		} else if (!numeroDocumento.equals(other.numeroDocumento))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}
	
	//Metodos
	public abstract String mostrarInformacion();
}
