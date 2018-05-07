/**
 * 
 */
package domZdravlja.klase;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sofija Dimitrijevic
 *
 */
public class DatumIVremeTest {
	private DatumIVreme d;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		d = new DatumIVreme();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		d = null;
	}

	/**
	 * Test method for {@link domZdravlja.klase.DatumIVreme#setDatum(java.util.Date)}.
	 */
	@Test
	public void testSetDatum() {
		Date datum = new Date();
		d.setDatum(datum);
		assertEquals(datum, d.getDatum());
	}
	/**
	 * Test method for {@link domZdravlja.klase.DatumIVreme#setDatum(java.util.Date)}.
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetDatumNULL() {
		d.setDatum(null);
	}

	/**
	 * Test method for {@link domZdravlja.klase.DatumIVreme#setSati(int)}.
	 */
	@Test
	public void testSetSati() {
		d.setSati(8);
		assertEquals(8, d.getSati());
	}

	/**
	 * Test method for {@link domZdravlja.klase.DatumIVreme#setMinuti(int)}.
	 */
	@Test
	public void testSetMinuti() {
		d.setMinuti(15);
		assertEquals(15, d.getMinuti());
	}

	/**
	 * Test method for {@link domZdravlja.klase.DatumIVreme#toString()}.
	 */
	/*@Test
	public void testToString() {
		
	}*/

}
