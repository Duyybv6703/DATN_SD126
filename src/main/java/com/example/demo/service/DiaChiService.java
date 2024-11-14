package com.example.demo.service;

import com.example.demo.entity.DiaChi;
import org.springframework.data.domain.Page;

public interface DiaChiService {

    Page<DiaChi> getData(Integer page);

    DiaChi getOne(String id);

    void add(DiaChi diaChi);

    void delete(String id);

    void update(String id, DiaChi diaChi);
}
