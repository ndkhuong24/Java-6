package com.example.demo.controller;

import com.example.demo.bean.Student;
import com.example.demo.bean.StudentMap;
import com.example.demo.repository.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentDAO dao;

    @GetMapping("/index")
    public String index(Model model) {
        Student student = new Student("", "", 0.0, true, "VN");
        model.addAttribute("form", student);
        StudentMap map = dao.findAll();
        model.addAttribute("items", map);
        return "student/index";
    }

    @GetMapping("/edit/{key}")
    public String edit(Model model, @PathVariable("key") String key) {
        model.addAttribute("key", key);
        Student student = dao.findByKey(key);
        model.addAttribute("form", student);
        StudentMap map = dao.findAll();
        model.addAttribute("items", map);
        return "student/index";
    }

    @PutMapping("/update/{key}")
    public String update(Student student, @PathVariable("key") String key) {
        dao.update(key,student);
        return "redirect:/student/edit/"+key;
    }

    @PostMapping("/create")
    public String create(Student student) {
        dao.create(student);
        return "redirect:/student/index";
    }
}
