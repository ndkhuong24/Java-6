package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hangkhachhang")
public class HangKhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mahang")
    private Integer maHang;

    @Column(name = "tenhang")
    private String tenHang;

//    @Column(name = "mota")
//    private String moTa;
//
//    @Column(name = "diemtoithieu")
//    private Integer diemToiThieu;
//
//    @Column(name = "trangthai")
//    private Integer trangThai;

    @JsonIgnore
    @OneToMany(mappedBy = "hangKhachHang")
    private List<KhachHang> khachHang;
}
