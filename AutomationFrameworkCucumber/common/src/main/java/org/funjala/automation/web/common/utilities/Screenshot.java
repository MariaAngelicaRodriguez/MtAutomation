package org.funjala.automation.web.common.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;



public class Screenshot {
  static SimpleDateFormat formatter = new SimpleDateFormat("MMddyyyy_hh-mm-ss");
  static Calendar now = Calendar.getInstance();

  public static String capture(WebDriver driver, ITestResult testResult) throws IOException {
    File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    String filePath = "../automation/reports/screenShot/" + testResult.getName()
            + "_" + formatter.format(now.getTime()) + ".png";
    FileUtils.copyFile(scrFile, new File(filePath));
    filePath = filePath.replaceAll("/automation/reports", "");
    return filePath;
  }
}
