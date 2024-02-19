package cipoBolt;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class Fajlkezeles {

	public List<Cipo> fajlBeolvas(String fajlnev, String elvalaszto) {

		List<Cipo> cipok = new ArrayList<Cipo>();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fajlnev), "UTF-8"))) {

			br.readLine();

			int hibasTetelekSzama = 0;

			while (br.ready()) {

				String[] csvSor = br.readLine().split(elvalaszto);

				if (csvSor.length == 7) {
					Cipo ujCipo = new Cipo(csvSor);
					cipok.add(ujCipo);
				} else {
					hibasTetelekSzama++;
				}
			}

			System.out.println(
					"Fajl feldolgozva. Beimportalt/ hibas tetelek szama: " + cipok.size() + "/" + hibasTetelekSzama);

		} catch (UnsupportedEncodingException e) {
			System.err.println("Hibas karakterkodolas!");
		} catch (FileNotFoundException e) {
			System.err.println("Nem letezo fajl!");
		} catch (IOException e) {
			System.err.println("I/O hiba!");
		}

		return cipok;

	}

	public void hazaiFajlbaIr(List<Cipo> hazai, String elvalaszto, String fajlnev) {

		try {

			OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(fajlnev), "UTF-8");
			out.write("cikkszam" + elvalaszto + "ar\n");

			for (Cipo cipo : hazai) {

				out.write(cipo.getCikkszam() + elvalaszto + String.valueOf(cipo.getAr()) + "\n");

			}

			out.close();
			System.out.println("Fajlba iras sikeres");

		} catch (IOException e) {
			System.err.println("I/O hiba!");
		}

	}

}
