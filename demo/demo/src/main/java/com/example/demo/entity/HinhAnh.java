package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "hinh_anh")
public class HinhAnh {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(nullable = false, length = 30)
    private String ma;

    @Column(nullable = false, length = 50)
    private String ten;

    @Column(name = "url_anh1")
    private String urlAnh1;

    @Column(name = "url_anh2")
    private String urlAnh2;

    @Column(name = "url_anh3")
    private String urlAnh3;

    @Column(name = "ngay_tao", columnDefinition = "DATE DEFAULT GETDATE()")
    private LocalDate ngayTao;

    @Column(name = "ngay_cap_nhat")
    private LocalDate ngayCapNhat;

    @Column(name = "tinh_trang")
    private Integer tinhTrang;

    @Column(name = "mo_ta", columnDefinition = "NVARCHAR(MAX)") // Sử dụng tên cột đúng trong SQL Server
    private String moTa;
}
