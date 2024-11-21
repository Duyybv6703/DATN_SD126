package com.example.demo.repostory;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.KhuyenMai;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChatLieuRepostory  extends JpaRepository<ChatLieu, UUID> {
    Page<ChatLieu> getAllByTinhTrang(Integer tinhTrang, Pageable pageable);

}
