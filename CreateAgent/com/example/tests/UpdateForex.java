package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

@Test
public class UpdateForex {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://192.168.2.33/";
    //
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  public void testUpdateForex() throws Exception {
    driver.get(baseUrl + "thetransborder/auth/login.tb");
    driver.findElement(By.name("transborder-username")).clear();
    driver.findElement(By.name("transborder-username")).sendKeys("superadmin");
    driver.findElement(By.name("transborder-password")).clear();
    driver.findElement(By.name("transborder-password")).sendKeys("123456");
    driver.findElement(By.cssSelector("input.myButton")).click();
    //update forex
    driver.get(baseUrl + "thetransborder/forex/update.tb");
    //driver.findElement(By.linkText("Update")).click();
    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
    
  }

  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    }
}