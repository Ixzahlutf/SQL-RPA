package com.juaracoding.ecom.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverUtil {
  private static WebDriver driver;

  @Deprecated(since = "Provide driver manager")
  public static WebDriver getDriver(){
    if(driver==null){
      driver = new FirefoxDriver();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));//menunggu keseluruhan elemen yang ada dihalaman web
      driver.manage().window().maximize();
    }
    return driver;
  }

  public static void quitDriver(){
    if (driver != null) {
      driver.quit();
      driver = null;
    }
  }
}
