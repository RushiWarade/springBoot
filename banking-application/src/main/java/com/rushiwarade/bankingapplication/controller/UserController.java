package com.rushiwarade.bankingapplication.controller;

import com.rushiwarade.bankingapplication.dto.UserDto;
import com.rushiwarade.bankingapplication.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bank")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserDto createAccount(@RequestBody UserDto userdto) {
        return userService.createAccount(userdto);
    }



}
