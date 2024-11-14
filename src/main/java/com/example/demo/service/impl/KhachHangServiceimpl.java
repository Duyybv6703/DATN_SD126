package com.example.demo.service.impl;

import com.example.demo.entity.KhachHang;
import com.example.demo.repository.KhachHangRepository;
import com.example.demo.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class KhachHangServiceimpl implements KhachHangService {

    @Autowired
    private KhachHangRepository khachHangRepository;



    @Override
    public Page<KhachHang> getData(Integer page) {
        Pageable pageable = PageRequest.of(page, 3);
        return khachHangRepository.findAll(pageable);
    }


    @Override
    public KhachHang getOne(String id) {
        return khachHangRepository.findById(UUID.fromString(id)).orElse(null);
    }

    @Override
    public void add(KhachHang khachHang) {

        khachHangRepository.save(khachHang);

    }


    @Override
    public void delete(String id) {
        khachHangRepository.deleteById(UUID.fromString(id));
    }

    @Override
    public void update(String id, KhachHang khachHang) {

        khachHang.setId(UUID.fromString(id));
        khachHangRepository.save(khachHang);

    }


}
