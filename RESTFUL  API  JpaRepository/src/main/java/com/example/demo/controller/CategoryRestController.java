package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
public class CategoryRestController {
    @Autowired
    private CategoryReposiroty categoryReposiroty;

    @GetMapping("/rest/categories")
    public ResponseEntity<List<Category>> getAll(Model model) {
        return ResponseEntity.ok(categoryReposiroty.findAll());
    }

    @GetMapping("/rest/categories/{id}")
    public ResponseEntity<Category> getOne(@PathVariable("id") Long id, Model model) {
        if (!categoryReposiroty.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(categoryReposiroty.findById(id).get());
    }
}
