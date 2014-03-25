package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactCreationValid extends TestBase {
  @Test(dataProvider = "randomValidContactGenerator")
  public void testContactCreation(ContactData contact) throws Exception {
    
    //save old list
	SortedListOf<ContactData> oldList = app.getContactHelper().getContacts(); 
    
    //actions
    app.getContactHelper().createContact(contact);
    
    //save new list
    SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
    
    //compare states
    assertThat(newList, equalTo(oldList.withAdded(contact)));
  }
}
