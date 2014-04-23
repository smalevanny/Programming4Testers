package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactModification extends TestBase {
	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContact(ContactData contact) {
		
		//save old list
		SortedListOf<ContactData> oldList = new SortedListOf<ContactData>(app.getHibernateHelper().listContacts());
	    
	    // Randomize contact index
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    //actions
		app.getContactHelper().modifyContact(index, contact);
		
		 //save new list
		SortedListOf<ContactData> newList = app.getContactHelper().getUIContacts();
	    
	    //compare states
	    assertThat(newList, equalTo(oldList.without(index).withAdded(contact)));
	}
}
