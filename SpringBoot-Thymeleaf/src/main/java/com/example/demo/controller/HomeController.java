package com.example.demo.controller;

import com.example.bean.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;

@Controller
public class HomeController {
    @RequestMapping("/home/index")
    public String index(Model model) throws IOException {
        model.addAttribute("message", "Welcome to Thymeleaf");

        ObjectMapper mapper = new ObjectMapper();
        String path = "C:\\Users\\kn134\\Downloads\\Java-6-test\\SpringBoot-Thymeleaf\\src\\main\\resources\\static\\student.json";
        Student student = mapper.readValue(new File(path), Student.class);
        model.addAttribute("student", student);

        return "home/index";
    }
}
