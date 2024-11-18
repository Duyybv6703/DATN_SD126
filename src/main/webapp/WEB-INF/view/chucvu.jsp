<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<html>
<head>
    <title>Table Chuc Vu</title>
</head>
<body>

<form action="/chuc-vu/add" method="post">
    <br> <br>
    Mã: <input type="text" name="ma" value="${detail.ma}">
    Tên chức vụ: <input type="text" name="ten" value="${detail.ten}">

    <br> <br>

    Tình Trạng:
    <input type="radio" name="tinhtrang" value="true" ${detail.tinhTrang == "Đang hoạt động" ? "checked" : ""}
           checked> Đang hoạt động
    <input type="radio" name="tinhtrang" value="false" ${detail.tinhTrang == "Không hoạt động" ? "checked" : ""}>
    Không hoạt động

    <br> <br>

    Ngày Tạo: <input type="date" name="ngaytao" value="${detail.ngayTao}">
    Ngày Cập Nhật: <input type="date" name="ngaycapnhat" value="${detail.ngayCapNhat}">

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
        <th>Tên Chức Vụ</th>
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
            <td>${hienthis.ten}</td>
            <td>${hienthis.ngayTao}</td>
            <td>${hienthis.ngayCapNhat}</td>
            <td>${hienthis.tinhTrang ? 'Hoạt động' : 'Không hoạt động'}</td>
            <td>${hienthis.moTa}</td>
            <td>
                <a class="btn btn-success" href="/chuc-vu/detail/${hienthis.id}">Detail</a>
                <a class="btn btn-danger" href="/chuc-vu/remove/${hienthis.id}">Delete</a>
                <a class="btn btn-primary" href="/chuc-vu/view-update/${hienthis.id}">Update</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<nav aria-label="Page navigation example">
    <ul class="pagination">
        <c:forEach begin="0" end="${hienthi.totalPages -1}" varStatus="loop">
            <li class="page-item"><a class="page-link" href="/chuc-vu?page=${loop.index}">${loop.index + 1}</a>
            </li>
        </c:forEach>
    </ul>
</nav>
</body>
</html>