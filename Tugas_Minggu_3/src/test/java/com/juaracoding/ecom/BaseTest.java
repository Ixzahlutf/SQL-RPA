package com.juaracoding.ecom;

import org.apache.commons.math3.analysis.interpolation.SmoothingPolynomialBicubicSplineInterpolator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.juaracoding.ecom.utils.DriverUtil;

public class BaseTest {
    @BeforeMethod
    @Parameters({"baseURL","username","password"})
    public void setup(String baseURL, String username, String password) {
        WebDriver driver = DriverUtil.getDriver();
        driver.get(baseURL);
        
        WebElement inputUsername = driver.findElement(By.id("user-name"));
        inputUsername.sendKeys(username);

        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys(password);

        WebElement buttonLogin = driver.findElement(By.id("login-button"));
        buttonLogin.click();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {// menutup test
        Thread.sleep(2000);
        DriverUtil.quitDriver();
    }
}
