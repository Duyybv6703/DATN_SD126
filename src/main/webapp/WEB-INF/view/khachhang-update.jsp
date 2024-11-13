<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="/khach-hang/update?id=${detail.id}" method="post">

    <br> <br>
    Mã: <input type="text" name="ma" value="${detail.ma}">
    Họ Tên: <input type="text" name="hoten" value="${detail.ho_ten}">

    <br> <br>

    SĐT: <input type="text" name="sdt" value="${detail.sdt}">
    Email: <input type="email" name="email" value="${detail.email}">

    <br> <br>

    Gioi Tính:
    <select name="gioitinh">

        <option value="Nam" ${detail.gioi_tinh == "Nam" ? "selected" : ""} >Nam</option>
        <option value="Nữ" ${detail.gioi_tinh == "Nữ" ? "selected" : ""} >Nữ</option>
        <%--        <c:forEach items="${khachhang}" var="kh">--%>
        <%--            <option value="${kh.id}" ${detail.id == kh.id ? "selected" : ""}>${kh.quocGia}</option>--%>
        <%--        </c:forEach>--%>
    </select>

    <br> <br>

    Tình Trạng:
    <input type="radio" name="tinhtrang" value="true" ${detail.tinh_trang == "Đang hoạt động" ? "checked" : ""}
           checked> Đang hoạt động
    <input type="radio" name="tinhtrang" value="false" ${detail.tinh_trang == "Không hoạt động" ? "checked" : ""}>
    Không hoạt động

    <br> <br>

    Ngày Sinh: <input type="date" name="ngaysinh" value="${detail.ngay_sinh}">
    Ngày Tạo: <input type="date" name="ngaytao" value="${detail.ngay_tao}">
    Ngày Cập Nhật: <input type="date" name="ngaycapnhat" value="${detail.ngay_cap_nhat}">

    <br> <br>

    Tài Khoản: <input type="text" name="taikhoan" value="${detail.tai_khoan}">
    Mật Khẩu: <input type="text" name="matkhau" value="${detail.mat_khau}">

    <br> <br>

    <button class="btn btn-primary" type="submit">Update</button>

</form>