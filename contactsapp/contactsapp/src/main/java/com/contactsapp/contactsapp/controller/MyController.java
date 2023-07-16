package com.contactsapp.contactsapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.contactsapp.contactsapp.entities.Contact;
import com.contactsapp.contactsapp.services.ContactService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class MyController {
	
	@Autowired
	private ContactService contactService;

//	@GetMapping("/home")
//	public String home() {
//		return "Welcome to Contact Application";
//	}
//	
	
//	get the contacts
	@GetMapping("/contacts")
	public List<Contact> getContacts() {
		
		return this.contactService.getContacts();
		
	}
	
//	single contacts get
	@GetMapping("/contacts/{contactId}")
	public Contact getContact(@PathVariable String contactId) {
		return this.contactService.getContacts(Long.parseLong(contactId));
	}
	
	
	
	@GetMapping("contacts/search/name")
    public ResponseEntity<List<Contact>> searchContactsByName(@RequestParam String name) {
        List<Contact> contacts = contactService.searchContactsByName(name);
        return ResponseEntity.ok(contacts);
    }
	
	@GetMapping("contacts/search/phonenumber")
    public ResponseEntity<List<Contact>> searchContactsByPhoneNumber(@RequestParam String phoneNumber) {
        List<Contact> contacts = contactService.searchContactsByPhoneNumber(phoneNumber);
        return ResponseEntity.ok(contacts);
    }
	
//	contact add
	@PostMapping("/contacts")
	public Contact createContact(@RequestBody Contact contact) {
			return this.contactService.createContact(contact);
		
	}
	
//	update contact using put request
	@PutMapping("/contacts/{contactId}")
	public Contact updateContact(@RequestBody Contact contact) {
		return this.contactService.updateContact(contact);
	}
	
//	deleter the contact
	@DeleteMapping("/contacts/{contactId}")
	public ResponseEntity<HttpStatus> deleteContact(@PathVariable String contactId){
		try {
			this.contactService.deleteContact(Long.parseLong(contactId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
