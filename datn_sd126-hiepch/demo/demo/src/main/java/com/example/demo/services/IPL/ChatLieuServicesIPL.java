package com.example.demo.services.IPL;

import com.example.demo.entity.ChatLieu;

import java.util.UUID;

public interface ChatLieuServicesIPL {
    ChatLieu saveChatLieu(ChatLieu chatLieu);
    boolean deleteChatLieu(UUID id);
    ChatLieu updateChatLieu(UUID id ,ChatLieu newChatLieuData);
}
