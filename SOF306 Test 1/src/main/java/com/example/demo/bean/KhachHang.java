package com.example.demo.bean;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

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
    private BigDecimal maKhachHang;

    @Column(name = "tenkhachhang")
    @NotBlank(message = "Vui lòng nhập tên khách hàng")
    private String tenKhachHang;

//    @Column(name = "sinhnhat")
//    private Date sinhNhat;

    @Column(name = "sodienthoai")
    @NotBlank(message = "Vui lòng nhập số điện thoại")
    private String soDienThoai;

//    @Column(name = "email")
//    private String email;

    @Column(name = "gioitinh")
    private Boolean gioiTinh;

//    @Column(name = "chungminhthu")
//    private String chungMinhThu;
//
//    @Column(name = "socancuoc")
//    private String soCanCuoc;
//
//    @Column(name = "anhdaidien")
//    private String anhDaiDien;
//
//    @Column(name = "trangthai")
//    private Integer trangThai;
//
//    @Column(name = "diemtichluy")
//    private Integer diemTichLuy;

    @ManyToOne
    @JoinColumn(name = "hangkhachhang")
    private HangKhachHang hangKhachHang;

//    @OneToOne
//    @JoinColumn(name = "nguoigioithieu")
//    private KhachHang khachHang;
}
