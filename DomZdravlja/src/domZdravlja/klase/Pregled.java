package domZdravlja.klase;

import java.util.GregorianCalendar;

public class Pregled {
	private Lekar lekar;
	private Pacijent pacijent;
	private DatumIVreme datumIVreme;

	public Lekar getLekar() {
		return lekar;
	}

	public void setLekar(Lekar lekar) {
		this.lekar = lekar;
	}


	public DatumIVreme getDatumIVreme() {
		return datumIVreme;
	}

	public void setDatumIVreme(DatumIVreme datumIVreme) {
		this.datumIVreme = datumIVreme;
	}

	public Pacijent getPacijent() {
		return pacijent;
	}

	public void setPacijent(Pacijent pacijent) {
		this.pacijent = pacijent;
	}

	public String IzvestajZaLekara() {
		return "Pacijent: " + pacijent + ", datum i vreme: " + datumIVreme.toString();
	}

	public String IzvestajZaPacijenta() {
		return datumIVreme.toString() + "  Lekar: " + lekar.getImeIPrezime();
	}

}
