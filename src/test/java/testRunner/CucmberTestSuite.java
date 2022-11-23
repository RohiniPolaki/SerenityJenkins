package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features="src/test/resources/Features",
		glue="steps",
		plugin="pretty",
		tags="@Test1"
		)

public class CucmberTestSuite {

	
}
