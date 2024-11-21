package com.example.demo.services.IPL;

import com.example.demo.entity.HinhAnh;
import com.example.demo.entity.KhuyenMai;

import java.util.UUID;

public interface HinhAnhServicesIPL {
    HinhAnh saveHinhAnh(HinhAnh hinhAnh);
    boolean deleteHinhAnh(UUID id);
    HinhAnh updateHinhAnh(UUID id, HinhAnh newHinhAnhData);
}
