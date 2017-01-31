package org.funjala.automation.web.model.pivotal.projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Topo on 9/12/2016.
 */
public class CreateProjectModel {

  public static final String projectName = "div.tc-project-name > label > input";

  public static final String createBtn = "button.tc-create-project-footer__button.tc-create-project-footer__button--submit";

  public static final String menuButton = "fieldset > div";

  public static final String selectAccountItem = "div.tc-account-selector__options > ul > li:nth-child(1)";

  public static final String typeProject = "//fieldset/label/input";

  public static final String accountItem = "//div[text()= '";

  public static final String projectNewAccount = "//div[1]/div[2]/span";

  public static final String projectNameNewAccount = "//fieldset/div/div/input";

  public static final String selectorAccount = "div.tc-account-selector__options";


}
