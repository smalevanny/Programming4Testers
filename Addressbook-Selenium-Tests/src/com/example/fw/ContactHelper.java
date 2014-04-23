package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends WebDriverHelperBase{

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public ContactHelper createContact(ContactData contact) {
		manager.navigateTo().mainPage();
		initContactCreation();
		fillContactForm(contact);
	    submitContactCreation();
	    returnToMainPage();
	    manager.getModel().addContact(contact);
		return this;
	}
	
	public ContactHelper modifyContact(int index, ContactData contact) {
		initContactUpdate(index);
		fillContactForm(contact);
		submitContactUpdate();
		returnToMainPage();
		manager.getModel().removeContact(index).addContact(contact);
		return this;
	}
	
	public ContactHelper deleteContact(int index) {
		initContactUpdate(index);
	    submitContactDeletion();
	    returnToMainPage();
	    manager.getModel().removeContact(index);
		return this;
	}
	

	
	public SortedListOf<ContactData> getUIContacts() {
		SortedListOf<ContactData> contacts = new SortedListOf<ContactData>();
		manager.navigateTo().mainPage();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			String name = "";
			String title = checkbox.getAttribute("title");	
			String fullname = title.substring("Select (".length(), title.length() - ")".length());
			String[] initials = fullname.split(" ");
			if (!fullname.endsWith(" ")) {
				name = initials[1];
			}
			contacts.add(new ContactData().withLastName(name));
		}
		return contacts;
	}

//------------------------------------------------------------------------------------------------------

	

	public ContactHelper fillContactForm(ContactData contact) {
		type(By.name("firstname"), contact.getFirstname());
		type(By.name("lastname"), contact.getLastname());
	    type(By.name("address"), contact.getAddress());
	    type(By.name("home"), contact.getHomephone());
	    type(By.name("mobile"), contact.getMobilephone());
	    type(By.name("work"), contact.getWorkphone());
	    type(By.name("email"), contact.getEmail());
	    type(By.name("email2"), contact.getEmail2());
	    selectByText(By.name("bday"), contact.getBday());
	    selectByText(By.name("bmonth"), contact.getBmonth());
	    type(By.name("byear"), contact.getByear());
	    selectByText(By.name("new_group"), contact.getGroup());
	    type(By.name("address2"), contact.getAddress2());
	    type(By.name("phone2"), contact.getPhone2());
	    return this;
	}

	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		return this;
	}

	public ContactHelper initContactCreation() {
		click(By.linkText("add new"));
		return this;
	}

	

	public ContactHelper submitContactDeletion() {
		click(By.xpath("//input[@value='Delete']"));
		return this;
	}

	public ContactHelper initContactUpdate(int index) {
//		click(By.xpath("//tr[" + (index+2) + "]/td[7]"));
		click(By.xpath("(//img[@alt='Edit'])[" + (index+1) + "]"));
		return this;
	}

	public ContactHelper submitContactUpdate() {
		click(By.xpath("//input[@value='Update']"));
		return this;
	}

	
	public void returnToMainPage() {
		click(By.linkText("home page"));
	}
	
}
