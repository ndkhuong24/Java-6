package com.example.demo.repository;

import com.example.demo.bean.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, BigDecimal> {
}
