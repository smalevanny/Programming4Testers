package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class GroupModification extends TestBase {
	@Test
	public void modifySomeGroup() {
		app.getNavigationHelper().openMainPage();
		app.getGroupHelper().openGroupsPage();
		
		// save old state
	    List<GroupData> oldList = app.getGroupHelper().getGroups();
	    
	    // actions
		app.getGroupHelper().initGroupModification(0);
		GroupData group = new GroupData();
		group.name = "new_name";
		app.getGroupHelper().fillGroupForm(group);
		app.getGroupHelper().submitGroupModification();
		app.getGroupHelper().returnToGroupsPage();
		
		// save new state
	    List<GroupData> newList = app.getGroupHelper().getGroups();
	    
	    // compare both states 
	    oldList.remove(0);
	    oldList.add(group);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}
}
	
