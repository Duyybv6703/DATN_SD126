package com.example.demo.repostory;

import com.example.demo.entity.HinhAnh;
import com.example.demo.entity.KhuyenMai;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HinhAnhRepostory  extends JpaRepository<HinhAnh, UUID> {
    Page<HinhAnh> getAllByTinhTrang(Integer tinhTrang, Pageable pageable);
}
