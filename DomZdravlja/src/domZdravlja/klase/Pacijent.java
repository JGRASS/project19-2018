package domZdravlja.klase;

import java.util.LinkedList;

import sistemskeoperacije.SOIstorija;
import sistemskeoperacije.SOZakazaniPregledi;

/**
 * Klasa predstavlja pacijenta sa osnovnim osobinama.
 * 
 * @author Mila Dikic
 * 
 */

public class Pacijent {
	/**
	 * Ime i prezime pacijenta.
	 */
	private String imePrezime;
	/**
	 * Jedinstveni identifikator pacijenta.
	 */
	private String lbo;
	/**
	 * Datum rodjenja pacijenta.
	 */
	private String datumRodjenja;
	/**
	 * Izabrani lekar pacijenta.
	 * 
	 * @see domZdravlja.klase.Lekar;
	 */
	private Lekar izabraniLekar;
	/**
	 * Lista zakazanih pregleda pacijenta.
	 * 
	 * @see domZdravlja.klase.Pregled
	 */
	public static LinkedList<Pregled> zakazaniPregledi = new LinkedList<Pregled>();
	/**
	 * Lista odrzanih pregleda.
	 * 
	 * @see domZdravlja.klase.Pregled
	 */
	public static LinkedList<Pregled> istorijaPregleda = new LinkedList<Pregled>();

	/**
	 * Vraca ime i prezime pacijenta.
	 * 
	 * @return ime i prezime pacijenta
	 */

	public String getImePrezime() {
		return imePrezime;
	}

	/**
	 * Metoda postavlja vrednost atributa imePrezime ukoliko uneti parametar nije
	 * <b>null</b>.
	 * 
	 * @param imePrezime
	 *            specijalizacija lekara
	 * @throws RuntimeException
	 *             ukoliko je parametar null
	 */

	public void setImePrezime(String imePrezime) {
		if (imePrezime != null)
			this.imePrezime = imePrezime;
		else
			throw new RuntimeException("Greska, imePrezime pacijenta ne moze imati vrednost null.");
	}

	/**
	 * Vraca jedinstveni identifikator pacijenta.
	 * 
	 * @return jedinstveni identifikator pacijenta
	 */

	public String getLbo() {
		return lbo;
	}

	/**
	 * Metoda postavlja vrednost atributa lbo ukoliko uneti parametar:
	 * <ol type="1">
	 * <li>nije null</li>
	 * <li>duzna == 11</li>
	 * </ol>
	 * 
	 * @param lbo
	 *            jedinstveni identifikator pacijenta
	 * @throws RuntimeException
	 *             ukoliko je parametar null ili duzine razlicite od 11
	 */

	public void setLbo(String lbo) {
		if (lbo != null && lbo.length() == 11)
			this.lbo = lbo;
		else
			throw new RuntimeException("Greska, lbo mora biti duzine 11.");
	}

	/**
	 * Vraca datum rodjenja pacijenta.
	 * 
	 * @return datum rodjenja pacijenta
	 */

	public String getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(String datumRodjenja) {
		if (datumRodjenja != null)
			this.datumRodjenja = datumRodjenja;
		else
			throw new RuntimeException("Greska, datumRodjenja ne moze imati vrednost null.");
	}

	/**
	 * Vraca izabranog lekara pacijenta.
	 * 
	 * @return izabranog lekara pacijenta
	 */

	public Lekar getIzabraniLekar() {
		return izabraniLekar;
	}

	/**
	 * Postavlja vrednost atributa izbraniLekar ukoliko uneti parametar nije
	 * <b>null</b>.
	 * 
	 * @param izabraniLekar
	 *            izbrani lekar pacijenta
	 * @return RuntimeException ukoliko je vrednost unetog parametra null
	 */

	public void setIzabraniLekar(Lekar izabraniLekar) {
		if (izabraniLekar != null)
			this.izabraniLekar = izabraniLekar;
		else
			throw new RuntimeException("Greska, izbraniLekar ne moze imati vrednost null.");
	}

	/**
	 * Poziva funkciju izvrsi klase SOIstorija.
	 * 
	 * @return String koji predstavlja istoriju pregleda
	 */

	public String istorija() {
		return SOIstorija.izvrsi();
	}

	/**
	 * Poziva funkciju izvrsi klase SOZakazaniPregledi.
	 * 
	 * @return String koji predstavlja zakazane preglede
	 */

	public String zakazaniPregledi() {
		return SOZakazaniPregledi.izvrsi();
	}

}
