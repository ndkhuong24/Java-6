package com.example.demo.controller;

import com.example.demo.bean.KhachHang;
import com.example.demo.service.KhachHangService;
import com.example.demo.service.impl.IKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/khach-hang")
public class KhachHangRestController {
    @Autowired
    private IKhachHangService service;

    @GetMapping
    public ResponseEntity<List<KhachHang>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{maKhachHang}")
    public ResponseEntity<KhachHang> getOne(@PathVariable("maKhachHang") BigDecimal maKhachHang) {
        if (!service.existsById(maKhachHang)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(service.findById(maKhachHang).get());
    }
}
