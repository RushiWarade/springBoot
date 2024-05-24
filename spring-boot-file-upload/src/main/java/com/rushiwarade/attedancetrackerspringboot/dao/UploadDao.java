package com.rushiwarade.attedancetrackerspringboot.dao;

import com.rushiwarade.attedancetrackerspringboot.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadDao extends CrudRepository<Student,Integer> {
}
