package example.cucumber.mockmvc;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import example.HourlyPricing;
import example.PricingPolicy;

public class HourlyPricingTest {

	private PricingPolicy pricing = new HourlyPricing();

	@Test
	public void shouldPayNothingOnEscapeTime() throws Exception {
		assertThat(pricing.calc(0, 10 * 60 * 1000L - 1), is(0.0));
	}

	@Test
	public void shouldPayFullHourOnEscapeTimeMark() throws Exception {
		assertThat(pricing.calc(0, 10 * 60 * 1000L), is(10.0));
	}

	@Test
	public void shouldPayFirstIntervalOnTheHourMark() throws Exception {
		assertThat(pricing.calc(0, 60 * 60 * 1000L), is(13.0));
	}

	@Test
	public void shouldPaySecondIntervalOnFirstIntervalMark() throws Exception {
		assertThat(pricing.calc(0, (60 + 15) * 60 * 1000L), is(16.0));
	}
}
