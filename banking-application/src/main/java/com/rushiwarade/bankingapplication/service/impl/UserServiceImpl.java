package com.rushiwarade.bankingapplication.service.impl;

import com.rushiwarade.bankingapplication.dao.UserDao;
import com.rushiwarade.bankingapplication.dto.UserDto;
import com.rushiwarade.bankingapplication.mapper.UserMapper;
import com.rushiwarade.bankingapplication.model.User;
import com.rushiwarade.bankingapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public UserDto createAccount(UserDto userDto) {

        User user = UserMapper.mapToUser(userDto);
        User savedUser = userDao.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }
}
