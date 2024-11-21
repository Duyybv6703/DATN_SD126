<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="/nhan-vien/update?id=${detail.id}" method="post">

    <br> <br>
    Mã: <input type="text" name="ma" value="${detail.ma}">
    Họ Tên: <input type="text" name="hoten" value="${detail.hoTen}">

    <br> <br>

    SĐT: <input type="text" name="sdt" value="${detail.sdt}">

    Email: <input type="email" name="email" value="${detail.email}">

    Url ảnh: <input type="text" name="urlanh" value="${detail.urlAnh}">

    <br> <br>

    Gioi Tính:
    <select name="gioitinh">

        <option value="Nam" ${detail.gioiTinh == "Nam" ? "selected" : ""} >Nam</option>
        <option value="Nữ" ${detail.gioiTinh == "Nữ" ? "selected" : ""} >Nữ</option>
    </select>

    <br> <br>

    Tình Trạng:
    <input type="radio" name="tinhtrang" value="true" ${detail.tinhTrang == "Đang hoạt động" ? "checked" : ""}
           checked> Đang hoạt động
    <input type="radio" name="tinhtrang" value="false" ${detail.tinhTrang == "Không hoạt động" ? "checked" : ""}>
    Không hoạt động

    <br> <br>

    Ngày Sinh: <input type="date" name="ngaysinh" value="${detail.ngaySinh}">
    Quê quán: <input type="text" name="quequan" value="${detail.queQuan}">
    Cccd: <input type="text" name="cccd" value="${detail.cccd}">


    Ngày Tạo: <input type="date" name="ngaytao" value="${detail.ngayTao}">

    Ngày Cập Nhật: <input type="date" name="ngaycapnhat" value="${detail.ngayCapNhat}">


    <br> <br>

    Tài Khoản: <input type="text" name="taikhoan" value="${detail.taiKhoan}">
    Mật Khẩu: <input type="text" name="matkhau" value="${detail.matKhau}">

    <br> <br>
    <button class="btn btn-primary" type="submit">Update</button>

</form>