package before;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CurrencyConverterTest {
	
	private CurrencyConverter cc;
	
	@Before
	public void setup() {
		cc = new CurrencyConverter();
	}

	/** 1.	Test at veksling fra en valuta til seg selv gir samme beløp ut som inn */
	@Test
	public void sammeUtSomInn() {
		double someAmount = 1234;
		String someCurrCode = "NOK";
		assertEquals(someAmount, cc.convertAmount(someAmount, someCurrCode, someCurrCode), Double.MIN_VALUE);
	}

	/** 2.	Test at et beløp på 0 gir 0 ut når man veksler fra en valuta til en annen */
	@Test
	public void nullGirNull() {
		assertEquals(0, cc.convertAmount(0, "NOK", "USD"), Double.MIN_VALUE);
	}
	
	/** 3.	Ugyldig valutakode skal gi 0 som svar, ikke kaste unntak. Test at dette fungerer. */
	@Test
	public void ugydligKodeGirNull() {
		assertEquals(0, cc.convertAmount(1234, "NOK", "ABC"), Double.MIN_VALUE);
	}
}
