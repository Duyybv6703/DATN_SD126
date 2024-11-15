package com.example.demo.controller;


import com.example.demo.entity.DiaChi;
import com.example.demo.entity.KhachHang;
import com.example.demo.service.DiaChiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/dia-chi/detail/{id}")
    public String detail(@PathVariable("id") String id, Model model) {

        DiaChi diaChi = diaChiService.getOne(id);

        Page<DiaChi> diaChis = diaChiService.getData(0);

        model.addAttribute("hienthi", diaChis);

        model.addAttribute("detail", diaChi);

        return "diachi";
    }

    @PostMapping("/dia-chi/add")
    public String add(
            @RequestParam("ma") String ma1,
            @RequestParam("phuongxa") String phuongxa1,
            @RequestParam("quanhuyen") String quanhuyen1,
            @RequestParam("thanhpho") String thanhpho1,
            @RequestParam("ngaytao") String ngaytao1,
            @RequestParam("ngaycapnhat") String ngaycapnhat1,
            @RequestParam("tinhtrang") String tinhtrang1,
            @RequestParam("mota") String mota1
    ) {
        DiaChi diaChi = DiaChi.builder()
                .ma(ma1)
                .phuongXa(phuongxa1)
                .quanHuyen(quanhuyen1)
                .thanhPho(thanhpho1)
                .ngayTao(ngaytao1)
                .ngayCapNhat(ngaycapnhat1)
                .tinhTrang(Boolean.valueOf(tinhtrang1))
                .moTa(mota1)
                .build();
        diaChiService.add(diaChi);

        return "redirect:/dia-chi";
    }


}
