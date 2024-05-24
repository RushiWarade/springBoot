package com.rushiwarade.attedancetrackerspringboot.service;

import com.rushiwarade.attedancetrackerspringboot.dao.UploadDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UploadService {

    @Autowired
    UploadDao uploadDao ;

}
