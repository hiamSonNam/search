<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="sidebar">
			<div class="profile">
				<img src="<c:url value="/assets/user/images/logo.png"/>" alt=""
					class="profile-avatar" /> <span class="profile-position">Listen
					ours music</span>
			</div>
			<ul class="menu">
				<li class="menu-item"><a href="home" class="menu-link"> <i
						class="fa fa-home menu-icon"></i> <span>Home</span>
				</a></li>
				<li class="menu-item"><a href="artist" class="menu-link"> <i
						class="fa fa-user menu-icon"></i> <span>Artist</span>
				</a></li>
				<li class="menu-item"><a href="genre" class="menu-link"> <i
						class="fa fa-list menu-icon"></i> <span>Genre</span>
				</a></li>
				<li class="menu-item"><a
					href="<c:url value="/WEB-INF/views/user/index.jsp"/>"
					class="menu-link"> <i class="fa fa-play menu-icon"></i> <span>Videos</span>
				</a></li>
			</ul>
			
			<button class="turnBack" onclick="history.back()">Back to previous</button>
		</div>
		