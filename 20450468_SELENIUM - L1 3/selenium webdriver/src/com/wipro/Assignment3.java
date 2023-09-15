package com.wipro;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","/Users/pu20450468/Downloads/chromedriver_mac64/chromedriver");
		WebDriver driver =new ChromeDriver();
		driver.get("https://shop.demoqa.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/p/a")).click();
		driver.findElement(By.xpath("//a[@href=\"https://shop.demoqa.com/my-account/\"]")).click();
		
		driver.findElement(By.id("reg_username")).sendKeys("Hemanthrhfgdh11d234");
		driver.findElement(By.id("reg_email")).sendKeys("pulletigufrthid1ghhdemanthkukmarh@gmail.com");
		driver.findElement(By.id("reg_password")).sendKeys("Hemanth@2001");
		driver.findElement(By.name("register")).click();
		driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/nav/ul/li[6]/a")).click();

		driver.findElement(By.id("username")).sendKeys("Hemanthrhfgdh11d234");
		driver.findElement(By.id("password")).sendKeys("Hemanth@2001");
		driver.findElement(By.id("rememberme")).click();
		driver.findElement(By.name("login")).click();
		driver.findElement(By.xpath("//*[@id=\"noo-site\"]/header/div[2]/div/div/div/a/i")).click();
		driver.findElement(By.name("s")).sendKeys("DRESS");
		driver.findElement(By.name("s")).sendKeys(Keys.ENTER);
		Select s=new Select(driver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[1]/div/div[2]/form[3]/select")));
		s.selectByVisibleText("List");
		s=new Select(driver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[1]/div/form/select")));
		s.selectByValue("price");
		String s1=driver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[2]/div/div/div[1]/div/div[2]/p")).getText();
		System.out.println(s1);
		File f=new File("savetxt.txt");
		driver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[2]/div/div/div[1]/div/div[2]/h3/a")).click();
		Select objSelect =new Select(driver.findElement(By.id("pa_color")));
		objSelect.selectByVisibleText("Black");
		Select objSelect1 =new Select(driver.findElement(By.id("pa_size")));
		objSelect1.selectByVisibleText("Medium");
		driver.findElement(By.xpath("//*[@id=\"product-1162\"]/div[1]/div[2]/form/div/div[2]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"noo-site\"]/header/div[2]/div/div/div/ul")).click();
		driver.findElement(By.xpath("//*[@id=\"post-6\"]/div/div/div[2]/div[2]/div/a")).click();
		driver.findElement(By.id("billing_first_name")).sendKeys("Hemanth");
		driver.findElement(By.id("billing_last_name")).sendKeys("pulletigurthi");
		Select objSelect2 =new Select(driver.findElement(By.id("billing_country")));
		objSelect2.selectByVisibleText("India");
		driver.findElement(By.id("billing_address_1")).sendKeys("95, home");
		driver.findElement(By.id("billing_city")).sendKeys("VZM");
		Select objSelect3 =new Select(driver.findElement(By.id("billing_state")));
		objSelect3.selectByVisibleText("Andhra Pradesh");
		driver.findElement(By.id("billing_postcode")).sendKeys("535001");
		driver.findElement(By.id("billing_phone")).sendKeys("6302733769");
		driver.findElement(By.id("order_comments")).sendKeys("Not Applicable");
		//to perform Scroll on application using Selenium
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	       js.executeScript("window.scrollBy(0,-350)", "");
		
		driver.findElement(By.xpath("//*[@id=\"payment\"]/div/div/p/label/span")).click();
		driver.findElement(By.id("place_order")).click();
		// Wait Upto Click a element
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(
		ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("My Account")));

        driver.findElement(By.xpath("//*[@id=\"noo-site\"]/header/div[1]/div/ul[2]/li[2]/a")).click();					
		driver.findElement(By.xpath("//a[@href=\"https://shop.demoqa.com/my-account/\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/nav/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/nav/ul/li[6]/a")).click();
		driver.quit();
	}

}
