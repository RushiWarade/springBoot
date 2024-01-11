package org.example.springbootjdbc.service;

import org.example.springbootjdbc.dao.StudentDao;
import org.example.springbootjdbc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentDao studentDao ;


    public void save(Student student){
        studentDao.save(student);
    }

}
