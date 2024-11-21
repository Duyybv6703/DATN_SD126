package com.example.demo.controller;


import com.example.demo.entity.SanPham;
import com.example.demo.repostory.SanPhamRepostory;
import com.example.demo.services.SanPhamServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/sanPham")
public class SanPhamController {
    @Autowired
    SanPhamRepostory sanPhamRepostory;
    @Autowired
    SanPhamServices sanPhamServices;
    @GetMapping("/hien-thi-page")
    public ResponseEntity<?> hienThiPage(@RequestParam(defaultValue = "0") Integer page) {

        Integer tinhTrang = 1;

        Pageable pageable = PageRequest.of(page, 5);
        Page<SanPham> sanPhamPage = sanPhamRepostory.getAllByTinhTrang(tinhTrang, pageable);

        return ResponseEntity.ok(sanPhamPage.getContent());
    }
    @PostMapping("/add")
    public ResponseEntity<SanPham> addSanPham(@RequestBody SanPham sanPham) {
        SanPham newSanPham = sanPhamServices.saveSanPham(sanPham);
        return ResponseEntity.ok(newSanPham);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSanPham(@PathVariable UUID id) {
        boolean deleted = sanPhamServices.deleteSanPham(id);
        if (deleted) {
            return ResponseEntity.ok("Đã cập nhật tinhTrang về 0 thành công");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SanPham> updateSanPham(@PathVariable UUID id, @RequestBody SanPham sanPham) {
        SanPham updatedSanPham = sanPhamServices.updateSanPham(id, sanPham);
        return updatedSanPham != null ? ResponseEntity.ok(updatedSanPham) : ResponseEntity.notFound().build();
    }
}
