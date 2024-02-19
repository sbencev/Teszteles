package osztalyzatokTeszt;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.time.Duration;

import org.junit.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import osztalyzatok.Fajlkezeles;
import osztalyzatok.Tanulo;

class FajlkezelesTeszt {

	@Test
	public void fajlbeolvasasTeszt() throws IOException {

		Fajlkezeles fajlObj = new Fajlkezeles();

		int elvartEredmeny = 6;

		assertEquals(elvartEredmeny, fajlObj.fajlBeolvasas("osztalyzatok.csv", ";").length);

	}

	@Test
	public void fajlSorainakSzamaTesztKiveteldobas() {

		Fajlkezeles fajlObj = new Fajlkezeles();

		assertThrows(NoSuchFileException.class, () -> fajlObj.fajlBeolvasas("osztalyzat.csv", ";"));

	}

	@Test
	public void fajlSorainakSzamaTeszt() throws IOException {

		int elvartEredmeny = 7;

		Fajlkezeles fajlObj = new Fajlkezeles();

		assertEquals(elvartEredmeny, fajlObj.fajlSorainakSzama("osztalyzatok.csv"));

	}

	@Disabled
	public void fajlbaIrasTeszt() throws IOException {

		Fajlkezeles fajlObj = new Fajlkezeles();

		int elvartEredmeny = fajlObj.fajlSorainakSzama("osztalyzatok.csv") + 1;

		Tanulo tanulo = new Tanulo("valaki", 4, 2, 4);

		fajlObj.fajlbaIras("osztalyzatok.csv", ";", tanulo);

		assertEquals(elvartEredmeny, fajlObj.fajlSorainakSzama("osztalyzatok.csv"));

		assertEquals(4, fajlObj.fajlBeolvasas("osztalyzatok.csv", ";")[7].getMatek());

	}
	
	@Test
	public void fajlBeolvasasTesztValaszido() {

		Fajlkezeles fajlObj = new Fajlkezeles();

		assertTimeout(Duration.ofMillis(2000), () -> fajlObj.fajlBeolvasas("osztalyzatok.csv", ";"));

	}

}
