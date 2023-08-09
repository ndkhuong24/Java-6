package com.example.demo.service;

import com.example.demo.bean.HangKhachHang;
import com.example.demo.repository.HangKhachHangRepository;
import com.example.demo.service.impl.IHangKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HangKhachHangHangService implements IHangKhachHangService {
    @Autowired
    private HangKhachHangRepository hangKhachHangRepository;

    @Override
    public List<HangKhachHang> getAll() {
        return hangKhachHangRepository.findAll();
    }
}
