package sistemskeoperacije;

import domZdravlja.klase.Pacijent;

public class SOIstorija {
	public static String izvrsi() {
		String s = "";
		for (int i = 0; i < Pacijent.istorijaPregleda.size(); i++) {
			s = s + System.lineSeparator() +  Pacijent.istorijaPregleda.get(i).IzvestajZaPacijenta();
		}
		return s;
	}
}
