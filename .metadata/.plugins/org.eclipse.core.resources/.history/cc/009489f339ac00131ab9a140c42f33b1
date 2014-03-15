package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class EmptyGroupCreation extends TestBase {

	@Test
	  public void testEmptyGroupCreation() throws Exception {
	    app.getNavigationHelper().openMainPage();
	    app.getGroupHelper().openGroupsPage();
	    
	    // save old state
	    List<GroupData> oldList = app.getGroupHelper().getGroups();
	    
	    // actions
	    app.getGroupHelper().initGroupCreation();
	    GroupData group = new GroupData("", "", "");
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
