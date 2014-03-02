package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreation extends TestBase {
  @Test
  public void testContactCreation() throws Exception {
    openMainpage();
    initContactCreation();
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
	fillContactForm(contact);
    submitContactCreation();
    returnToMainPage();
  }
}