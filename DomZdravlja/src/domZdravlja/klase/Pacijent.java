package domZdravlja.klase;

import java.util.GregorianCalendar;
import java.util.LinkedList;


public class Pacijent {

	private String imePrezime;
	private String lbo;
	private String datumRodjenja;
	private Lekar izabraniLekar;
	
	private LinkedList<Pregled> zakazaniPregledi;
	private LinkedList<Pregled> istorijaPregleda;
	
	public String getImePrezime() {
		return imePrezime;
	}
	public void setImePrezime(String imePrezime) {
		this.imePrezime = imePrezime;
	}
	public String getLbo() {
		return lbo;
	}
	public void setLbo(String lbo) {
		this.lbo = lbo;
	}
	public String getDatumRodjenja() {
		return datumRodjenja;
	}
	public void setDatumRodjenja(String datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
	public Lekar getIzabraniLekar() {
		return izabraniLekar;
	}
	public void setIzabraniLekar(Lekar izabraniLekar) {
		this.izabraniLekar = izabraniLekar;
	}
	
	
	
}
