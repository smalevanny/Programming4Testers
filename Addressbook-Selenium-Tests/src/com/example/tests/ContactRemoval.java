package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactRemoval extends TestBase {
	@Test
	public void deleteSomeContact() {
		
		//save old list
		SortedListOf<ContactData> oldList = new SortedListOf<ContactData>(app.getHibernateHelper().listContacts());
	    
	    // Randomize contact index
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()-1);
	    
	    //actions
	    app.getContactHelper().deleteContact(index);

	    //save new list
	    SortedListOf<ContactData> newList = app.getContactHelper().getUIContacts();
	    
	    //compare states
	    assertThat(newList, equalTo(oldList.without(index)));
	}

}
