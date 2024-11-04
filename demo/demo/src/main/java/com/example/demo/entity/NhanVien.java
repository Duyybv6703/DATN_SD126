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
@Table(name = "nhan_vien")
public class NhanVien {

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

    @Column(name = "url_anh")
    private String urlAnh;

    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;

    @Column(name = "ngay_sinh")
    private LocalDate ngaySinh;

    @Column(name = "que_quan")
    private String queQuan;

    @Column(length = 30)
    private String cccd;

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

    @ManyToOne
    @JoinColumn(name = "id_chuc_vu")
    private ChucVu chucVu;

    @OneToMany(mappedBy = "nhanVien", cascade = CascadeType.ALL)
    private List<HoaDon> hoaDonList;

    @OneToMany(mappedBy = "nhanVien", cascade = CascadeType.ALL)
    private List<DoiTra> doiTraList;
}
