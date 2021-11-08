package solution;

import java.io.IOException;

import com.google.gson.JsonSyntaxException;

public class ExchangeRateServiceTestStub implements ExchangeRateService {

	@Override
	public ExchangeRate getRate(String source, String target)
			throws IOException, JsonSyntaxException {
		ExchangeRate exchangeRate = new ExchangeRate();
		exchangeRate.rate = 8;
		return exchangeRate;
	}

}
