package before;

import java.io.IOException;

import com.google.gson.JsonSyntaxException;

public class CurrencyConverter {

	public double convertAmount(double fromAmount, String fromCurrencyParameter, String toCurrencyParameter) {
		
		double toAmount = 0;
		
		ExchangeRate exchangeRate;
		try {
			exchangeRate = ExchangeRateService.getRate(fromCurrencyParameter, toCurrencyParameter);
			toAmount = fromAmount * exchangeRate.rate;
		} catch (JsonSyntaxException | IOException e) {
			// returning default toAmount;
		}
		return toAmount;
	}
}
