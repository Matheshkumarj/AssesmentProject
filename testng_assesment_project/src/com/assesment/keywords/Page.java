package com.assesment.keywords;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class Page {

	protected WebDriver driver;

	public Page(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void navigate(String url) {
		driver.navigate().to(url);
		driver.manage().window().maximize();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void click_element(String locator) {
		WebElement element = element_locator(locator);
		element.click();

	}

	public void input_text(String locator, String value) {
		WebElement element = element_locator(locator);
		element.sendKeys(value);
	}

	public void submit(String locator) {
		WebElement element = element_locator(locator);
		element.sendKeys(Keys.ENTER);

	}

	public String get_text(String locator) {
		WebElement element = element_locator(locator);
		return element.getText();

	}
	
	public String get_attribute(String locator,String attribute) {
		WebElement element = element_locator(locator);
		return element.getAttribute(attribute);

	}

	private WebElement element_locator(String locator) {
		String[] Split_locator = locator.split(";");
		if (Split_locator[0].equalsIgnoreCase("xpath")) {
			try {
				return (driver.findElement(By.xpath(Split_locator[1])));
			} catch (Exception e) {
				Reporter.log("Element click fail" + '\n' + e.toString());
			}
		}
		if (Split_locator[0].equalsIgnoreCase("id")) {
			try {
				return (driver.findElement(By.id(Split_locator[1])));
			} catch (Exception e) {
				Reporter.log("Element click fail" + '\n' + e.toString());
			}
		}
		if (Split_locator[0].equalsIgnoreCase("name")) {
			try {
				return (driver.findElement(By.name(Split_locator[1])));
			} catch (Exception e) {
				Reporter.log("Element click fail" + '\n' + e.toString());
			}
		}
		return null;

	}

	public void tearDown() {
		try {
	      this.driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
