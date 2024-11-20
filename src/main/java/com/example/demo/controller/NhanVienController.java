package com.example.demo.controller;


import com.example.demo.entity.KhachHang;
import com.example.demo.entity.NhanVien;
import com.example.demo.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping("/nhan-vien")
    public String hienThiNhanVien(@RequestParam(defaultValue = "0", name = "page") int page, Model model) {

        Page<NhanVien> nhanVien = nhanVienService.getData(page);

        model.addAttribute("hienthi", nhanVien);

        return "nhanvien";
    }

    @GetMapping("/nhan-vien/detail/{id}")
    public String detail(@PathVariable("id") String id, Model model) {

        NhanVien nhanVien = nhanVienService.getOne(id);

        Page<NhanVien> nhanViens = nhanVienService.getData(0);

        model.addAttribute("hienthi", nhanViens);

        model.addAttribute("detail", nhanVien);

        return "nhanvien";
    }

}
