package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {
	
	public static void main(String[] args) throws IOException {
		if (args.length < 3) {
			System.out.println("Please specify parameters: <amount of test data>, <file>, <format>");
			return;
		}
		int amount = Integer.parseInt(args[0]);
		File file =  new File(args[1]);
		String format = args[2];
		
		if (file.exists()) {
			System.out.println("File exists. Please delete it manually: " + file);
			return;
		}
		
		List<ContactData> contacts = generateRandomContacts(amount);
		if ("csv".equals(format)) {
			saveContactsToCSVFile(contacts, file);
		}
		else if ("xml".equals(format)) {
			saveContactsToXMLFile(contacts, file);
		}
		else {
			System.out.println("Unknown file format:" + format);
			return;
		}

	}
	
//--------------------------------------------------------------------------------------------------------

	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();
		for (int i = 0; i < amount; i++) {
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
		list.add(contact);
		}
		return list;
	}
	
//-----------------------------------------------------------------------------------------------------
	
	private static void saveContactsToCSVFile(List<ContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts) {
			writer.write(	contact.getFirstname()		+ "," + 
							contact.getLastname()		+ "," + 
							contact.getAddress()		+ "," + 
							contact.getHomephone()		+ "," + 
							contact.getMobilephone()	+ "," + 
							contact.getWorkphone() 		+ "," + 
							contact.getEmail() 			+ "," + 
							contact.getEmail2() 		+ "," + 
							contact.getBday() 			+ "," + 
							contact.getBmonth() 		+ "," +
							contact.getByear() 			+ "," +
							contact.getAddress2() 		+ "," +
							contact.getPhone2() 		+ "," + "!" + "\n");
		}
		writer.close();
	}

	private static void saveContactsToXMLFile(List<ContactData> contacts, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
	}
	
//--------------------------------------------------------------------------------------------------
	
		public static List<ContactData> loadContactsFromCSVFile(File file) throws IOException {
			List<ContactData> list = new ArrayList<ContactData>();
			FileReader reader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line = bufferedReader.readLine();
			while (line != null) {
				String[] part = line.split(",");
				ContactData contact = new ContactData()
					.withFirstName(part[0])
					.withLastName(part[1])
					.withAddress(part[2])
					.withHomePhone(part[3])
					.withHomePhone(part[4])
					.withWorkPhone(part[5])
					.withEMail(part[6])
					.withEMail2(part[7])
					.withBDay(part[8])
					.withBMonth(part[9])
					.withBYear(part[10])
					.withAddress2(part[11])
					.withPhone2(part[12]);
				line = bufferedReader.readLine();
				list.add(contact);
			}
			bufferedReader.close();
			return list;
		}

		public static List<ContactData> loadContactsFromXMLFile(File file) throws IOException {
			XStream xstream = new XStream();
			xstream.alias("contact", ContactData.class);
			return (List<ContactData>) xstream.fromXML(file);
		}


//-----------------------------------------------------------------------------------------------	


	private static String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt();
		}
	}

	private static String generateRandomPhone() {
		Random rnd = new Random();
		int phone = 1000000 + rnd.nextInt(8999999);
		return String.valueOf(phone);
	}

}