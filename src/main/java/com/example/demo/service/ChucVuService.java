package com.example.demo.service;

import com.example.demo.entity.ChucVu;
import org.springframework.data.domain.Page;

public interface ChucVuService {

    Page<ChucVu> getData(Integer page);

    ChucVu getOne(String id);

    void add(ChucVu chucVu);

    void delete(String id);

    void update(String id, ChucVu chucVu);


}
