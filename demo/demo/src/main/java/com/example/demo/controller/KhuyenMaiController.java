package com.example.demo.controller;

import com.example.demo.entity.KhuyenMai;
import com.example.demo.repostory.KhuyenMaiRepostory;
import com.example.demo.services.KhuyenMaiServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/khuyenMai")
public class KhuyenMaiController {

    @Autowired
    KhuyenMaiRepostory khuyenMaiRepostory;

    @Autowired
    KhuyenMaiServices khuyenMaiServices;

    @GetMapping("/hien-thi-page")
    public ResponseEntity<?> hienThiPage(@RequestParam(defaultValue = "0") Integer page) {

        Integer tinhTrang = 1;

        Pageable pageable = PageRequest.of(page, 5);
        Page<KhuyenMai> khuyenMaiPage = khuyenMaiRepostory.getAllByTinhTrang(tinhTrang, pageable);

        return ResponseEntity.ok(khuyenMaiPage.getContent());
    }

    @PostMapping("/add")
    public ResponseEntity<KhuyenMai> addKhuyenMai(@RequestBody KhuyenMai khuyenMai) {
        KhuyenMai newKhuyenMai = khuyenMaiServices.saveKhuyenMai(khuyenMai);
        return ResponseEntity.ok(newKhuyenMai);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteKhuyenMai(@PathVariable UUID id) {
        boolean deleted = khuyenMaiServices.deleteKhuyenMai(id);
        if (deleted) {
            return ResponseEntity.ok("Đã cập nhật tinhTrang về 0 thành công");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<KhuyenMai> updateKhuyenMai(@PathVariable UUID id, @RequestBody KhuyenMai khuyenMai) {
        KhuyenMai updatedKhuyenMai = khuyenMaiServices.updateKhuyenMai(id, khuyenMai);
        return updatedKhuyenMai != null ? ResponseEntity.ok(updatedKhuyenMai) : ResponseEntity.notFound().build();
    }
}
