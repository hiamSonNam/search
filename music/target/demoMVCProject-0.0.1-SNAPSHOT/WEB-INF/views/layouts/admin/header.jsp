<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="sidebar">
	<div class="profile">
		<img src="<c:url value="/assets/user/images/logo.png"/>" alt=""
			class="profile-avatar" /> <span class="profile-position">Listen
			ours music</span>
	</div>
	<ul class="menu">
		<li class="menu-item"><a href="danhSachBaiHat" class="menu-link"> <i
				class="fa fa-home menu-icon"></i> <span>Bài hát</span>
		</a></li>
		<li class="menu-item"><a href="danhSachNgheSy" class="menu-link"> <i
				class="fa fa-user menu-icon"></i> <span>Nghệ sỹ</span>
		</a></li>
		<li class="menu-item"><a href="danhSachTheLoai" class="menu-link"> <i
				class="fa fa-list menu-icon"></i> <span>Thể loại</span>
		</a></li>
	</ul>

	<button class="turnBack" onclick="history.back()">Back to
		previous</button>
</div>
