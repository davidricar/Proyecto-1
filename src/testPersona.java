import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import clases.Persona;

public class testPersona {



	@Test
	 @DisplayName("Ver si funciona el metodo get")
   
		public void testSetter_setsProperly() throws NoSuchFieldException, IllegalAccessException {
	        //given
	        final Persona per = new Persona(null, null, 0);

	        //when
	        per.setEdad(18);
	        per.setNomapellido("Alfredo");
	        per.setSexo("Hombre");

	        //then
	        final Field field = per.getClass().getDeclaredField("value");
	        field.setAccessible(true);
	        assertEquals("Fields didn't match", field.get(per), "foo");
	   
		fail("Not yet implemented");
	}


}

