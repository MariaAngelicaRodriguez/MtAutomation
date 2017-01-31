package org.funjala.automation.web.pivotal;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources/features/",
        format = {"json:target/pivotal.json","html:target/pivotal/pivotal-cucumber"})
public class Runner extends AbstractTestNGCucumberTests{

}
