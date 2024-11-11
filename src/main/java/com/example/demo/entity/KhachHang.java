package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Builder;


import java.util.Date;
import java.util.UUID;

@Table(name = "khach_hang")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder


public class KhachHang {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ho_ten")
    private String ho_ten;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "email")
    private String email;

    @Column(name = "gioi_tinh")
    private Boolean gioi_tinh;

    @Column(name = "ngay_sinh")
    private String ngay_sinh;

    @Column(name = "tai_khoan")
    private String tai_khoan;

    @Column(name = "mat_khau")
    private String mat_khau;

    @Column(name = "ngay_tao")
    private String ngay_tao;

    @Column(name = "ngay_cap_nhat")
    private String ngay_cap_nhat;

    @Column(name = "tinh_trang")
    private Boolean tinh_trang;


}
