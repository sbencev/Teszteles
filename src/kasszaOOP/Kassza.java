package kasszaOOP;

public class Kassza {

	private int egyenleg;

	public Kassza(int egyenleg) {
		this.egyenleg = egyenleg;
	}

	public int getEgyenleg() {
		return egyenleg;
	}

	public void setEgyenleg(int egyenleg) {

		if (egyenleg >= 0) {
			this.egyenleg = egyenleg;
		} else {
			throw new IllegalArgumentException("Az egyenleg nem lehet minusz!");
			// System.err.println("Az egyenleg nem lehet minusz!");
		}
	}

	public void bevetelKonyveles(int bevetel) {
		setEgyenleg(egyenleg + bevetel);
	}

	public void kiadasKonyvelese(int kiadas) {
		setEgyenleg(egyenleg - kiadas);
	}

}
