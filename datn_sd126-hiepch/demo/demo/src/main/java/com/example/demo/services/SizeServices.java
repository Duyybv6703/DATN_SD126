package com.example.demo.services;

import com.example.demo.entity.Size;
import com.example.demo.repostory.SizeRepostory;
import com.example.demo.services.IPL.SizeServicesIPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@Service
public class SizeServices implements SizeServicesIPL {
    @Autowired
    SizeRepostory sizeRepostory;

    @Override
    public Size saveSize(Size size) {
        size.setTinhTrang(1);
        return sizeRepostory.save(size);
    }

    @Override
    public boolean deleteSize(UUID id) {
        Optional<Size> optionalSize = sizeRepostory.findById(id);
        if (optionalSize.isPresent()) {
            Size Size = optionalSize.get();
            if (Size.getTinhTrang() == 1) {
                Size.setTinhTrang(0);
                sizeRepostory.save(Size);
                return true;
            }
        }
        return false;
    }

    @Override
    public Size updateSize(UUID id, Size newSizeData) {
        Optional<Size> optionalSize = sizeRepostory.findById(id);

        if (optionalSize.isPresent()) {
            Size existingSize = optionalSize.get();

            // Cập nhật các trường cần thiết
            existingSize.setMa(newSizeData.getMa());
            existingSize.setSize(newSizeData.getSize());
            existingSize.setId(newSizeData.getId());
            existingSize.setNgayTao(newSizeData.getNgayTao());
            existingSize.setNgayCapNhat(newSizeData.getNgayCapNhat());
            existingSize.setMoTa(newSizeData.getMoTa());

            // Lưu lại bản ghi đã được cập nhật
            return sizeRepostory.save(existingSize);
        }

        return null; // Trả về null nếu không tìm thấy Size
    }
}
