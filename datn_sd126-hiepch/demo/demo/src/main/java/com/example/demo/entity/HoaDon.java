package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "hoa_don")
public class HoaDon {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(nullable = false, length = 50)
    private String ma;

    @ManyToOne
    @JoinColumn(name = "id_nhan_vien", nullable = false)
    private NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "id_khach_hang", nullable = false)
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "id_dia_chi", nullable = false)
    private DiaChi diaChi;

    @Column(name = "ten_khach_hang_nhan")
    private String tenKhachHangNhan;

    @Column(length = 50)
    private String sdt;

    @Column(name = "tong_tien")
    private BigDecimal tongTien;

    @Column(name = "ngay_tao", columnDefinition = "DATE DEFAULT GETDATE()")
    private LocalDate ngayTao;

    @Column(name = "ngay_cap_nhat")
    private LocalDate ngayCapNhat;

    @Column(name = "ngay_ship")
    private LocalDate ngayShip;

    @Column(name = "ngay_nhan")
    private LocalDate ngayNhan;

    @Column(name = "tinh_trang")
    private Integer tinhTrang;

    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String ghiChu;
}
