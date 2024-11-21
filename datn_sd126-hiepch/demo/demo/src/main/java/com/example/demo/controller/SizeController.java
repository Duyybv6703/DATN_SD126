package com.example.demo.controller;

import com.example.demo.entity.Size;
import com.example.demo.repostory.SizeRepostory;
import com.example.demo.services.SizeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/size")
public class SizeController {
    @Autowired
    SizeRepostory sizeRepostory;
    @Autowired
    SizeServices sizeServices;
    @GetMapping("/hien-thi-page")
    public ResponseEntity<?> hienThiPage(@RequestParam(defaultValue = "0") Integer page) {

        Integer tinhTrang = 1;

        Pageable pageable = PageRequest.of(page, 5);
        Page<Size> sizePage = sizeRepostory.getAllByTinhTrang(tinhTrang, pageable);

        return ResponseEntity.ok(sizePage.getContent());
    }
    @PostMapping("/add")
    public ResponseEntity<Size> addSize(@RequestBody Size size) {
        Size newSize = sizeServices.saveSize(size);
        return ResponseEntity.ok(newSize);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSize(@PathVariable UUID id) {
        boolean deleted = sizeServices.deleteSize(id);
        if (deleted) {
            return ResponseEntity.ok("Đã cập nhật tinhTrang về 0 thành công");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Size> updateSize(@PathVariable UUID id, @RequestBody Size size) {
        Size updatedSize = sizeServices.updateSize(id, size);
        return updatedSize != null ? ResponseEntity.ok(updatedSize) : ResponseEntity.notFound().build();
    }
}
