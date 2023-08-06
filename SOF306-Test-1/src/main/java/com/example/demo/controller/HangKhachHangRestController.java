package com.example.demo.controller;

import com.example.demo.bean.HangKhachHang;
import com.example.demo.service.impl.IHangKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/sof306")
public class HangKhachHangRestController {
    @Autowired
    private IHangKhachHangService service;

    @GetMapping("/hang-khach-hang")
    public ResponseEntity<List<HangKhachHang>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
