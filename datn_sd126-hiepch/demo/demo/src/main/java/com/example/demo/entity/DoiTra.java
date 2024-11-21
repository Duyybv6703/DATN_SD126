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
@Table(name = "doi_tra")
public class DoiTra {

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
    @JoinColumn(name = "id_hoa_don", nullable = false)
    private HoaDon hoaDon;

    @Column(name = "ngay_doi_tra")
    private LocalDate ngayDoiTra;

    @Column(name = "ngay_hoan_tra")
    private LocalDate ngayHoanTra;

    @Column(name = "ly_do_doi_tra")
    private String lyDoDoiTra;

    @Column(name = "tien_doi_tra")
    private BigDecimal tienDoiTra;

    @Column(name = "tinh_trang")
    private Integer tinhTrang;
}
