package testRunner;
import io.cucumber.java.ParameterType;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "stepDefinitions",
    		plugin = {"pretty", "html:target/cucumber-reports", "junit:target/Cucumber.xml"},
    monochrome = true
)
public class TestRunner {

}