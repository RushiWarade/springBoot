package com.rushiwarade.thymeleafspringboot.controller;

import com.rushiwarade.thymeleafspringboot.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class MvcController {


    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("today", new Date());
        Student student = new Student(1, "Rushi", "Pune");
        model.addAttribute("student", student);


        return "index";
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        Student student1 = new Student(1, "Rushi", "Pune");
        Student student2 = new Student(2, "Rushikesh", "Nimbari");
        Student student3 = new Student(3, "Rushi warade", "Akurdi, pune");
        Student student4 = new Student(4, "Saurabh", "Mlk");
        Student student5 = new Student(5, "saurabh warade", "Pune");
        Student student6 = new Student(6, "shubham", "Datala");
        Student student7 = new Student(7, "Rushikesh warade", "Moshi, Pune");

        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);
        studentList.add(student6);
        studentList.add(student7);


        model.addAttribute("studentList", studentList);

        return "profile";
    }

}
