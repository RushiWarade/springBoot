package org.example.springbootmvc.service;

import org.example.springbootmvc.dao.StudentDao;
import org.example.springbootmvc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentDao studentDao;

    public List<Student> getAll() {
        return (List<Student>) studentDao.findAll();
    }

    public boolean emailExist(String email) {
        return studentDao.existsByEmail(email);
    }

}
