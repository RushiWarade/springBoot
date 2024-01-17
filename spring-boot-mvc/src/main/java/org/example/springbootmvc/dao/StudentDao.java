package org.example.springbootmvc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {

    @Autowired
    HibernateTemplate hibernateTemplate ;


    public void add(){
        hibernateTemplate.findByExample(2);
    }
}
