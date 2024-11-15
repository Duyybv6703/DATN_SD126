<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="/dia-chi/update?id=${detail.id}" method="post">

    <br> <br>

    Mã: <input type="text" name="ma" value="${detail.ma}">
    Phường xã: <input type="text" name="phuongxa" value="${detail.phuongXa}">

    <br> <br>

    Quận huyện: <input type="text" name="quanhuyen" value="${detail.quanHuyen}">
    Thành phố: <input type="text" name="thanhpho" value="${detail.thanhPho}">

    <br> <br>

    Ngày Tạo: <input type="date" name="ngaytao" value="${detail.ngayTao}">
    Ngày Cập Nhật: <input type="date" name="ngaycapnhat" value="${detail.ngayCapNhat}">

    <br> <br>

    Tình Trạng:
    <input type="radio" name="tinhtrang" value="true" ${detail.tinhTrang == "Đang hoạt động" ? "checked" : ""}
           checked> Đang hoạt động
    <input type="radio" name="tinhtrang" value="false" ${detail.tinhTrang == "Không hoạt động" ? "checked" : ""}>
    Không hoạt động

    <br> <br>

    Mô tả: <input type="text" name="mota" value="${detail.moTa}">

    <br> <br>

    <button class="btn btn-primary" type="submit">Update</button>

</form>