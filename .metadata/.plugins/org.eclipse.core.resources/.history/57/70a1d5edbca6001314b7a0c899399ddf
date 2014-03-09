package com.example.tests;

import org.testng.annotations.Test;

public class GroupRemoval extends TestBase {
	
	@Test
	public void deleteSomeGroup() {
		app.getNavigationHelper().openMainPage();
		app.getGroupHelper().openGroupsPage();
		app.getGroupHelper().deleteGroup(1);
		app.getGroupHelper().returnToGroupsPage();
	}
}