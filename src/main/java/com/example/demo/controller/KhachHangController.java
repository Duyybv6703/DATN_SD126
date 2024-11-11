package com.example.demo.controller;


import com.example.demo.entity.KhachHang;
import com.example.demo.repository.KhachHangRepository;
import com.example.demo.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
public class KhachHangController {

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Autowired
    private KhachHangService khachHangService;

    @GetMapping("/khach_hang")

    public String hienThiKhachHang(@RequestParam(defaultValue = "0", name = "page") int page, Model model) {

        Page<KhachHang> khachHang = khachHangService.getData(page);
        List<KhachHang> khachHangList = khachHangService.getAll();
        model.addAttribute("khachhang", khachHangList);
        model.addAttribute("hienthi", khachHang);

        return "khachhang";
    }

    @GetMapping("/khach_hang/detail/{id}")
    public String detail(@PathVariable("id") String id, Model model) {

        KhachHang khachHang = khachHangService.getOne(UUID.fromString(id));
        Page<KhachHang> khachHangs = khachHangService.getData(0);
        List<KhachHang> khachHangList = khachHangService.getAll();
        model.addAttribute("khachhang", khachHangList);

        model.addAttribute("hienthi", khachHangs);
        model.addAttribute("detail", khachHang);

        return "khachhang";
    }


}
