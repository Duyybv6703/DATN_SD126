package com.example.demo.service;

import com.example.demo.entity.KhachHang;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface KhachHangService {

    List<KhachHang> getAll();

    Page<KhachHang> getData(int page);

    KhachHang getOne(UUID id);

    void add(KhachHang khachHang);

    void delete(UUID id);
}
