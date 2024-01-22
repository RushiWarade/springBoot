package org.example.springbootmvc.controller;

import jakarta.servlet.http.HttpSession;
import org.example.springbootmvc.dao.StudentDao;
import org.example.springbootmvc.model.Student;
import org.example.springbootmvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller

public class MvcController {


    @Autowired
    StudentService studentService;

    //    show showData page view by / url
//    localhost:8080/
    @RequestMapping(value = "/")
    public ModelAndView showData() {
        ModelAndView modelAndView = new ModelAndView();
        List<Student> studentList = (List<Student>) studentService.getAll();
//        System.out.println(studentList);
        modelAndView.addObject("allData", studentList);
        modelAndView.setViewName("showData");
        return modelAndView;
    }

    //    show login page view
    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }


    //    show the register page view
    @RequestMapping(value = "/signup")
    public String signup() {
        return "signup";
    }


    //    for redirect purpose create this url of editStudent it use in get mapping edit url
//    set the view of edit student
//    @RequestMapping(value = "/editStudent")
//    public String edit() {
//        return "editStudent";
//    }

    //    Login Student just check email and password is correct if correct redirect showStudent page else get error
    @RequestMapping(value = "/studentLogin")
    public String studentLogin(@RequestParam("email") String email, @RequestParam("password") String pass, HttpSession session) {
       /* System.out.println(email);
        System.out.println(pass);*/
        boolean b = studentService.emailExist(email);
        if (b) {
            Student student = studentService.findByEmailAndPassword(email, pass);
            if (student != null) {
                session.setAttribute("msg", "Student Login Successful");
                return "redirect:/";
            } else {
                session.setAttribute("msg", "Invalid Username or Password");
                return "redirect:/login";
            }
        } else {
            session.setAttribute("msg", "Invalid Email Id, This email id not exist in our database");
            return "redirect:/login";
        }
    }

    // Register Student
    @RequestMapping(value = "/register")
    public String register(@ModelAttribute Student student, HttpSession session) {
        String email = student.getEmail();
        boolean b = studentService.emailExist(email);
        if (b) {
            session.setAttribute("msg", email + " Id Already exist try with another email");
            return "redirect:/signup";
        } else {
            Student save = studentService.save(student);
            if (save != null) {
                session.setAttribute("msg", "Register Successfully");
                return "redirect:/";
            } else {
                session.setAttribute("msg", "Something wrong ");
                return "redirect:/signup";
            }
        }
    }

    // Get data by id
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model, HttpSession session) {
        Student student = studentService.findById(id);
//        System.out.println(student);
        model.addAttribute("student", student);
        model.addAttribute("student", student);
        return "editStudent";
    }

    //    update data by id
    @PostMapping("/edit/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute Student updatedStudent, HttpSession session) {
        Student save = studentService.save(updatedStudent);
//        System.out.println(save);
        if (save != null) {
            session.setAttribute("msg", "Student Updated Successfully.!!!");
            return "redirect:/";
        } else {
            session.setAttribute("msg", "Something went wrong.!!!");
            return "redirect:/";
        }
    }


    //    Delete Multiple entries
    @RequestMapping(value = "/batchDelete", method = RequestMethod.POST)
    public String multipleDelete(@RequestParam("selectedId") List<Integer> selectedUserId, HttpSession session) {
//        selectedUserId.forEach(System.out::println);
        for (Integer id : selectedUserId) {
            studentService.deleteById(id);
        }
        session.setAttribute("msg", "Selected data has been deleted");
        return "redirect:/";
    }


}
