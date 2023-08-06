package com.example.demo.service;

import com.example.demo.bean.KhachHang;
import com.example.demo.repository.KhachHangRepository;
import com.example.demo.service.impl.IKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class KhachHangService implements IKhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepository;

    @Override
    public List<KhachHang> getAll() {
        return khachHangRepository.findAll();
    }

    @Override
    public boolean existsById(BigDecimal maKhachHang) {
        return khachHangRepository.existsById(maKhachHang);
    }

    @Override
    public Optional<KhachHang> findById(BigDecimal maKhachHang) {
        return khachHangRepository.findById(maKhachHang);
    }
}
