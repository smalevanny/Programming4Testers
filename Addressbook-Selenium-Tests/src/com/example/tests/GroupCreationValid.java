package com.example.tests;

import static com.example.tests.GroupDataGenerator.loadGroupsFromCSVFile;
import static com.example.tests.GroupDataGenerator.loadGroupsFromXMLFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class GroupCreationValid extends TestBase {
	
	@DataProvider
	public Iterator<Object[]> groupsFromFile() throws IOException {
		return wrapGroupDataForDataProvider(loadGroupsFromXMLFile(new File ("groups.xml"))).iterator();
	}
	

	@Test(dataProvider = "groupsFromFile")
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
