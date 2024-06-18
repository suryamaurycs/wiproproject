package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "C:\\Users\\athun\\Downloads\\all_mix\\eclipse all code\\Wipro_Capstone_Project\\src\\test\\java\\features",
    glue = "com.demo.Login_Check",
    plugin = {"pretty", "html:target/final1.html"}
)
public class TestRunner {
}
