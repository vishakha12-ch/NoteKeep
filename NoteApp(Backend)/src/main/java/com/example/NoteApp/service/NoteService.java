package com.example.NoteApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.NoteApp.entity.Note;
import com.example.NoteApp.entity.User;
import com.example.NoteApp.repository.NoteRepo;
import com.example.NoteApp.repository.UserRepo;

@Service
public class NoteService {
	
	@Autowired
	private NoteRepo noterepo;
	
	@Autowired
	private UserRepo userrepo;
	
	public Note Addnote(Note note,String username) throws IllegalArgumentException{
		
		User user = userrepo.findByUsername(username);
		note.setUser(user);
		return noterepo.save(note);
	}
	
	public String Delete(int id) {
		
		 Note note = noterepo.findById(id);
		 noterepo.delete(note);
		 return "Notes deleted Successfuly";
		
	}
	
}
		
