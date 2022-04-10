<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Chỉnh sửa nghệ sỹ</title>
<body>
	<h3>Chỉnh sửa nghệ sỹ: ${command.artistName}</h3>
	<form:form method="POST" action="/demoMVCProject/quan-tri/chinhSuaNgheSy/editsave">
		<form:hidden  path="artistId" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<!-- ten nghe sy -->
		<div class="mb-3">
			<label for="artistName" class="form-label">Tên nghệ sỹ</label>
		    <form:input path="artistName" class="form-control" id="artistName"/>
		</div>
					
		<!-- anh nen -->
		<div class="mb-3">
		  <label for="artistAvatar" class="form-label">Chọn ảnh đại diện</label>
		  <input name="artistAvatar" class="form-control" type="file" id="artistAvatar">
		</div>
		
		<!-- ngay sinh -->
		<div class="mb-3">
			<label for="artistDoB" class="form-label">Ngày sinh</label>
		    <form:input path="artistDoB" class="form-control" id="artistDoB"/>
		</div>
		
		<!-- que quan -->
		<div class="mb-3">
			<label for="artistCountry" class="form-label">Quê quán</label>
		    <form:input path="artistCountry" class="form-control" id="artistCountry"/>
		</div>
		
		<div class="card-body">
			<!-- Luu nghe sy -->
			<input type="submit" value="Lưu" class="btn btn-primary"/>
			<!-- Huy -->
			<button type="button" class="btn btn-outline-danger" onclick="history.back()" style="margin-left: 30px">Hủy bỏ</button>
		</div>
	</form:form>	   
</body>
