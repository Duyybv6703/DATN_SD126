<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<html>
<head>
    <title>Table Khach Hang</title>
</head>
<body>

<form>
    <br> <br>
    Id: <input type="text" name="id" value="${detail.id}">
    <%--    <br> <br>--%>
    Mã: <input type="text" name="ma" value="${detail.ma}">
    <br> <br>
    Họ Tên: <input type="text" name="hoten" value="${detail.ho_ten}">
    <%--    <br> <br>--%>
    SĐT: <input type="text" name="sdt" value="${detail.sdt}">
    <br> <br>
    Email: <input type="email" name="email" value="${detail.email}">
    <%--    <br> <br>--%>
    Gioi Tính:
    <select name="gioitinh">

        <option value="Nam" ${detail.gioi_tinh == "Nam" ? "selected" : ""} >Nam</option>
        <option value="Nữ" ${detail.gioi_tinh == "Nữ" ? "selected" : ""} >Nữ</option>
        <%--        <c:forEach items="${khachhang}" var="kh">--%>
        <%--            <option value="${kh.id}" ${detail.id == kh.id ? "selected" : ""}>${kh.quocGia}</option>--%>
        <%--        </c:forEach>--%>
    </select>
    <br> <br>
    Ngày Sinh: <input type="date" name="ngaysinh" value="${detail.ngay_sinh}">
    <%--    <br> <br>--%>
    Tài Khoản: <input type="text" name="taikhoan" value="${detail.tai_khoan}">
    <br> <br>
    Mật Khẩu: <input type="text" name="matkhau" value="${detail.mat_khau}">
    <%--    <br> <br>--%>
    Ngày Tạo: <input type="date" name="ngaytao" value="${detail.ngay_tao}">
    <br> <br>
    Ngày Cập Nhật: <input type="date" name="ngaycapnhat" value="${detail.ngay_cap_nhat}">
    <%--    <br> <br>--%>
    Tình Trạng:

    <select name="tinh_trang">

        <option value="Hoạt động" ${detail.tinh_trang == "Hoạt động" ? "selected" : ""} >Hoạt động</option>
        <option value="Không hoạt động" ${detail.tinh_trang == "Không hoạt động" ? "selected" : ""} >Không hoạt động
        </option>
        <%--        <c:forEach items="${khachhang}" var="kh">--%>
        <%--            <option value="${kh.id}" ${detail.id == kh.id ? "selected" : ""}>${kh.quocGia}</option>--%>
        <%--        </c:forEach>--%>
    </select>


    <br> <br>


</form>


<table class="table">
    <thead>
    <tr>
        <th>STT</th>
        <th>Id</th>
        <th>Mã</th>
        <th>Họ Tên</th>
        <th>SĐT</th>
        <th>Email</th>
        <th>Gioi Tính</th>
        <th>Ngày Sinh</th>
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
            <td>${hienthis.id}</td>
            <td>${hienthis.ma}</td>
            <td>${hienthis.ho_ten}</td>
            <td>${hienthis.sdt}</td>
            <td>${hienthis.email}</td>
            <td>${hienthis.gioi_tinh ? 'Nam' : 'Nữ'}</td>
            <td>${hienthis.ngay_sinh}</td>
            <td>${hienthis.tai_khoan}</td>
            <td>${hienthis.mat_khau}</td>
            <td>${hienthis.ngay_tao}</td>
            <td>${hienthis.ngay_cap_nhat}</td>
            <td>${hienthis.tinh_trang ? 'Hoạt động' : 'Không hoạt động'}</td>
            <td>
                <a class="btn btn-success" href="/khach_hang/detail/${hienthis.id}">Detail</a>
                <a class="btn btn-danger" href="">Delete</a>
                <a class="btn btn-primary" href="">Update</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<nav aria-label="Page navigation example">
    <ul class="pagination">
        <c:forEach begin="0" end="${hienthi.totalPages}" varStatus="loop">
            <li class="page-item"><a class="page-link" href="/khach_hang?page=${loop.index}">${loop.index+1}</a>
            </li>
        </c:forEach>
    </ul>
</nav>

</body>
</html>