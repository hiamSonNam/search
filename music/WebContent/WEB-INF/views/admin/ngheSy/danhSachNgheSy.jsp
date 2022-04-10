<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Danh sách nghệ sỹ</title>

<body>
	<div class="container">
	
		<div class="d-grid gap-2">
			<a href="taoMoiNgheSy">
				<button type="button" class="btn btn-primary" style="margin-bottom: 20px">Thêm nghệ sỹ mới</button>
			</a>
		</div>
	
		<div class="row">
			<c:forEach var="item" items="${listArtist}">
				<div class="col"  style="margin-bottom: 20px">
					<div class="card" style="width: 18rem;">
						<img src="http://localhost/${item.artistAvatar}" class="card-img-top" alt="${item.artistName}">
						<div class="card-body">
							<h5 class="card-title">${item.artistName}</h5>
							<p class="card-text">${item.artistDoB}</p>
						</div>
						<ul class="list-group list-group-flush">
							<li class="list-group-item">${item.artistCountry}</li>
						</ul>
						<div class="card-body">
							<a href="chinhSuaNgheSy/${item.artistId}" class="card-link">
								<button type="button" class="btn btn-outline-primary">Chỉnh sửa</button>
							</a> 
							<a href="xoaNgheSy/${item.artistId}" class="card-link" id="del">
								<button type="button" class="btn btn-outline-danger">Xóa bỏ</button>
							 </a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
