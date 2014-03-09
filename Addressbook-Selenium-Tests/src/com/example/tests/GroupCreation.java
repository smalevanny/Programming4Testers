package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreation extends TestBase {
  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getGroupHelper().openGroupsPage();
    app.getGroupHelper().initGroupCreation();
    GroupData group = new GroupData();
    group.name = "Group1";
    group.header = "Header1";
    group.footer = "Footer";
	app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupsPage();
  }

}
