package cipoBolt;

import java.time.LocalDate;

public class Cipo {

	private String cikkszam;
	private String megnevezes;
	private byte tipus;
	private int ar;
	private int keszlet;
	private LocalDate gyartasiDatum;
	private boolean hazaiTermek;

	public Cipo(String cikkszam, String megnevezes, byte tipus, int ar, int keszlet, LocalDate gyartasiDatum,
			boolean hazaiTermek) {
		this.cikkszam = cikkszam;
		this.megnevezes = megnevezes;
		this.tipus = tipus;
		this.ar = ar;
		this.keszlet = keszlet;
		this.gyartasiDatum = gyartasiDatum;
		this.hazaiTermek = hazaiTermek;
	}

	public Cipo(String[] csvSor) {
		this.cikkszam = csvSor[0];
		this.megnevezes = csvSor[1];
		this.tipus = Byte.parseByte(csvSor[2]);
		this.ar = Integer.parseInt(csvSor[3]);
		this.keszlet = Integer.parseInt(csvSor[4]);
		this.gyartasiDatum = LocalDate.parse(csvSor[5]);
		this.hazaiTermek = csvSor[6].equals("1");
	}

	public String getCikkszam() {
		return cikkszam;
	}

	public String getMegnevezes() {
		return megnevezes;
	}

	public byte getTipus() {
		return tipus;
	}

	public int getAr() {
		return ar;
	}

	public int getKeszlet() {
		return keszlet;
	}

	public LocalDate getGyartasiDatum() {
		return gyartasiDatum;
	}

	public boolean isHazaiTermek() {
		return hazaiTermek;
	}

	public String getTipusSzovegesen() {

		String szoveg = null;
		switch (tipus) {

		case 1:
			szoveg = "alkalmi cipo";
			break;
		case 2:
			szoveg = "edzocipo";
			break;
		case 3:
			szoveg = "csizma";
			break;
		case 4:
			szoveg = "papucs";
			break;

		}
		return szoveg;
	}

	public String getHazaiTermekSzovegesen() {
		if (hazaiTermek) {
			return "hazai termek";
		} else {
			return "import termek";
		}
	}

	@Override
	public String toString() {
		
		
		return cikkszam + " " + megnevezes + getTipusSzovegesen() + " " + ar + " Ft " + keszlet + " db " + gyartasiDatum
				+ " " + getHazaiTermekSzovegesen();
	}

}
