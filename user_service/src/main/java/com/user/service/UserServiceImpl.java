package com.user.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.user.entity.User;


@Service
public class UserServiceImpl implements UserService{

	//fake list
	List<User> list = Arrays.asList(
			new User(1311L,"Kumar Abhishek","2323235645"),
			new User(1312L,"Ashish","2323235315"),
			new User(1313L,"Rahul","2323232335")
			);
			
	
	public User getUser(Long id) {
		// TODO Auto-generated method stub
		return list.stream().filter(user->user.getUserId().equals(id)).findAny().orElse(null);
	}

	
}
