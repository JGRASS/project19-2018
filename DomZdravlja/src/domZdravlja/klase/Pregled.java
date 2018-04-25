package domZdravlja.klase;

import java.util.GregorianCalendar;
import java.util.LinkedList;

public class Pregled {
	private Lekar lekar;
	private Pacijent pacijent;
	private String vrstaPregleda;
	private GregorianCalendar datumIVreme;
	
	public Lekar getLekar() {
		return lekar;
	}
	public void setLekar(Lekar lekar) {
		this.lekar = lekar;
	}
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
	public String IzvestajZaPacijenta() {
		return "Vrsta pregleda: " + vrstaPregleda+ "	Datum i vreme: " + datumIVreme 
				+ "	Lekar: " + lekar.getImeIPrezime();
	}
	
	
	
}
