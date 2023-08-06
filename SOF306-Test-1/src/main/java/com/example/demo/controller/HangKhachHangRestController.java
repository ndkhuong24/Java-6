package com.example.demo.controller;

import com.example.demo.service.HangKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class HangKhachHangRestController {
    @Autowired
    private HangKhachHangService hangKhachHangService;
}
