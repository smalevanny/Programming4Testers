package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupRemoval extends TestBase {
	
	@Test
	public void deleteSomeGroup() {
		app.getNavigationHelper().openMainPage();
		app.getGroupHelper().openGroupsPage();
		
		// save old state
	    List<GroupData> oldList = app.getGroupHelper().getGroups();
	    
	    // actions
		app.getGroupHelper().deleteGroup(0);
		app.getGroupHelper().returnToGroupsPage();
		
		 // save new state
	    List<GroupData> newList = app.getGroupHelper().getGroups();
	    
	    // compare both states    
	    oldList.remove(0);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}
}