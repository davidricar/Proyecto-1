import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import clases.Persona;

public class testPersona1 {
	
	Persona persona1;

	@Before
	public void setUp() throws Exception {
		
		persona1 = new Persona(null, null, 0);
		//final Persona per = new Persona(null, null, 0);
		
	}

	@After
	public void tearDown() throws Exception {
		persona1=null;
	}

	@Test
	public void getNomapellido() {
		String nomapellido = "David Pacheco";
		persona1.setNomapellido(nomapellido);
		assert (persona1.getNomapellido().equals(nomapellido));
		//fail("Not yet implemented");
	}
	@Test
	public void getSexo() {
		
		
	}
	}


