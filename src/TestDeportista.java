import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import clases.Deportista;


public class TestDeportista {
	
	Deportista deportista1;

	@Before
	public void setUp() throws Exception {
		
		deportista1 = new Deportista(null, null, 0, 0);
		//final Persona per = new Persona(null, null, 0);
		
	}

	@After
	public void tearDown() throws Exception {
		deportista1=null;
	}

	@Test
	public void getNomapellido() {
		String nomapellido = "David Pacheco";
		deportista1.setNomapellido(nomapellido);
		assert (deportista1.getNomapellido().equals(nomapellido));
		//fail("Not yet implemented");
	}
	@Test
	public void getSexo() {
		
		String sexo = "Masculino";
		deportista1.setSexo(sexo);
		assert (deportista1.getSexo().equals(sexo));
		
	}
	@Test
	public void getedad() {
		
		int edad = 19;
		deportista1.setEdad(edad);
		assert (deportista1.getEdad()) == edad;
		
		
	}
	@Test
	public void getIdolimpico() {
		
		int edad = 19;
		deportista1.setEdad(edad);
		assert (deportista1.getEdad()) == edad;
	}
}


