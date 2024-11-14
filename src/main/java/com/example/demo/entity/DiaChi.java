package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "dia_chi")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class DiaChi {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "phuong_xa")
    private String phuongXa;

    @Column(name = "quan_huyen")
    private String quanHuyen;

    @Column(name = "thanh_pho")
    private String thanhPho;

    @Column(name = "ngay_tao")
    private String ngayTao;

    @Column(name = "ngay_cap_nhat")
    private String ngayCapNhat;

    @Column(name = "tinh_trang")
    private Boolean tinhTrang;

    @Column(name = "mo_ta")
    private String moTa;


}
