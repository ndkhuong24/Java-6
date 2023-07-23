package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/scope")
public class ScopeController {
    @GetMapping
    public String index(Model model){
        model.addAttribute("a","I am in Model");
        return "scope/index";
    }
}
