package com.example.NoteApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.NoteApp.entity.CustomerUserDetails;
import com.example.NoteApp.entity.User;
import com.example.NoteApp.repository.UserRepo;

@Service
public class CustomerUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserRepo user;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = this.user.findByUsername(username);
		if(user==null) {
			System.out.print("user not found");
			throw new UsernameNotFoundException("User is not present.");
		}
		return new CustomerUserDetails(user);
	}
	

}
