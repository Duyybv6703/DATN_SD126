package com.example.demo.controller;

import com.example.demo.entity.KhachHang;
import com.example.demo.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class KhachHangController {


    @Autowired
    private KhachHangService khachHangService;

    @GetMapping("/khach-hang")
    public String hienThiKhachHang(@RequestParam(defaultValue = "0", name = "page") int page, Model model) {

        Page<KhachHang> khachHang = khachHangService.getData(page);

        model.addAttribute("hienthi", khachHang);

        return "khachhang";
    }

    @GetMapping("/khach-hang/detail/{id}")
    public String detail(@PathVariable("id") String id, Model model) {

        KhachHang khachHang = khachHangService.getOne(id);

        Page<KhachHang> khachHangs = khachHangService.getData(0);

        model.addAttribute("hienthi", khachHangs);

        model.addAttribute("detail", khachHang);

        return "khachhang";
    }

    @GetMapping("/khach-hang/remove/{id}")
    public String delete(@PathVariable("id") String id) {
        khachHangService.delete(id);
        return "redirect:/khach-hang";
    }


    @PostMapping("/khach-hang/add")
    public String add(
            @RequestParam("ma") String ma1,
            @RequestParam("hoten") String hoten1,
            @RequestParam("sdt") String sdt1,
            @RequestParam("email") String email1,
            @RequestParam("gioitinh") String gioitinh1,
            @RequestParam("ngaysinh") String ngaysinh1,
            @RequestParam("taikhoan") String taikhoan1,
            @RequestParam("matkhau") String matkhau1,
            @RequestParam("ngaytao") String ngaytao1,
            @RequestParam("ngaycapnhat") String ngaycapnhat1,
            @RequestParam("tinhtrang") String tinhtrang1
    ) {
        KhachHang khachHang = KhachHang.builder()
                .ma(ma1)
                .ho_ten(hoten1)
                .sdt(sdt1)
                .email(email1)
                .gioi_tinh(Boolean.valueOf(gioitinh1))
                .ngay_sinh(ngaysinh1)
                .tai_khoan(taikhoan1)
                .mat_khau(matkhau1)
                .ngay_tao(ngaytao1)
                .ngay_cap_nhat(ngaycapnhat1)
                .tinh_trang(Boolean.valueOf(tinhtrang1))
                .build();
        khachHangService.add(khachHang);

        return "redirect:/khach-hang";
    }

    @GetMapping("/khachhang/view-update/{id}")
    public String viewUpdate(@PathVariable("id") String id, Model model) {

        KhachHang khachHang = khachHangService.getOne(id);

        model.addAttribute("detail", khachHang);
        return "khachhang-update";
    }

    @PostMapping("/khach-hang/update")
    public String update(
            @RequestParam("ma") String ma1,
            @RequestParam("hoten") String hoten1,
            @RequestParam("sdt") String sdt1,
            @RequestParam("email") String email1,
            @RequestParam("gioitinh") String gioitinh1,
            @RequestParam("ngaysinh") String ngaysinh1,
            @RequestParam("taikhoan") String taikhoan1,
            @RequestParam("matkhau") String matkhau1,
            @RequestParam("ngaytao") String ngaytao1,
            @RequestParam("ngaycapnhat") String ngaycapnhat1,
            @RequestParam("tinhtrang") String tinhtrang1,
            @RequestParam("id") String id1

    ) {
        KhachHang khachHang = KhachHang.builder()
                .ma(ma1)
                .ho_ten(hoten1)
                .sdt(sdt1)
                .email(email1)
                .gioi_tinh(Boolean.valueOf(gioitinh1))
                .ngay_sinh(ngaysinh1)
                .tai_khoan(taikhoan1)
                .mat_khau(matkhau1)
                .ngay_tao(ngaytao1)
                .ngay_cap_nhat(ngaycapnhat1)
                .tinh_trang(Boolean.valueOf(tinhtrang1))
                .build();

        khachHangService.update(id1, khachHang);

        return "redirect:/khach-hang";

    }


}
