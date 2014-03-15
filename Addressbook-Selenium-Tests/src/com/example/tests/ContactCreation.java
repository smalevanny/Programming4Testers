package com.example.tests;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class ContactCreation extends TestBase {
  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    
    //save old list
    List<ContactData> oldList = app.getContactHelper().getContacts(); 
    
    //actions
    app.getContactHelper().initContactCreation();
    ContactData contact = new ContactData();
    contact.firstname		= "Ivan";
    contact.lastname		= "Ivanov";
    contact.address			= "Ivanov str., 1, 30";
    contact.homephone		= "1234567";
    contact.mobilephone		= "2345678";
    contact.workphone		= "3456789";
    contact.email			= "ivanov@email.ru";
    contact.email2			= "ivanov2@email.ru";
    contact.bday			= "1";
    contact.bmonth			= "January";
    contact.byear			= "1980";
    contact.group			= "Rob";
    contact.address			= "Ivanov pr., 2, 305";
    contact.phone2			= "4567890";
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
