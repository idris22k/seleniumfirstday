package org.sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import junit.framework.Assert;

public class sample {
static 
 @BeforeClass
 public void launchBrowser() {
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\IQBAL\\eclipse-workspace\\seleniumfirstday\\drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");

}
	
	
	
	
	
	
	public static void main(String[] args) throws InterruptedException {
		
		
		
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\IQBAL\\eclipse-workspace\\seleniumfirstday\\drivers\\chromedriver.exe");
	
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.amazon.in");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	WebElement txtBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
	txtBox.click();
	txtBox.sendKeys("Iphone 11",Keys.ENTER);
	 List<WebElement> list_of_products = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
	 List<WebElement> list_of_products_price = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
	 String product_name;
		String product_price;
		int int_product_price;
		HashMap<Integer, String> map_final_products = new HashMap<Integer,String>();
		for(int i=0;i<list_of_products.size();i++) {
			product_name = list_of_products.get(i).getText();//Iterate and fetch product name
			product_price = list_of_products_price.get(i).getText();//Iterate and fetch product price
			product_price = product_price.replaceAll("[^0-9]", "");//Replace anything wil space other than numbers
			int_product_price = Integer.parseInt(product_price);//Convert to Integer
			map_final_products.put(int_product_price,product_name);//Add product and price in HashMap
		}
		
		Set<Integer> allkeys = map_final_products.keySet();
		ArrayList<Integer> array_list_values_product_prices = new ArrayList<Integer>(allkeys);
		Collections.sort(array_list_values_product_prices);
		int high_price = array_list_values_product_prices.get(array_list_values_product_prices.size()-1);
		int low_price = array_list_values_product_prices.get(0);
		for (int i = 0; i < array_list_values_product_prices.size(); i++) {
			System.out.println(i);
		}
		for (Integer integer : array_list_values_product_prices) {
			System.out.println(integer);
		}
System.out.println("High Product Price is: " + high_price + " Product name is: " + map_final_products.get(high_price));
System.out.println("Low Product Price is: " + low_price + " Product name is: " + map_final_products.get(low_price));		
driver.close();
	
	}
}
