package org.funjala.automation.web.mach2.steps.widget;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.funjala.automation.web.common.drivers.Driver;
import org.funjala.automation.web.common.utilities.Log;
import org.funjala.automation.web.pages.mach2.login.LoginPage;
import org.funjala.automation.web.pages.mach2.menu.TopMenuPage;
import org.funjala.automation.web.pages.mach2.widget.WidgetPage;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.List;

/**
 * Created by David/Jorge on 1/27/2017.
 */
public class CommonSteps {

  @Given("^I am login on Mach2 with credentials$")
  public void loginOnMachWebpage(DataTable tableCredentials) throws IOException {
    List<List<String>> data = tableCredentials.raw ();
    Log log = Log.getInstance();
    log.info("Step", "I am login on Mach2 webpage", "Go to Mach2 webpage");
    WebDriver driver = Driver.getDriver().openBrowser(Driver.Mach2);
    LoginPage loginPage = new LoginPage(driver);
    loginPage.setUsernameTextField(data.get(1).get(0));
    loginPage.setPasswordTextField(data.get(1).get(1));
    loginPage.clickNextButton();
  }

  @And("^I have a board and widget created$")
  public void iHaveABoardWithWidget() throws IOException {
    Log log = Log.getInstance();
    WebDriver driver = Driver.getDriver().getWebDriver();
    log.info("Step", "I have a board created with a widget", "created board and widget");
    TopMenuPage topMenuPage = new TopMenuPage(driver);
    topMenuPage.addNewBoard();
    topMenuPage.addNewWidget();
  }

  @When("^I select \"([^\"]*)\" icon on Widget options$")
  public void iClickOnListButtonOnWidgetDisplayed(String widgetType) {
    Log log = Log.getInstance();
    WebDriver driver = Driver.getDriver().getWebDriver();
    log.info("Step", "I click on Widget button", "Add a Widget");
    WidgetPage widget= new WidgetPage(driver);
    widget.addWidget(widgetType);
  }

  @And("^I select \"(.*)\" service$")
  public void iSelectXService(String service) {
    Log log = Log.getInstance();
    WebDriver driver = Driver.getDriver().getWebDriver();
    log.info("Step", "I select " + service + " service", "Select Open ERP service");
    WidgetPage widget= new WidgetPage(driver);
    widget.clickOnService(service);
  }

  @And("^I select \"([^\"]*)\" of Open ERP$")
  public void iSelectOptionOfOpenERP(String specificService) {
    Log log = Log.getInstance();
    WebDriver driver = Driver.getDriver().getWebDriver();
    log.info("Step", "I select ", specificService + "service of Open ERP");
    WidgetPage widget= new WidgetPage(driver);
    widget.clickOnSpecificService(specificService);
  }

  @And("^I click on save button$")
  public void iClickOnSaveButton() throws InterruptedException {
    Log log = Log.getInstance();
    WebDriver driver = Driver.getDriver().getWebDriver();
    WidgetPage widget = new WidgetPage(driver);
    log.info("Step", "I click on save button", "Click on save button");
    widget.clickSaveButton();
  }
}
