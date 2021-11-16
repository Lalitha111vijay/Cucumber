package com.flipkart.stepdefinition;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;


public class MobileSearchSteps {
	
	static WebDriver driver;
	@Given("User lauch Flipkart URL")
	public void user_lauch_Flipkart_URL() {
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.get("http://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   
	}

	@Given("user enter mobiles in search option")
	public void user_enter_mobiles_in_search_option() {
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("Mobiles",Keys.ENTER);
		try {
			WebElement button = driver.findElement(By.xpath("//button[text()='✕']"));
			button.isDisplayed();
			button.click();
			} catch (Exception e){
			System.out.println("pop up is not displayed");
			}
		

	}
	    

	@When("click the particular mobiles in the list")
	public void click_the_particular_mobiles_in_the_list() {
		WebElement mobileName = driver.findElement(By.xpath("(//div[contains(text(),'POCO C31 (Royal Blue, 64 GB)')])"));
		mobileName.click();
		String parentURL = driver.getWindowHandle();
		Set<String> childURL = driver.getWindowHandles();
		for(String child : childURL){
		if(!parentURL.equals(child)){
		driver.switchTo().window(child);
		}
		}
		
	}

	@When("sclick add to cart option")
	public void sclick_add_to_cart_option() {
		WebElement addToCart = driver.findElement(By.xpath("//button[text()='ADD TO CART']"));
		addToCart.click();
		String parentURL = driver.getWindowHandle();
		Set<String> childURL = driver.getWindowHandles();
		for(String child : childURL){
		if(!parentURL.equals(child)){
		driver.switchTo().window(child);
		}
		}
		try {
			WebElement button = driver.findElement(By.xpath("//button[text()='✕']"));
			button.isDisplayed();
			button.click();
			} catch (Exception e){
			System.out.println("pop up is not displayed");
			}
		WebElement checkCart = driver.findElement(By.xpath("//button[span()='Cart']"));
		checkCart.click();
		
    //Assert.assertTrue(driver.findElement(By.xpath("//span[test()='Place Order']")).isDisplayed());
	
	    
	   
	}
	
}
