package domZdravlja.klase;

import java.util.LinkedList;

import sistemskeoperacije.SOIstorija;
import sistemskeoperacije.SOZakazaniPregledi;


public class Pacijent {

	private String imePrezime;
	private String lbo;
	private String datumRodjenja;
	private Lekar izabraniLekar;
	
	public static LinkedList<Pregled> zakazaniPregledi = new LinkedList<Pregled>();
	public static LinkedList<Pregled> istorijaPregleda = new LinkedList<Pregled>();
	
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
	
	public String istorija() {
		return SOIstorija.izvrsi();
	}
	
	public String zakazaniPregledi() {
		return SOZakazaniPregledi.izvrsi();
	}
	
	
}
