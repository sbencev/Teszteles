package osztalyzatok;

import java.util.Scanner;

public class Adatkezeles {

	public Tanulo adatokKonzolrol() {
		Scanner sc = new Scanner(System.in);

		String nev;
		int matek, angol, tortenelem;

		boolean joAdat = false;
		Tanulo ujtanulo = null;

		do {
			try {
				System.out.println("Kerem a tanulo nevet: ");
				nev = sc.nextLine();

				System.out.println("Kerem " + nev + " matek osztalyzatat: ");
				matek = Integer.parseInt(sc.nextLine());

				System.out.println("Kerem " + nev + " angol osztalyzatat: ");
				angol = Integer.parseInt(sc.nextLine());

				System.out.println("Kerem " + nev + " tortenelem osztalyzatat: ");
				tortenelem = Integer.parseInt(sc.nextLine());

				ujtanulo = new Tanulo();
				ujtanulo.setNev(nev);
				ujtanulo.setMatek(matek);
				ujtanulo.setAngol(angol);
				ujtanulo.setTortenelem(tortenelem);

				joAdat = true;
			} catch (NumberFormatException e) {
				System.out.println("Nem megfelelo formatum!");
			} catch (IllegalArgumentException e) {
				System.err.println(e.getMessage());
			}
		} while (!joAdat);

		sc.close();

		return ujtanulo;

	}

}
