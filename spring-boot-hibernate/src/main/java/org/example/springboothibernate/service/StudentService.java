package org.example.springboothibernate.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.springboothibernate.dao.StudentDao;
import org.example.springboothibernate.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentDao studentDao;

    public void save(Student student) {
        studentDao.save(student);
    }

    public boolean getById(int id) {
        return studentDao.existsById(id);
    }

    public Student findById(int id) {
        return studentDao.findById(id).orElse(null);
    }


    public int count() {
        return (int) studentDao.count();
    }


    public void deleteById(int id) {
          studentDao.deleteById(id);
    }

    public Student update(int id,Student update){
        Student student= studentDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found with id: " + id));

        // Update fields with new values
        student.setName(update.getName());
        student.setEmail(update.getEmail());
        student.setMobile(update.getMobile());

        return studentDao.save(student);
    }
}
