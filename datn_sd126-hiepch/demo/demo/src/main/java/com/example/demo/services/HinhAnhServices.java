package com.example.demo.services;

import com.example.demo.entity.HinhAnh;
import com.example.demo.entity.KhuyenMai;
import com.example.demo.entity.HinhAnh;
import com.example.demo.repostory.HinhAnhRepostory;
import com.example.demo.services.IPL.HinhAnhServicesIPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@Service
public class HinhAnhServices implements HinhAnhServicesIPL {

    @Autowired
    HinhAnhRepostory hinhAnhRepostory;

    @Override
    public HinhAnh saveHinhAnh(HinhAnh hinhAnh) {
        hinhAnh.setTinhTrang(1);
        return hinhAnhRepostory.save(hinhAnh);
    }

    @Override
    public boolean deleteHinhAnh(UUID id) {
        Optional<HinhAnh> optionalHinhAnh = hinhAnhRepostory.findById(id);
        if (optionalHinhAnh.isPresent()) {
            HinhAnh hinhAnh = optionalHinhAnh.get();
            if (hinhAnh.getTinhTrang() == 1) {
                hinhAnh.setTinhTrang(0);
                hinhAnhRepostory.save(hinhAnh);
                return true;
            }
        }
        return false;
    }

    @Override
    public HinhAnh updateHinhAnh(UUID id, HinhAnh newHinhAnhData) {
        Optional<HinhAnh> optionalHinhAnh = hinhAnhRepostory.findById(id);

        if (optionalHinhAnh.isPresent()) {
            HinhAnh existingHinhAnh = optionalHinhAnh.get();

            // Cập nhật các trường cần thiết
            existingHinhAnh.setMa(newHinhAnhData.getMa());
            existingHinhAnh.setTen(newHinhAnhData.getTen());
            existingHinhAnh.setId(newHinhAnhData.getId());
            existingHinhAnh.setUrlAnh1(newHinhAnhData.getUrlAnh1());
            existingHinhAnh.setUrlAnh2(newHinhAnhData.getUrlAnh2());
            existingHinhAnh.setUrlAnh3(newHinhAnhData.getUrlAnh3());
            existingHinhAnh.setNgayTao(newHinhAnhData.getNgayTao());
            existingHinhAnh.setNgayCapNhat(newHinhAnhData.getNgayCapNhat());
            existingHinhAnh.setMoTa(newHinhAnhData.getMoTa());

            // Lưu lại bản ghi đã được cập nhật
            return hinhAnhRepostory.save(existingHinhAnh);
        }

        return null; // Trả về null nếu không tìm thấy HinhAnh
    }
}
