package clases;

import java.util.ArrayList;

import interfaz.DeclaracionFormatoFichero;


/**
 * 
 * @author David Pacheco
 *
 */
public class Deportista implements DeclaracionFormatoFichero{
	String nomapellido;
	String sexo;
	int edad;
	private int idolimpico;

	
	/**
	 * El método Deportista extends de la clase persona,incluyendo todo sus parámetros), añadiendo un atributo adicional  que es:
	 * @param idolimpico--> tipo int para identificar cada deportista 
	 */
	public Deportista (String nomapellido,String sexo,int edad, int idolimpico) {
		this.nomapellido = nomapellido;
		this.sexo = sexo;
		this.edad = edad;
		this.idolimpico = idolimpico;

	}
	public String getNomapellido() {
		return nomapellido;
	}
	public void setNomapellido(String nomapellido) {
		this.nomapellido = nomapellido;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getIdolimpico() {
		return idolimpico;
	}

	public void setIdolimpico(int idolimpico) {
		this.idolimpico = idolimpico;
	}


	/**
	 *  Este método devuelve 
	 */
	public String formatoFichero() {
		return this.nomapellido + ";" + this.sexo+";"+this.edad+";"+this.idolimpico;
	}
	}
	

