package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "hang_san_pham")
public class HangSanPham {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(nullable = false, length = 30)
    private String ma;

    @Column(nullable = false, length = 50)
    private String ten;

    @Column(name = "xuat_su")
    private String xuatSu;

    @Column(name = "ngay_tao", columnDefinition = "DATE DEFAULT GETDATE()")
    private LocalDate ngayTao;

    @Column(name = "ngay_cap_nhat")
    private LocalDate ngayCapNhat;

    @Column(name = "tinh_trang")
    private Integer tinhTrang;

    @Column(name = "mo_ta")
    private String moTa;

    @OneToMany(mappedBy = "hangSanPham", cascade = CascadeType.ALL)
    private List<ChiTietSanPham> chiTietSanPhamList;
}
