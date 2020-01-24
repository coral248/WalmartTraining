package example.cucumber.mockmvc;

import example.ConsumerService;
import example.KafkaPublisher;
import io.cucumber.java.Before;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {


    KafkaPublisher kafkaPublisher = Mockito.mock(KafkaPublisher.class);

    @Autowired
    MockMvc httpClient;

    @Autowired
    ConsumerService consumer;


	@Given("getting the event")
	public void getting_the_event() {
		kafkaPublisher.ingest();
	}

    @When("event consumer consumes it")
    public void event_consumer_consumes_it() {
        consumer.receive();
    }

    @Then("event is persisted into database {string}")
    public void event_is_persisted_into_database(String eventRecord) {
        consumer.process(eventRecord);
    }

    @Then("a ValidationException is thrown, as the mandatory params are missing in the event.")
    public void a_ValidationException_is_thrown_as_the_mandatory_params_are_missing_in_the_event() {
        // Write code here that turns the phrase above into concrete actions

    }
}
