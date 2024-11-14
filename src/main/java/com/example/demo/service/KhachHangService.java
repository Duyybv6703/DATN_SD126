package com.example.demo.service;

import com.example.demo.entity.KhachHang;
import org.springframework.data.domain.Page;

import java.util.List;


public interface KhachHangService {


    Page<KhachHang> getData(Integer page);

    KhachHang getOne(String id);

    void add(KhachHang khachHang);

    void delete(String id);

    void update(String id, KhachHang khachHang);

}
