package org.funjala.automation.web.mach2.steps.widget;

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
import org.funjala.automation.web.pages.mach2.widget.WidgetPage;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by JorgeForero on 1/25/2017.
 */
public class ListEnInForJobTitleStep {

  @And("^I fill Job Title with \"([^\"]*)\" option and I click on save$")
  public void iFillJobTitle(String jobTitle) throws InterruptedException {
    Log log = Log.getInstance();
    WebDriver driver = Driver.getDriver().getWebDriver();
    log.info("Step", "I fill Job Title with " + jobTitle, "Select Job Title");
    WidgetPage widget = new WidgetPage(driver);
    widget.clickAdvanceConfiguration();
    widget.selectCFO();
    widget.clickSaveButton();
  }

  @Then("^I have a List widget with \"([^\"]*)\"$")
  public void iHaveAListWidgetWithFilled(String name) throws IOException, InterruptedException {
    Log log = Log.getInstance();
    WebDriver driver = Driver.getDriver().getWebDriver();
    log.info("Step", "Verification on Mach2 and Open ERP", "Verification of datas");
    WidgetPage widget = new WidgetPage(driver);
    boolean mach2 = widget.verifyList(name);
    Thread.sleep(5000);
    MyDashboard dashboard = new MyDashboard(driver);
    dashboard.deleteBoard();

    //Logout Mach2
    TopMenuPage topMenuPage = new TopMenuPage(driver);
    topMenuPage.clickOnLogOut();
    assertEquals(openERPVerification(name), mach2);
  }

  private boolean openERPVerification(String name) throws IOException, InterruptedException {
    WebDriver driver;
    driver = Driver.getDriver().openBrowser(Driver.OpenERP);
    OELoginPage loginERP = new OELoginPage(driver);
    loginERP.setUserName("jose7");
    loginERP.setPassword("jose7");
    OEHomePage homeERP = loginERP.clickBtnSubmit();

    //Go to Human Resources

    homeERP.clickHumanResources();
    OESearch searchERP = homeERP.oeSearch();

    //Go to Search
    searchERP.clickSearchArrow();
    searchERP.clickAdvancedSearch();
    searchERP.foundAndClickAdvancedFilterOptions("Job Title", "is equal to", "CFO");
    searchERP.clickApplySearch();
    searchERP.clickSwitchList();
    searchERP.clickNumberElement();
    searchERP.clickQuantityButton();
    searchERP.clickUnlimitedOption();
    boolean result = false;
    List<ModelSearch> list = searchERP.getResultOfSearch();
    if (list.get(0).getName().equals(name)) {
      result = true;
    }
    homeERP.clickUserAccount();
    homeERP.clickLogOut();
    return result;
  }
}
