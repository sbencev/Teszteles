package kasszaOOP;

import java.util.Scanner;

public class KasszaFoprogram {

	public static void main(String[] args) {

		Kassza kasszaObj = new Kassza(300000);
		Scanner sc = new Scanner(System.in);

		char menuOpcio;

		do {

			System.out.println("Valasszon az alabbi menupontok kozul: ");
			System.out.println("1. Bevetel rogzitese");
			System.out.println("2. Kiadas rogzitese");
			System.out.println("3. Egyenleg lekerdezese");
			System.out.println("4. Kilepes");

			menuOpcio = sc.nextLine().charAt(0);

			switch (menuOpcio) {

			case '1':
				System.out.println("Adja meg a bevetel osszeget: ");
				int bevetel = Integer.parseInt(sc.nextLine());
				kasszaObj.bevetelKonyveles(bevetel);
				break;
			case '2':
				System.out.println("Adja meg a kiadas osszeget: ");
				int kiadas = Integer.parseInt(sc.nextLine());
				kasszaObj.kiadasKonyvelese(kiadas);
				break;
			case '3':
				System.out.println("A kassza egyenlege: " + kasszaObj.getEgyenleg() + " Ft");
				break;

			}

		} while (menuOpcio != '4');

		sc.close();

	}

}
