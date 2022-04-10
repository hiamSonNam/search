<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Danh sách nghệ sỹ</title>

<body>
	<div class="container">
	
		<div class="d-grid gap-2">
			<a href="taoMoiTheLoai">
				<button type="button" class="btn btn-primary" style="margin-bottom: 20px">Thêm thể loại mới</button>
			</a>
		</div>
	
		<div class="row">
			<c:forEach var="item" items="${listCate}">
				<div class="col"  style="margin-bottom: 20px">
					<div class="card" style="width: 18rem;">
						
						<div class="card-body">
							<h5 class="card-title">${item.cateName}</h5>
						</div>
						
						<div class="card-body">
							<a href="chinhSuaTheLoai/${item.cateId}" class="card-link">
								<button type="button" class="btn btn-outline-primary">Chỉnh sửa</button>
							</a> 
							<a href="xoaTheLoai/${item.cateId}" class="card-link" id="del">
								<button type="button" class="btn btn-outline-danger">Xóa bỏ</button>
							 </a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
