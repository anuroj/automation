package com.example.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
//for excel file reading
import java.io.File;
import java.util.Date;
import jxl.*;

@Test
public class CreateAgent {
  private WebDriver driver;
  private String baseUrl;
  private String environment;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private String accnum;
  private String agName;

   
  @BeforeMethod
public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://192.168.2.33/";
    environment = "thetransborder";
   Timeouts implicitlyWait = driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  public void testCreateAgent() throws Exception {
	
	  driver.get(baseUrl + environment + "/auth/login.tb");
	  driver.findElement(By.name("transborder-username")).clear();
	  driver.findElement(By.name("transborder-username")).sendKeys("superadmin");
	  driver.findElement(By.name("transborder-password")).clear();
	  driver.findElement(By.name("transborder-password")).sendKeys("123456");
	  driver.findElement(By.cssSelector("input.myButton")).click();
	 
	  for (int i=1; i<7; i++)
		{
		  //For reading contents from excel file
		  //open workbook
		  
		  Workbook workbook = Workbook.getWorkbook(new File("C:\\Selenium\\Test Cases\\TestData.xls"));
		  
		  //open sheet
		  Sheet sheet = workbook.getSheet(0);
		  
		  //get content of 1st column ith row
		  accnum = sheet.getCell(0, i).getContents();
		  
		  //get content of 2nd column ith row
		  agName = sheet.getCell(1, i).getContents();
		  
		  //close workbook
		  workbook.close();
		  
		  //below code was part of for loop instead of excel file.
		  //accnum = "ACC12345"+i;
		  //agName = "AnuAgent"+i;
		  
		driver.get(baseUrl + environment + "/agent.tb");
	    driver.findElement(By.linkText("Add a Principal Agent")).click();
	    driver.findElement(By.id("agent_name")).clear();
	    driver.findElement(By.id("agent_name")).sendKeys(agName);
	    driver.findElement(By.id("account_number")).clear();
	    driver.findElement(By.id("account_number")).sendKeys(accnum);
	    driver.findElement(By.id("branch_code")).clear();
	    driver.findElement(By.id("branch_code")).sendKeys("1234567893");
	    driver.findElement(By.id("commission_account_number")).clear();
	    driver.findElement(By.id("commission_account_number")).sendKeys(accnum);
	    driver.findElement(By.id("branch_code")).clear();
	    driver.findElement(By.id("branch_code")).sendKeys("123456789015");
	    new Select(driver.findElement(By.id("country"))).selectByVisibleText("Nepal");
	    new Select(driver.findElement(By.id("state"))).selectByVisibleText("BAGMATI");
	    new Select(driver.findElement(By.id("city"))).selectByVisibleText("KATHMANDU");
	    new Select(driver.findElement(By.id("timezone"))).selectByVisibleText("[UTC + 5:45] Nepal Time");
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys("anuroj@f1soft.com");
	    driver.findElement(By.id("phone")).clear();
	    driver.findElement(By.id("phone")).sendKeys("9849474497");
	    driver.findElement(By.id("contact_person")).clear();
	    driver.findElement(By.id("contact_person")).sendKeys("Anuroj");
	    driver.findElement(By.id("registration_number")).clear();
	    driver.findElement(By.id("registration_number")).sendKeys("987654");
	    driver.findElement(By.id("per_txn_limit")).clear();
	    driver.findElement(By.id("per_txn_limit")).sendKeys("10000");
	    driver.findElement(By.id("daily_txn_limit")).clear();
	    driver.findElement(By.id("daily_txn_limit")).sendKeys("100000");
	    driver.findElement(By.id("monthly_txn_limit")).clear();
	    driver.findElement(By.id("monthly_txn_limit")).sendKeys("3000000");
	    driver.findElement(By.id("is_taxable")).click();
	    driver.findElement(By.cssSelector("li.ms-elem-selectable")).click();
	    driver.findElement(By.cssSelector("#ms-payout_allowed_banks > div.ms-selectable > ul.ms-list > li.ms-elem-selectable")).click();
	    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
	    new Select(driver.findElement(By.name("agent_from"))).selectByVisibleText(agName);
	    driver.findElement(By.name("destination_country[0]")).click();
	    new Select(driver.findElement(By.name("destination_country[0]"))).selectByVisibleText("Nepal");
	    driver.findElement(By.cssSelector("option[value=\"155\"]")).click();
	    driver.findElement(By.name("amount_from_id[0][0][]")).clear();
	    driver.findElement(By.name("amount_from_id[0][0][]")).sendKeys("1");
	    driver.findElement(By.name("amount_to_id[0][0][]")).clear();
	    driver.findElement(By.name("amount_to_id[0][0][]")).sendKeys("10000000");
	    driver.findElement(By.name("ocom_flat_id[0][0][]")).clear();
	    driver.findElement(By.name("ocom_flat_id[0][0][]")).sendKeys("1");
	    driver.findElement(By.name("ocom_percent_id[0][0][]")).clear();
	    driver.findElement(By.name("ocom_percent_id[0][0][]")).sendKeys("1");
	    driver.findElement(By.name("rcom_flat_id[0][0][]")).clear();
	    driver.findElement(By.name("rcom_flat_id[0][0][]")).sendKeys("0.5");
	    driver.findElement(By.name("rcom_percent_id[0][0][]")).clear();
	    driver.findElement(By.name("rcom_percent_id[0][0][]")).sendKeys("0.5");
	    driver.findElement(By.name("pcom_flat_id[0][0][]")).clear();
	    driver.findElement(By.name("pcom_flat_id[0][0][]")).sendKeys("0.5");
	    driver.findElement(By.name("pcom_percent_id[0][0][]")).clear();
	    driver.findElement(By.name("pcom_percent_id[0][0][]")).sendKeys("0.5");
	    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
	}
  }

  @AfterMethod
public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      Assert.fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alert.getText();
    } finally {
      acceptNextAlert = true;
    }
  }
}
