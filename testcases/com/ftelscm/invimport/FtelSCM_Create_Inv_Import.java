package com.ftelscm.invimport;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FtelSCM_Create_Inv_Import {
	WebDriver driver;
	Actions action;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

//	@Test
//	public void Login_Success() {
//		driver.get("http://ftelscmstag.fpt.vn/");
//		driver.findElement(By.xpath("//input[@id='txtUserName']")).sendKeys("xuyennt6@fpt.com.vn");
//		driver.findElement(By.xpath("//input[@id='txtPassWord']")).sendKeys("scm@1220");
//		driver.findElement(By.xpath("//input[@class='loginBtn']")).click();
//
//		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='user-acc']")).getText(), "xuyennt6@fpt.com.vn");
//	}

	//// span[text()='Quản lý kho']
	
	@BeforeClass
	public void beforeClass() {
//		if (osName.contains("Windows")) {
//			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
//		} else {
//			System.setProperty("webdriver.chrome.driver", projectPath + "/browserDrivers/chromedriver");
//			driver = new ChromeDriver();
//		}
		if (osName.contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		}
		driver = new FirefoxDriver();
		action = new Actions(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	@Test
	public void Create_InvImport() {
		driver.get("http://ftelscmstag.fpt.vn/");
		driver.findElement(By.xpath("//input[@id='txtUserName']")).sendKeys("xuyennt6@fpt.com.vn");
		driver.findElement(By.xpath("//input[@id='txtPassWord']")).sendKeys("scm@1220");
		driver.findElement(By.xpath("//input[@class='loginBtn']")).click();
		driver.findElement(By.xpath("// span[text()='Quản lý kho']")).click();		
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Phiếu nhập kho']"))).perform();
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Tạo phiếu nhập (v2)']"))).perform();
		driver.findElement(By.xpath("//div[@class='menu-text']//span[(text()='Tạo phiếu nhập (v2)')]/following-sibling::a")).click();
		driver.findElement(By.xpath("//span[text()='Thêm mới']")).click();
	}
	

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}

}
