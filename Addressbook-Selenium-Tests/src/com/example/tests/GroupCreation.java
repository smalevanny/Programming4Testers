package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreation extends TestBase {
  @Test
  public void testGroupCreation() throws Exception {
    openMainPage();
    openGroupsPage();
    initGroupCreation();
    GroupData group = new GroupData();
    group.name = "Group1";
    group.header = "Header1";
    group.footer = "Footer";
	fillGroupForm(group);
    submitGroupCreation();
    returnToGroupsPage();
  }

}
