package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PhieuGiaoHang")
public class PhieuGiaoHang {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "MaPhieuGiao")
    private UUID maPhieuGiao;

    @Column(name = "SdtNhan")
    private String sdtNhan;

    @Column(name = "PhiGiaoHang")
    private BigDecimal phiGiaoHang;

    @Column(name = "DiaChiGiao")
    private UUID diaChiGiao;

    @ManyToOne
    @JoinColumn(name = "HoaDonGiao")
    private HoaDon hoaDon;
}
