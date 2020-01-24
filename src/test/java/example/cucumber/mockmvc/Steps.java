package example.cucumber.mockmvc;

import static java.lang.Double.parseDouble;
import static java.lang.Long.parseLong;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {

	@Autowired
	ClockMock clock;

	@Autowired
	MockMvc httpClient;

	private long code;
	private double actualAmount;

	@Given("I entered the parking {string}")
	public void i_entered_the_parking(String timeStr)
			throws NumberFormatException, UnsupportedEncodingException, Exception {
		clock.setCurrTime(parseTime(timeStr));
		code = enterParking();
	}

	@When("I pay at {string}")
	public void i_pay_at(String timeStr) throws NumberFormatException, UnsupportedEncodingException, Exception {
		clock.setCurrTime(parseTime(timeStr));
		actualAmount = calcPayment(code);
	}

	@Then("payment is {double}")
	public void payment_is(double expectedAmount) {
		Assert.assertEquals(expectedAmount, actualAmount, 0);
	}

	private double calcPayment(long code) throws NumberFormatException, UnsupportedEncodingException, Exception {
		return parseDouble(doHttp(get("/parking/" + code + "/amount")));
	}

	private long enterParking() throws NumberFormatException, UnsupportedEncodingException, Exception {
		return parseLong(doHttp(post("/parking")));
	}

	private String doHttp(MockHttpServletRequestBuilder req) throws UnsupportedEncodingException, Exception {
		return httpClient.perform(req.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn()
				.getResponse().getContentAsString();
	}

	private long parseTime(String timeStr) throws ParseException {
		return new SimpleDateFormat("hh:mm:ss").parse(timeStr).getTime();
	}
}
