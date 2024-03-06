package com.example.demo4noteapp.controller;

import com.example.demo4noteapp.entity.Note;
import com.example.demo4noteapp.entity.User;
import com.example.demo4noteapp.service.NoteService;
import com.example.demo4noteapp.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private NoteService noteService;
    @Autowired
    private UserService userService;
    @GetMapping("/home")
    public String home(){
        return "user/home";
    }
    @GetMapping("/profile")
    public String profile(){
        return "user/view_profile";
    }
    @GetMapping("/addNotes")
    public String addNotes(){
        return "user/add_notes";
    }
    @GetMapping("/listNotes")
    public String listNotes(Principal principal , Model model , HttpServletRequest request){
        User user = userService.findUserByUserName(principal.getName());
//        User user = userService.findUserByUserName(request.getUserPrincipal().getName());
        List<Note> notes = noteService.findAllByUserId(user.getId());
        model.addAttribute("notes",notes);
        return "user/view_notes";
    }
    @PostMapping("/saveNotes")
    @Transactional
    public String saveNotes(@RequestParam("title") String title, @RequestParam("content") String content, Model model , Principal principal){
        Note note = new Note();
        User user = userService.findUserByUserName(principal.getName());
        note.setTitle(title);
        note.setContent(content);
//        note.setUser(user);
        noteService.addNote(note);
        user.add(note);
        model.addAttribute("note",note);
        return "redirect:/user/addNotes";
    }
    @GetMapping("/deleteNote")
    public String deleteNote(@RequestParam("id") int id){
        noteService.deleteNoteById(id);
        return "redirect:/user/listNotes";
    }
}
