package com.example.NoteApp.Utility;

public class JWTresponse {
	
	String token;
	
	public JWTresponse() {}

	/**
	 * @param token
	 */
	public JWTresponse(String token) {
		super();
		this.token = token;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
	
	
	

}
