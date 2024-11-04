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
@Table(name = "khach_hang")
public class KhachHang {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(nullable = false, length = 50)
    private String ma;

    @Column(name = "ho_ten")
    private String hoTen;

    @Column(length = 15)
    private String sdt;

    @Column(length = 50)
    private String email;

    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;

    @Column(name = "ngay_sinh")
    private LocalDate ngaySinh;

    @Column(name = "tai_khoan")
    private String taiKhoan;

    @Column(name = "mat_khau")
    private String matKhau;

    @Column(name = "ngay_tao", columnDefinition = "DATE DEFAULT GETDATE()")
    private LocalDate ngayTao;

    @Column(name = "ngay_cap_nhat")
    private LocalDate ngayCapNhat;

    @Column(name = "tinh_trang")
    private Integer tinhTrang;

    @OneToMany(mappedBy = "khachHang")
    private List<DiaChi> diaChiList;

    @OneToMany(mappedBy = "khachHang")
    private List<GioHang> gioHangList;

    @OneToMany(mappedBy = "khachHang")
    private List<HoaDon> hoaDonList;

    @OneToMany(mappedBy = "khachHang")
    private List<DoiTra> doiTraList;
}
