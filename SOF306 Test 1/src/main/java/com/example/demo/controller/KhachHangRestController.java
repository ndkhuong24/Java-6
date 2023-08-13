package com.example.demo.controller;

import com.example.demo.bean.KhachHang;
import com.example.demo.service.impl.IKhachHangService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/khach-hang")
public class KhachHangRestController {
    @Autowired
    private IKhachHangService service;

    Page<KhachHang> khachHangPage;

    @GetMapping
    public ResponseEntity<List<KhachHang>> getAll(@RequestParam(defaultValue = "1") int page) {
        if (page < 1) page = 1;
        int pageNumber = page;
        int pageSize = 5;
        Pageable pageable = PageRequest.of(page - 1, 5);
        khachHangPage = service.getAll(pageable);
//        List<KhachHang> khachHangList = service.getAll()
//                .stream()
//                .skip(pageNumber * pageSize)
//                .limit(pageSize)
//                .collect(Collectors.toList());
        return ResponseEntity.ok(khachHangPage.getContent());
    }

    @GetMapping("/{maKhachHang}")
    public ResponseEntity<KhachHang> getOne(@PathVariable("maKhachHang") BigDecimal maKhachHang) {
        if (!service.existsById(maKhachHang)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(service.findById(maKhachHang).get());
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody @Valid KhachHang khachHang, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> list = bindingResult.getAllErrors();
            return ResponseEntity.ok(list);
        } else {
            if (service.existsById(khachHang.getMaKhachHang())) {
                return ResponseEntity.badRequest().build();
            }
            service.save(khachHang);
            return ResponseEntity.ok(khachHang);
        }
//        if (service.existsById(khachHang.getMaKhachHang())) {
//            return ResponseEntity.badRequest().build();
//        }
//        service.save(khachHang);
//        return ResponseEntity.ok(khachHang);
    }

    @DeleteMapping("/{maKhachHang}")
    public ResponseEntity<Void> delete(@PathVariable("maKhachHang") BigDecimal maKhachHang) {
        if (!service.existsById(maKhachHang)) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(maKhachHang);
        return ResponseEntity.ok().build();
    }
}
