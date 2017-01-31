package org.funjala.automation.web.mach2.steps.widget;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.funjala.automation.web.common.drivers.Driver;
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
import org.funjala.automation.web.pages.pivotal.home.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Administrator on 1/25/2017.
 */
public class TablePerInForDepartmentsSteps {

private int actualResult;

  @And("^I set department name with \"([^\"]*)\"$")
  public void iSetDepartmentNameWith(String arg0) {
    Log log = Log.getInstance();
    WebDriver driver = Driver.getDriver().getWebDriver();
    WidgetPage widget = new WidgetPage(driver);
    log.info("Step", "I set department name with a name","select a Security test");
    widget.clickOnAdvanceConfiguration();
    widget.setDepartmentName(arg0);

  }

  @And("^I save that option with the department \"([^\"]*)\" selected$")
  public void iSaveThatOption(String department) throws InterruptedException {
    Log log = Log.getInstance();
    WebDriver driver = Driver.getDriver().getWebDriver();
    WidgetPage widget = new WidgetPage(driver);
    TopMenuPage topMenuPage = new TopMenuPage(driver);
    log.info("Step", "I save that option with the department","save option");
    widget.clickSaveButton();
    actualResult = widget.verifyCantDepartment(department);
    MyDashboard myDashboard = new MyDashboard(driver);
    myDashboard.deleteBoard();

    topMenuPage.clickOnLogOut();
  }

  @Then("^I have a table with employees filtered for a \"([^\"]*)\"$")
  public void iHaveATableWithEmployeesFilteredForA(String s) throws InterruptedException, IOException {
    Log log = Log.getInstance();
    WebDriver driver = Driver.getDriver().openBrowser(Driver.OpenERP);
    OEHomePage homePage;

    OELoginPage oeLoginPage = new OELoginPage(driver);
    OESearch oeSearch;

    log.info("Step", "I have a table with employees filtered","expected result");


    oeLoginPage.setUserName("jose7");
    oeLoginPage.setPassword("jose7");
    homePage = oeLoginPage.clickBtnSubmit();
    homePage.clickHumanResources();
    oeSearch = homePage.oeSearch();
    oeSearch.clickSearchArrow();
    oeSearch.clickAdvancedSearch();
    oeSearch.foundAndClickAdvancedFilterOptions("Department", "is equal to", "Security test");
    oeSearch.clickApplySearch();
    oeSearch.clickSwitchList();
    oeSearch.clickNumberElement();
    oeSearch.clickQuantityButton();
    oeSearch.clickUnlimitedOption();

    List<WebElement> result = oeSearch.listOfAllElements();
    int expectResult = result.size();
    homePage.clickUserAccount();
    homePage.clickLogOut();
    assertEquals(expectResult, actualResult, "Compare numbers of Items");
  }
}
