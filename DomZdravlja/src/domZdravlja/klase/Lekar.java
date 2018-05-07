package domZdravlja.klase;

import java.util.LinkedList;
import domZdravlja.klase.Pregled;

/**
 * Klasa predstavlja lekara sa osnovnim osobinama.
 * 
 * @author Sofija Dimitrijevic
 * 
 */

public class Lekar {

	/**
	 * Jedinstveni identifikator lekara.
	 */
	private String IDLekara;
	/**
	 * Ime i prezime lekara.
	 */
	private String imeIPrezime;
	/**
	 * Specijalizacija lekara.
	 */
	private String specijalizacija;
	/**
	 * Sifra koju lekar koristi da bi pristupio svom nalogu.
	 */
	private String sifra;
	/**
	 * Zakazani pregledi Lekara.
	 * @see domZdravlja.klase.Pregled
	 */
	private LinkedList<Pregled> pregledi = new LinkedList<Pregled>();
	/**
	 * Pacijenti lekara.
	 * @see domZdravlja.klase.Pacijent
	 */
	private LinkedList<Pacijent> pacijenti = new LinkedList<Pacijent>();

	/**
	 * Vraca jedinstveni identifikator lekara.
	 * 
	 * @return jedinstveni identifikator lekara
	 */
	public String getIDLekara() {
		return IDLekara;
	}

	/**
	 * Metoda postavlja vrednost atributa IDLekara ukoliko uneti parametar:
	 * <ol type="1">
	 * <li>nije null</li>
	 * <li>duzna == 7</li>
	 * </ol>
	 * 
	 * @param IDLekara
	 *            jedinstveni identifikator lekara
	 * @throws RuntimeException
	 *             ukoliko je parametar null ili duzine razlicite od 7
	 */
	public void setIDLekara(String iDLekara) {
		if (iDLekara != null && iDLekara.length() == 7)
			IDLekara = iDLekara;
		else
			throw new RuntimeException("Greska, IDLekara mora biti duzine 7.");
	}

	/**
	 * Vraca ime i prezime lekara.
	 * 
	 * @return ime i prezime lekara
	 */

	public String getImeIPrezime() {
		return imeIPrezime;
	}

	/**
	 * Metoda postavlja vrednost atributa imeIPrezime ukoliko uneti parametar:
	 * <ol type="1">
	 * <li>nije null</li>
	 * <li>duzna > 8</li>
	 * <li>duzina < 50</li>
	 * </ol>
	 * 
	 * @param imeIPrezime
	 *            ime i prezime lekara
	 * @throws RuntimeException
	 *             ukoliko je parametar null ili duzine manje od 8 ili duzine vece
	 *             od 49
	 */

	public void setImeIPrezime(String imeIPrezime) {
		if (imeIPrezime != null && imeIPrezime.length() > 8 && imeIPrezime.length() < 50)
			this.imeIPrezime = imeIPrezime;
		else
			throw new RuntimeException("Greska, imeIPrezime mora biti duzine izmedju 8 i 50.");
	}

	/**
	 * Vraca specijalizaciju lekara.
	 * 
	 * @return specijalizaciju lekara
	 */

	public String getSpecijalizacija() {
		return specijalizacija;
	}

	/**
	 * Metoda postavlja vrednost atributa specijalizacija ukoliko uneti parametar
	 * nije <b>null</b>.
	 * 
	 * @param specijalizacija
	 *            specijalizacija lekara
	 * @throws RuntimeException
	 *             ukoliko je parametar null
	 */

	public void setSpecijalizacija(String specijalizacija) {
		if (specijalizacija != null)
			this.specijalizacija = specijalizacija;
		else
			throw new RuntimeException("Greska, specijalizacija ne moze imati vrednost null.");
	}

	/**
	 * Vraca vrednost sifre koju lekar koristi da bi pristupio svom nalogu.
	 * 
	 * @return sifru koju lekar koristi da bi pristupio svom nalogu
	 */

	public String getSifra() {
		return sifra;
	}

	/**
	 * Metoda postavlja vrednost atributa sifra ukoliko uneti parametar:
	 * <ol type="1">
	 * <li>nije null</li>
	 * <li>duzna == 7</li>
	 * </ol>
	 * 
	 * @param sifra
	 *            sifru koju lekar koristi da bi pristupio svom nalogu
	 * @throws RuntimeException
	 *             ukoliko je parametar null ili duzine razlicite od 7
	 */

	public void setSifra(String sifra) {
		if (sifra != null && sifra.length() == 7)
			this.sifra = sifra;
		else
			throw new RuntimeException("Greska, sifra mora biti duzine 7.");
	}

	/**
	 * Vraca listu zakazanih pregleda.
	 * 
	 * @return listu zakazanih pregleda
	 */

	public LinkedList<Pregled> getPregledi() {
		return pregledi;
	}

	/**
	 * Postavlja vrednost pregleda ukoliko je uneti parametar razlicit od
	 * <b>null</b>.
	 * 
	 * @param pregledi
	 *            lista pregleda
	 * 
	 * @throws RuntimeException
	 *             ukoliko je vrednost unetog parametra null
	 */

	public void setPregledi(LinkedList<Pregled> pregledi) {
		if (pregledi != null)
			this.pregledi = pregledi;
		else
			throw new RuntimeException("Vrednost pregleda ne moze biti null.");
	}

	/**
	 * Vraca listu pacijenata.
	 * 
	 * @return listu pacijenata
	 */
	public LinkedList<Pacijent> getPacijenti() {
		return pacijenti;
	}

	/**
	 * Postavlja vrednost pacijenata ukoliko je uneti parametar razlicit od
	 * <b>null</b>.
	 * 
	 * @param pacijenti
	 *            lista pacijenata
	 * 
	 * @throws RuntimeException
	 *             ukoliko je vrednost unetog parametra null
	 */

	public void setPacijenti(LinkedList<Pacijent> pacijenti) {
		if (pacijenti != null)
			this.pacijenti = pacijenti;
		else
			throw new RuntimeException("Vredost pacijenata ne moze biti null.");
	}

}
