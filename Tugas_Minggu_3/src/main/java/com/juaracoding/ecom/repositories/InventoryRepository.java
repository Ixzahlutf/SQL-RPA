package com.juaracoding.ecom.repositories;

import org.openqa.selenium.By;

public class InventoryRepository {
  public static By inventoryItem = By.xpath("//div[@class='inventory_item']");
  public static By inventoryItemName = By.xpath("//div[@class='inventory_item_name']");
  public static By productSortContainer = By.xpath("//select[@class='product_sort_container']");
  public static By button1AddToCart = By.xpath("//div[@class='inventory_list']//div[1]//div[3]//button[1]");
  public static By badgeCart = By.xpath("//span[@class='fa-layers-counter shopping_cart_badge']");
}
