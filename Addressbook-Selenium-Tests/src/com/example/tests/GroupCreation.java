package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreation extends TestBase {
  @Test
  public void testGroupCreation() throws Exception {
    openMainPage();
    openGroupsPage();
    initGroupCreation();
    GroupData group = new GroupData("Group1", "Header1", "Footer1");
    group.name = "Group1";
    group.header = "Header1";
    group.footer = "Footer";
	fillGroupForm(group);
    submitGroupCreation();
    returnToGroupsPage();
  }

}
