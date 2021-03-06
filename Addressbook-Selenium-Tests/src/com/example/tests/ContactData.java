package com.example.tests;

public class ContactData implements Comparable<ContactData>{
	private String id;
	private String firstname;
	private String lastname;
	private String address;
	private String homephone;
	private String mobilephone;
	private String workphone;
	private String email;
	private String email2;
	private String bday;
	private String bmonth;
	private String byear;
	private String group;
	private String address2;
	private String phone2;
//	private String fullname;

	public ContactData() {
		
	}
	public ContactData(String firstname, String lastname, String address,
			String homephone, String mobilephone, String workphone,
			String email, String email2, String bday, String bmonth,
			String byear, String group, String address2, String home2) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.homephone = homephone;
		this.mobilephone = mobilephone;
		this.workphone = workphone;
		this.email = email;
		this.email2 = email2;
		this.bday = bday;
		this.bmonth = bmonth;
		this.byear = byear;
		this.group = group;
		this.address2 = address2;
		this.phone2 = home2;
//		this.fullname = lastname + "" + firstname;
	}
	
	
	@Override
	public String toString() {
		return "ContactData [lastname=" + lastname + "]";
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result
//				+ ((lastname == null) ? 0 : lastname.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;
	}
	@Override
	public int compareTo(ContactData other) {
		return this.lastname.toLowerCase().compareTo(other.lastname.toLowerCase());
	}
	
	public ContactData withFirstName(String firstName) {
		this.firstname = firstName;
		return this;
	}
	
	public ContactData withId(String id) {
		this.id = id;
		return this;
	}
	public ContactData withLastName(String lastName) {
		this.lastname = lastName;
		return this;
	}
	public ContactData withAddress(String address) {
		this.address = address;
		return this;
	}
	
	public ContactData withAddress2(String address2) {
		this.address2 = address2;
		return this;
	}
	public ContactData withHomePhone(String homePhone) {
		this.homephone = homePhone;
		return this;
	}
	
	public ContactData withMobilePhone(String mobilePhone) {
		this.mobilephone = mobilePhone;
		return this;
	}
	
	public ContactData withWorkPhone(String workPhone) {
		this.workphone = workPhone;
		return this;
	}
	
	public ContactData withPhone2(String phone2) {
		this.phone2 = phone2;
		return this;
	}
	public ContactData withEMail(String email) {
		this.email = email;
		return this;
	}
	
	public ContactData withEMail2(String email2) {
		this.email2 = email2;
		return this;
	}
	public ContactData withBDay(String bday) {
		this.bday = bday;
		return this;
	}
	public ContactData withBMonth(String bmonth) {
		this.bmonth = bmonth;
		return this;
	}
	
	public ContactData withBYear(String byear) {
		this.byear = byear;
		return this;
	}
	public String getFirstname() {
		return firstname;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}
	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}
	public void setWorkphone(String workphone) {
		this.workphone = workphone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public void setBday(String bday) {
		this.bday = bday;
	}
	public void setBmonth(String bmonth) {
		this.bmonth = bmonth;
	}
	public void setByear(String byear) {
		this.byear = byear;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getLastname() {
		return lastname;
	}
	public String getAddress() {
		return address;
	}
	public String getHomephone() {
		return homephone;
	}
	public String getMobilephone() {
		return mobilephone;
	}
	public String getWorkphone() {
		return workphone;
	}
	public String getEmail() {
		return email;
	}
	public String getEmail2() {
		return email2;
	}
	public String getBday() {
		return bday;
	}
	public String getBmonth() {
		return bmonth;
	}
	public String getByear() {
		return byear;
	}
	public String getGroup() {
		return group;
	}
	public String getAddress2() {
		return address2;
	}
	public String getPhone2() {
		return phone2;
	}
	
}