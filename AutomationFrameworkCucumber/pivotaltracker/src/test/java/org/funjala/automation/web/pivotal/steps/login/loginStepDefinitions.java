package org.funjala.automation.web.pivotal.steps.login;

import org.funjala.automation.web.common.drivers.Driver;

import org.funjala.automation.web.pages.pivotal.home.HomePage;
import org.funjala.automation.web.pages.pivotal.login.LoginPage;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import java.io.IOException;

import static org.testng.Assert.assertEquals;

/**
 * Created by Fernando  on 1/10/2017.
 */
public class loginStepDefinitions {
  WebDriver driver;
  LoginPage login;
  HomePage homePage;

  @Given("^I navigate to Pivotal Tracker Website$")
  public void openPivotalTracker() throws IOException {
    driver = Driver.getDriver().openBrowser(Driver.Url);
    login = new LoginPage(driver);
  }

  @When("^I set a valid username/email as (.*?)$")
  public void validUsernameOrEmailIsSet(String userName) {
    login.setUserName(userName);
  }

  @And("^I press NEXT button a new password field should appear$")
  public void aNewPasswordFieldAppears() {
    login.clickContinue();
  }

  @And("^I set a valid password as (.*?)$")
  public void aValidPasswordIsSet(String password) {
    login.setPassword(password);
  }

  @And("^I press the SIGN IN button$")
  public void signInButtonIsPressed() {
    login.clickSubmit();
  }

  @Then("^I should be redirected to the Pivotal Dashboard$")
  public void redirectToPivotalTrackerDashboard() {
    assertEquals(driver.getTitle(), "Pivotal Tracker - Sign in");
    System.out.println(driver.getTitle());
    homePage = new HomePage(driver);
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    homePage.logOut();
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    driver.get("https://www.pivotaltracker.com/signin?signin_with_different=true");
  }

}


