package example.cucumber.mockmvc;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( //
		glue = { "example.cucumber.steps", "example.cucumber.mockmvc" },
		features = "src/test/resources", //
		plugin = { "summary" }, // generate missing steps
		strict = true // fail on unresolved steps.
)
public class CucumberTest {

}