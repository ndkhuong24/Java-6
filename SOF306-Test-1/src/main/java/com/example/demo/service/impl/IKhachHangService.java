package com.example.demo.service.impl;

import com.example.demo.bean.KhachHang;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IKhachHangService {
    List<KhachHang> getAll();

    boolean existsById(BigDecimal maKhachHang);

    Optional<KhachHang> findById(BigDecimal maKhachHang);

    void save(KhachHang khachHang);

    void deleteById(BigDecimal maKhachHang);
}
