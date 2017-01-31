package org.funjala.automation.web.mach2.steps.widget;

import cucumber.api.PendingException;
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
import org.funjala.automation.web.pages.mach2.sidebar.SideBarPage;
import org.funjala.automation.web.pages.mach2.widget.WidgetPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Created by FernandoIquiza on 1/25/2017.
 */
public class ListEmExBySkillsSteps {

  @When("^I click on Skills combobox and select Cloud.$")
  public void iChooseOnSkillsCombobox() {
    Log log = Log.getInstance();
    WebDriver driver = Driver.getDriver().getWebDriver();
    WidgetPage widget = new WidgetPage(driver);
    log.info("Step", "I click on Skills combobox", " and select Cloud");
    widget.clickOnSpecificCombobox();
  }

  @Then("^I should see the list of Employees by Skill: \"([^\"]*)\" on E.E. category$")
  public void iShouldSeeTheListOfEmployeesBySkillCloudOnEECategory(String skillName) throws IOException, InterruptedException {
    Log log = Log.getInstance();
    WebDriver driver = Driver.getDriver().getWebDriver();
    WidgetPage widget = new WidgetPage(driver);
    TopMenuPage topMenuPage = new TopMenuPage(driver);
    int actualResult = widget.verifyQtyEmployeeExperienceBySkillsCloud(skillName);
    System.out.println("****************** Result of items found in the List**********");
    System.out.println("The number of Employees found is: " + actualResult + " by Skill: " + skillName);
    MyDashboard dashboard = new MyDashboard(driver);
    dashboard.deleteBoard();

    //Logout Mach2
    topMenuPage.clickOnLogOut();

    //Login to OPEN ERP web app

    driver = Driver.getDriver().openBrowser(Driver.OpenERP);
    OELoginPage loginERP = new OELoginPage(driver);
    loginERP.setUserName("jose4");
    loginERP.setPassword("jose4");
    OEHomePage homeERP = loginERP.clickBtnSubmit();

    //Go and Click on Human Resources top menu button

    homeERP.clickHumanResources();
    OESearch searchERP = homeERP.oeSearch();

    //Go and Click on Human Resources text field
    searchERP.clickSearchArrow();
    searchERP.clickAdvancedSearch();
    searchERP.foundAndClickAdvancedFilterOptions("Skills", "contains", "Cloud");
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
