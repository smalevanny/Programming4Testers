package com.example.tests;

import org.testng.annotations.Test;

public class ContactModification extends TestBase {
	@Test
	public void modifySomeContact() {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactUpdate(1);
		ContactData contact = new ContactData();
		contact.firstname = "Petrov";
		contact.lastname = "Petr";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactUpdate();
		app.getNavigationHelper().returnToMainPage();
	}
}
