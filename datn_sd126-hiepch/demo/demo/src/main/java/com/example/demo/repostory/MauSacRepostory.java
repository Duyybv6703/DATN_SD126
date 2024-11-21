package com.example.demo.repostory;

import com.example.demo.entity.KhuyenMai;
import com.example.demo.entity.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MauSacRepostory extends JpaRepository<MauSac,UUID> {
    Page<MauSac> getAllByTinhTrang(Integer tinhTrang, Pageable pageable);

}
