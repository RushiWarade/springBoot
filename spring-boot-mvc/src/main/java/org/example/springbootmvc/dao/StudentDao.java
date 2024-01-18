package org.example.springbootmvc.dao;

import org.example.springbootmvc.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends CrudRepository<Student, Integer> {

    public Student findAllByEmailAndPassword(String email, String password);

    public boolean existsByEmail(String email);

}
