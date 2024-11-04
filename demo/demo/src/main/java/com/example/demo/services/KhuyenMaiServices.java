package com.example.demo.services;

import com.example.demo.entity.KhuyenMai;
import com.example.demo.repostory.KhuyenMaiRepostory;
import com.example.demo.services.IPL.KhuyenMaiServicesIPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class KhuyenMaiServices implements KhuyenMaiServicesIPL {

    @Autowired
    KhuyenMaiRepostory khuyenMaiRepostory;

    @Override
    public KhuyenMai saveKhuyenMai(KhuyenMai khuyenMai) {
        khuyenMai.setTinhTrang(1);
        return khuyenMaiRepostory.save(khuyenMai);
    }

    @Override
    public boolean deleteKhuyenMai(UUID id) {
        Optional<KhuyenMai> optionalKhuyenMai = khuyenMaiRepostory.findById(id);
        if (optionalKhuyenMai.isPresent()) {
            KhuyenMai khuyenMai = optionalKhuyenMai.get();
            if (khuyenMai.getTinhTrang() == 1) {
                khuyenMai.setTinhTrang(0);
                khuyenMaiRepostory.save(khuyenMai);
                return true;
            }
        }
        return false;
    }

    @Override
    public KhuyenMai updateKhuyenMai(UUID id, KhuyenMai newKhuyenMaiData) {
        Optional<KhuyenMai> optionalKhuyenMai = khuyenMaiRepostory.findById(id);

        if (optionalKhuyenMai.isPresent()) {
            KhuyenMai existingKhuyenMai = optionalKhuyenMai.get();

            // Cập nhật các trường cần thiết
            existingKhuyenMai.setMa(newKhuyenMaiData.getMa());
            existingKhuyenMai.setTen(newKhuyenMaiData.getTen());
            existingKhuyenMai.setNgayBatDau(newKhuyenMaiData.getNgayBatDau());
            existingKhuyenMai.setNgayKetThuc(newKhuyenMaiData.getNgayKetThuc());
            existingKhuyenMai.setLoaiGiamGia(newKhuyenMaiData.getLoaiGiamGia());
            existingKhuyenMai.setHinhThucGiamGia(newKhuyenMaiData.getHinhThucGiamGia());
            existingKhuyenMai.setSoTienGiam(newKhuyenMaiData.getSoTienGiam());
            existingKhuyenMai.setMoTa(newKhuyenMaiData.getMoTa());

            // Lưu lại bản ghi đã được cập nhật
            return khuyenMaiRepostory.save(existingKhuyenMai);
        }

        return null; // Trả về null nếu không tìm thấy KhuyenMai
    }
}
