package com.example.demo.repostory;

import com.example.demo.entity.KhuyenMai;
import com.example.demo.entity.Size;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SizeRepostory extends JpaRepository<Size, UUID> {
    Page<Size> getAllByTinhTrang(Integer tinhTrang, Pageable pageable);

}
