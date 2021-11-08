package clases;

public class Persona {
	String nomapellido;
	String sexo;
	int edad;
	
	/**
	 * 
	 * @param nomapellido
	 * @param sexo
	 * @param edad
	 */
	public Persona(String nomapellido, String sexo, int edad) {
		super();
		this.nomapellido = nomapellido;
		this.sexo = sexo;
		this.edad = edad;
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
	
	
}

