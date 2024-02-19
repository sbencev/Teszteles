package osztalyzatokTeszt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import osztalyzatok.Tanulo;

class OsztalyzatokTeszt {

	Tanulo tanulo = new Tanulo();

	@Test
	public void TanuloNevHibadobas() {

		assertThrows(IllegalArgumentException.class, () -> tanulo.setNev(null));

	}

	@Test
	public void TanuloMatekHibadobas() {

		assertThrows(IllegalArgumentException.class, () -> tanulo.setMatek(7));

	}
	
	@Test
	public void TanuloAngolHibadobas() {

		assertThrows(IllegalArgumentException.class, () -> tanulo.setAngol(7));

	}
	
	@Test
	public void TanuloTortenelemHibadobas() {

		assertThrows(IllegalArgumentException.class, () -> tanulo.setTortenelem(7));

	}
	
	@Test
	public void TanuloToStringTeszt() {
		
		assertTrue(tanulo.toString().contains("matek"));
		
	}
	
	@Test
	public void AtlagszamitasTeszt() {
		
		tanulo.setAngol(4);
		tanulo.setMatek(5);
		tanulo.setTortenelem(3);
		
		double elvart = 4;
		
		assertEquals(elvart, tanulo.atlagSzamitas(), 0.0001);
		
	}
	
}
