package myRunner;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "D:\\WiproProject\\CapstoneProject\\CapstoneProject\\src\\test\\java\\feature\\Login.feature", // Path to your feature file
    glue = {"stepDef"}, // Package where step definitions are located
    plugin = {"pretty", "html:target/BlazeLoginReport.html"} // Report format and destination
)
public class LoginTestRunner {
    // This class will not have any code inside, it's just used as a runner
}

