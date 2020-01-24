package example;

import static java.time.Duration.ofMinutes;

public class HourlyPricing implements PricingPolicy {

	@Override
	public double calc(long entryTime, long paymentTime) {
		long timeInParking = paymentTime - entryTime;
		if (timeInParking < ofMinutes(60).toMillis())
			return 10;
		return 20;
	}

}
