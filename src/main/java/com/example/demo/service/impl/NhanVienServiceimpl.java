package com.example.demo.service.impl;


import com.example.demo.entity.NhanVien;
import com.example.demo.repository.NhanVienRepository;
import com.example.demo.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NhanVienServiceimpl implements NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Override
    public Page<NhanVien> getData(Integer page) {
        Pageable pageable = PageRequest.of(page, 3);
        return nhanVienRepository.findAll(pageable);
    }

    @Override
    public NhanVien getOne(String id) {
        return nhanVienRepository.findById(UUID.fromString(id)).orElse(null);
    }

    @Override
    public void add(NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);

    }

    @Override
    public void delete(String id) {
        nhanVienRepository.deleteById(UUID.fromString(id));

    }

    @Override
    public void update(String id, NhanVien nhanVien) {

    }
}
