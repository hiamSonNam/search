<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Tạo mới thể loại</title>
<body>
	<h3>Tạo mới thể loại</h3>
	<form:form method="post" action="luuTheLoai">
		<!-- ten The loai -->
		<div class="mb-3">
			<label for="cateName" class="form-label">Tên thể loại</label>
		    <form:input path="cateName" class="form-control" id="cateName"/>
		</div>
		
		<div class="card-body">
			<!-- Luu the loai -->
			<input type="submit" value="Lưu" class="btn btn-primary"/>
			<!-- Huy -->
			<button type="button" class="btn btn-outline-danger" onclick="history.back()" style="margin-left: 30px">Hủy bỏ</button>
		</div>
		
	</form:form>
</body>
