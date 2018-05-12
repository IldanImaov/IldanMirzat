package com.jenkins.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class FacebookTest {

	@Test
	public void facebookLogin() throws Exception {
		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
		driver.manage().window().maximize();
		driver.get("http://www.facebook.com/");
		Thread.sleep(3000);
		WebElement email = driver.findElement(By.cssSelector("#email"));
		email.click();
		email.sendKeys("ildan.imam49@gmail.com");
		WebElement password = driver.findElement(By.cssSelector("#pass"));
		password.click();
		password.sendKeys("13999868881.");

		driver.findElement(By.cssSelector("input[value = 'Log In']")).click();

		Thread.sleep(6000);

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		Thread.sleep(3000);

		WebElement message = driver.findElement(By.xpath("//textarea[@name='xhpc_message']"));

		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL);
		action.click(message);
		action.keyUp(Keys.CONTROL);
		action.build().perform();
		
		

		message.sendKeys("jenkins has finally worked ");
		
		driver.findElement(By.xpath("//button[text()=\'Post\']")).click();

		Thread.sleep(3000);

		driver.quit();

	}

}
