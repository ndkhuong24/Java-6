package com.example.demo.controller;

import com.example.demo.bean.Student;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/demo")
public class StudentController {
    @GetMapping("/utilities")
    public String view(Model model) throws IOException {
        File file = new ClassPathResource("/static/students.json").getFile();
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Student>> type = new TypeReference<List<Student>>() {
        };
        List<Student> list = mapper.readValue(file, type);
        model.addAttribute("dssv", list);
        model.addAttribute("now", new Date());
        return "utilities";
    }
}
