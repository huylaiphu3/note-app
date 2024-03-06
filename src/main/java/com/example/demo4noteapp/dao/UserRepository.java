package com.example.demo4noteapp.dao;

import com.example.demo4noteapp.entity.Note;
import com.example.demo4noteapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    public User findByEmail(String email);

}
