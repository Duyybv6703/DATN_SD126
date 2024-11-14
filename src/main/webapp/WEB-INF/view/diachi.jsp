<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<html>
<head>
    <title>Table Dia Chi</title>
</head>
<body>

<form action="/dia-chi/add" method="post">
    <br> <br>
    Mã: <input type="text" name="ma" value="${detail.ma}">
    Phường xã: <input type="text" name="phuongxa" value="${detail.phuongXa}">

    <br> <br>

    Quận huyện: <input type="text" name="quanhuyen" value="${detail.quanHuyen}">
    Thành phố: <input type="email" name="thanhpho" value="${detail.thanhPho}">

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

    <button type="submit" class="btn btn-success">Add</button>
</form>


<table class="table">
    <thead>
    <tr>
        <th>STT</th>
        <th>Mã</th>
        <th>Phường Xã</th>
        <th>Quận Huyện</th>
        <th>Thành Phố</th>
        <th>Ngày Tạo</th>
        <th>Ngày Cập Nhật</th>
        <th>Tình Trạng</th>
        <th>Mô Tả</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${hienthi.content}" var="hienthis" varStatus="i">
        <tr>
            <td>${i.index + 1}</td>
            <td>${hienthis.ma}</td>
            <td>${hienthis.phuongXa}</td>
            <td>${hienthis.quanHuyen}</td>
            <td>${hienthis.thanhPho}</td>
            <td>${hienthis.ngayTao}</td>
            <td>${hienthis.ngayCapNhat}</td>
            <td>${hienthis.tinhTrang ? 'Hoạt động' : 'Không hoạt động'}</td>
            <td>${hienthis.moTa}</td>
            <td>
                <a class="btn btn-success" href="/khach-hang/detail/${hienthis.id}">Detail</a>
                <a class="btn btn-danger" href="/khach-hang/remove/${hienthis.id}">Delete</a>
                <a class="btn btn-primary" href="/khachhang/view-update/${hienthis.id}">Update</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<nav aria-label="Page navigation example">
    <ul class="pagination">
        <c:forEach begin="0" end="${hienthi.totalPages -1}" varStatus="loop">
            <li class="page-item"><a class="page-link" href="/dia-chi?page=${loop.index}">${loop.index + 1}</a>
            </li>
        </c:forEach>
    </ul>
</nav>

</body>
</html>