package com.example.demo4noteapp.service;

import com.example.demo4noteapp.entity.User;

import java.util.Optional;

public interface UserService  {
     User addUser(User user);
     Optional<User> profile(int id);
     User findUserByUserName(String email);
     Optional<User> findUserById(int id);
}
