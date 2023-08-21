package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/rest/categories")
    public ResponseEntity<Category> post(@RequestBody Category category) {
        if (categoryReposiroty.existsById(category.getId())) {
            return ResponseEntity.badRequest().build();
        }
        categoryReposiroty.save(category);
        return ResponseEntity.ok(category);
    }

    @PutMapping("/rest/categories/{id}")
    public ResponseEntity<Category> put(@PathVariable("id") Long id, @RequestBody Category category) {
        if (!categoryReposiroty.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        categoryReposiroty.save(category);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/rest/categories/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        if (!categoryReposiroty.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        categoryReposiroty.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
