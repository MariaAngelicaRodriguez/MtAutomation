package org.funjala.automation.web.mach2.steps.widget;

/**
 * Created by Angelica Rodriguez on 1/27/2017.
 */

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
import static org.testng.Assert.assertTrue;


public class InfoEmployeePersonalInformation {

    WebDriver driver;
    TopMenuPage topMenuPage;
    LoginPage loginPage;
    WidgetPage widget;
    MyDashboard dashboard;
    Log log = Log.getInstance();
    boolean result = false;

    @Given("^I am at Mach2 Webpage$")
    public void iAmOnMachWebpage() throws IOException {
        log.info("Step", "I am at Mach2 webpage", "and prepare to Login");
        driver = Driver.getDriver().openBrowser(Driver.Mach2);
        loginPage = new LoginPage(driver);
    }

    @And("^I set Username as \"([^\"]*)\"$")
    public void iFillUsernameOrMailTextfieldAs(String userName) {
        log.info("Step", "I set username as ", userName);
        loginPage.setUsernameTextField(userName);
    }

    @And("^I set Password as \"([^\"]*)\" and press Submit button$")
    public void iFillPasswordTextfieldAsAndPressSubmitButton(String password) {
        log.info("Step", "I set password as ",  password + "and press submit");
        loginPage.setPasswordTextField(password);
        topMenuPage = loginPage.clickNextButton();
    }
    @And("^I add new Board to the Group$")
    public void iHaveBoardCreated() {
        log.info("Step", "I add a mew Board to the group", "My Dashboard");
        topMenuPage.addNewBoard();
    }


    @And("^I click on Widget Button at the top menubar$")
    public void iClickOnWidgetButtonAtTheTopMenubar() {
        log.info("Step", "I click on Widget button", "at the top menu bar");
        widget = topMenuPage.addNewWidget();
    }

    @And("^I click on \"([^\"]*)\" Icon inside the Widget options$")
    public void iClickOnIconInsideTheWidgetOptions(String ListTypeIcon) {
        log.info("Step", "I click on ",  ListTypeIcon + "icon inside the Widget options");
        widget.addWidget(ListTypeIcon);
    }

    @And("^I select \"([^\"]*)\" service Icon.$")
    public void iSelectServiceIcon(String ERPservice) {
        log.info("Step", "I select ",  ERPservice + "service icon and click on it");
        widget.clickOnService(ERPservice);
    }

    @And("^I select \"([^\"]*)\" on Open ERP$")
    public void iSelectOptionOfOpenERP(String specificService) {
        log.info("Step", "I select ", specificService + "service of Open ERP");
        widget.clickOnSpecificService(specificService);
    }

    @When("^I click on Divisions Combobox and select \"([^\"]*)\"$")
    public void i_click_on_Divisions_combobox_and_select(String nameDivision) throws Throwable {
        widget.setDivisionName(nameDivision);
    }

    @And("^I click save button$")
    public void iClickOnSaveButton() throws InterruptedException {
        log.info("Step", "I click on save Button", "Click on save Button");
        widget.clickSaveButton();
    }


    @When("^I should see the first Employee Personal Information by \"([^\"]*)\": \"([^\"]*)\"$")
    public void i_should_see_the_first_Employee_Personal_Information_by_Outsourcing(String item, String value) throws Throwable {
        widget.clickIcoInfoSearchElem();
        widget.setMenuInfoElemen(item);
        assertEquals(widget.getDescInfo(), value);

    }

    @Then("^I should have the same result using Open ERP web page to search Employee Personal Information for \"([^\"]*)\" as Employee$")
    public void i_should_have_the_same_result_using_Open_ERP_web_page_to_search_Division(String value) throws Throwable {

        log.info("Step", "I have a table widget with Information filled", "Verification of datas");

        dashboard = new MyDashboard(driver);
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
        searchERP.foundAndClickAdvancedFilterOptions("Division", "is equal to", "Outsourcing");
        searchERP.clickApplySearch();
        searchERP.clickSwitchList();
        searchERP.clickNumberElement();
        searchERP.clickQuantityButton();
        searchERP.clickUnlimitedOption();

        List<ModelSearch> resultOfSearch= searchERP.getResultOfSearch();

        for (ModelSearch modelSearch : resultOfSearch) {
            if (modelSearch.getName().equals(value)) {
                result = true;
                 break;
            }
        }

        assertTrue(result);

        homeERP.clickUserAccount();
        homeERP.clickLogOut();

    }
}
