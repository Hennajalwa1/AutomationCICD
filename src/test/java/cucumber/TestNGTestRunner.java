package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//cucumber cannot run itsown , it always depend on testNG or Junit
@CucumberOptions(features="src/test/java/cucumber",glue="Riowalacademy.stepDefinition",
monochrome=true,tags="@Regression",plugin = {"html:target/cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {




}
