package com.example.demo4noteapp.service;

import com.example.demo4noteapp.dao.NoteRepository;
import com.example.demo4noteapp.dao.UserRepository;
import com.example.demo4noteapp.entity.Note;
import com.example.demo4noteapp.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService{
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public Note addNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    @Transactional
    public List<Note> findAllByUserId(int id) {
        User user = userRepository.findById(id).orElse(null);
        List<Note> notes = user.getNotes();
        return notes;
    }

    @Override
    public void deleteNoteById(int id) {
        noteRepository.deleteById(id);
    }
}
