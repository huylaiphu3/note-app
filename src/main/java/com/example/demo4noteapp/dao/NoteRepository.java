package com.example.demo4noteapp.dao;

import com.example.demo4noteapp.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note,Integer> {
    public void deleteById(int id);
}
