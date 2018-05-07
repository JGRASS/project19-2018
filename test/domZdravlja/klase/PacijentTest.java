/**
 * 
 */
package domZdravlja.klase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sofija Dimitrijevic
 *
 */
public class PacijentTest {
	Pacijent p;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		p = new Pacijent();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		p = null;
	}

	/**
	 * Test method for {@link domZdravlja.klase.Pacijent#setImePrezime(java.lang.String)}.
	 */
	@Test
	public void testSetImePrezime() {
		p.setImePrezime("Mila Dikic");
		assertEquals("Mila Dikic", p.getImePrezime());
	}
	/**
	 * Test method for {@link domZdravlja.klase.Pacijent#setImePrezime(java.lang.String)}.
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetImePrezimeNull() {
		p.setImePrezime(null);
	}
	/**
	 * Test method for {@link domZdravlja.klase.Pacijent#setLbo(java.lang.String)}.
	 */
	@Test
	public void testSetLbo() {
		p.setLbo("12345678901");
		assertEquals("12345678901", p.getLbo());
	}


	/**
	 * Test method for {@link domZdravlja.klase.Pacijent#setLbo(java.lang.String)}.
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetLboNull() {
		p.setLbo(null);
	}
	/**
	 * Test method for {@link domZdravlja.klase.Pacijent#setLbo(java.lang.String)}.
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetLboDuzina() {
		p.setLbo("123");
	}

	/**
	 * Test method for {@link domZdravlja.klase.Pacijent#setDatumRodjenja(java.lang.String)}.
	 */
	@Test
	public void testSetDatumRodjenja() {
		p.setDatumRodjenja("31/01/1997");
		assertEquals("31/01/1997", p.getDatumRodjenja());
	}
	/**
	 * Test method for {@link domZdravlja.klase.Pacijent#setDatumRodjenja(java.lang.String)}.
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetDatumRodjenjaNull() {
		p.setDatumRodjenja(null);
	}

	/**
	 * Test method for {@link domZdravlja.klase.Pacijent#setIzabraniLekar(domZdravlja.klase.Lekar)}.
	 */
	@Test
	public void testSetIzabraniLekar() {
		Lekar l = new Lekar();
		p.setIzabraniLekar(l);
		assertEquals(l, p.getIzabraniLekar());
	}
	
	/**
	 * Test method for {@link domZdravlja.klase.Pacijent#setIzabraniLekar(domZdravlja.klase.Lekar)}.
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetIzabraniLekarNull() {
		p.setIzabraniLekar(null);
	}


}
