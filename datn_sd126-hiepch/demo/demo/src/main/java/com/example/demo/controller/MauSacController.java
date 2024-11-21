package com.example.demo.controller;

import com.example.demo.entity.KhuyenMai;
import com.example.demo.entity.MauSac;
import com.example.demo.repostory.MauSacRepostory;
import com.example.demo.services.MauSacServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/mauSac")
public class MauSacController {
    @Autowired
    MauSacRepostory mauSacRepostory;
    @Autowired
    MauSacServices mauSacServices;
    @GetMapping("/hien-thi-page")
    public ResponseEntity<?> hienThiPage(@RequestParam(defaultValue = "0") Integer page) {

        Integer tinhTrang = 1;

        Pageable pageable = PageRequest.of(page, 5);
        Page<MauSac> mauSacPage = mauSacRepostory.getAllByTinhTrang(tinhTrang, pageable);

        return ResponseEntity.ok(mauSacPage.getContent());
    }
    @PostMapping("/add")
    public ResponseEntity<MauSac> addMauSac(@RequestBody MauSac mauSac) {
        MauSac newMauSac = mauSacServices.saveMauSac(mauSac);
        return ResponseEntity.ok(newMauSac);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMauSac(@PathVariable UUID id) {
        boolean deleted = mauSacServices.deleteMauSac(id);
        if (deleted) {
            return ResponseEntity.ok("Đã cập nhật tinhTrang về 0 thành công");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MauSac> updateMauSac(@PathVariable UUID id, @RequestBody MauSac mauSac) {
        MauSac updatedMauSac = mauSacServices.updateMauSac(id, mauSac);
        return updatedMauSac != null ? ResponseEntity.ok(updatedMauSac) : ResponseEntity.notFound().build();
    }

}
