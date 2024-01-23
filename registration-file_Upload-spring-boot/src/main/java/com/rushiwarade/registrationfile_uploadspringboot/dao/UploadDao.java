package com.rushiwarade.registrationfile_uploadspringboot.dao;

import com.rushiwarade.registrationfile_uploadspringboot.model.Register;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadDao extends CrudRepository<Register, Integer> {

    boolean existsByEmail(String email);

    Register findAllByEmailAndPassword(String email, String pass);
}
