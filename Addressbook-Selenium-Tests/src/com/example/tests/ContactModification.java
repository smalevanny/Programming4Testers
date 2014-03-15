package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactModification extends TestBase {
	@Test
	public void modifySomeContact() {
		app.getNavigationHelper().openMainPage();
		
		//save old list
	    List<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    //actions
		app.getContactHelper().initContactUpdate(0);
		ContactData contact = new ContactData();
		contact.firstname = "Petrov";
		contact.lastname = "Petr";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactUpdate();
		app.getNavigationHelper().returnToMainPage();
		
		 //save new list
	    List<ContactData> newList = app.getContactHelper().getContacts();
	    
	    //compare states
	    oldList.remove(0);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    assertEquals(oldList, newList);
	}
}
