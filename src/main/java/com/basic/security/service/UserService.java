package com.basic.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.basic.security.model.Users;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	Environment env;
	
	public UserService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		String user = env.getProperty("spring.security.user.name");
		String password = env.getProperty("spring.security.user.password");
		
		//Users users = new Users();
		//String userN = users.getUserName();
		//String userP = users.getUserPassword();
		
		UsersDetailsRetrieval userDetails = new UsersDetailsRetrieval(user, password);
		
		System.out.println("User Name ========> "+userDetails.getUsername());
		System.out.println("User Password ==========> "+userDetails.getPassword());
		
		return userDetails;
	}

}
