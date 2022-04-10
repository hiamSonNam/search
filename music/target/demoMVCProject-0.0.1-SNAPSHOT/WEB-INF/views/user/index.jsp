<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<title>Home</title>
<body>
	<div class="content">
		<div class="content-item">
			<div class="block-box">
				<h2 class="heading">Tufy's Song List</h2>
			</div>
			<div id="song-list">
			<!-- render here -->
			</div>
		</div>

		<%@include file="/WEB-INF/views/layouts/user/player.jsp" %>
	</div>
</body>