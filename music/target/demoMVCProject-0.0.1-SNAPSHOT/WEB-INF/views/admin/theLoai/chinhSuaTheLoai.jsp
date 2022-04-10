<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Chỉnh sửa thể loại</title>
<body>
	<h3>Chỉnh sửa thể loại: ${command.cateName}</h3>
	<form:form method="POST" action="/demoMVCProject/quan-tri/chinhSuaTheLoai/editsave">
		<form:hidden  path="cateId" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<!-- ten the loai -->
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
