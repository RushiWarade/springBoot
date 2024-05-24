package com.rushiwarade.bankingapplication.service;

import com.rushiwarade.bankingapplication.dao.UserDao;
import com.rushiwarade.bankingapplication.dto.UserDto;
import com.rushiwarade.bankingapplication.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface UserService {


    UserDto createAccount(UserDto userDto );

}
