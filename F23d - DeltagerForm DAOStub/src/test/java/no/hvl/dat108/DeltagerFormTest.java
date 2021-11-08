package no.hvl.dat108;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;

public class DeltagerFormTest {
	
	/*
	 * populerFraRequestOgSettOppEvtFeilmeldinger(
	        HttpServletRequest request, DeltagerDAO deltagerDao)
	 */
	
	//1 - Ugyldig telefonnr
	//2 - Gyldig telefonnr, men allerede registrert i db
	//3 - Gydlig telefonnr, og ikke registrert i db
	
	
	
	@Test
	public void testNr2() {

		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setParameter("fornavn", "Per");
		request.setParameter("etternavn", "Persen");
		request.setParameter("passord", "abc123");
		request.setParameter("passordRepetert", "abc123");
		request.setParameter("kjonn", "mann");
		
		request.setParameter("mobil", "12345678");
		
		DeltagerDAO deltagerDao = new DeltagerDAODerBrukerErRegistrert();
		
		DeltagerForm df = new DeltagerForm();
		df.populerFraRequestOgSettOppEvtFeilmeldinger(request, deltagerDao);
		
		assertEquals("", df.getMobil());
		assertTrue(df.getMobilMelding().length() > 1);
		assertFalse(df.isAlleGyldig());	
	}
	

}
