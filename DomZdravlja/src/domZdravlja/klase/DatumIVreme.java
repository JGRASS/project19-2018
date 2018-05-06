package domZdravlja.klase;

import java.util.Date;


public class DatumIVreme {

	private Date datum;
	private int sati;
	private int minuti;
	
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public int getSati() {
		return sati;
	}
	public void setSati(int sati) {
		this.sati = sati;
	}
	public int getMinuti() {
		return minuti;
	}
	public void setMinuti(int minuti) {
		this.minuti = minuti;
	}
	@Override
	public String toString() {
		return "Datum: " + datum + "  Sati: " + sati + "  Minuti: " + minuti;
	}
	
	
}
