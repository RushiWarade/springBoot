package com.rushiwarade.enote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoteController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

@GetMapping("/add")
    public String add() {
        return "add";
    }

    @GetMapping("/view")
    public String view() {
        return "view";
    }

}
