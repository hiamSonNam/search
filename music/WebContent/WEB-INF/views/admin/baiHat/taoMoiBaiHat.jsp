<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Tạo mới bài hát</title>
<body>
	<h3>Tạo mới bài hát</h3>
	<form:form method="post" action="luuBaiHat">
		<!-- ten bai hat -->
		<div class="mb-3">
			<label for="songName" class="form-label">Tên bài hát</label>
		    <form:input path="songName" class="form-control" id="songName"/>
		</div>
					
		<!-- anh nen -->
		<div class="mb-3">
		  <label for="songThumbnail" class="form-label">Chọn ảnh nền</label>
		  <input name="songThumbnail" class="form-control" type="file" id="songThumbnail">
		</div>
		
		<!-- thoi luong bai hat -->
		<div class="mb-3">
			<label for="songDuration" class="form-label">Thời lượng bài hát</label>
		    <form:input path="songDuration" class="form-control" id="songDuration"/>
		</div>
		
		<!-- file nhac -->
		<div class="mb-3">
		  <label for="songPath" class="form-label">Chọn link nhạc</label>
		  <input name="songPath" class="form-control" type="file" id="songPath">
		</div>
		
		<!-- Nghe sy -->
		<div class="mb-3">
		  	<label for="artist" class="form-label">Chọn nghệ sỹ biểu diễn</label>
		  	<form:select path="artistId" class="form-select">
				<form:options items="${artistList}" itemValue="artistId" itemLabel="artistName" id="artist"/>
			</form:select>																									
		</div>
		
		<!-- The loai -->
		<div class="mb-3">
			<label for="cate" class="form-label">Chọn thể loại nhạc</label>
		  	<form:select path="cateId" class="form-select">
				<form:options items="${cateList}" itemValue="cateId" itemLabel="cateName" id="cate"/>
			</form:select>
		</div>
		
		<div class="card-body">
			<!-- Luu bai hat -->
			<input type="submit" value="Lưu" class="btn btn-primary"/>
			<!-- Huy -->
			<button type="button" class="btn btn-outline-danger" onclick="history.back()" style="margin-left: 30px">Hủy bỏ</button>
		</div>
		
	</form:form>
</body>
