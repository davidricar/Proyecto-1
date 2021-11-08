package clases;

import java.util.ArrayList;

import interfaz.DeclaracionFormatoFichero;



public class Deportista extends Persona implements DeclaracionFormatoFichero{
	
	private int idolimpico;

	
	/**
	 * 
	 * @param nomapellido
	 * @param sexo
	 * @param edad
	 * @param idolimpico
	 */
	public Deportista(String nomapellido,String sexo,int edad, int idolimpico) {
		super(nomapellido, sexo, edad);
		this.idolimpico = idolimpico;

	}

	public int getIdolimpico() {
		return idolimpico;
	}

	public void setIdolimpico(int idolimpico) {
		this.idolimpico = idolimpico;
	}


	
	public String formatoFichero() {
		return this.nomapellido + ";" + this.sexo+";"+this.edad+";"+this.idolimpico;
	}
	}
	

