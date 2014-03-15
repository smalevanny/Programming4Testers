package com.example.tests;

import org.testng.annotations.Test;

public class GroupModification extends TestBase {
	@Test
	public void modifySomeGroup() {
		app.getNavigationHelper().openMainPage();
		app.getGroupHelper().openGroupsPage();
		app.getGroupHelper().initGroupModification(1);
		GroupData group = new GroupData();
		group.name = "new_name";
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupModification();
		app.getGroupHelper().returnToGroupsPage();
	}
}
	
