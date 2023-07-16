package com.contactsapp.contactsapp.services;

import java.util.List;

import com.contactsapp.contactsapp.entities.Contact;

public interface ContactService {

	public List<Contact> getContacts();
	
	public Contact getContacts(long contactId);
	
	public Contact createContact(Contact contact);
	
	public Contact updateContact(Contact contact);
	
	public Contact deleteContact(long parseLong);

	public List<Contact> searchContactsByName(String name);

	public List<Contact> searchContactsByPhoneNumber(String phoneNumber);
}
