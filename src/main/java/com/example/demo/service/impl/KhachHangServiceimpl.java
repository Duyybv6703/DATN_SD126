package com.example.demo.service.impl;

import com.example.demo.entity.KhachHang;
import com.example.demo.repository.KhachHangRepository;
import com.example.demo.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class KhachHangServiceimpl implements KhachHangService {

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Override
    public List<KhachHang> getAll() {
        return khachHangRepository.findAll();
    }

    @Override
    public Page<KhachHang> getData(int page) {
        Pageable pageable = PageRequest.of(page, 3);
        return khachHangRepository.findAll(pageable);
    }

    @Override
    public KhachHang getOne(UUID id) {
        return khachHangRepository.findById(id).orElse(null);
    }

    @Override
    public void add(KhachHang khachHang) {

        khachHangRepository.save(khachHang);

    }

    @Override
    public void delete(UUID id) {
        khachHangRepository.deleteById(id);
    }
}
