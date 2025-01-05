package com.example.NoteApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.NoteApp.Utility.JWTresponse;
import com.example.NoteApp.Utility.JWThelp;
import com.example.NoteApp.Utility.JWTrequest;
import com.example.NoteApp.repository.UserRepo;
import com.example.NoteApp.service.CustomerUserDetailService;


@RestController
@CrossOrigin
public class TokenController {
	

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomerUserDetailService customerservice;
	
	@Autowired
	private JWThelp jwttoken;
	
	@Autowired
	private UserRepo userrepo;
	
	
	@PostMapping("/gettoken")
	public ResponseEntity<?> generateToken(@RequestBody JWTrequest request) throws Exception{
		authenticate(request.getUsername(),request.getPassword());
		
		UserDetails userdetail = this.customerservice.loadUserByUsername(request.getUsername());
		String token =this.jwttoken.generateToken(userdetail);
		return ResponseEntity.ok(new JWTresponse(token));
		
		
	}
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
		} catch(UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("invalid user");
		}
	}
	

}
