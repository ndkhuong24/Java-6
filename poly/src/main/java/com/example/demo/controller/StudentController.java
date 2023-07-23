package com.example.demo.controller;

import com.example.demo.bean.Student;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/student")
public class StudentController {
    @GetMapping
    private String index(Model model,
                         @RequestParam("index") Optional<Integer> index) throws IOException {
        //Đọc danh sách sinh viên từ file
        ObjectMapper mapper = new ObjectMapper();
        File path = ResourceUtils.getFile("C:\\Users\\kn134\\Downloads\\Java-6-test\\poly\\src\\main\\java\\com\\example\\demo\\bean\\students.json");
        TypeReference<List<Student>> typeReference = new TypeReference<>() {
        };
        List<Student> students = mapper.readValue(path, typeReference);
        int i = index.orElse(0);
        model.addAttribute("n", i);
        model.addAttribute("sv", students.get(i));
        return "scope/student";
    }
}
