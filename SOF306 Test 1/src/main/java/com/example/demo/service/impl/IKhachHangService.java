package com.example.demo.service.impl;

import com.example.demo.bean.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.Optional;

public interface IKhachHangService {

    boolean existsById(BigDecimal maKhachHang);

    Optional<KhachHang> findById(BigDecimal maKhachHang);

    void save(KhachHang khachHang);

    void deleteById(BigDecimal maKhachHang);

    Page<KhachHang> getAll(Pageable pageable);
}
