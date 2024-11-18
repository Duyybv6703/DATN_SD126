package com.example.demo.controller;


import com.example.demo.entity.ChucVu;
import com.example.demo.entity.KhachHang;
import com.example.demo.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/chuc-vu/detail/{id}")
    public String detail(@PathVariable("id") String id, Model model) {

        ChucVu chucVu = chucVuService.getOne(id);

        Page<ChucVu> chucVus = chucVuService.getData(0);

        model.addAttribute("hienthi", chucVus);

        model.addAttribute("detail", chucVu);

        return "chucvu";
    }

    @GetMapping("/chuc-vu/remove/{id}")
    public String delete(@PathVariable("id") String id) {
        chucVuService.delete(id);
        return "redirect:/chuc-vu";
    }


    @PostMapping("/chuc-vu/add")
    public String add(
            @RequestParam("ma") String ma1,
            @RequestParam("ten") String ten1,
            @RequestParam("ngaytao") String ngaytao1,
            @RequestParam("ngaycapnhat") String ngaycapnhat1,
            @RequestParam("tinhtrang") String tinhtrang1,
            @RequestParam("mota") String mota1
    ) {
        ChucVu chucVu = ChucVu.builder()
                .ma(ma1)
                .ten(ten1)
                .ngayTao(ngaytao1)
                .ngayCapNhat(ngaycapnhat1)
                .tinhTrang(Boolean.valueOf(tinhtrang1))
                .moTa(mota1)
                .build();
        chucVuService.add(chucVu);

        return "redirect:/chuc-vu";
    }


}
