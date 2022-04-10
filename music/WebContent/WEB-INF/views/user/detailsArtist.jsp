<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<title>${artistInfo.artistName }'s Details</title>
<body>
	<div class="content">
		<div class="content-item">
			<div class="block-box">
				<h2 class="heading artistHeading">${artistInfo.artistName }'s Info.</h2>
				<div class="artistInfo">
					<div class="artistAvatar">
						<img class="artistImg"
							src="http://localhost/${artistInfo.artistAvatar }" alt="" />
					</div>
					<div class="detailsInfo">
						<h3 class="artistFullName">${artistInfo.artistName }</h3>
						<h4 class="artistAge">${artistInfo.artistDoB }</h4>
						<h4 class="artistAddress">${artistInfo.artistCountry }</h4>
					</div>
				</div>
				<h2 class="heading artistOfSong">${artistInfo.artistName }'s Song List.</h2>
			</div>
			<div id="song-list">
				<!-- render here -->
				
			</div>
		</div>

		<%@include file="/WEB-INF/views/layouts/user/player.jsp" %>
	</div>
</body>
