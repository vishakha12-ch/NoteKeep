package com.example.NoteApp.repository;

import org.springframework.stereotype.Repository;

import com.example.NoteApp.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
	
	public User findByUsernameAndPassword(String username, String password);
	public User findByUsername(String username);
	public User findByEmail(String email);
	public User findById(int id);

}
