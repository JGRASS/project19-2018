package sistemskeoperacije;

import domZdravlja.klase.Pacijent;

public class SOIstorija {
	/**
	 * Varca String koji predstavlja istoriju pregleda.
	 * @return String koji predstavlja istoriju pregleda
	 */
	public static String izvrsi() {
		String s = "";
		for (int i = 0; i < Pacijent.istorijaPregleda.size(); i++) {
			s = s + System.lineSeparator() +  Pacijent.istorijaPregleda.get(i).IzvestajZaPacijenta();
		}
		return s;
	}
}
