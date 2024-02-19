package osztalyzatok;

import java.io.IOException;

public class OsztalyzatokFoprogram {

	public static void main(String[] args) throws IOException {

		Fajlkezeles fajlObj = new Fajlkezeles();

		Tanulo[] tanulok = fajlObj.fajlBeolvasas("osztalyzatok.csv", ";");

		for (Tanulo tanulo : tanulok) {
			System.out.print(tanulo.toString());
			System.out.printf(" atlaga: %.2f%n", tanulo.atlagSzamitas());
		}
		
		System.out.printf("\nAz osztaly atlaga: %.2f%n",Tanulo.osztalyAtlag(tanulok));

		Adatkezeles adatobj = new Adatkezeles();
		fajlObj.fajlbaIras("osztalyzatok.csv", ";", adatobj.adatokKonzolrol());
		
	}

}
