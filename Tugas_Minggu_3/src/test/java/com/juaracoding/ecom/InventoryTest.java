package com.juaracoding.ecom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.juaracoding.ecom.repositories.InventoryRepository;
import com.juaracoding.ecom.utils.DriverManager;
import com.juaracoding.ecom.utils.LoginUtil;

public class InventoryTest {

  @Test
  public void TC_INV_001(){//product display test
    DriverManager driverManager = new DriverManager();
    WebDriver driver = driverManager.getDriver();
    driver.get("https://www.saucedemo.com/v1/index.html");

    LoginUtil.performLogin(driver);

    int expected = 6;
    int actual = driver.findElements(InventoryRepository.inventoryItemName).size();

    Assert.assertEquals(actual, expected,"Jumlah produk tidak menampilkan data sesuai ekspektasi");
    driverManager.quitDriver();
  }


  @Test
  public void TC_INV_002() throws InterruptedException{//productReserveSortFeatureTest
    DriverManager driverManager = new DriverManager();
    WebDriver driver = driverManager.getDriver();
    driver.get("https://www.saucedemo.com/v1/index.html");

    LoginUtil.performLogin(driver);

    Select select = new Select(driver.findElement(InventoryRepository.productSortContainer));
    select.selectByValue("za");
    Thread.sleep(1000);
    List<WebElement> items = driverManager.getDriver().findElements(InventoryRepository.inventoryItemName);
    List<String> actualItemTitles = new ArrayList<>();

    for (WebElement item : items){
      actualItemTitles.add(item.getText());
    }

    List<String> expectedItemTitles = new ArrayList<>(actualItemTitles);
    Collections.sort(expectedItemTitles, Collections.reverseOrder());

    Assert.assertEquals(actualItemTitles, expectedItemTitles);
    driverManager.quitDriver();
  }

  @Test
  public void TC_INV_003(){ //inventory - add to cart
    DriverManager driverManager = new DriverManager();
    WebDriver driver = driverManager.getDriver();
    driver.get("https://www.saucedemo.com/v1/index.html");

    LoginUtil.performLogin(driver);

    //klik tombol "Add to Cart" pada product pertama
    WebElement buttonAddToCart = driver.findElement(InventoryRepository.button1AddToCart);
    buttonAddToCart.click();

    //Expected = Ikon keranjang menunjukkan angka 1 dan tombol berubah jadi "Remove"
    WebElement cartBadge = driver.findElement(InventoryRepository.badgeCart);
    String cartCount = cartBadge.getText();
    Assert.assertEquals(cartCount, "1", "Keranjang tidak menunjukkan angka 1");

    String buttonRemove = buttonAddToCart.getText();
    Assert.assertEquals(buttonRemove, "REMOVE", "Tombol tidak berubah menjadi 'REMOVE'");
    driverManager.quitDriver();
  }
 }
