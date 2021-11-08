package clases;

import interfaz.DeclaracionFormatoFichero;

public class Medalla implements DeclaracionFormatoFichero  {

	String Tipomedalla;

	
	public String getTipomedalla() {
		return Tipomedalla;
	}
	public void setTipomedalla(String tipomedalla) {
		Tipomedalla = tipomedalla;
	}
	
		public Medalla(String tipomedalla) {
		super();
		this.Tipomedalla = tipomedalla;

	}
		
		public String formatoFichero() {
			return this.Tipomedalla;
		}
	
	
}
