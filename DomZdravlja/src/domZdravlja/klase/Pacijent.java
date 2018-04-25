package domZdravlja.klase;

import java.util.LinkedList;


public class Pacijent {

	private String imePrezime;
	private String lbo;
	private String datumRodjenja;
	private Lekar izabraniLekar;
	
	private LinkedList<Lekar> lekari;
	public LinkedList<Pregled> zakazaniPregledi;
	public LinkedList<Pregled> istorijaPregleda;
	
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
	
	public String Istorija() {
		String s = "";
		for (int i = 0; i < istorijaPregleda.size(); i++) {
			s = s + System.lineSeparator() +  istorijaPregleda.get(i).IzvestajZaPacijenta();
		}
		return s;
	}
	
	public String ZakazaniPregledi() {
		String s = "";
		for (int i = 0; i < zakazaniPregledi.size(); i++) {
			s = s + System.lineSeparator() + zakazaniPregledi.get(i).IzvestajZaPacijenta();
		}
		return s;
	}
	
	public void izaberiLekara(String imePrezime) {
		for (int i = 0; i < lekari.size(); i++) {
			if(lekari.get(i).getImeIPrezime().equals(imePrezime))
				setIzabraniLekar(lekari.get(i));
		}
	}
	
	
}
