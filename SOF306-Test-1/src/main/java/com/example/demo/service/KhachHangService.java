package com.example.demo.service;

import com.example.demo.repository.KhachHangRepository;
import com.example.demo.service.impl.IKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KhachHangService implements IKhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepository;
}
