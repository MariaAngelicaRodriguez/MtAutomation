package org.funjala.automation.web.mach2.steps.widget;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.funjala.automation.web.common.drivers.Driver;
import org.funjala.automation.web.common.utilities.CucumberScreenshot;
import org.funjala.automation.web.common.utilities.Log;
import org.funjala.automation.web.model.erp.search.ModelSearch;
import org.funjala.automation.web.pages.erp.home.OEHomePage;
import org.funjala.automation.web.pages.erp.login.OELoginPage;
import org.funjala.automation.web.pages.erp.search.OESearch;
import org.funjala.automation.web.pages.mach2.dashboard.MyDashboard;
import org.funjala.automation.web.pages.mach2.login.LoginPage;
import org.funjala.automation.web.pages.mach2.menu.TopMenuPage;
import org.funjala.automation.web.pages.mach2.sidebar.SideBarPage;
import org.funjala.automation.web.pages.mach2.widget.WidgetPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by DavidVallejos on 1/21/2017.
 */
public class TableEmPeInForManagerSteps {

  @And("^I fill manager name on textfield as \"([^\"]*)\"$")
  public void iFillManagerNameOnTextfieldAs(String managerName) {
    Log log = Log.getInstance();
    WebDriver driver = Driver.getDriver().getWebDriver();
    WidgetPage widget = new WidgetPage(driver);
    log.info("Step", "I fill manager name on textfield as " + managerName, "Select Manager");
    widget.setManagerName(managerName);
  }

  @Then("^I have a table widget with \"([^\"]*)\" filled$")
  public void iHaveATableWidgetWithFilled(String managerName) throws IOException, InterruptedException {
    Log log = Log.getInstance();
    WebDriver driver = Driver.getDriver().getWebDriver();
    WidgetPage widget = new WidgetPage(driver);
    MyDashboard dashboard = new MyDashboard(driver);
    TopMenuPage topMenuPage = new TopMenuPage(driver);
    log.info("Step", "Verification on Mach2 and Open ERP", "Verification of datas");
    int actualResult = widget.verifyCant(managerName);

    //Clean up Widget and Board
    log.info("Clean", "Delete Widget and Board Mach2", "Clean up: Delete Mach2");
    dashboard.deleteBoard();

    //Logout Mach2
    log.info("Clean", "Logout Mach2", "Clean up: Logout");
    topMenuPage.clickOnLogOut();

    //Login OPEN ERP
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
    searchERP.foundAndClickAdvancedFilterOptions("manager", "is equal to", managerName);
    searchERP.clickApplySearch();
    searchERP.clickSwitchList();

    //Get elements of the list
    searchERP.clickNumberElement();
    searchERP.clickQuantityButton();
    searchERP.clickUnlimitedOption();
    List<WebElement> listManager = searchERP.listOfAllElements();
    int expectResult = listManager.size();

    log.info("Verification", "Verification on Mach2 and Open ERP", "Verification of Mach2 with OpenERP");

    System.out.println(">>>>>>>>>>>>>>>>>>");
    System.out.println(listManager.size());
    System.out.println(actualResult);
    System.out.println(">>>>>>>>>>>>>>>>>>");

    //Logout Open ERP page
    log.info("Clean", "Logout OpenERP", "Clean up: Logout");
    homeERP.clickUserAccount();
    homeERP.clickLogOut();

    assertEquals(expectResult, actualResult);
  }

  @And("^I fill division textfield as \"([^\"]*)\"$")
  public void iFillDivisionTextfieldAs(String value) throws Throwable {
    Log log = Log.getInstance();
    WebDriver driver = Driver.getDriver().getWebDriver();
    WidgetPage widget = new WidgetPage(driver);
    log.info("Step", "I fill division textfield as ", value);
    widget.setDivisionName(value);
  }

  @Then("^I have a table widget with division \"([^\"]*)\"$")
  public void iHaveATableWidgetWithDivision(String value) throws Throwable {
    Log log = Log.getInstance();
    WebDriver driver = Driver.getDriver().getWebDriver();
    WidgetPage widget = new WidgetPage(driver);
    MyDashboard dashboard = new MyDashboard(driver);
    TopMenuPage topMenuPage = new TopMenuPage(driver);
    log.info("Step", "I have a table widget with division", value);
    int actualResult = widget.verifyCant(value);
    System.out.println(actualResult);

    //Clean up Widget and Board
    dashboard.deleteBoard();

    //Logout Mach2
    topMenuPage.clickOnLogOut();

    //Login OPEN ERP
    driver = Driver.getDriver().openBrowser(Driver.OpenERP);
    OELoginPage loginERP = new OELoginPage(driver);
    loginERP.setUserName("jose6");
    loginERP.setPassword("jose6");
    OEHomePage homeERP = loginERP.clickBtnSubmit();

//    //Go to Human Resources
    homeERP.clickHumanResources();
    OESearch searchERP = homeERP.oeSearch();

    //Go to Search
    searchERP.clickSearchArrow();
    searchERP.clickAdvancedSearch();

    //Make a search by manager
    searchERP.foundAndClickAdvancedFilterOptions("division", "is equal to", value);
    searchERP.clickApplySearch();
    searchERP.clickSwitchList();

    //Get elements of the list
    searchERP.clickNumberElement();
    searchERP.clickQuantityButton();
    searchERP.clickUnlimitedOption();
    List<ModelSearch> listManager = searchERP.getResultOfSearch();
    int expectResult = listManager.size();


    //Logout Open ERP page
    homeERP.clickUserAccount();
    homeERP.clickLogOut();

    assertEquals(expectResult, actualResult);
  }
}
