package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactRemoval extends TestBase {
	@Test
	public void deleteSomeContact() {
		app.getNavigationHelper().openMainPage();
		
		//save old list
	    List<ContactData> oldList = app.getContactHelper().getContacts(); 
	    
	    //actions
	    app.getContactHelper().initContactUpdate(0);
	    app.getContactHelper().submitContactDeletion();
	    app.getNavigationHelper().returnToMainPage();
	    
	    //save new list
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    //compare states
	    oldList.remove(0);
	    Collections.sort(oldList);
	    assertEquals(oldList, newList);
	}

}
