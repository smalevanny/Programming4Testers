package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactRemoval extends TestBase {
	@Test
	public void deleteSomeContact() {
		app.getNavigationHelper().openMainPage();
		
		//save old list
	    List<ContactData> oldList = app.getContactHelper().getContacts(); 
	    
	    // Randomize contact index
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    //actions
	    app.getContactHelper().initContactUpdate(index);
	    app.getContactHelper().submitContactDeletion();
	    app.getNavigationHelper().returnToMainPage();
	    
	    //save new list
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    //compare states
	    oldList.remove(index);
	    Collections.sort(oldList);
	    assertEquals(oldList, newList);
	}

}
