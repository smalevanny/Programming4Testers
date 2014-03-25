package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {
	
	protected static ApplicationManager app;	

	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();    
	  }
	
	@AfterTest
	public void tearDown() throws Exception {
		app.stop();	    
	  }
	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator () {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 5; i++) {
		GroupData group = new GroupData()
		.withName(generateRandomString())
		.withHeader(generateRandomString())
		.withFooter(generateRandomString());
		list.add(new Object[] {group});
		}
		return list.iterator();
	}
	
	

	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator () {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 5; i++) {
		ContactData contact = new ContactData()
		.withFirstName(generateRandomString())
		.withLastName(generateRandomString())
		.withAddress(generateRandomString())
		.withHomePhone(generateRandomPhone())
		.withMobilePhone(generateRandomPhone())
		.withWorkPhone(generateRandomPhone())
		.withEMail(generateRandomString() + "@email.ru")
		.withEMail2(generateRandomString() + "@email.ru")
		.withBDay("1")
		.withBMonth("January")
		.withBYear("1980")
		.withAddress2(generateRandomString())
		.withPhone2(generateRandomPhone());
		list.add(new Object[] {contact});
		}
		return list.iterator();
	}
	private String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt();
		}
	}
	
	private String generateRandomPhone() {
		Random rnd = new Random();
		int phone = 1000000 + rnd.nextInt(8999999);
		return String.valueOf(phone);
	}
	
}
