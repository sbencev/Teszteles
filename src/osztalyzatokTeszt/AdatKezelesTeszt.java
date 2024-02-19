package osztalyzatokTeszt;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import osztalyzatok.Adatkezeles;
import osztalyzatok.Fajlkezeles;

class AdatKezelesTeszt {

	@Test
	public void adatKonzolrolTeszt() {

		Adatkezeles adatObj = new Adatkezeles();

		assertNotNull(adatObj.adatokKonzolrol());

	}


}
