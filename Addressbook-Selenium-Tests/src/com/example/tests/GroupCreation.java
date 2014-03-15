package com.example.tests;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class GroupCreation extends TestBase {
  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getGroupHelper().openGroupsPage();
    
    // save old state
    List<GroupData> oldList = app.getGroupHelper().getGroups();
    
    // actions
    app.getGroupHelper().initGroupCreation();
    GroupData group = new GroupData();
    group.name = "Group1";
    group.header = "Header1";
    group.footer = "Footer";
	app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupsPage();
    
    // save new state
    List<GroupData> newList = app.getGroupHelper().getGroups();
    
    // compare both states    
    oldList.add(group);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
  }

}
