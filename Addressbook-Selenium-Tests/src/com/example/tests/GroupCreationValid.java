package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupCreationValid extends TestBase {
	
	
	@Test(dataProvider = "randomValidGroupGenerator")
	public void testGroupCreation(GroupData group) throws Exception {
    
		// save old state
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
    
		// actions
		app.getGroupHelper().createGroup(group);
		
    
		// save new state
		SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
    
		// compare both states    
		assertThat(newList, equalTo(oldList.withAdded(group)));
	}

}
