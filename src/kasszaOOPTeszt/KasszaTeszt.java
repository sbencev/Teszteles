package kasszaOOPTeszt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kasszaOOP.Kassza;

class KasszaTeszt {

	Kassza kasszaObj = new Kassza(400000);

	@BeforeEach
	public void kasszaInicializal() {

		kasszaObj = new Kassza(400000);

	}

	@Test
	void kasszaTeszt() {

		assertEquals(400000, kasszaObj.getEgyenleg());

	}

	@Test
	void setEgyenlegTesztJoertekkel() {

		kasszaObj.setEgyenleg(500000);
		assertEquals(500000, kasszaObj.getEgyenleg());

	}

	@Test
	void setEgyenlegTesztRosszertekkel() {

		assertThrows(IllegalArgumentException.class, () -> kasszaObj.setEgyenleg(-10000));

	}

	@Test
	void bevetelKonyvelesTeszt() {

		int elvart = 500000;
		kasszaObj.bevetelKonyveles(100000);

		assertEquals(elvart, kasszaObj.getEgyenleg());

	}

	@Test
	void kiadasKonyvelesTeszt() {

		int elvart = 250000;
		kasszaObj.kiadasKonyvelese(150000);

		assertEquals(elvart, kasszaObj.getEgyenleg());

	}

}
