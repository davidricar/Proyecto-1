import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import clases.Medalla;
import clases.Pais;

public class TestMedalla {

	Medalla medalla1;
	
	@Before
	public void setup() throws Exception{
		medalla1 = new Medalla(null);
	}
	
	@After
	public void teardown() throws Exception{
		medalla1 = null;
	}
	
	@Test
	public void getTipoMedalla() {
		String tipomedalla = "oro";
		medalla1.setTipomedalla(tipomedalla);
		assert (medalla1.getTipomedalla().equals(tipomedalla));
	}
}
