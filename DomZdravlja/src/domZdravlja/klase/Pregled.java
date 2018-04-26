package domZdravlja.klase;

import java.util.GregorianCalendar;
import java.util.LinkedList;

public class Pregled {
	private LinkedList<Lekar> lekari;
	private Pacijent pacijent;
	private String vrstaPregleda;
	private GregorianCalendar datumIVreme;
	public String getVrstaPregleda() {
		return vrstaPregleda;
	}
	public void setVrstaPregleda(String vrstaPregleda) {
		this.vrstaPregleda = vrstaPregleda;
	}
	public GregorianCalendar getDatumIVreme() {
		return datumIVreme;
	}
	public void setDatumIVreme(GregorianCalendar datumIVreme) {
		this.datumIVreme = datumIVreme;
	}
	public Pacijent getPacijent() {
		return pacijent;
	}
	public void setPacijent(Pacijent pacijent) {
		this.pacijent = pacijent;
	}
}
