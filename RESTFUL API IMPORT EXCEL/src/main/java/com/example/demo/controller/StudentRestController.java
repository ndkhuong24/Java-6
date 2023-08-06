package com.example.demo.controller;

import com.example.demo.bean.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentRestController {
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/rest/students")
    public Student post(@RequestBody Student student) {
        studentRepository.save(student);
        return student;
    }
}
