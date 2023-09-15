package com.wipro;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class Assignment04 {
	static WebDriver driver;
	double totalAmount;
	boolean condition = true;
	@BeforeClass
	public static void setUp1() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/pu20450468/Downloads/chromedriver_mac64/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://shop.demoqa.com/");
		
		Thread.sleep(3000);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/p/a")).click();
		driver.findElement(By.xpath("//a[@href=\"https://shop.demoqa.com/my-account/\"]")).click();
		driver.findElement(By.id("username")).sendKeys("Hemanthrhfgdh11d234");
		driver.findElement(By.id("password")).sendKeys("Hemanth@2001");
		driver.findElement(By.id("rememberme")).click();
		driver.findElement(By.name("login")).click();
	}
	@Before
	public void setUp2() {
		driver.findElement(By.xpath("//*[@id=\"noo-site\"]/header/div[2]/div/div/div/a/i")).click();
		driver.findElement(By.name("s")).sendKeys("sandals",Keys.ENTER);
	}
	@Test
	public void test() throws InterruptedException, IOException {
		while (condition) {
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[2]/div/div/div[1]/div/div[1]/div[2]/div[1]/div/div[1]/a/img")).click();
			driver.findElement(By.name("quantity")).clear();
			driver.findElement(By.name("quantity")).sendKeys("1");
			Select s = new Select(driver.findElement(By.id("pa_color")));
			s.selectByVisibleText("Brown");
			s = new Select(driver.findElement(By.id("pa_size")));
			s.selectByVisibleText("36");
			driver.findElement(By.xpath("//*[@id=\"product-1318\"]/div[1]/div[2]/form/div/div[2]/button")).click();
			driver.findElement(By.xpath("//*[@id=\"noo-site\"]/header/div[2]/div/div/div/ul")).click();
			String s1 = driver.findElement(By.xpath("//*[@id=\"post-6\"]/div/div/form/table/tbody/tr[1]/td[5]/span/bdi")).getText();
			// to create text file
			FileWriter f = new FileWriter("savetxt.txt");
			f.write(s1);
			f.close();
			
			String totalValue = driver.findElement(By.className("amount")).getText();
			totalValue = totalValue.replaceAll("₹", "");
			totalAmount = Double.parseDouble(totalValue);
			if (totalAmount < 200) {
				driver.findElement(By.xpath("//*[@id=\"post-6\"]/div/div/form/table/tbody/tr[2]/td/a[2]")).click();
				driver.findElement(By.xpath("//*[@id=\"noo-site\"]/header/div[2]/div/div/div/a/i")).click();
				driver.findElement(By.name("s")).sendKeys("sandals",Keys.ENTER);
			} else {
				condition = false;
			}
		}
	}
	@After
	public void logoutthepage() {
		driver.findElement(By.xpath("//*[@id=\"noo-site\"]/header/div[1]/div/ul[2]/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/nav/ul/li[6]/a")).click();
	}
	@AfterClass
	public static void setUp4() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
	}
}