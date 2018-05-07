package domZdravlja.klase;

import java.util.GregorianCalendar;

/**
 * Klasa predstavlja pregled sa osnovnim osobinama.
 * 
 * @author Bojan Djekic
 * 
 */
public class Pregled {
	/**
	 * Lekar koji ce vrsiti pregled. Atribut je klase Lekar.
	 * 
	 * @see domZdravlja.klase.Lekar
	 */
	private Lekar lekar;
	/**
	 * Pacijent koji ce biti pregledati. Atribut je klase Pacijent.
	 * 
	 * @see domZdravlja.klase.Pacijent
	 */
	private Pacijent pacijent;
	/**
	 * Datum i vreme kada ce se odrzati pregled. Atribut je klase DatumIVreme.
	 * 
	 * @see domZdravlja.klase.DatumIVreme
	 */
	private DatumIVreme datumIVreme;

	/**
	 * Vraca lekara koji ce vrsiti pregled.
	 * 
	 * @return lekar koji ce vrsiti pregled
	 */
	public Lekar getLekar() {
		return lekar;
	}

	/**
	 * Metoda postavlja vrednost atributa lekar ukoliko uneti parametar nije
	 * <b>null</b>.
	 * 
	 * @param lekar
	 *            lekar koji ce vrsiti pregled
	 * @throws RuntimeException
	 *             ukoliko je parametar null
	 */

	public void setLekar(Lekar lekar) {
		if (lekar != null)
			this.lekar = lekar;
		else
			throw new RuntimeException("Lekar ne moze imati vrednost null.");
	}

	/**
	 * Vraca datum i vreme kada ce se odrzati pregled.
	 * 
	 * @return datum i vreme kada ce se odrzati pregled
	 */

	public DatumIVreme getDatumIVreme() {
		return datumIVreme;
	}

	/**
	 * Metoda postavlja vrednost atributa datumIVreme ukoliko uneti parametar nije
	 * <b>null</b>.
	 * 
	 * @param datumIVreme
	 *            datum i vreme kada ce se odrzati pregled
	 * @throws RuntimeException
	 *             ukoliko je parametar null
	 */

	public void setDatumIVreme(DatumIVreme datumIVreme) {
		if (datumIVreme != null)
			this.datumIVreme = datumIVreme;
		else
			throw new RuntimeException("DatumIVreme ne mogu imati vrednost null.");
	}

	/**
	 * Vraca pacijenta koji ce biti pregledan.
	 * 
	 * @return pacijenta koji ce biti pregledan
	 */

	public Pacijent getPacijent() {
		return pacijent;
	}

	/**
	 * Metoda postavlja vrednost atributa pacijent ukoliko uneti parametar nije
	 * <b>null</b>.
	 * 
	 * @param pacijent
	 *            pacijent koji ce biti pregledan
	 * @throws RuntimeException
	 *             ukoliko je parametar null
	 */
	public void setPacijent(Pacijent pacijent) {
		if (pacijent != null)
			this.pacijent = pacijent;
		else
			throw new RuntimeException("Pacijent ne moze imati vrednost null.");
	}

	/**
	 * Vraca String koji pokazuje vrednosti atributa imeIPrezime atributa pacijent i
	 * vrednost atributa datumIVreme.
	 * 
	 * @return String koji pokazuje vrednosti atributa imeIPrezime atributa pacijent
	 *         i vrednost atributa datumIVreme.
	 */

	public String IzvestajZaLekara() {
		return "Pacijent: " + pacijent.getImePrezime() + ", datum i vreme: " + datumIVreme.toString();
	}

	/**
	 * Vraca String koji pokazuje vrednost atributa datumIVreme i vrednost atributa
	 * imeIPrezime atributa lekar.
	 * 
	 * @return String koji pokazuje vrednost atributa datumIVreme i vrednost
	 *         atributa imeIPrezime atributa lekar.
	 */

	public String IzvestajZaPacijenta() {
		return datumIVreme.toString() + "  Lekar: " + lekar.getImeIPrezime();
	}

}
