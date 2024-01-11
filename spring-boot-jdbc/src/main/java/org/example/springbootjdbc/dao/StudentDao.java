package org.example.springbootjdbc.dao;

import org.example.springbootjdbc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {

    @Autowired
    JdbcTemplate jdbcTemplate ;



    public void save(Student student){
        String query  = "insert into student (id,name,email,mobile) values (?,?,?,?)"  ;
        jdbcTemplate.update(query,ps -> {
            ps.setInt(1,student.getId());
            ps.setString(2,student.getName());
            ps.setString(3,student.getEmail());
            ps.setString(4,student.getMobile());
        });
    }



}
