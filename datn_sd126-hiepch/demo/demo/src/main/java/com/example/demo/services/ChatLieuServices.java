package com.example.demo.services;

import com.example.demo.entity.ChatLieu;
import com.example.demo.entity.ChatLieu;
import com.example.demo.repostory.ChatLieuRepostory;
import com.example.demo.repostory.ChatLieuRepostory;
import com.example.demo.services.IPL.ChatLieuServicesIPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@Service
public class ChatLieuServices implements ChatLieuServicesIPL {
    @Autowired
    ChatLieuRepostory chatLieuRepostory;

    @Override
    public ChatLieu saveChatLieu(ChatLieu chatLieu) {
        chatLieu.setTinhTrang(1);
        return chatLieuRepostory.save(chatLieu);
    }

    @Override
    public boolean deleteChatLieu(UUID id) {
        Optional<ChatLieu> optionalChatLieu = chatLieuRepostory.findById(id);
        if (optionalChatLieu.isPresent()) {
            ChatLieu chatLieu = optionalChatLieu.get();
            if (chatLieu.getTinhTrang() == 1) {
                chatLieu.setTinhTrang(0);
                chatLieuRepostory.save(chatLieu);
                return true;
            }
        }
        return false;
    }

    @Override
    public ChatLieu updateChatLieu(UUID id, ChatLieu newChatLieuData) {
        Optional<ChatLieu> optionalChatLieu = chatLieuRepostory.findById(id);

        if (optionalChatLieu.isPresent()) {
            ChatLieu existingChatLieu = optionalChatLieu.get();

            // Cập nhật các trường cần thiết
            existingChatLieu.setMa(newChatLieuData.getMa());
            existingChatLieu.setLoaiChatLieu(newChatLieuData.getLoaiChatLieu());
            existingChatLieu.setId(newChatLieuData.getId());
            existingChatLieu.setNgayTao(newChatLieuData.getNgayTao());
            existingChatLieu.setNgayCapNhat(newChatLieuData.getNgayCapNhat());
            existingChatLieu.setMoTa(newChatLieuData.getMoTa());

            // Lưu lại bản ghi đã được cập nhật
            return chatLieuRepostory.save(existingChatLieu);
        }

        return null; // Trả về null nếu không tìm thấy ChatLieu
    }
}
