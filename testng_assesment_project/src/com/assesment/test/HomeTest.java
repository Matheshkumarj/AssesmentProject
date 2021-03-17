package com.assesment.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomeTest extends AbstractTest {

	@Test(priority = 1)
	@Parameters({ "to_do_item" })
	public void add_and_verify_item(String to_do_item) {
		todos.add_item(to_do_item);
		todos.verify_item_list(to_do_item);
		todos.verify_count("1");
	}
	@Test(priority = 2)
	@Parameters({ "to_do_item" })
	public void active_list(String to_do_item) {
		todos.verify_active_filter(to_do_item);
		todos.verify_item_list(to_do_item);
		todos.verify_count("1");
	}
	
	@Test(priority = 3)
	@Parameters({ "to_do_item" })
	public void verify_complete_activity_filter(String to_do_item) {
		todos.verify_all_filter(to_do_item);
		todos.complete_activity_and_verify(to_do_item);
		
	}
	@Test(priority = 4)
	@Parameters({ "to_do_item" })
	public void verify_complete_list(String to_do_item) {
		todos.verify_completed_filter(to_do_item);
		todos.verify_item_list(to_do_item);
		todos.verify_count("0");
	}
	

}
