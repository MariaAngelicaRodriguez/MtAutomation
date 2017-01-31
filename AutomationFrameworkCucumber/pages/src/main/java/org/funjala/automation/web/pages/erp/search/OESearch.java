package org.funjala.automation.web.pages.erp.search;

import org.funjala.automation.web.model.erp.search.ModelSearch;
import org.funjala.automation.web.model.erp.search.SearchModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 1/24/2017.
 */
public class OESearch {
  private WebDriver driver;
  private WebDriverWait wait;
  private int indexConditions;

  public OESearch(WebDriver driver) {
    indexConditions = 1;
    this.driver = driver;
    AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
    PageFactory.initElements(factory, this);
    wait = new WebDriverWait(driver, 10);
  }

  @FindBy(xpath = SearchModel.searchArrow)
  WebElement searchArrow;

  @FindBy(xpath = SearchModel.advancedSearch)
  WebElement advancedSearchButton;

  @FindBy(xpath = SearchModel.applyButton)
  WebElement applyButton;

  @FindBy(xpath = SearchModel.showMoreButton)
  WebElement showMoreButton;

  @FindBy(xpath = SearchModel.switchListButton)
  WebElement switchListButton;

  @FindBy(xpath = SearchModel.searchList)
  List<WebElement> searchList;

  @FindBy(xpath = SearchModel.quantityButton)
  WebElement quantityButton;

  @FindBy(xpath = SearchModel.unlimitedOption)
  WebElement unlimitedOption;

  @FindBy(xpath = SearchModel.numbersElement)
  WebElement numberElement;

  @FindBy(xpath = SearchModel.addACondition)
  WebElement addAConditionButton;

  public void clickSearchArrow() {
    searchArrow.click();
  }

  public void clickAdvancedSearch() {
    advancedSearchButton.click();
  }


  public void foundAndClickAdvancedFilterOptions(String filterType, String condition) {
    List<WebElement> advancedFilterOptions = driver.findElements(
            By.xpath("//li[" + indexConditions + "]/select[@class='searchview_extended_prop_field']/option"));

    for (WebElement type : advancedFilterOptions) {

      if (type.getText().trim().equalsIgnoreCase(filterType.trim()))
        type.click();
    }

    List<WebElement> advancedConditions = driver.findElements(
            By.xpath("//li[" + indexConditions + "]/select[@class='searchview_extended_prop_op']/option"));

    for (WebElement option : advancedConditions) {
      if (option.getText().trim().equalsIgnoreCase(condition.trim()))
        option.click();
    }
  }

  public void foundAndClickAdvancedFilterOptions(String filterType, String condition, String value) {
    List<WebElement> advancedFilterOptions = driver.findElements(
            By.xpath("//li[" + indexConditions + "]/select[@class='searchview_extended_prop_field']/option"));

    for (WebElement type : advancedFilterOptions) {

      if (type.getText().trim().equalsIgnoreCase(filterType.trim()))
        type.click();
    }

    List<WebElement> advancedConditions = driver.findElements(
            By.xpath("//li[" + indexConditions + "]/select[@class='searchview_extended_prop_op']/option"));

    for (WebElement option : advancedConditions) {
      if (option.getText().trim().equalsIgnoreCase(condition.trim()))
        option.click();
    }

    WebElement valueOfSearch = driver.findElement(By.xpath("//li[" + indexConditions + "]/span[@class='searchview_extended_prop_value']/input"));

    valueOfSearch.sendKeys(value);
  }

  public void clickApplySearch() {
    applyButton.click();
  }

  public void clickShowMoreButton() {
    showMoreButton.click();
  }

  public void clickShowMoreButtonUntilItDoesNotExist() {
    while (showMoreButton.isEnabled() && showMoreButton.isDisplayed()) {
      wait.until(ExpectedConditions.visibilityOf(showMoreButton));
      wait.until(ExpectedConditions.elementToBeClickable(showMoreButton));
      showMoreButton.click();
    }
  }

  public List<WebElement> searchResult() {

    List<WebElement> searchResult = driver.findElements(By.xpath(SearchModel.searchResult));
    wait.until(ExpectedConditions.visibilityOf(searchResult.get(searchResult.size() - 1)));
    return searchResult;
  }

  public void clickSwitchList() {
    switchListButton.click();
  }

  public void clickNumberElement() {
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    numberElement.click();
  }

  public void clickQuantityButton() {
    quantityButton.click();
  }

  public void clickUnlimitedOption() {
    unlimitedOption.click();
  }

  public List<WebElement> listOfAllElements() throws InterruptedException {

    Thread.sleep(500);
    List<WebElement> result = searchList;
    return result;
  }

  public void clickAddAConditionButton() {
    addAConditionButton.click();
    indexConditions++;
  }

  public List<ModelSearch> getResultOfSearch() throws InterruptedException {
    List<ModelSearch> listModelSearch = new ArrayList<>();
    ModelSearch modelSearch;
    for (WebElement element : listOfAllElements()) {
      modelSearch = new ModelSearch();
      modelSearch.setInternalId(element.findElement(By.xpath(".//td[@data-field='internal_number']")).getText());
      modelSearch.setName(element.findElement(By.xpath(".//td[@data-field='name']")).getText());
      modelSearch.setDepartment(element.findElement(By.xpath(".//td[@data-field='department_id']")).getText());
      modelSearch.setJobTitle(element.findElement(By.xpath(".//td[@data-field='job_id']")).getText());
      modelSearch.setLocation(element.findElement(By.xpath(".//td[@data-field='location_id']")).getText());
      modelSearch.setLead(element.findElement(By.xpath(".//td[@data-field='lead_id']")).getText());
      modelSearch.setManager(element.findElement(By.xpath(".//td[@data-field='parent_id']")).getText());
      listModelSearch.add(modelSearch);
    }
    return listModelSearch;
  }


}
