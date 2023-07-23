package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/operator")
public class OperationController {
    @GetMapping
    public String demo(Model model) {
        model.addAttribute("x",5);
        model.addAttribute("y",7);
        return "thymeleaf-operator/operator";
    }
}
