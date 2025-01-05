package com.example.NoteApp.configuration;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.NoteApp.Utility.JWThelp;
import com.example.NoteApp.service.CustomerUserDetailService;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private CustomerUserDetailService customerservice;
	
	@Autowired
	private JWThelp jwttoken;
	
	/**
	 * This method checks the token whether it is valid or not then allow access to api's
	 * @Param HttpServletRequest for handling request
	 * @Param HttpservletResponse for response
	 * 
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain Chain)
			throws ServletException, IOException {
		final String requestTokenHeader =request.getHeader("Authorization");
		String username=null;
		String Token=null;

		if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer "))
		{
			Token=requestTokenHeader.substring(7);

			try {
				
				username=jwttoken.extractUsername(Token);

			}catch(IllegalArgumentException e) {
				System.out.print("token not found ");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

		UserDetails userDetials  =this.customerservice.loadUserByUsername(username);
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDetials,null,userDetials.getAuthorities());
			
			usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		
		}
		else
		{
			System.out.println("invalid token");
		}
		}
	
		Chain.doFilter(request,response);
	}


}
