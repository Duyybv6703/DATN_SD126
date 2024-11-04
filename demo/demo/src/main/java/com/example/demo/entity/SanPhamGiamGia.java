package com.example.demo.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "san_pham_giam_gia")
public class SanPhamGiamGia {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_chi_tiet_san_pham", nullable = false)
    private ChiTietSanPham chiTietSanPham;

    @ManyToOne
    @JoinColumn(name = "id_khuyen_mai", nullable = false)
    private KhuyenMai khuyenMai;

    @Column(name = "tinh_trang")
    private Integer tinhTrang;

    @Column(name = "mo_ta")
    private String moTa;
}
