package example.cucumber.mockmvc;

import java.text.ParseException;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import io.cucumber.java.en.Given;

/**
 * @author Eran
 * <p>
 * This is the tricky part. cucumber-spring will find any steps class
 * with @SpringBootTest and use it as a SpringBootTest. We must have
 * some "never-invoked" step for cucumber to understand this is a steps
 * class.
 */
@SpringBootTest(properties = {"spring.main.allow-bean-definition-overriding=true"})
@AutoConfigureMockMvc
public class SpringBootTestConfig {

    /**
     * Override application beans and define test beans here.
     */
    @TestConfiguration
    public static class TestConfig {

    }

    @Given("never invoked")
    public void neverInvoked() throws ParseException {
    }
}