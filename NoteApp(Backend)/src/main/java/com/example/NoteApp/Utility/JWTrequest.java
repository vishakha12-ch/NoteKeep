package com.example.NoteApp.Utility;

public class JWTrequest {
	
	String username;
	String password;
	
	public JWTrequest( ) {}

	/**
	 * @param username
	 * @param password
	 */
	public JWTrequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "JWTrequest [username=" + username + ", password=" + password + "]";
	}
	
	
	

}
