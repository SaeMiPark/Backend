package models;

import classes.Contact;

public class ContactManager {
	private Contact[] contacts=new Contact[10];
	private int index=0;
	
	public void addContact(Contact contact) {
		contacts[index++]=contact;
	}
	
	public Contact[] getContacts() {
		return contacts;
	}
	
	public int getIndex() {
		return index;
	}
	
	

}
