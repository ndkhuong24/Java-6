package com.example.demo.controller;

import com.example.demo.bean.Student;
import com.example.demo.bean.StudentMap;
import com.example.demo.repository.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student/index")
public class StudentController {
    @Autowired
    StudentDAO dao;

    @GetMapping
    public String index(Model model){
        Student student = new Student("","",0.0,true,"VN");
        model.addAttribute("form",student);
        StudentMap map = dao.findAll();
        model.addAttribute("items",map);
        return "student/index";
    }

    @GetMapping("/student/edit/{key}")
    public String edit(Model model, @PathVariable("key") String key){
        model.addAttribute("key",key);
        Student student = dao.findByKey(key);
        model.addAttribute("form",student);
        StudentMap map = dao.findAll();
        model.addAttribute("items",map);
        return "student/index";
    }
}
