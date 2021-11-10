import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import clases.Deporte;
import clases.Pais;
import clases.Deportista;

public class TestDeporte {

		
		Deporte Deporte1;
		
		@Before
		public void setUp() throws Exception {
			
			Deporte1 = new Deporte(null, null);
			//final Persona per = new Persona(null, null, 0);
			
		}

		@After
		public void tearDown() throws Exception {
			Deporte1=null;
		}

		@Test
		public void getnomPais() {
			String deporte = "Alemania";
			Deporte1.setTipodeporte(deporte);
			assert (Deporte1.getTipodeporte().equals(deporte));
			//fail("Not yet implemented");
		}
		
		
}