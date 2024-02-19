package cipoBolt;

public class CipoFoprogram {

	public static void main(String[] args) {

		Feladatok feladatObj = new Feladatok();

		System.out.println("1. feladat - fajlbeolvasas");
		feladatObj.fajlbeolvasas("cipobolt.csv", ";");
		System.out.println();

		System.out.println("2. feladat - kiiratas");
		feladatObj.kilistaz();
		System.out.println();

		System.out.println("3. feladat - tipusonkenti lista");
		feladatObj.tipusonkentiLista();
		System.out.println();

		// System.out.println("4. feladat - ar intervallum lista");
		// feladatObj.arIntervallumLista();
		// System.out.println();

		System.out.println("5. feladat - csizmak atlagara: ");
		System.out.printf("%.2f Ft%n", feladatObj.csizmaAtlagar());
		System.out.println();

		System.out.println("6. feladat - 5 vagy kevesebb termekkel rendelkezo tipusok: ");
		feladatObj.keszletHiany();
		System.out.println();

		System.out.println("7. feladat - teljes raktarkeszlet (db)");
		System.out.println(feladatObj.osszesDB());
		System.out.println();
		
		System.out.println("8. feladat - hazai termekek fajlba irasa");
		feladatObj.hazaiFajlba("hazai.txt",";");
		System.out.println();
		
		System.out.println("9. feladat - Legregebbi es legujabb termekek gyartasa kozott eltelt honapok szama: ");
		System.out.println(feladatObj.hanyHonapTeltel());
		System.out.println();

	}

}
