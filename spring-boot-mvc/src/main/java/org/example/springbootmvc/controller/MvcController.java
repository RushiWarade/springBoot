package org.example.springbootmvc.controller;

import org.example.springbootmvc.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class MvcController {
    @Autowired
    StudentDao studentDao;


    @RequestMapping(value = "/home")
    public String home() {

        return "home";
    }


}
