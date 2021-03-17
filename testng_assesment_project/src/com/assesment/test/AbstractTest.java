package com.assesment.test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.assesment.keywords.Page;
import com.assesment.keywords.ToDos;

public abstract class AbstractTest {

	protected static Page page;
	protected static ToDos todos;

	@BeforeTest
	@Parameters({ "url" })
	public void setup(String url) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		page = new Page(new ChromeDriver());
		page.navigate(url);
		todos = new ToDos(page);
	}

	@AfterTest
	public void afterTest() {
		page.tearDown();
	}
}
