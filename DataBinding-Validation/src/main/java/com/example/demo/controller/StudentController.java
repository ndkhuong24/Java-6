package com.example.demo.controller;

import com.example.demo.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
    @GetMapping("/form")
    public String form(Model model){
        Student student = new Student();
        model.addAttribute("student",student);
        return "student/form";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("student")Student student){
        return "student/success";
    }
}
