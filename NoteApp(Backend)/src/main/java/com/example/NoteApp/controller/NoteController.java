package com.example.NoteApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.NoteApp.entity.Note;
import com.example.NoteApp.entity.User;
import com.example.NoteApp.repository.NoteRepo;
import com.example.NoteApp.repository.UserRepo;
import com.example.NoteApp.service.NoteService;

@RestController
@CrossOrigin
public class NoteController {
	
	@Autowired
	private NoteRepo note;
	
	@Autowired
	private UserRepo users;
	
	@Autowired
	private NoteService noteservice;
	
	
	@PostMapping("/addnote/{username}")
	public ResponseEntity addnote(@RequestBody Note note ,@PathVariable("username") String username) throws Exception {
		try {
			Note notes = noteservice.Addnote(note,username);
			return ResponseEntity.ok(notes);
		}catch(Exception e) {
			throw new Exception(e.getMessage());	
		}
		
	}
	
	@GetMapping("/getnote/{username}")
	public ResponseEntity<List<Note>> getnote(@PathVariable("username") String username, @RequestParam(defaultValue ="0")int page ,@RequestParam(defaultValue="10") int size){
		 User user = users.findByUsername(username);
		 
		 if(user == null) {
			 return ResponseEntity.notFound().build();
		 }
		 Pageable pageable = PageRequest.of(page, size, Sort.by("timestamp").descending());
		 List<Note> notes = note.findByUserOrderByTimestampDesc(user, pageable);
		 
		 return ResponseEntity.ok(notes);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteNote(@PathVariable("id") int id) throws Exception{
		try {
			    noteservice.Delete(id);
		}catch(Exception e) {
			throw new Exception(e.getMessage());			
		}
		
	}
	
	@GetMapping("/currentuser/{username}")
	public User currentuser(@PathVariable("username") String username) {
		return users.findByUsername(username);
		
	}
	
	
	
	
	
}
