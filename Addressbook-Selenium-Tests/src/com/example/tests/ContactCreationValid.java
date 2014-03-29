package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;
import static com.example.tests.ContactDataGenerator.loadContactsFromCSVFile;
import static com.example.tests.ContactDataGenerator.loadContactsFromXMLFile;

public class ContactCreationValid extends TestBase {
	
	@DataProvider
	public Iterator<Object[]> contactsFromFile() throws IOException {
	return wrapContactDataForDataProvider(loadContactsFromXMLFile(new File ("contacts.xml"))).iterator();
	}
	
	@Test(dataProvider = "contactsFromFile")
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
