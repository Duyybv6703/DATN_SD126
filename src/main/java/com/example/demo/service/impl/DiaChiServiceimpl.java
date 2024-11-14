package com.example.demo.service.impl;

import com.example.demo.entity.DiaChi;
import com.example.demo.repository.DiaChiRepository;
import com.example.demo.service.DiaChiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DiaChiServiceimpl implements DiaChiService {

    @Autowired
    private DiaChiRepository diaChiRepository;

    @Override
    public Page<DiaChi> getData(Integer page) {
        Pageable pageable = PageRequest.of(page, 3);
        return diaChiRepository.findAll(pageable);
    }

    @Override
    public DiaChi getOne(String id) {
        return null;
//                diaChiRepository.findById(UUID.fromString(id)).orElse(null);
    }

    @Override
    public void add(DiaChi diaChi) {
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(String id, DiaChi diaChi) {

    }
}