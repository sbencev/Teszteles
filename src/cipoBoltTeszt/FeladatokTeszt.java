package cipoBoltTeszt;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import cipoBolt.Cipo;
import cipoBolt.Feladatok;

class FeladatokTeszt {

	@Test
	public void kilistazTeszt() {

		Feladatok feladatObj = new Feladatok();

		List<Cipo> cipok = new ArrayList<Cipo>();
		cipok.add(new Cipo("A0010", "teniszcipo", (byte) 1, 55000, 5, LocalDate.now(), false));
		cipok.add(new Cipo("A0008", "edzocipo", (byte) 2, 25000, 17, LocalDate.now(), false));

		assertTimeout(Duration.ofMillis(500), () -> feladatObj.kilistaz(cipok));

	}

	@Test
	public void hanyHonapTeltelTeszt() {

		// elofeltetel: rendelkezesre allegy adatokkal feltoltott lista:

		Feladatok feladatObj = new Feladatok();
		feladatObj.fajlbeolvasas("cipobolt.csv", ";");

		assertEquals(40, feladatObj.hanyHonapTeltel());

	}

}
