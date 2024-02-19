package cipoBolt;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Feladatok {

	List<Cipo> cipok = new ArrayList<Cipo>();
	Fajlkezeles fajlObj = new Fajlkezeles();

	public void fajlbeolvasas(String fajlnev, String elvalaszto) {

		cipok = fajlObj.fajlBeolvas("cipobolt.csv", ";");

	}

	public void kilistaz() {

		kilistaz(cipok);
	}

	public void kilistaz(List<Cipo> cipok) {

		for (Cipo cipo : cipok) {

			System.out.print(cipo.getCikkszam() + " ");
			System.out.print(cipo.getMegnevezes() + " ");
			System.out.print(cipo.getTipusSzovegesen() + " ");
			System.out.print(cipo.getAr() + " ");
			System.out.print(cipo.getKeszlet() + " ");
			System.out.printf("%tY.%tm.%td ", cipo.getGyartasiDatum(), cipo.getGyartasiDatum(),
					cipo.getGyartasiDatum());
			System.out.println(cipo.getHazaiTermekSzovegesen() + " ");

			// System.out.println(cipo.toString());

		}

	}

	public void tipusonkentiLista() {

		List<Cipo> alkalmiCipok = new ArrayList<Cipo>();
		List<Cipo> edzoCipok = new ArrayList<Cipo>();
		List<Cipo> csizmak = new ArrayList<Cipo>();
		List<Cipo> papucsok = new ArrayList<Cipo>();

		for (Cipo cipo : cipok) {

			switch (cipo.getTipus()) {

			case 1:
				alkalmiCipok.add(cipo);
				break;
			case 2:
				edzoCipok.add(cipo);
				break;
			case 3:
				csizmak.add(cipo);
				break;
			case 4:
				papucsok.add(cipo);
				break;
			}

		}

		System.out.println("Alkalmi cipok listaja: ");
		kilistaz(alkalmiCipok);

		System.out.println("\nEdzocipok listaja: ");
		kilistaz(edzoCipok);

		System.out.println("\nCsizmak listaja: ");
		kilistaz(csizmak);

		System.out.println("\nPapucsok listaja: ");
		kilistaz(papucsok);
	}

	public void arIntervallumLista() {

		List<Cipo> arSzerintiLista = new ArrayList<Cipo>();

		Scanner sc = new Scanner(System.in);

		boolean joErtek = false;
		int alsoHatar = 0;
		int felsoHatar = 0;

		do {

			try {

				System.out.println("Kerem adja meg az ar also hatarat: ");
				alsoHatar = Integer.parseInt(sc.nextLine());

				System.out.println("Kerem adja meg az ar felso hatarat: ");
				felsoHatar = Integer.parseInt(sc.nextLine());

				joErtek = true;

			} catch (NumberFormatException e) {
				System.err.println("Nem megfelelo formatum!");
			}

		} while (!joErtek || felsoHatar < alsoHatar);

		for (Cipo cipo : cipok) {
			if (cipo.getAr() >= alsoHatar && cipo.getAr() <= felsoHatar) {
				arSzerintiLista.add(cipo);
			}
		}
		System.out.println("\nAz ar szerinti lista: ");
		kilistaz(arSzerintiLista);
		sc.close();

	}

	public Object csizmaAtlagar() {

		int db = 0;
		int osszAr = 0;
		for (Cipo cipo : cipok) {
			if (cipo.getTipus() == 3) {

				osszAr += cipo.getAr();
				db++;

			}
		}

		return (double) osszAr / db;
	}

	public void keszletHiany() {

		Set<String> keszletHianyosTipus = new HashSet<String>();

		for (Cipo cipo : cipok) {
			if (cipo.getKeszlet() <= 5) {
				keszletHianyosTipus.add(cipo.getTipusSzovegesen());
			}
		}
		for (String tipus : keszletHianyosTipus) {
			System.out.println(tipus);
		}
	}

	public int osszesDB() {

		int db = 0;
		for (Cipo cipo : cipok) {
			db += cipo.getKeszlet();
		}
		return db;
	}

	public void hazaiFajlba(String fajlnev, String elvalaszto) {

		List<Cipo> hazai = new ArrayList<Cipo>();
		for (Cipo cipo : cipok) {
			if (cipo.isHazaiTermek()) {
				hazai.add(cipo);

			}
		}
		fajlObj.hazaiFajlbaIr(hazai, elvalaszto, fajlnev);
	}

	public int hanyHonapTeltel() {

		int legregebbiIndex = 0;
		int legujabbIndex = 0;

		for (int i = 1; i < cipok.size(); i++) {

			if (cipok.get(i).getGyartasiDatum().isBefore(cipok.get(legregebbiIndex).getGyartasiDatum())) {
				legregebbiIndex = i;
			}
			if (cipok.get(i).getGyartasiDatum().isAfter(cipok.get(legujabbIndex).getGyartasiDatum())) {
				legujabbIndex = i;
			}
		}

		LocalDate regi = cipok.get(legregebbiIndex).getGyartasiDatum();
		LocalDate uj = cipok.get(legujabbIndex).getGyartasiDatum();

		return (Period.between(regi, uj).getYears() * 12) + Period.between(regi, uj).getMonths();
	}

}
