package com.rushiwarade.registrationfile_uploadspringboot.service;

import com.rushiwarade.registrationfile_uploadspringboot.dao.UploadDao;
import com.rushiwarade.registrationfile_uploadspringboot.model.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UploadService {
    @Autowired
    UploadDao uploadDao;


    public Register register(Register register) {
        return uploadDao.save(register);
    }

    public boolean validateEmail(String email) {
        return uploadDao.existsByEmail(email);
    }

    public Register validateUser(String email, String pass) {
        return uploadDao.findAllByEmailAndPassword(email, pass);
    }
/*
    public Optional<Register> profile(int id) {
        return uploadDao.findById(id);
    }
*/

}
