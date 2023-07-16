package com.contactsapp.contactsapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Contact {

	@Id
	private long id;
	private String firstname;
	private String lastname;
	private String email;
	
	private String phoneNumbers;

	public Contact(long id, String firstname, String lastname, String email, String phoneNumbers) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phoneNumbers = phoneNumbers;
	}

	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(String phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", phoneNumbers=" + phoneNumbers + "]";
	} 
	
	
	
}
