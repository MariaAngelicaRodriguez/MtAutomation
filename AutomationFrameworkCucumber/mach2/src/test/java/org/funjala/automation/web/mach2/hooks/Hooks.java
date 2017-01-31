package org.funjala.automation.web.mach2.hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.funjala.automation.web.common.utilities.CucumberScreenshot;
import org.funjala.automation.web.common.utilities.Log;

import java.io.IOException;


/**
 * Created by DavidVallejos on 1/26/2017.
 */
public class Hooks {
  Log log;
  @Before
  public void beforeScenario(Scenario scenario) {
    System.out.println("The Scenario started: " + scenario.getName());
    log = Log.getInstance();
    log.info("Scenario", scenario.getName(), "starting scenario");
  }

  @After
  public void screenshot(Scenario scenario) throws IOException {
    CucumberScreenshot screenshot = new CucumberScreenshot();
    screenshot.takeScreenshot(scenario, "mach2");
  }
}
