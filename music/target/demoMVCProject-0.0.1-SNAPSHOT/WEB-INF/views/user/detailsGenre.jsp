<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${genre.cateName}</title>
</head>
<body>
	<div class="content">
		<div class="content-item">
			<div class="block-box">
				<h2 class="heading artistOfSong">${genre.cateName} Songs.</h2>
			</div>
			<div id="song-list">
				<!-- render here -->
			</div>
		</div>

		<%@include file="/WEB-INF/views/layouts/user/player.jsp" %>
	</div>
</body>
</html>