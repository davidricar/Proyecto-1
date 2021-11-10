package clases;

import java.util.ArrayList;

import interfaz.DeclaracionFormatoFichero;
import interfaz.DeclaracionFormatoFichero;

public class Pais implements DeclaracionFormatoFichero {

private String nompais;
	
	
	public Pais(String nompais) {
		super();
		this.nompais = nompais;
	}
	public String getNompais() {
		return nompais;
	}
	public void setNompais(String nompais) {
		this.nompais = nompais;
	}
	

	
	public String formatoFichero() {
		return this.nompais;
	}
}