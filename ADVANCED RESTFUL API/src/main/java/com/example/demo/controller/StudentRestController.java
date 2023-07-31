package com.example.demo.controller;

import com.example.demo.bean.Students;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest")
public class StudentRestController {
    @Autowired
    private StudentRepository repository;

    @GetMapping("/students")
    public List<Students> getAll(Model model) {
        return repository.findAll();
    }

    @GetMapping("/students/{email}")
    public Students getOne(@PathVariable("email") String email) {
        return repository.findById(email).get();
    }

    @PostMapping("/students")
    public Students post(@RequestBody Students students) {
        repository.save(students);
        return students;
    }

    @PutMapping("/students/{email}")
    public Students put(@PathVariable("email") String email,
                        @RequestBody Students students) {
        repository.save(students);
        return students;
    }

    @DeleteMapping("/students/{email}")
    public void delete(@PathVariable("email") String email) {
        repository.deleteById(email);
    }
}
