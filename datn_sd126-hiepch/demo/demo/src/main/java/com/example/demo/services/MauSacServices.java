package com.example.demo.services;

import com.example.demo.entity.MauSac;
import com.example.demo.entity.MauSac;
import com.example.demo.repostory.MauSacRepostory;
import com.example.demo.services.IPL.MauSacServicesIPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@Service
public class MauSacServices implements MauSacServicesIPL {
    @Autowired
    MauSacRepostory mauSacRepostory;

    @Override
    public MauSac saveMauSac(MauSac mauSac) {
        mauSac.setTinhTrang(1);
        return mauSacRepostory.save(mauSac);
    }

    @Override
    public boolean deleteMauSac(UUID id) {
        Optional<MauSac> optionalMauSac = mauSacRepostory.findById(id);
        if (optionalMauSac.isPresent()) {
            MauSac mauSac = optionalMauSac.get();
            if (mauSac.getTinhTrang() == 1) {
                mauSac.setTinhTrang(0);
                mauSacRepostory.save(mauSac);
                return true;
            }
        }
        return false;
    }

    @Override
    public MauSac updateMauSac(UUID id, MauSac newMauSacData) {
        Optional<MauSac> optionalMauSac = mauSacRepostory.findById(id);

        if (optionalMauSac.isPresent()) {
            MauSac existingMauSac = optionalMauSac.get();

            // Cập nhật các trường cần thiết
            existingMauSac.setMa(newMauSacData.getMa());
            existingMauSac.setTen(newMauSacData.getTen());
            existingMauSac.setId(newMauSacData.getId());
            existingMauSac.setNgayTao(newMauSacData.getNgayTao());
            existingMauSac.setNgayCapNhat(newMauSacData.getNgayCapNhat());
            existingMauSac.setMoTa(newMauSacData.getMoTa());

            // Lưu lại bản ghi đã được cập nhật
            return mauSacRepostory.save(existingMauSac);
        }

        return null; // Trả về null nếu không tìm thấy MauSac
    }
    }

