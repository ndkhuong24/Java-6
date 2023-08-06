package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminComtroller {
    @RequestMapping("/home")
    @ResponseBody
    public String home() {
        return "hello, admin!";
    }
}
