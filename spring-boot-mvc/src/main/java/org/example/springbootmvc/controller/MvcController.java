package org.example.springbootmvc.controller;

import jakarta.servlet.http.HttpSession;
import org.example.springbootmvc.dao.StudentDao;
import org.example.springbootmvc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller

public class MvcController {
    @Autowired
    StudentDao studentDao;


    @RequestMapping(value = "/home")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/signup")
    public String signup() {
        return "signup";
    }

    @RequestMapping(value = "/editStudent")
    public String edit() {
        return "editStudent";
    }

    @RequestMapping(value = "/studentLogin")
    public String studentLogin(@RequestParam("email") String email, @RequestParam("password") String pass) {
        System.out.println(email);
        System.out.println(pass);

        Student student = studentDao.findAllByEmailAndPassword(email, pass);
        System.out.println(student);

        return "redirect:/showData";
    }

    @RequestMapping(value = "/register")
    public String register(@ModelAttribute Student student, HttpSession session) {

        String email = student.getEmail();

        boolean b = studentDao.existsByEmail(email);

        if (b) {
            session.setAttribute("msg", email + " Id Already exist try with another email");
            return "redirect:/signup";
        } else {
            Student save = studentDao.save(student);
            if (save != null) {
                session.setAttribute("msg", "Register Successfully");
                return "redirect:/showData";
            } else {
                session.setAttribute("msg", "Something wrong ");
                return "redirect:/signup";
            }
        }
    }

    @RequestMapping(value = "/showData")
    public ModelAndView showData() {
        ModelAndView modelAndView = new ModelAndView();
        List<Student> studentList = (List<Student>) studentDao.findAll();
//        System.out.println(studentList);
        modelAndView.addObject("allData", studentList);
        modelAndView.setViewName("showData");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model, HttpSession session) {
        Student student = studentDao.findById(id).get();
//        System.out.println(student);
        model.addAttribute("student", student);
        session.setAttribute("student", student);
        return "redirect:/editStudent";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute Student updatedStudent, HttpSession session) {
        Student save = studentDao.save(updatedStudent);
//        System.out.println(save);

        if (save != null) {
            session.setAttribute("msg", "Student Updated Successfully.!!!");
            return "redirect:/showData";
        } else {
            session.setAttribute("msg", "Something went wrong.!!!");
            return "redirect:/showData";
        }
    }


    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") int id, HttpSession session) {
//        System.out.println(id);
        studentDao.deleteById(id);
        session.setAttribute("msg", "Data deleted Successfully of Id " + id);
        return ("redirect:/showData");
    }


    @RequestMapping(value = "/batchDelete", method = RequestMethod.POST)
    public String multipleDelete(@RequestParam("selectedId") List<Integer> selectedUserId) {
        selectedUserId.forEach(System.out::println);

        for (Integer id : selectedUserId) {
            studentDao.deleteById(id);
        }

        return "redirect:/showData";
    }


}
