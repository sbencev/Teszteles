package pizzeria;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PizzeriaFoprogram {

	static Random r = new Random();
	static List<Kiszallitas> kiszallitasok = new ArrayList<Kiszallitas>();

	public static void main(String[] args) {

		int rendelesekSzama = 0;

		System.out.println("A pizzeria kinyitott, fogad rendeleseket\n");
		try {
			for (int i = 0; i < 120; i++) {

				switch (r.nextInt(4)) {

				case 0:
				case 1: // uj kiszallitas

					rendelesekSzama++;
					String azonosito = "R" + String.valueOf(rendelesekSzama);
					int db = r.nextInt(5) + 1;
					Kiszallitas ujKiszallitas = new Kiszallitas(azonosito, db);
					kiszallitasok.add(ujKiszallitas);
					System.out.print(
							"\nUj kiszallitas indult, azonositoja: " + azonosito + " " + db + " db, idopontja: ");
					System.out.println(
							ujKiszallitas.getKiszallitasStart().format(DateTimeFormatter.ofPattern("HH:mm:ss")));

					break;
				case 2:// kezbesites, kalkulacio

					if (kiszallitasok.size() > 0) {

						int melyikRendelesErtOda = r.nextInt(kiszallitasok.size());

						Kiszallitas kiszObj = kiszallitasok.get(melyikRendelesErtOda);
						kiszObj.setKezbesitesIdeje(LocalTime.now());
						System.out.println("\nRendeles kezbesitve. Azonosito: " + kiszObj.getRendelesAzonosito());
						System.out.print(" indulasi ido: "
								+ kiszObj.getKiszallitasStart().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
						System.out.println(" kezbesitesi ido: "
								+ kiszObj.getKezbesitesIdeje().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
						System.out.println("A kezbesites idotartama: " + kiszObj.kalkulacio() + " perc. ");
						System.out.println("Ara az eltelt ido fuggvenyeben: " + kiszObj.getAr() + " Ft.");

						kiszallitasok.remove(melyikRendelesErtOda);

					}
					break;
				case 3:
					// uresjarat
					break;

				}

				Thread.sleep(1000); // minden iteracio vegen varakoztatjuk 1 masodpercet

			}

			System.out.println("A pizzeria bezart, nem fogad tobb rendelest!");

		} catch (InterruptedException e) {

			System.out.println("Szal problema!");

		} catch (IllegalArgumentException e) {

			System.out.println(e.getMessage());

		}

	}

}
