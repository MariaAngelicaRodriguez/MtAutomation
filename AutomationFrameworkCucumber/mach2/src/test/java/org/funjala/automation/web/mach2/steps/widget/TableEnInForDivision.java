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

import static org.testng.Assert.assertEquals;

/**
 * Created by Angelica Rodriguez on 1/21/2017.
 */
public class TableEnInForDivision {

  @And("^In the option Division I click on \"([^\"]*)\"$")
  public void iFillManagerNameOnTextfieldAs(String divisionName) {
    Log log = Log.getInstance();
    WebDriver driver = Driver.getDriver().getWebDriver();
    WidgetPage widget = new WidgetPage(driver);
    log.info("Step", "In the option Division I click on " + divisionName, "Select Division");
    widget.setDivisionName(divisionName);
  }

  @And("^I click on save Button$")
  public void iClickOnSaveButton() throws InterruptedException {
    Log log = Log.getInstance();
    WebDriver driver = Driver.getDriver().getWebDriver();
    WidgetPage widget = new WidgetPage(driver);
    log.info("Step", "I click on save Button", "Click on save Button");
    widget.clickSaveButton();
  }


  @Then("^I have a table widget with \"([^\"]*)\" Division filled$")
  public void iHaveATableWidgetWithFilled(String divisionName) throws IOException, InterruptedException {
    Log log = Log.getInstance();
    WebDriver driver = Driver.getDriver().getWebDriver();
    WidgetPage widget = new WidgetPage(driver);
    MyDashboard dashboard = new MyDashboard(driver);
    TopMenuPage topMenuPage = new TopMenuPage(driver);
    log.info("Step", "I have a table widget with Information filled", "Verification of datas");
    int actualResult = widget.verifyCant(divisionName);
    dashboard.deleteBoard();
    topMenuPage.clickOnLogOut();
    //ERP
    driver = Driver.getDriver().openBrowser(Driver.OpenERP);
    OELoginPage loginERP = new OELoginPage(driver);
    loginERP.setUserName("jose6");
    loginERP.setPassword("jose6");
    OEHomePage homeERP = loginERP.clickBtnSubmit();

    homeERP.clickHumanResources();
    OESearch searchERP = homeERP.oeSearch();

    searchERP.clickSearchArrow();
    searchERP.clickAdvancedSearch();
    searchERP.foundAndClickAdvancedFilterOptions("Division", "is equal to", divisionName);
    searchERP.clickApplySearch();
    searchERP.clickSwitchList();
    searchERP.clickNumberElement();
    searchERP.clickQuantityButton();
    searchERP.clickUnlimitedOption();
    List<WebElement> listManager = searchERP.listOfAllElements();
    int expectResult = listManager.size();
    homeERP.clickUserAccount();
    homeERP.clickLogOut();

    assertEquals(expectResult, actualResult);
  }
}
