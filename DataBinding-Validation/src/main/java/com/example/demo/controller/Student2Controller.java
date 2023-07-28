package com.example.demo.controller;

import com.example.demo.bean.Student2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student2")
public class Student2Controller {
    @GetMapping("/validation/form")
    public String form(Model model) {
        Student2 student2 = new Student2();
        model.addAttribute("student2", student2);
        return "student2/form";
    }

    @PostMapping("/validation/validate")
    public String save(Model model,
                       @Validated @ModelAttribute("student2") Student2 student2,
                       Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("message", "Vui lòng sửa các lỗi sau");
            return "student2/form";
        }
        return "student2/success";
    }
}
