package sistemskeoperacije;

import domZdravlja.klase.Pacijent;

public class SOZakazaniPregledi {
	public static String izvrsi() {
		String s = "";
		for (int i = 0; i < Pacijent.zakazaniPregledi.size(); i++) {
			s = s + System.lineSeparator() + Pacijent.zakazaniPregledi.get(i).IzvestajZaPacijenta();
		}
		return s;
	}
}
