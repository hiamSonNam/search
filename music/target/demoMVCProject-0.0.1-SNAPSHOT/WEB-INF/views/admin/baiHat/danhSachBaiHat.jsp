<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Danh sách bài hát</title>

<body>
	<div class="container">
	
		<div class="d-grid gap-2">
			<a href="taoMoiBaiHat">
				<button type="button" class="btn btn-primary" style="margin-bottom: 20px">Thêm bài hát mới</button>
			</a>
		</div>
	
		<div class="row">
			<c:forEach var="item" items="${listSong}">
				<div class="col"  style="margin-bottom: 20px">
					<div class="card" style="width: 18rem;">
						<img src="http://localhost/${item.songThumbnail}" class="card-img-top" alt="${item.songName}">
						<div class="card-body">
							<h5 class="card-title">${item.songName}</h5>
							<p class="card-text">${item.artistName}</p>
						</div>
						<ul class="list-group list-group-flush">
							<li class="list-group-item">${item.cateName}</li>
							<li class="list-group-item">${item.songDuration}</li>
							<li class="list-group-item">${item.songPath}</li>
						</ul>
						<div class="card-body">
							<a href="chinhSuaBaiHat/${item.songId}" class="card-link">
								<button type="button" class="btn btn-outline-primary">Chỉnh sửa</button>
							</a> 
							<a href="xoaBaiHat/${item.songId}" class="card-link" id="del">
								<button type="button" class="btn btn-outline-danger">Xóa bỏ</button>
							 </a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
