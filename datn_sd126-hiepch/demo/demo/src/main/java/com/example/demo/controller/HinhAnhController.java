package com.example.demo.controller;

import com.example.demo.entity.HinhAnh;
import com.example.demo.repostory.HinhAnhRepostory;
import com.example.demo.services.HinhAnhServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/hinhAnh")
public class HinhAnhController {
    @Autowired
    HinhAnhRepostory hinhAnhRepostory;

    @Autowired
    HinhAnhServices hinhAnhServices;

    @GetMapping("/hien-thi-page")
    public ResponseEntity<?> hienThiPage(@RequestParam(defaultValue = "0") Integer page) {

        Integer tinhTrang = 1;

        Pageable pageable = PageRequest.of(page, 5);
        Page<HinhAnh> hinhAnhPage = hinhAnhRepostory.getAllByTinhTrang(tinhTrang, pageable);

        return ResponseEntity.ok(hinhAnhPage.getContent());
    }

    @PostMapping("/add")
    public ResponseEntity<HinhAnh> addHinhAnh(@RequestBody HinhAnh hinhAnh) {
        HinhAnh newHinhAnh = hinhAnhServices.saveHinhAnh(hinhAnh);
        return ResponseEntity.ok(newHinhAnh);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteHinhAnh(@PathVariable UUID id) {
        boolean deleted = hinhAnhServices.deleteHinhAnh(id);
        if (deleted) {
            return ResponseEntity.ok("Đã cập nhật tinhTrang về 0 thành công");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<HinhAnh> updateHinhAnh(@PathVariable UUID id, @RequestBody HinhAnh hinhAnh) {
        HinhAnh updatedHinhAnh = hinhAnhServices.updateHinhAnh(id, hinhAnh);
        return updatedHinhAnh != null ? ResponseEntity.ok(updatedHinhAnh) : ResponseEntity.notFound().build();
    }
}
