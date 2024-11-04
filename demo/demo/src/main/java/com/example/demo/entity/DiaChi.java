package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Data
@Entity
@Table(name = "dia_chi")

public class DiaChi {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(nullable = false, length = 30)
    private String ma;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String quan;

    @Column(length = 50)
    private String huyen;

    @Column(name = "thanh_pho")
    private String thanhPho;

    @ManyToOne
    @JoinColumn(name = "id_khach_hang")
    private KhachHang khachHang;

    @Column(name = "ngay_tao", columnDefinition = "DATE DEFAULT GETDATE()")
    private LocalDate ngayTao;

    @Column(name = "ngay_cap_nhat")
    private LocalDate ngayCapNhat;

    @Column(name = "tinh_trang")
    private Integer tinhTrang;


    @Column(name = "mo_ta")
    private String moTa;
}
