package com.example.demo.controller;

import com.example.demo.entity.ChatLieu;
import com.example.demo.repostory.ChatLieuRepostory;
import com.example.demo.services.ChatLieuServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/chatLieu")
public class ChatLieuController {


    @Autowired
    ChatLieuRepostory chatLieuRepostory;

    @Autowired
    ChatLieuServices chatLieuServices;

    @GetMapping("/hien-thi-page")
    public ResponseEntity<?> hienThiPage(@RequestParam(defaultValue = "0") Integer page) {

        Integer tinhTrang = 1;

        Pageable pageable = PageRequest.of(page, 5);
        Page<ChatLieu> chatLieuPage = chatLieuRepostory.getAllByTinhTrang(tinhTrang, pageable);

        return ResponseEntity.ok(chatLieuPage.getContent());
    }

    @PostMapping("/add")
    public ResponseEntity<ChatLieu> addChatLieu(@RequestBody ChatLieu chatLieu) {
        ChatLieu newChatLieu = chatLieuServices.saveChatLieu(chatLieu);
        return ResponseEntity.ok(newChatLieu);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteChatLieu(@PathVariable UUID id) {
        boolean deleted = chatLieuServices.deleteChatLieu(id);
        if (deleted) {
            return ResponseEntity.ok("Đã cập nhật tinhTrang về 0 thành công");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ChatLieu> updateChatLieu(@PathVariable UUID id, @RequestBody ChatLieu chatLieu) {
        ChatLieu updatedChatLieu = chatLieuServices.updateChatLieu(id, chatLieu);
        return updatedChatLieu != null ? ResponseEntity.ok(updatedChatLieu) : ResponseEntity.notFound().build();
    }
    
}
