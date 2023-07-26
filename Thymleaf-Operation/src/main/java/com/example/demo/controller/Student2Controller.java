package com.example.demo.controller;

import com.example.demo.bean.Student;
import com.example.demo.bean.Student2;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/std")
public class Student2Controller {
    @GetMapping("/list")
    public String list(Model model,
                       @RequestParam("index") Optional<Integer> index) throws IOException {
        File file = new ClassPathResource("static/students.json").getFile();
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Student2>> type = new TypeReference<List<Student2>>() {};
        List<Student2> list = mapper.readValue(file, type);

        model.addAttribute("sv", list.get(index.orElse(0)));
        model.addAttribute("dssv", list);
        return "student/list";
    }
}
