package com.example.demo4noteapp.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import org.aspectj.weaver.ast.Not;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "about")
    private String about;
    @Column(name = "role")
    private String role;
    @Getter
    @OneToMany(mappedBy = "user")
    private List<Note> notes;
    public User(){

    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public void add(Note note){
        if (notes == null){
            notes = new ArrayList<>();
        }
        notes.add(note);
        note.setUser(this);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", about='" + about + '\'' +
                ", role='" + role + '\'' +
                ", notes=" + notes +
                '}';
    }
}
