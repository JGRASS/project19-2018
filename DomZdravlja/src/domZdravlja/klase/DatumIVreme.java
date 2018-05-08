package domZdravlja.klase;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Klasa predstavlja pacijenta sa osnovnim osobinama.
 * 
 * @author Mila Dikic
 * 
 */

public class DatumIVreme {
	/**
	 * Predstavlja datum. Pripada klasi java.util.Date.
	 */
	private Date datum;
	/**
	 * Predstavlja sate.
	 */
	private int sati;
	/**
	 * Predstavlja minute.
	 */
	private int minuti;
	/**
	 * Format koji ce se koristiti za prikazivanje datuma.
	 */
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * Vraca datum.
	 * 
	 * @return datum
	 */
	public Date getDatum() {
		return datum;
	}

	/**
	 * Postavlja datum ukoliko uneti parametar nije <b>null</b>.
	 * 
	 * @param datum
	 * @throws RuntimeException
	 *             ukoliko je uneti parametar null
	 */
	public void setDatum(Date datum) {
		if (datum != null)
			this.datum = datum;
		else
			throw new RuntimeException("Greska, datum ne moze imati vrednost null.");
	}

	/**
	 * Vraca sate.
	 * 
	 * @return sati
	 */
	public int getSati() {
		return sati;
	}

	/**
	 * Postavlja vrednos sati.
	 * 
	 * @param sati
	 */
	public void setSati(int sati) {
		this.sati = sati;
	}

	/**
	 * Vraca minute.
	 * 
	 * @return minuti
	 */
	public int getMinuti() {
		return minuti;
	}

	/**
	 * Postavlja vrednost minuta.
	 * 
	 * @param minuti
	 */
	public void setMinuti(int minuti) {
		this.minuti = minuti;
	}

	/**
	 * Vraca String koji prikazuje vrednosti atributa klase datumIVreme.
	 * 
	 * @return String koji prikazuje vrednosti atributa klase datumIVreme
	 */
	@Override
	public String toString() {
		String sDate = sdf.format(datum);
		return "Datum: " + sDate + "  Sati: " + sati + "  Minuti: " + minuti;
	}

}
