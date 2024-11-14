package com.example.demo.controller;


import com.example.demo.entity.DiaChi;
import com.example.demo.service.DiaChiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DiaChiController {

    @Autowired
    private DiaChiService diaChiService;

    @GetMapping("/dia-chi")
    public String hienThiDiaChi(@RequestParam(defaultValue = "0", name = "page") Integer page, Model model) {

        Page<DiaChi> diaChi = diaChiService.getData(page);

        model.addAttribute("hienthi", diaChi);

        return "diachi";

    }


}
