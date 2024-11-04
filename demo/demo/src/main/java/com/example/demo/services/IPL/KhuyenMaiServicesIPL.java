package com.example.demo.services.IPL;

import com.example.demo.entity.KhuyenMai;

import java.util.UUID;

public interface KhuyenMaiServicesIPL {

    public KhuyenMai saveKhuyenMai(KhuyenMai khuyenMai);

    public boolean deleteKhuyenMai(UUID id);
    public KhuyenMai updateKhuyenMai(UUID id, KhuyenMai newKhuyenMaiData);

}
