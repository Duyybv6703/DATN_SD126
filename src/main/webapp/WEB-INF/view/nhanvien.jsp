<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<html>
<head>
    <title>Table Nhan Vien</title>
</head>
<body>

<form action="/nhan-vien/add" method="post">
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

    <button type="submit" class="btn btn-success">Add</button>
</form>


<table class="table">
    <thead>
    <tr>
        <th>STT</th>
        <th>Mã</th>
        <th>Họ Tên</th>
        <th>SĐT</th>
        <th>Email</th>
        <th>Url Ảnh</th>
        <th>Gioi Tính</th>
        <th>Ngày Sinh</th>
        <th>Quê quán</th>
        <th>CCCD</th>
        <th>Tài Khoản</th>
        <th>Mật Khẩu</th>
        <th>Ngày Tạo</th>
        <th>Ngày Cập Nhật</th>
        <th>Tình Trạng</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${hienthi.content}" var="hienthis" varStatus="i">
        <tr>
            <td>${i.index + 1}</td>
            <td>${hienthis.ma}</td>
            <td>${hienthis.hoTen}</td>
            <td>${hienthis.sdt}</td>
            <td>${hienthis.email}</td>
            <td>${hienthis.urlAnh}</td>
            <td>${hienthis.gioiTinh ? 'Nam' : 'Nữ'}</td>
            <td>${hienthis.ngaySinh}</td>
            <td>${hienthis.queQuan}</td>
            <td>${hienthis.cccd}</td>
            <td>${hienthis.taiKhoan}</td>
            <td>${hienthis.matKhau}</td>
            <td>${hienthis.ngayTao}</td>
            <td>${hienthis.ngayCapNhat}</td>
            <td>${hienthis.tinhTrang ? 'Hoạt động' : 'Không hoạt động'}</td>
            <td>
                <a class="btn btn-success" href="/nhan-vien/detail/${hienthis.id}">Detail</a>
                <a class="btn btn-danger" href="/nhan-vien/remove/${hienthis.id}">Delete</a>
                <a class="btn btn-primary" href="/khachhang/view-update/${hienthis.id}">Update</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<nav aria-label="Page navigation example">
    <ul class="pagination">
        <c:forEach begin="0" end="${hienthi.totalPages -1}" varStatus="loop">
            <li class="page-item"><a class="page-link" href="/nhan-vien?page=${loop.index}">${loop.index + 1}</a>
            </li>
        </c:forEach>
    </ul>
</nav>

</body>
</html>