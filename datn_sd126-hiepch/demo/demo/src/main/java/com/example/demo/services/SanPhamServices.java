package com.example.demo.services;

import com.example.demo.entity.SanPham;
import com.example.demo.repostory.SanPhamRepostory;
import com.example.demo.services.IPL.SanPhamServicesIPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@Service
public class SanPhamServices implements SanPhamServicesIPL {
    @Autowired
    SanPhamRepostory sanPhamRepostory;

    @Override
    public SanPham saveSanPham(SanPham sanPham) {
        sanPham.setTinhTrang(1);
        return sanPhamRepostory.save(sanPham);
    }

    @Override
    public boolean deleteSanPham(UUID id) {
        Optional<SanPham> optionalSanPham = sanPhamRepostory.findById(id);
        if (optionalSanPham.isPresent()) {
            SanPham sanPham = optionalSanPham.get();
            if (sanPham.getTinhTrang() == 1) {
                sanPham.setTinhTrang(0);
                sanPhamRepostory.save(sanPham);
                return true;
            }
        }
        return false;
    }

    @Override
    public SanPham updateSanPham(UUID id, SanPham newSanPhamData) {
        Optional<SanPham> optionalSanPham = sanPhamRepostory.findById(id);

        if (optionalSanPham.isPresent()) {
            SanPham existingSanPham = optionalSanPham.get();

            // Cập nhật các trường cần thiết
            existingSanPham.setMa(newSanPhamData.getMa());
            existingSanPham.setTen(newSanPhamData.getTen());
            existingSanPham.setId(newSanPhamData.getId());
            existingSanPham.setChiTietSanPhamList(newSanPhamData.getChiTietSanPhamList());
            existingSanPham.setNgayTao(newSanPhamData.getNgayTao());
            existingSanPham.setNgayCapNhat(newSanPhamData.getNgayCapNhat());
            existingSanPham.setMoTa(newSanPhamData.getMoTa());

            // Lưu lại bản ghi đã được cập nhật
            return sanPhamRepostory.save(existingSanPham);
        }

        return null; // Trả về null nếu không tìm thấy SanPham
    }
}
