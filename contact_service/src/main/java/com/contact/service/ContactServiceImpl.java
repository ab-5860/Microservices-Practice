package com.contact.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.contact.entity.Contact;

@Service
public class ContactServiceImpl implements ContactService{

	//fake list of contacts
	List<Contact> list = Arrays.asList(
			new Contact(1L, "akash@gmail.com", "Akash",1311L),
			new Contact(2L, "anil@gmail.com", "Anil",1311L),
			new Contact(3L, "rohan@gmail.com", "Rohan",1312L)
			);
	
	public List<Contact> getContactsOfUser(Long userId) {
		return list.stream().filter(contact-> contact.getUserId().equals(userId)).collect(Collectors.toList());
	}



}
