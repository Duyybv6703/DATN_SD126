package com.example.demo.services.IPL;

import com.example.demo.entity.Size;

import java.util.UUID;

public interface SizeServicesIPL {
        Size saveSize(Size size);
        boolean deleteSize(UUID id);
        Size updateSize(UUID id ,Size newSizeData);
}
