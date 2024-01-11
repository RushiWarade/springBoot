package org.example.springboothibernate.controller;

import org.example.springboothibernate.model.Student;
import org.example.springboothibernate.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService ;

    public void save(Student student){
        studentService.save(student);
    }


    public boolean getById(int id){
      return   studentService.getById(id);
    }

    public Student findById(int id) {
        return studentService.findById(id);
    }

    public int count(){
        return studentService.count();
    }


    public void deleteById(int id) {
        studentService.deleteById(id);
    }


    public Student update(int id,Student update){
        return studentService.update(id,update);
    }



}
