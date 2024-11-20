package com.example.demo.service;

import com.example.demo.entity.NhanVien;
import org.springframework.data.domain.Page;

public interface NhanVienService {

    Page<NhanVien> getData(Integer page);

    NhanVien getOne(String id);

    void add(NhanVien nhanVien);

    void delete(String id);

    void update(String id, NhanVien nhanVien);


}
