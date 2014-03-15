package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class GroupRemoval extends TestBase {
	
	@Test
	public void deleteSomeGroup() {
		app.getNavigationHelper().openMainPage();
		app.getGroupHelper().openGroupsPage();
		
		// save old state
	    List<GroupData> oldList = app.getGroupHelper().getGroups();
	    
	    // Randomise group index
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    //actions
		app.getGroupHelper().deleteGroup(index);
		app.getGroupHelper().returnToGroupsPage();
		
		// save new state
	    List<GroupData> newList = app.getGroupHelper().getGroups();
	    
	    // compare both states    
	    oldList.remove(index);
	    Collections.sort(oldList);
	    assertEquals(newList, oldList);
	}
}