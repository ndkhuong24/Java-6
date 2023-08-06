package com.example.demo.service;

import com.example.demo.repository.HangKhachHangRepository;
import com.example.demo.service.impl.IHangKhachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HangKhachHangService implements IHangKhachService {
    @Autowired
    private HangKhachHangRepository hangKhachHangRepository;
}
