package com.example.tests;

import static com.example.tests.ContactDataGenerator.loadContactsFromXMLFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactCreationValid extends TestBase {
	
	@DataProvider
	public Iterator<Object[]> contactsFromFile() throws IOException {
	return wrapContactDataForDataProvider(loadContactsFromXMLFile(new File ("contacts.xml"))).iterator();
	}
	
	@Test(dataProvider = "contactsFromFile")
	public void testContactCreation(ContactData contact) throws Exception {
    
    //save old list
	SortedListOf<ContactData> oldList = new SortedListOf<ContactData>(app.getHibernateHelper().listContacts());
    
    //actions
    app.getContactHelper().createContact(contact);
    
    //save new list
    SortedListOf<ContactData> newList = app.getModel().getContacts();
    
    //compare states
    assertThat(newList, equalTo(oldList.withAdded(contact)));
    
    // check contacts or not
 		if (wantToCheck()) {
 			
 		// check contacts in DB
 			if ("yes".equals(app.getProperty("check.db"))) {
 				assertThat(app.getModel().getContacts(), equalTo(app.getHibernateHelper().listContacts()));	
 			}
 			
 		// check contacts in UI
 			if ("yes".equals(app.getProperty("check.ui"))) {
 				assertThat(app.getModel().getContacts(), equalTo(app.getContactHelper().getUIContacts()));
 			}
 		}
  }
}
