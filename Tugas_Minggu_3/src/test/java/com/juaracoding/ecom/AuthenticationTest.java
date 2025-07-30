package com.juaracoding.ecom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.juaracoding.ecom.providers.DataTestProvider;
import com.juaracoding.ecom.utils.DriverManager;
import com.juaracoding.ecom.utils.LoginUtil;

public class AuthenticationTest {
  @Test(dataProvider =  "loginDataProvider", dataProviderClass = DataTestProvider.class)
  public void loginTest(String username, String password) throws InterruptedException{
    DriverManager driverManager = new DriverManager();
    WebDriver driver = driverManager.getDriver();
    driver.get("https://www.saucedemo.com/v1/index.html");

    LoginUtil.performLogin(driver, username, password);

    String actual = driver.getCurrentUrl();
    String expected = "https://www.saucedemo.com/v1/inventory.html";
    Assert.assertEquals(actual, expected);

    driverManager.quitDriver();
  }

  @Test
  public void loginWithInvalidUsername(){
    DriverManager driverManager = new DriverManager();
    WebDriver driver = driverManager.getDriver();
    driver.get("https://www.saucedemo.com/v1/index.html");

    LoginUtil.performLogin(driver, "Lalalala", "secret_sauce");

    WebElement errorValidation = driver.findElement(By.cssSelector("h3[data-test='error'"));
    String actual = errorValidation.getText();
    String expected = "Epic sadface: Username and password do not match any user in this service";

    Assert.assertEquals(actual, expected);

    driverManager.quitDriver();
  }

  @Test
  public void loginWithInvalidPassword(){
    DriverManager driverManager = new DriverManager();
    WebDriver driver = driverManager.getDriver();
    driver.get("https://www.saucedemo.com/v1/index.html");

    LoginUtil.performLogin(driver, "standard_user", "secret_sambel");

    WebElement errorValidation = driver.findElement(By.cssSelector("h3[data-test='error'"));
    String actual = errorValidation.getText();
    String expected = "Epic sadface: Username and password do not match any user in this service";

    Assert.assertEquals(actual, expected);

    driverManager.quitDriver();
  }

  @Test
  public void loginWithoutUsername(){
    DriverManager driverManager = new DriverManager();
    WebDriver driver = driverManager.getDriver();
    driver.get("https://www.saucedemo.com/v1/index.html");

    LoginUtil.performLogin(driver,"" , "secret_sambel");

    WebElement errorValidation = driver.findElement(By.cssSelector("h3[data-test='error'"));
    String actual = errorValidation.getText();
    String expected = "Epic sadface: Username is required";

    Assert.assertEquals(actual, expected);

    driverManager.quitDriver();
  }

  @Test
  public void loginWithoutPassword(){
    DriverManager driverManager = new DriverManager();
    WebDriver driver = driverManager.getDriver();
    driver.get("https://www.saucedemo.com/v1/index.html");

    LoginUtil.performLogin(driver,"standard_user" , "");

    WebElement inputUsername =  driver.findElement(By.id("user-name"));
    inputUsername.sendKeys("standard_user");

    WebElement buttonLogin = driver.findElement(By.id("login-button"));
    buttonLogin.click();

    WebElement errorValidation = driver.findElement(By.cssSelector("h3[data-test='error'"));
    String actual = errorValidation.getText();
    String expected = "Epic sadface: Password is required";

    Assert.assertEquals(actual, expected);

    driverManager.quitDriver();
  }
}
