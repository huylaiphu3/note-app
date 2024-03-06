package com.example.demo4noteapp.service;

import com.example.demo4noteapp.dao.UserRepository;
import com.example.demo4noteapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> profile(int id) {
        return userRepository.findById(id);
    }

    @Override
    public User findUserByUserName(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> findUserById(int id) {
        return userRepository.findById(id);
    }
}
