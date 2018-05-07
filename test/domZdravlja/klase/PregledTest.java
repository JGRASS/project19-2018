/**
 * 
 */
package domZdravlja.klase;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sofija Dimitrijevic
 *
 */
public class PregledTest {

	private Pregled p;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		p = new Pregled();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		p = null;
	}

	/**
	 * Test method for
	 * {@link domZdravlja.klase.Pregled#setLekar(domZdravlja.klase.Lekar)}.
	 */
	@Test
	public void testSetLekar() {
		Lekar l = new Lekar();
		p.setLekar(l);

		assertEquals(l, p.getLekar());
	}

	/**
	 * Test method for
	 * {@link domZdravlja.klase.Pregled#setLekar(domZdravlja.klase.Lekar)}.
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetLekarNull() {
		p.setLekar(null);
	}

	/**
	 * Test method for
	 * {@link domZdravlja.klase.Pregled#setDatumIVreme(domZdravlja.klase.DatumIVreme)}.
	 */
	@Test
	public void testSetDatumIVreme() {
		DatumIVreme datumIVreme = new DatumIVreme();
		p.setDatumIVreme(datumIVreme);
		assertEquals(datumIVreme, p.getDatumIVreme());
	}

	/**
	 * Test method for
	 * {@link domZdravlja.klase.Pregled#setDatumIVreme(domZdravlja.klase.DatumIVreme)}.
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetDatumIVremeNull() {
		p.setDatumIVreme(null);
	}

	/**
	 * Test method for
	 * {@link domZdravlja.klase.Pregled#setPacijent(domZdravlja.klase.Pacijent)}.
	 */
	@Test
	public void testSetPacijent() {
		Pacijent pa = new Pacijent();
		p.setPacijent(pa);

		assertEquals(pa, p.getPacijent());

	}

	/**
	 * Test method for
	 * {@link domZdravlja.klase.Pregled#setPacijent(domZdravlja.klase.Pacijent)}.
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPacijentNull() {
		p.setPacijent(null);
	}

	/**
	 * Test method for {@link domZdravlja.klase.Pregled#IzvestajZaLekara()}.
	 */
	/*@Test
	public void testIzvestajZaLekara() {
		Pacijent pa = new Pacijent();
		pa.setImePrezime("Mila Dikic");
	}*/

	/**
	 * Test method for {@link domZdravlja.klase.Pregled#IzvestajZaPacijenta()}.
	 */
	/*@Test
	public void testIzvestajZaPacijenta() {
		Lekar l = new Lekar();
		l.setImeIPrezime("Bojan Djekic");
	}*/

}
