package com.example.demo.controller;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/scope")
public class ScopeController {
    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpSession session;

    @Autowired
    ServletContext servletContext;

    @GetMapping
    public String index(Model model){
        model.addAttribute("a","I am in Model");
        request.setAttribute("b","I am in Request Scope");
        session.setAttribute("c","I am in Session Scope");
        servletContext.setAttribute("d","I am in Application Scope");
        return "scope/index";
    }
}
