package com.example.demo.controller;

import com.example.demo.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
    @GetMapping
    public String index(Model model) {
        model.addAttribute("bean", new Student());
        return "student/Student";
    }
}
