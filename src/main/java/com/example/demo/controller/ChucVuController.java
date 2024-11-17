package com.example.demo.controller;


import com.example.demo.entity.ChucVu;
import com.example.demo.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChucVuController {

    @Autowired
    private ChucVuService chucVuService;


    @GetMapping("/chuc-vu")
    String loadChucVu(@RequestParam(defaultValue = "0", name = "page") int page, Model model) {

        Page<ChucVu> chucVu = chucVuService.getData(page);

        model.addAttribute("hienthi", chucVu);

        return "chucvu";


    }


}
