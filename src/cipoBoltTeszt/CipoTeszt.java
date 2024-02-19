package cipoBoltTeszt;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import cipoBolt.Cipo;
import osztalyzatok.Fajlkezeles;

class CipoTeszt {

	@Test
	public void cipoTeszt() {

		Cipo cipoObj = new Cipo("A0010", "teniszcipo", (byte) 1, 55000, 5, LocalDate.now(), false);

		assertEquals(55000, cipoObj.getAr());

	}

	@Test
	public void cipoTeszt2() {

		Cipo cipoObj = new Cipo(
				new String[] { "A0010", "teniszcipo", "1", "55000", "5", LocalDate.now().toString(), "0" });

		assertEquals(55000, cipoObj.getAr());

	}

	@Test
	public void getTipusSzovegesenTeszt() {

		Cipo cipoObj = new Cipo("A0010", "teniszcipo", (byte) 1, 55000, 5, LocalDate.now(), false);

		String elvartErtek = "alkalmi cipo";

		assertEquals(1, cipoObj.getTipus());

		assertEquals(elvartErtek, cipoObj.getTipusSzovegesen());

	}

	@Test
	public void GetHazaiTermekSzovegesenTeszt() {

		Cipo cipoObj = new Cipo("A0010", "teniszcipo", (byte) 1, 55000, 5, LocalDate.now(), false);

		String elvart = "import termek";

		assertEquals(elvart, cipoObj.getHazaiTermekSzovegesen());

	}

	@Test
	public void toStringTeszt() {

		Cipo cipoObj = new Cipo("A0010", "teniszcipo", (byte) 1, 55000, 5, LocalDate.now(), false);

		String elvart = "A0010 teniszcipo alkalmi cipo 55000 Ft 5db 2023.10.12 import termek";

	}

	@Test
	public void hazaiFajlbaIr() {

		cipoBolt.Fajlkezeles fajlObj = new cipoBolt.Fajlkezeles();
		List<Cipo> cipok = new ArrayList<Cipo>();

		cipok.add(new Cipo("A0010", "teniszcipo", (byte) 1, 55000, 5, LocalDate.now(), false));

		fajlObj.hazaiFajlbaIr(cipok, ";", "hazai.txt");

		assertTrue(new File("hazai.txt").exists());

	}

}
