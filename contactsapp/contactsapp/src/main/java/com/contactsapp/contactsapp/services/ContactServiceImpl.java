package com.contactsapp.contactsapp.services;


import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contactsapp.contactsapp.dao.ContactDao;
import com.contactsapp.contactsapp.entities.Contact;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactDao contactDao;
	
//	private static final Contact Contact = null;
//	List<Contact> list;
	
	public ContactServiceImpl() {
//		list = new ArrayList<>();
//		list.add(new Contact(1, "Raj","Kumar", "raj123@gmail.com","9998877665"));
//		
//		list.add(new Contact(2, "Rahul", "Kumar", "rahul123@gmail.com","9988776655"));
		
		
	}

	@Override
	public List<Contact> getContacts() {
		
		return contactDao.findAll();
		
//		return list;
	}
	

	@Override
	public Contact getContacts(long contactId) {
		// TODO Auto-generated method stub
		
//		Contact c = null;
//		for(Contact contact:list) {
//			if(contact.getId()==contactId) {
//				c=contact;
//				break;
//			}
//		}
//		return c;
		
		return contactDao.findById(contactId).orElse(null);	
	}
	
	public List<Contact> searchContactsByName(String name) {
        return contactDao.findByFirstnameContainingIgnoreCase(name);
    }

	
	public List<Contact> searchContactsByPhoneNumber(String phoneNumber) {
        return contactDao.findByPhoneNumbersContaining(phoneNumber);
    }

	@Override
	public Contact createContact(Contact contact) {
		// TODO Auto-generated method stub
//		list.add(contact);
		
		return contactDao.save(contact);
	}
	
	

	@Override
	public Contact updateContact(Contact contact) {
		// TODO Auto-generated method stub
//		list.forEach(e ->{
//			if(e.getId() == contact.getId()) {
//				e.setFirstname(contact.getFirstname());
//				e.setLastname(contact.getLastname());
//				e.setEmail(contact.getEmail());
//				e.setPhoneNumbers(contact.getPhoneNumbers());
//			}
//		});
		
		return contactDao.save(contact);
	}

	@Override
	public com.contactsapp.contactsapp.entities.Contact deleteContact(long parseLong) {
		// TODO Auto-generated method stub
//		list = this.list.stream()
//			    .filter(e -> e.getId() != parseLong)
//			    .collect(Collectors.toList());

		Contact entity = contactDao.getOne(parseLong);
		contactDao.delete(entity);
//		return Contac	t;
		return entity;
	}
	
	

	
}
