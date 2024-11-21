package com.example.demo.services.IPL;

import com.example.demo.entity.MauSac;

import java.util.UUID;

public interface MauSacServicesIPL {
    MauSac saveMauSac(MauSac mauSac);
    boolean deleteMauSac(UUID id);
    MauSac updateMauSac(UUID id , MauSac newMauSacData);
}
