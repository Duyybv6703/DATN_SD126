package com.example.demo.service.impl;

import com.example.demo.entity.ChucVu;
import com.example.demo.repository.ChucVuRepository;
import com.example.demo.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ChucVuServiceimpl implements ChucVuService {

    @Autowired
    private ChucVuRepository chucVuRepository;


    @Override
    public Page<ChucVu> getData(Integer page) {
        Pageable pageable = PageRequest.of(page, 3);
        return chucVuRepository.findAll(pageable);
    }

    @Override
    public ChucVu getOne(String id) {
        return chucVuRepository.findById(UUID.fromString(id)).orElse(null);
    }

    @Override
    public void add(ChucVu chucVu) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(String id, ChucVu chucVu) {

    }
}
