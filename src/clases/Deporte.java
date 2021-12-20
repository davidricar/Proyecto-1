package clases;

import java.util.ArrayList;

import interfaz.DeclaracionFormatoFichero;
import interfaz.I_Comparable;

/**
 * 
 * @author David Pacheco
 *
 */


public class Deporte implements DeclaracionFormatoFichero  {

	String sexo;
	String tipodeporte;
	ArrayList<Deporte>lista_deportes;
	
/**
 * 
 * @param tipodeporte
 * @param sexo
 */

	public Deporte(String tipodeporte,String sexo) {
		super();
		this.tipodeporte = tipodeporte;
		this.sexo=sexo;

		
	}



	public String getTipodeporte() {
		return tipodeporte;
	}



	public void setTipodeporte(String tipodeporte) {
		this.tipodeporte = tipodeporte;
	}
	/**
	 * Este método, implementado por la interfaz, sirve para enviar el Deporte con los atributos
	 *  tipo String separados con ";", para ser escritos en el fichero del dicho clase
	 *  
	 */
	public String formatoFichero() {
		return this.tipodeporte + ";" + this.sexo;
	}

	public boolean compareStr1(Deporte deporte) {
		// TODO Auto-generated method stub
		return true ;
	}



	public int compareTo(Deporte deporte) {
		// TODO Auto-generated method stub
		return 0;
	}
}
