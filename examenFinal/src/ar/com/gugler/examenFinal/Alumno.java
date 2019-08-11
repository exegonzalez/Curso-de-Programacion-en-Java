package ar.com.gugler.examenFinal;

import java.util.ArrayList;

public class Alumno extends Persona {
	protected ArrayList<Integer> notas;

	public Alumno(Integer dni, String apellido, String nombre,
			ArrayList<Integer> notas) {
		super(dni, apellido, nombre);
		this.notas = notas;
	}

	public ArrayList<Integer> getNotas() {
		return notas;
	}
	public void setNotas(ArrayList<Integer> notas) {
		this.notas = notas;
	}

	public void agregarNota(Integer a){
		notas.add(a);
	}
	
	public Integer getPromedio(){
		int cont;
        int acum;
        int prom;
        cont = 0;
        acum = 0;
        prom = 0;
		try{	 
	        for (Integer nota: notas){
	        	++cont;
	        	acum = acum + nota;
	        }
	        prom = acum/cont;
         }
         catch(Exception e){
	         System.out.println(" No se cargaron las notas");
         }
		return prom;
    }
		
	public String mostrarInformacion() {	
		 StringBuilder sb = new StringBuilder();		
		 	sb.append("Nombre: " + this.getNombre()+ '\n');
		 	sb.append("Apellido: " + this.getApellido()+ '\n');
			sb.append("Promedio: " + this.getPromedio()+ '\n');	
		 return sb.toString();
	}
}
