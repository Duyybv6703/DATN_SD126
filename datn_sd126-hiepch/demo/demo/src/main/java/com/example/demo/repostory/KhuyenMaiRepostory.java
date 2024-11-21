package com.example.demo.repostory;

import com.example.demo.entity.KhuyenMai;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface KhuyenMaiRepostory extends JpaRepository<KhuyenMai, UUID> {

//    Page<KhuyenMai> getAllByTinhTrang( Pageable pageable);

    Page<KhuyenMai> getAllByTinhTrang(Integer tinhTrang, Pageable pageable);

}
