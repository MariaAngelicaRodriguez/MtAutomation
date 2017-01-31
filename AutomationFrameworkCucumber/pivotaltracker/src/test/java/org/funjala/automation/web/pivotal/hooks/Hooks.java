package org.funjala.automation.web.pivotal.hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.funjala.automation.web.common.utilities.Log;


/**
 * Created by Angelica Rodriguez on 1/13/2017.
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
  public void afterScenario(Scenario scenario) {
    System.out.println("The Scenario finished: " + scenario.getName() + ", Status is :" + scenario.getStatus());
  }
}
