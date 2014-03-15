package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class EmptyContactCreation extends TestBase {
  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    
    //save old list
    List<ContactData> oldList = app.getContactHelper().getContacts(); 
    
    //actions
    app.getContactHelper().initContactCreation();
    ContactData contact = new ContactData();
    contact.firstname		= "";
    contact.lastname		= "";
    contact.address			= "";
    contact.homephone		= "";
    contact.mobilephone		= "";
    contact.workphone		= "";
    contact.email			= "";
    contact.email2			= "";
    contact.group			= "";
    contact.address			= "";
    contact.phone2			= "";
	app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().returnToMainPage();
    
    //save new list
    List<ContactData> newList = app.getContactHelper().getContacts();
    
    //compare states
    oldList.add(contact);
    Collections.sort(oldList);
    assertEquals(oldList, newList);
    
  }
}
