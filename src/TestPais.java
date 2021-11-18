import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import clases.Pais;
import clases.Deportista;

public class TestPais {

		
		Pais Pais1;
		
		@Before
		public void setUp() throws Exception {
			
			Pais1 = new Pais(null);
			
		}

		@After
		public void tearDown() throws Exception {
			Pais1=null;
		}

		@Test
		public void getnomPais() {
			String nomPais = "Alemania";
			Pais1.setNompais(nomPais);
			assert (Pais1.getNompais().equals(nomPais));
			
			
		}
		
}
