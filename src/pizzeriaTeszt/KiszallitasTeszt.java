package pizzeriaTeszt;

import static org.junit.jupiter.api.Assertions.*; // statikus import, JUnit 5-os tesztmetodusait erhetjuk el

import java.time.Duration;
import java.time.LocalTime;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test; // annotaciok importja
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import pizzeria.Kiszallitas;

@TestMethodOrder(OrderAnnotation.class)
class KiszallitasTeszt {

	@Test
	public void KiszallitasTeszt() { // peldanyositas tesztje, a megfelelo arat rendeli-e hozza az objektumhoz

		Kiszallitas kiszallObj = new Kiszallitas("R001", 3);
		int elvartAr = 1600;
		assertEquals(elvartAr, kiszallObj.getAr());

	}

	@Test
	public void KiszallitasTesztHibadobas() {

		assertThrows(IllegalArgumentException.class, () -> new Kiszallitas(null, 2));

	}

	@Test
	public void KiszallitasHibadobas2() {

		assertThrows(IllegalArgumentException.class, () -> new Kiszallitas("R0001", 0));

	}

	@Test
	public void setKezbesitesIdejeTeszt() {

		Kiszallitas kiszallObj = new Kiszallitas("R0001", 2);
		LocalTime hibasIdo = kiszallObj.getKiszallitasStart().minusSeconds(1);

		assertThrows(IllegalArgumentException.class, () -> kiszallObj.setKezbesitesIdeje(hibasIdo));

	}

	@Test
	public void KiszallitasTesztMelyikHibauzenet() {

		Exception e = assertThrows(IllegalArgumentException.class, () -> new Kiszallitas("R0002", 9));
		String elvartUzenet = "Darab";

		assertTrue(e.getMessage().contains(elvartUzenet));

	}

	@Test
	@Order(1)
	public void PizzeriaFoprogramTeszt() {

		assertTimeout(Duration.ofSeconds(130), () -> pizzeria.PizzeriaFoprogram.main(null));

	}

	// feketedoboz teszttechnikát alkalmazva állapíthatjuk meg az optimális
	// teszteset számot és a konkrét tesztadatokat
	// ekvivalencia partíciók:
	// x < 0; 0 <= x <= 30; 30 < x <= 40; 40 < x <= 50; 50 < x <= 60; x > 60
	// tesztadatok a bövitett határérték elemzés alapján:
	// -1, 0, 1, 29, 30, 31, 39, 40 , 41, 49, 50, 51, 59, 60, 61 vagyis 15 teszteset
	// szükséges

	@Test
	public void kalkulacioTeszt() {

		Kiszallitas obj = new Kiszallitas("R0001", 3);

		obj.setKezbesitesIdeje(obj.getKiszallitasStart().plusSeconds(61));

		int elvartAr = 0;
		obj.kalkulacio();

		assertEquals(elvartAr, obj.getAr());

	}

	@Test
	public void kalkulacioTeszt2() {

		Kiszallitas obj = new Kiszallitas("R0001", 3);

		obj.setKezbesitesIdeje(obj.getKiszallitasStart().plusSeconds(60));

		int elvartAr = 400;
		obj.kalkulacio();

		assertEquals(elvartAr, obj.getAr());

	}

	@Test
	public void kalkulacioTeszt3() {

		Kiszallitas obj = new Kiszallitas("R0001", 3);

		obj.setKezbesitesIdeje(obj.getKiszallitasStart().plusSeconds(59));

		int elvartAr = 400;
		obj.kalkulacio();

		assertEquals(elvartAr, obj.getAr());

	}

	public static int[][] tesztadatok() {

		return new int[][] {

				{ 0, 1600 }, { 1, 1600 }, { 29, 1600 }, { 30, 1600 }, { 31, 1200 }, { 39, 1200 }, { 40, 1200 },
				{ 41, 800 }, { 49, 800 }, { 50, 800 }, { 51, 400 }

		};

	}

	@ParameterizedTest
	@MethodSource(value = "tesztadatok")
	public void kalkulacioParameterezettTeszt(int[] adat) {

		Kiszallitas obj = new Kiszallitas("R0001", 3);

		obj.setKezbesitesIdeje(obj.getKiszallitasStart().plusSeconds(adat[0]));

		int elvartAr = adat[1];
		obj.kalkulacio();

		assertEquals(elvartAr, obj.getAr());

	}
	
	//néhány további annotáció:
		//@BeforeEach --> minden teszteset elött le fog futni a jelölt metódus
		//@BeforeAll --> egyszer, a tesztelés kezdetekor lefutó metódust jelöl
		//@AfterEach --> minden teszteset lefutása után aktivizálódó metódust jelöl
		//@AfterAll --> egyszer, a tesztelés végén lefutó metódust jelöl
		//@Disable --> kihagyja a tesztet
		//@RepeatedTest(x) --> x alkalommal futtatja az adott tesztet
		
	// assertEquals esetében megadható egv • delta • paraméter , ami turéshatárt ad meg az elvárt és a valós eredmény között
	// valos szamoknal erdemes hasznalni
	
}
