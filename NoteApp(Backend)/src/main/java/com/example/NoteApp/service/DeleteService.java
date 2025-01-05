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
public class DeleteService {
	
	@Autowired
	private NoteRepo noterepo;
	
	@Autowired
	private UserRepo userrepo;
	
	@Scheduled(cron ="0 0 * * * *")
	public void deleteoldnotes() {
		List<User> users = userrepo.findAll();
		for(User user : users) {
			Pageable pageable = PageRequest.of(0, 10, Sort.by("timestamp").descending());
			List<Note> recentnotes = noterepo.findByUserOrderByTimestampDesc(user, pageable);
			List<Note> deletenotes = noterepo.findByUser(user);
			deletenotes.removeAll(recentnotes);
			noterepo.deleteAll(deletenotes);
			
		}
				
	}

}
