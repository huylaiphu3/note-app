package com.example.demo4noteapp.service;

import com.example.demo4noteapp.entity.Note;

import java.util.List;

public interface NoteService {
    Note addNote(Note note);
    List<Note> findAllByUserId(int id);
    void deleteNoteById(int id);
}
