package com.contactsapp.contactsapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.contactsapp.contactsapp.entities.Contact;

public interface ContactDao extends JpaRepository<Contact, Long> {

	List<Contact> findByFirstnameContainingIgnoreCase(String name);
//	List<Contact> findByFirstnameContainingIgnoreCase(String firstname);
//	List<Contact> findByPhoneNumbersContaing(String phoneNumber);
	List<Contact> findByPhoneNumbersContaining(String phoneNumber);
//	List<Contact> findByFirstNameContainingIgnoreCase(String name);
//	List<Contact> findByFirstNameContainingIgnoreCase(String name);
}
