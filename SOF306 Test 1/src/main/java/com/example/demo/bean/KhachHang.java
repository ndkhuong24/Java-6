package com.example.demo.bean;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "khachhang")
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "makhachhang")
    @NotNull(message = "Vui lòng nhập mã khách hàng")
    private BigDecimal maKhachHang;

    @Column(name = "tenkhachhang")
    @NotBlank(message = "Vui lòng nhập tên khách hàng")
    private String tenKhachHang;

    @Column(name = "sodienthoai")
    @NotBlank(message = "Vui lòng nhập số điện thoại")
    private String soDienThoai;

    @Column(name = "gioitinh")
    private Boolean gioiTinh;

    @ManyToOne
    @JoinColumn(name = "hangkhachhang")
    private HangKhachHang hangKhachHang;
}
