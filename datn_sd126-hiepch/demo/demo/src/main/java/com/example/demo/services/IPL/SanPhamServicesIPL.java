package com.example.demo.services.IPL;

import com.example.demo.entity.SanPham;

import java.util.UUID;

public interface SanPhamServicesIPL {
     SanPham saveSanPham(SanPham sanPham);

    boolean deleteSanPham(UUID id);
    SanPham updateSanPham(UUID id, SanPham newSanPhamData);
}
