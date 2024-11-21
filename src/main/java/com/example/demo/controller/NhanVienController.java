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
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/nhan-vien/remove/{id}")
    public String delete(@PathVariable("id") String id) {
        nhanVienService.delete(id);
        return "redirect:/nhan-vien";
    }


    @PostMapping("/nhan-vien/add")
    public String add(
            @RequestParam("ma") String ma1,
            @RequestParam("hoten") String hoten1,
            @RequestParam("sdt") String sdt1,
            @RequestParam("email") String email1,
            @RequestParam("urlanh") String urlanh1,
            @RequestParam("gioitinh") String gioitinh1,
            @RequestParam("ngaysinh") String ngaysinh1,
            @RequestParam("quequan") String quequan1,
            @RequestParam("cccd") String cccd,
            @RequestParam("taikhoan") String taikhoan1,
            @RequestParam("matkhau") String matkhau1,
            @RequestParam("ngaytao") String ngaytao1,
            @RequestParam("ngaycapnhat") String ngaycapnhat1,
            @RequestParam("tinhtrang") String tinhtrang1
    ) {
        NhanVien nhanVien = NhanVien.builder()
                .ma(ma1)
                .hoTen(hoten1)
                .sdt(sdt1)
                .email(email1)
                .urlAnh(urlanh1)
                .gioiTinh(Boolean.valueOf(gioitinh1))
                .ngaySinh(ngaysinh1)
                .queQuan(quequan1)
                .cccd(cccd)
                .taiKhoan(taikhoan1)
                .matKhau(matkhau1)
                .ngayTao(ngaytao1)
                .ngayCapNhat(ngaycapnhat1)
                .tinhTrang(Boolean.valueOf(tinhtrang1))
                .build();
        nhanVienService.add(nhanVien);

        return "redirect:/nhan-vien";
    }

}
