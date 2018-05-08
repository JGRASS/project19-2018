package sistemskeoperacije;

import domZdravlja.klase.Pacijent;

public class SOZakazaniPregledi {
	/**
	 * Varca String koji predstavlja zakazane preglede.
	 * @return String koji predstavlja zakazane preglede
	 */
	public static String izvrsi() {
		String s = "";
		for (int i = 0; i < Pacijent.zakazaniPregledi.size(); i++) {
			s = s + System.lineSeparator() + Pacijent.zakazaniPregledi.get(i).IzvestajZaPacijenta();
		}
		return s;
	}
}
