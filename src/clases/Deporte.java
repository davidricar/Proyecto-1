package clases;

import java.util.ArrayList;

import interfaz.DeclaracionFormatoFichero;

/**
 * 
 * @author David Pacheco
 *
 */

public class Deporte implements DeclaracionFormatoFichero  {

	String sexo;
	String tipodeporte;
	
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

	public String formatoFichero() {
		return this.tipodeporte + ";" + this.sexo;
	}







	
	
}
