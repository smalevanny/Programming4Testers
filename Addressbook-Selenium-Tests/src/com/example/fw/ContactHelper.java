package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase{

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void fillContactForm(ContactData parameterObject) {
		type(By.name("firstname"), parameterObject.firstname);
		type(By.name("lastname"), parameterObject.lastname);
	    type(By.name("address"), parameterObject.address);
	    type(By.name("home"), parameterObject.homephone);
	    type(By.name("mobile"), parameterObject.mobilephone);
	    type(By.name("work"), parameterObject.workphone);
	    type(By.name("email"), parameterObject.email);
	    type(By.name("email2"), parameterObject.email2);
	    selectByText(By.name("bday"), parameterObject.bday);
	    selectByText(By.name("bmonth"), parameterObject.bmonth);
	    type(By.name("byear"), parameterObject.byear);
	    selectByText(By.name("new_group"), parameterObject.group);
	    type(By.name("address2"), parameterObject.address2);
	    type(By.name("phone2"), parameterObject.phone2);
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void initContactCreation() {
		click(By.linkText("add new"));
	}

	

	public void submitContactDeletion() {
		click(By.xpath("//input[@value='Delete']"));
		
	}

	public void initContactUpdate(int index) {
		index = index+1; 
		click(By.xpath("//tr[" + index + "]/td[7]"));
		
	}

	public void submitContactUpdate() {
		click(By.xpath("//input[@value='Update']"));
		
	}


}