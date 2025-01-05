package com.example.NoteApp.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.NoteApp.entity.Note;
import com.example.NoteApp.entity.User;

public interface NoteRepo extends JpaRepository<Note,Integer> {
	public List<Note> findByUserOrderByTimestampDesc(User user, Pageable pageable);
	public List<Note> findByUser(User user);
	public List<Note> findFirst10ByOrderByTimestampDesc();
	public Note findById(int id);

}
