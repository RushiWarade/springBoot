package org.example.springbootjdbc.controller;

import org.example.springbootjdbc.model.Student;
import org.example.springbootjdbc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class StudentController {


    @Autowired
    StudentService studentService;

    public void save(Student student) {
        studentService.save(student);
    }

}
