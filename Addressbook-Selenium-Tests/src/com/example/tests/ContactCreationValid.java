package com.example.tests;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class ContactCreationValid extends TestBase {
  @Test(dataProvider = "randomValidContactGenerator")
  public void testContactCreation(ContactData contact) throws Exception {
    app.getNavigationHelper().openMainPage();
    
    //save old list
    List<ContactData> oldList = app.getContactHelper().getContacts(); 
    
    //actions
    app.getContactHelper().initContactCreation();
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
