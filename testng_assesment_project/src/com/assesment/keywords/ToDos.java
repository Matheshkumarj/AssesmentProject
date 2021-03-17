package com.assesment.keywords;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ToDos {

	protected Page page;
	public static String add_activity_box = "xpath;//input[@ng-model='newTodo']";
	public static String filter_all = "xpath;//ul[@class='filters']//li//a[contains(text(),\"All\")]";
	public static String filter_active = "xpath;//ul[@class='filters']//li//a[contains(text(),\"Active\")]";
	public static String filter_completed = "xpath;//ul[@class='filters']//li//a[contains(text(),\"Completed\")]";
	public static String count = "xpath;//*[@class='todo-count']";

	public ToDos(Page page) {

		this.page = page;

	}
	
	public void add_item(String value) {

		page.click_element(add_activity_box);
		page.input_text(add_activity_box, value);
		page.submit(add_activity_box);
		verify_item_list(value);

	}

	public void verify_item_list(String value) {

		String item_locator = "xpath;//div[@class='view']//label[contains(text(),'" + value + "')]";
		Assert.assertEquals(page.get_text(item_locator), value, "Verify Added item in the to do list");

	}
	
	public void complete_activity_and_verify(String value) {
		String complete_checkbox = "xpath;//div[@class='view']//*[text()='"+value+"']//preceding-sibling::input[@type='checkbox']";
		String complete_activity = "xpath;//div[@class='view']//*[text()='"+value+"']//ancestor::li";
		page.click_element(complete_checkbox);
		Assert.assertTrue((page.get_attribute(complete_activity, "class")).contains("completed"));
		
	}
	
	public void verify_completed_filter(String value) {
		page.click_element(filter_completed);
				
	}
	
	public void verify_active_filter(String value) {
		page.click_element(filter_active);
				
	}
	public void verify_all_filter(String value) {
		page.click_element(filter_all);
				
	}
	public void verify_count(String _count) {
		Assert.assertTrue((page.get_text(count)).contains(_count));
	}
	

}
