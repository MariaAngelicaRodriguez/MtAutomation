package org.funjala.automation.web.mach2.steps.widget;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.funjala.automation.web.common.drivers.Driver;
import org.funjala.automation.web.common.utilities.Log;
import org.funjala.automation.web.pages.erp.home.OEHomePage;
import org.funjala.automation.web.pages.erp.login.OELoginPage;
import org.funjala.automation.web.pages.erp.search.OESearch;
import org.funjala.automation.web.pages.mach2.dashboard.MyDashboard;
import org.funjala.automation.web.pages.mach2.login.LoginPage;
import org.funjala.automation.web.pages.mach2.menu.TopMenuPage;
import org.funjala.automation.web.pages.mach2.widget.WidgetPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;
import static org.testng.Assert.assertEquals;


public class TableEnInForManager {
  private int result;

  @And("^I choose \"(.*)\" as value for Manager field$")
  public void iChooseXAsValueForManagerField(String manager) {
    Log log = Log.getInstance();
    WebDriver driver = Driver.getDriver().getWebDriver();
    WidgetPage widget = new WidgetPage(driver);
    log.info("Step", "I choose " + manager + " as value for Manager field", "Select a Manager");
    widget.setManagerName(manager);
  }

  @And("^I obtain a table with the Engineer Information for \"(.*)\" as manager$")
  public void iObtainATableWithTheEnngineerInformationForXAsManager(String manager) throws InterruptedException {
    Log log = Log.getInstance();
    WebDriver driver = Driver.getDriver().getWebDriver();
    WidgetPage widget = new WidgetPage(driver);
    MyDashboard dashboard = new MyDashboard(driver);
    TopMenuPage topMenuPage = new TopMenuPage(driver);

    log.info("Step", "I obtain a table with the Engineer Information for " + manager + " as manager", "Get Engineer Information for Manager in Mach2");
    result = widget.verifyCant(manager);
    dashboard.deleteBoard();
    topMenuPage.clickOnLogOut();
  }

  @Then("^I should have the same result using Open ERP web page to search Engineer Information for \"(.*)\" as manager$")
  public void iShouldHaveTheSameResulUsingErpPageToSearchEngineerInformationForManager(String manager) throws IOException, InterruptedException {
    Log log = Log.getInstance();
    WebDriver driver;
    log.info("Step", "I should have the same result using Open ERP web page to search Engineer Information for " + manager + " as manager", "Mach Engineer Information for Manager between Mach2 and Open ERP");
    driver = Driver.getDriver().openBrowser(Driver.OpenERP);
    OELoginPage loginERP = new OELoginPage(driver);
    loginERP.setUserName("jose6");
    loginERP.setPassword("jose6");
    OEHomePage homeERP = loginERP.clickBtnSubmit();

    //Go to Human Resources
    homeERP.clickHumanResources();
    OESearch searchERP = homeERP.oeSearch();

    //Go to Search
    searchERP.clickSearchArrow();
    searchERP.clickAdvancedSearch();

    //Make a search by manager
    searchERP.foundAndClickAdvancedFilterOptions("manager", "is equal to", manager);
    searchERP.clickApplySearch();
    searchERP.clickSwitchList();

    //Get elements of the list
    searchERP.clickNumberElement();
    searchERP.clickQuantityButton();
    searchERP.clickUnlimitedOption();
    List<WebElement> listManager = searchERP.listOfAllElements();
    int expectResult = listManager.size();


    //Logout Open ERP page
    homeERP.clickUserAccount();
    homeERP.clickLogOut();
    assertEquals(expectResult, result);
  }
}