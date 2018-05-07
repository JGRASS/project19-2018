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
public class LekarTest {

	private Lekar l;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		l = new Lekar();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		l = null;
	}

	/**
	 * Test method for
	 * {@link domZdravlja.klase.Lekar#setIDLekara(java.lang.String)}.
	 */
	@Test
	public void testSetIDLekara() {
		l.setIDLekara("1234567");
		assertEquals("1234567", l.getIDLekara());
	}
	/**
	 * Test method for
	 * {@link domZdravlja.klase.Lekar#setIDLekara(java.lang.String)}.
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetIDLekaraNull() {
		l.setIDLekara(null);
	}

	/**
	 * Test method for
	 * {@link domZdravlja.klase.Lekar#setIDLekara(java.lang.String)}.
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetIDLekaraDuzina() {
		l.setIDLekara("123");
	}


	/**
	 * Test method for
	 * {@link domZdravlja.klase.Lekar#setImeIPrezime(java.lang.String)}.
	 */
	@Test
	public void testSetImeIPrezime() {
		l.setImeIPrezime("Bojan Djekic");
		assertEquals("Bojan Djekic", l.getImeIPrezime());
	}
	
	/**
	 * Test method for
	 * {@link domZdravlja.klase.Lekar#setImeIPrezime(java.lang.String)}.
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetImeIPrezimeNull() {
		l.setImeIPrezime(null);
	}

	/**
	 * Test method for
	 * {@link domZdravlja.klase.Lekar#setImeIPrezime(java.lang.String)}.
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetImeIPrezimeDuzinaManja() {
		l.setImeIPrezime("Bojan");
	}
	
	/**
	 * Test method for
	 * {@link domZdravlja.klase.Lekar#setImeIPrezime(java.lang.String)}.
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetImeIPrezimeDuzinaVeca() {
		l.setImeIPrezime("Bojan Bojan Bojan Bojan Bojan Bojan Bojan Bojan Bojan Bojan");
	}

	/**
	 * Test method for
	 * {@link domZdravlja.klase.Lekar#setSpecijalizacija(java.lang.String)}.
	 */
	@Test
	public void testSetSpecijalizacija() {
		l.setSpecijalizacija("Kardiolog");
		assertEquals("Kardiolog", l.getSpecijalizacija());
	}
	/**
	 * Test method for
	 * {@link domZdravlja.klase.Lekar#setSpecijalizacija(java.lang.String)}.
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetSpecijalizacijaNull() {
		l.setSpecijalizacija(null);
	}

	/**
	 * Test method for {@link domZdravlja.klase.Lekar#setSifra(java.lang.String)}.
	 */
	@Test
	public void testSetSifra() {
		l.setSifra("1234567");
		assertEquals("1234567", l.getSifra());
	}
	/**
	 * Test method for {@link domZdravlja.klase.Lekar#setSifra(java.lang.String)}.
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetSifraNull() {
		l.setSifra(null);
	}
	/**
	 * Test method for {@link domZdravlja.klase.Lekar#setSifra(java.lang.String)}.
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetSifraDuzinaRazlicita() {
		l.setSifra("123");
	}


	/**
	 * Test method for
	 * {@link domZdravlja.klase.Lekar#setPregledi(java.util.LinkedList)}.
	 */
	@Test
	public void testSetPregledi() {
		LinkedList<Pregled> pregledi = new LinkedList<>();
		l.setPregledi(pregledi);
	}
	/**
	 * Test method for
	 * {@link domZdravlja.klase.Lekar#setPregledi(java.util.LinkedList)}.
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPreglediNull() {
		l.setPregledi(null);
	}

	/**
	 * Test method for
	 * {@link domZdravlja.klase.Lekar#setPacijenti(java.util.LinkedList)}.
	 */
	@Test
	public void testSetPacijenti() {
		LinkedList<Pacijent> pacijenti = new LinkedList<>();
		l.setPacijenti(pacijenti);
	}

	/**
	 * Test method for
	 * {@link domZdravlja.klase.Lekar#setPacijenti(java.util.LinkedList)}.
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPacijentiNull() {
		l.setPacijenti(null);
	}


}
