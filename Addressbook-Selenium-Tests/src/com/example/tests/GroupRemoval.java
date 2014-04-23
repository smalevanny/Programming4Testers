package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupRemoval extends TestBase {
	
	@Test
	public void deleteSomeGroup() {
		
		// save old state
		SortedListOf<GroupData> oldList = new SortedListOf<GroupData>(app.getHibernateHelper().listGroups());
	    
	    // Randomise group index
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    //actions
		app.getGroupHelper().deleteGroup(index);
		
		// save new state
		SortedListOf<GroupData> newList = app.getGroupHelper().getUIGroups();
	    
	    // compare both states    
	    assertThat(newList, equalTo(oldList.without(index)));
	}
}