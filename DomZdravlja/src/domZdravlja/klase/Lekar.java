package domZdravlja.klase;

import java.util.LinkedList;

public class Lekar {

	private String IDLekara;
	private String imeIPrezime;
	private String specijalizacija;
	private LinkedList<Pregled> pregledi;
	private LinkedList<Pacijent> pacijenti;

	public String getIDLekara() {
		return IDLekara;
	}

	public void setIDLekara(String iDLekara) {
		if (iDLekara != null && iDLekara.length() == 7)
			IDLekara = iDLekara;
		else
			throw new RuntimeException("Greska, IDLekara mora biti duzine 7.");
	}

	public String getImeIPrezime() {
		return imeIPrezime;
	}

	public void setImeIPrezime(String imeIPrezime) {
		if (imeIPrezime != null && imeIPrezime.length() > 8 && imeIPrezime.length() < 50)
			this.imeIPrezime = imeIPrezime;
		else
			throw new RuntimeException("Greska, imeIPrezime mora biti duzine izmedju 8 i 50.");
	}

	public String getSpecijalizacija() {
		return specijalizacija;
	}

	public void setSpecijalizacija(String specijalizacija) {
		if (specijalizacija != null)
			this.specijalizacija = specijalizacija;
		else
			throw new RuntimeException("Greska, specijalizacija ne moze imati vrednost null.");
	}

	public LinkedList<Pregled> getPregledi() {
		return pregledi;
	}

	public void setPregledi(LinkedList<Pregled> pregledi) {
		this.pregledi = pregledi;
	}

}
